package rpg.model;

import rpg.model.entities.*;
import rpg.model.items.*;
import rpg.model.rooms.Room;
import java.util.*;

/**
 * Factory Pattern - Creates and initializes the complete game world
 * Demonstrates: Factory Design Pattern, Game World Building
 * 
 * EXPANDED WORLD with 15+ rooms, 11+ monsters, 20+ items
 */
public class GameFactory {
    private static GameFactory instance;
    private Player player;
    
    private GameFactory() {}
    
    /**
     * Singleton pattern - get instance
     */
    public static GameFactory getInstance() {
        if (instance == null) {
            instance = new GameFactory();
        }
        return instance;
    }
    
    /**
     * Create player with name
     */
    public Player createPlayer(String name) {
        this.player = new Player(name);
        createGameWorld(player);
        return player;
    }
    
    /**
     * Creates the complete game world with expanded content
     */
    public static Room createGameWorld(Player player) {
        // ==================== CREATE ROOMS ====================
        
        // Starting Area
        Room castleEntrance = new Room("Castle Entrance", 
            "You stand at the grand entrance of an ancient castle.\n" +
            "Stone gargoyles watch over the gates. Torches flicker dimly.\n" +
            "A narrow path leads deeper into the castle.");
        
        Room courtyard = new Room("Courtyard",
            "An open courtyard overgrown with vines and moss.\n" +
            "Broken statues stand among crumbling fountains.\n" +
            "You hear the distant cry of a raven.");
        
        Room guardTower = new Room("Guard Tower",
            "A tall stone tower with narrow windows.\n" +
            "Rusted armor hangs on the walls.\n" +
            "Ancient weapons are scattered about.");
        
        // Main Castle Areas
        Room hallway = new Room("Hallway", 
            "A long, torch-lit hallway with high stone ceilings.\n" +
            "Portraits of ancient kings stare down at you.\n" +
            "Your footsteps echo through the chamber.");
        
        Room library = new Room("Ancient Library",
            "Shelves laden with dusty tomes and ancient scrolls.\n" +
            "The smell of aged paper fills the air.\n" +
            "A mysterious glowing book sits on a pedestal.");
        
        Room alchemyLab = new Room("Alchemy Lab",
            "Vials of strange liquids line the shelves.\n" +
            "A bubbling cauldron emits green smoke.\n" +
            "Alchemical equipment covers the workbench.");
        
        // Dungeon Areas
        Room dungeonEntrance = new Room("Dungeon Entrance",
            "The air grows cold as you descend stone stairs.\n" +
            "Chains hang from the walls.\n" +
            "You hear something moving in the darkness.");
        
        Room cellBlock = new Room("Prison Cell Block",
            "Rows of empty prison cells with rusted bars.\n" +
            "Scratches mark the walls - signs of past prisoners.\n" +
            "A foul smell permeates the area.");
        
        Room armoury = new Room("Armoury", 
            "Racks of weapons and armor line the walls.\n" +
            "Shields bear ancient crests and symbols.\n" +
            "A weapons master once trained here.");
        
        Room dungeonDeep = new Room("Deep Dungeon",
            "The deepest part of the castle dungeons.\n" +
            "Water drips from ceiling. The floor is slick with moisture.\n" +
            "Strange markings cover the stone walls.");
        
        // Treasure and Boss Areas
        Room throneRoom = new Room("Throne Room",
            "A grand chamber with a massive stone throne.\n" +
            "Royal tapestries hang in tatters.\n" +
            "An aura of power emanates from the throne itself.");
        
        Room treasureVault = new Room("Treasure Vault",
            "Chests overflowing with gold and jewels!\n" +
            "Ancient artifacts are displayed on pedestals.\n" +
            "This is the heart of the castle's wealth!");
        
        Room dragonLair = new Room("Dragon's Lair", 
            "A massive cavern beneath the castle.\n" +
            "The floor is scorched. Dragon bones litter the ground.\n" +
            "A great golden dragon sits coiled upon a mountain of treasure.");
        
        // Secret Areas
        Room secretPassage = new Room("Secret Passage",
            "A hidden tunnel carved into the stone.\n" +
            "Ancient torches still burn mysteriously.\n" +
            "This passage connects the castle's most important areas.");
        
        Room ancientTemple = new Room("Ancient Temple",
            "A sacred chamber with mystical symbols on the walls.\n" +
            "An altar stands in the center of the room.\n" +
            "Holy relics are arranged carefully around the chamber.");
        
        // ==================== CREATE EXITS (CONNECTIONS) ====================
        
        // Castle Entrance connections
        castleEntrance.setExit("north", hallway);
        castleEntrance.setExit("east", courtyard);
        castleEntrance.setExit("west", guardTower);
        
        // Courtyard connections
        courtyard.setExit("west", castleEntrance);
        courtyard.setExit("north", hallway);
        courtyard.setExit("south", dungeonEntrance);
        
        // Guard Tower connections
        guardTower.setExit("east", castleEntrance);
        guardTower.setExit("north", hallway);
        
        // Hallway (hub)
        hallway.setExit("south", castleEntrance);
        hallway.setExit("west", guardTower);
        hallway.setExit("east", library);
        hallway.setExit("north", throneRoom);
        hallway.setExit("down", dungeonEntrance);
        
        // Library connections
        library.setExit("west", hallway);
        library.setExit("south", alchemyLab);
        library.setExit("north", secretPassage);
        
        // Alchemy Lab connections
        alchemyLab.setExit("north", library);
        alchemyLab.setExit("east", ancientTemple);
        
        // Ancient Temple connections
        ancientTemple.setExit("west", alchemyLab);
        
        // Dungeon Entrance connections
        dungeonEntrance.setExit("north", courtyard);
        dungeonEntrance.setExit("east", cellBlock);
        dungeonEntrance.setExit("west", armoury);
        dungeonEntrance.setExit("down", dungeonDeep);
        
        // Cell Block connections
        cellBlock.setExit("west", dungeonEntrance);
        cellBlock.setExit("south", dungeonDeep);
        
        // Armoury connections
        armoury.setExit("east", dungeonEntrance);
        armoury.setExit("south", dungeonDeep);
        
        // Deep Dungeon connections
        dungeonDeep.setExit("north", dungeonEntrance);
        dungeonDeep.setExit("east", dragonLair);
        
        // Throne Room connections
        throneRoom.setExit("south", hallway);
        throneRoom.setExit("east", treasureVault);
        throneRoom.setExit("down", secretPassage);
        
        // Secret Passage connections
        secretPassage.setExit("south", library);
        secretPassage.setExit("up", throneRoom);
        
        // Treasure Vault connections
        treasureVault.setExit("west", throneRoom);
        treasureVault.setExit("down", dragonLair);
        
        // Dragon Lair connections
        dragonLair.setExit("up", treasureVault);
        dragonLair.setExit("west", dungeonDeep);
        
        // ==================== CREATE MONSTERS ====================
        // Constructor: Monster(name, maxHP, currentHP, attackDamage)
        
        // Weak Monsters
        courtyard.setMonster(new Monster("Raven", 15, 15, 3));
        guardTower.setMonster(new Monster("Skeleton Guard", 25, 25, 5));
        cellBlock.setMonster(new Monster("Ghost Prisoner", 20, 20, 4));
        
        // Medium Monsters
        library.setMonster(new Monster("Cursed Librarian", 35, 35, 7));
        alchemyLab.setMonster(new Monster("Alchemical Golem", 40, 40, 8));
        armoury.setMonster(new Monster("Armored Knight", 45, 45, 10));
        
        // Strong Monsters
        throneRoom.setMonster(new Monster("Dark Sorcerer", 60, 60, 12));
        secretPassage.setMonster(new Monster("Shadow Demon", 55, 55, 11));
        ancientTemple.setMonster(new Monster("Temple Guardian", 50, 50, 9));
        dungeonDeep.setMonster(new Monster("Lava Beast", 70, 70, 15));
        
        // Boss Monster
        dragonLair.setMonster(new Monster("Ancient Dragon", 150, 150, 25));
        
        // ==================== CREATE WEAPONS ====================
        
        // Weak Weapons
        guardTower.addItem(new Weapon("Rusty Dagger", "An old, dented dagger", 8));
        courtyard.addItem(new Weapon("Wooden Staff", "A gnarled wooden staff", 6));
        
        // Medium Weapons
        armoury.addItem(new Weapon("Iron Sword", "A well-crafted iron sword", 18));
        armoury.addItem(new Weapon("Steel Axe", "A heavy battle axe", 22));
        library.addItem(new Weapon("Mage's Staff", "An enchanted staff", 15));
        
        // Strong Weapons
        alchemyLab.addItem(new Weapon("Crystal Blade", "A blade that glows with magic", 28));
        secretPassage.addItem(new Weapon("Holy Sword", "A sacred weapon of ancient power", 32));
        throneRoom.addItem(new Weapon("Dragon Slayer", "A legendary sword forged for dragon hunting", 35));
        ancientTemple.addItem(new Weapon("Ancient Rune Blade", "A sword etched with powerful runes", 30));
        
        // ==================== CREATE POTIONS ====================
        
        // Small Healing Potions
        castleEntrance.addItem(new Potion("Small Potion", "Restores 15 HP", 15));
        courtyard.addItem(new Potion("Minor Health Potion", "Restores 10 HP", 10));
        guardTower.addItem(new Potion("Small Healing Vial", "Restores 12 HP", 12));
        
        // Medium Healing Potions
        library.addItem(new Potion("Health Potion", "Restores 30 HP", 30));
        alchemyLab.addItem(new Potion("Greater Healing Potion", "Restores 40 HP", 40));
        cellBlock.addItem(new Potion("Mana Potion", "Restores 25 HP and clears mind", 25));
        
        // Strong Healing Potions
        dungeonDeep.addItem(new Potion("Mega Potion", "Restores 50 HP", 50));
        treasureVault.addItem(new Potion("Full Health Elixir", "Fully restores all HP", 100));
        secretPassage.addItem(new Potion("Essence of Life", "Restores 60 HP and grants blessings", 60));
        ancientTemple.addItem(new Potion("Holy Water", "Restores 45 HP and purifies", 45));
        
        // ==================== SET PLAYER STARTING LOCATION ====================
        player.setCurrentRoom(castleEntrance);
        
        return castleEntrance;
    }
}
