package rpg.controller;

import rpg.model.GameFactory;
import rpg.model.entities.Player;
import rpg.model.entities.Monster;
import rpg.model.rooms.Room;
import rpg.model.items.Item;
import rpg.model.items.Weapon;
import rpg.model.items.Potion;
import java.util.ArrayList;

/**
 * GameController class - Core game logic
 * Demonstrates: MVC pattern, Command pattern, Game state management
 */
public class GameController {
    private Player player;
    private GameFactory factory;
    private boolean inCombat;
    private Monster currentMonster;
    
    public GameController() {
        factory = GameFactory.getInstance();
        player = factory.createPlayer("Hero");
        this.inCombat = false;
        this.currentMonster = null;
    }
    
    /**
     * Execute player command
     * Demonstrates: Command parsing, Polymorphism in action
     */
    public String executeCommand(String input) {
        if (input == null || input.trim().isEmpty()) {
            return "Invalid command.";
        }
        
        String[] parts = input.toLowerCase().trim().split("\\s+", 2);
        String command = parts[0];
        String argument = parts.length > 1 ? parts[1] : "";
        
        switch(command) {
            case "get":
            case "take":
                return handleGetItem(argument);
            case "drop":
                return handleDropItem(argument);
            case "inventory":
            case "i":
                return handleInventory();
            case "use":
                return handleUseItem(argument);
            case "attack":
                return handleAttack();
            case "look":
                return handleLook();
            case "help":
                return handleHelp();
            case "stats":
                return handleStats();
            default:
                return "Unknown command. Type 'help' for available commands.";
        }
    }
    
    /**
     * Move player in a direction
     * Demonstrates: State management, Collision detection
     */
    public String movePlayer(String direction) {
        Room currentRoom = player.getCurrentRoom();
        if (currentRoom == null) {
            return "Error: Not in a room!";
        }
        
        // Check if monster is blocking
        Monster monster = currentRoom.getMonster();
        if (monster != null && monster.isAlive()) {
            return "A fierce " + monster.getName() + " blocks your path!\nDefeat it first!";
        }
        
        Room nextRoom = currentRoom.getExit(direction);
        if (nextRoom == null) {
            return "You cannot go " + direction + " from here.";
        }
        
        player.setCurrentRoom(nextRoom);
        
        // Check for new monster
        if (nextRoom.getMonster() != null && nextRoom.getMonster().isAlive()) {
            currentMonster = nextRoom.getMonster();
            inCombat = true;
            return "You moved " + direction + ".\n\n[!] A " + currentMonster.getName() + 
                   " appears before you! (HP: " + currentMonster.getCurrentHP() + ")";
        }
        
        return "You moved " + direction + ".";
    }
    
    /**
     * Handle item pickup
     * Demonstrates: Inventory management
     */
    private String handleGetItem(String itemName) {
        if (itemName.isEmpty()) {
            return "What do you want to take?";
        }
        
        Room currentRoom = player.getCurrentRoom();
        Item item = currentRoom.findItem(itemName);
        
        if (item == null) {
            return "That item is not here.";
        }
        
        player.addItem(item);
        currentRoom.removeItem(item);
        return "You picked up: " + item.getName();
    }
    
    /**
     * Handle item drop
     */
    private String handleDropItem(String itemName) {
        if (itemName.isEmpty()) {
            return "What do you want to drop?";
        }
        
        Item item = player.findItem(itemName);
        if (item == null) {
            return "You don't have that item.";
        }
        
        player.removeItem(item);
        player.getCurrentRoom().addItem(item);
        return "You dropped: " + item.getName();
    }
    
    /**
     * Handle item usage
     * Demonstrates: Polymorphism - different items have different use() effects
     */
    private String handleUseItem(String itemName) {
        if (itemName.isEmpty()) {
            return "What do you want to use?";
        }
        
        Item item = player.findItem(itemName);
        if (item == null) {
            return "You don't have that item.";
        }
        
        item.use(player);
        
        if (item instanceof Weapon) {
            return "You equipped: " + item.getName();
        } else if (item instanceof Potion) {
            return "You used: " + item.getName() + ". You feel refreshed!";
        }
        
        return "You used: " + item.getName();
    }
    
    /**
     * Handle attack command
     * Demonstrates: Combat system, Entity interaction
     */
    private String handleAttack() {
        Room currentRoom = player.getCurrentRoom();
        Monster monster = currentRoom.getMonster();
        
        if (monster == null || !monster.isAlive()) {
            return "There's nothing to attack here!";
        }
        
        // Player attacks
        int playerDamage = player.calculateDamage();
        monster.takeDamage(playerDamage);
        
        StringBuilder result = new StringBuilder();
        result.append("You attacked the ").append(monster.getName()).append("!\n");
        result.append("Damage dealt: ").append(playerDamage).append("\n");
        
        if (!monster.isAlive()) {
            result.append("[Victory!] You defeated the ").append(monster.getName()).append("!\n");
            player.gainExperience(monster.getExperienceReward());
            result.append("You gained ").append(monster.getExperienceReward()).append(" experience points!");
            return result.toString();
        }
        
        // Monster counter-attacks
        result.append("\nThe ").append(monster.getName()).append(" attacks back!\n");
        int monsterDamage = monster.attack();
        player.takeDamage(monsterDamage);
        result.append("You took ").append(monsterDamage).append(" damage!\n");
        result.append("Your health: ").append(player.getCurrentHP()).append("/").append(player.getMaxHP());
        
        return result.toString();
    }
    
    /**
     * Handle look command
     */
    private String handleLook() {
        Room currentRoom = player.getCurrentRoom();
        if (currentRoom == null) {
            return "Error: Not in a room!";
        }
        return currentRoom.describe();
    }
    
    /**
     * Handle inventory display
     */
    private String handleInventory() {
        StringBuilder sb = new StringBuilder();
        sb.append("=== INVENTORY ===\n");
        sb.append("Items: ").append(player.getInventorySize()).append("\n\n");
        
        if (player.getEquippedWeapon() != null) {
            sb.append("[EQUIPPED] ").append(player.getEquippedWeapon().toString()).append("\n\n");
        }
        
        for (Item item : player.getInventory()) {
            if (!item.equals(player.getEquippedWeapon())) {
                sb.append("• ").append(item.toString()).append("\n");
            }
        }
        
        return sb.toString();
    }
    
    /**
     * Handle stats display
     */
    private String handleStats() {
        StringBuilder sb = new StringBuilder();
        sb.append("=== PLAYER STATS ===\n");
        sb.append("Name: ").append(player.getName()).append("\n");
        sb.append("Level: ").append(player.getLevel()).append("\n");
        sb.append("Experience: ").append(player.getExperience()).append("/")
          .append(player.getLevel() * 100).append("\n");
        sb.append("HP: ").append(player.getCurrentHP()).append("/").append(player.getMaxHP()).append("\n");
        sb.append("Attack Damage: ").append(player.calculateDamage()).append("\n");
        if (player.getEquippedWeapon() != null) {
            sb.append("Equipped: ").append(player.getEquippedWeapon().getName()).append("\n");
        }
        return sb.toString();
    }
    
    /**
     * Handle help command
     */
    private String handleHelp() {
        return "=== AVAILABLE COMMANDS ===\n" +
               "Movement: (Use arrow buttons or)\n" +
               "  go <direction> (north, south, east, west)\n\n" +
               "Items:\n" +
               "  get <item> - Pick up item\n" +
               "  drop <item> - Drop item\n" +
               "  inventory/i - Show inventory\n" +
               "  use <item> - Use/equip item\n\n" +
               "Combat:\n" +
               "  attack - Attack monster\n\n" +
               "Other:\n" +
               "  look - Describe room\n" +
               "  stats - Show player stats\n" +
               "  help - Show this message";
    }
    
    // Getters
    public Player getPlayer() {
        return player;
    }
    
    public boolean isInCombat() {
        return inCombat;
    }
    
    public Monster getCurrentMonster() {
        return currentMonster;
    }
}
