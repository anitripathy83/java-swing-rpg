package rpg.model.rooms;

import java.util.ArrayList;
import java.util.HashMap;
import rpg.model.items.Item;
import rpg.model.entities.Monster;

/**
 * Room class representing game world locations
 * Demonstrates: Encapsulation, Collections (HashMap, ArrayList)
 */
public class Room {
    private String name;
    private String description;
    private ArrayList<Item> items;
    private Monster monster;
    private HashMap<String, Room> exits; // Direction -> Room mapping
    
    public Room(String name, String description) {
        this.name = name;
        this.description = description;
        this.items = new ArrayList<>();
        this.exits = new HashMap<>();
        this.monster = null;
    }
    
    /**
     * Set exit in given direction
     * Demonstrates: HashMap usage
     */
    public void setExit(String direction, Room room) {
        if (direction != null && room != null) {
            exits.put(direction.toLowerCase(), room);
        }
    }
    
    /**
     * Get exit in given direction
     */
    public Room getExit(String direction) {
        return exits.get(direction.toLowerCase());
    }
    
    /**
     * Get available exit directions
     */
    public ArrayList<String> getExitDirections() {
        return new ArrayList<>(exits.keySet());
    }
    
    /**
     * Add item to room
     */
    public void addItem(Item item) {
        if (item != null) {
            items.add(item);
        }
    }
    
    /**
     * Remove item from room
     */
    public boolean removeItem(Item item) {
        return items.remove(item);
    }
    
    /**
     * Find item by name
     */
    public Item findItem(String itemName) {
        for (Item item : items) {
            if (item.getName().equalsIgnoreCase(itemName)) {
                return item;
            }
        }
        return null;
    }
    
    /**
     * Get full room description
     */
    public String describe() {
        StringBuilder sb = new StringBuilder();
        sb.append("=== ").append(name).append(" ===\n");
        sb.append(description).append("\n");
        
        if (monster != null && monster.isAlive()) {
            sb.append("\n[Monster] ").append(monster.getName()).append(" is here! (HP: ")
              .append(monster.getCurrentHP()).append("/").append(monster.getMaxHP()).append(")\n");
        }
        
        if (!items.isEmpty()) {
            sb.append("\nItems here:\n");
            for (Item item : items) {
                sb.append("  - ").append(item.toString()).append("\n");
            }
        }
        
        if (!exits.isEmpty()) {
            sb.append("\nExits: ").append(String.join(", ", exits.keySet())).append("\n");
        }
        
        return sb.toString();
    }
    
    // Getters and Setters
    public String getName() {
        return name;
    }
    
    public String getDescription() {
        return description;
    }
    
    public ArrayList<Item> getItems() {
        return items;
    }
    
    public Monster getMonster() {
        return monster;
    }
    
    public void setMonster(Monster monster) {
        this.monster = monster;
    }
    
    public HashMap<String, Room> getExits() {
        return exits;
    }
}
