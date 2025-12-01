package rpg.model.entities;

import java.util.ArrayList;
import java.util.List;
import rpg.model.items.Item;
import rpg.model.items.Weapon;
import rpg.model.rooms.Room;

/**
 * Player class extending Entity
 * Demonstrates: Inheritance, Polymorphism, Collections
 */
public class Player extends Entity {
    private ArrayList<Item> inventory;
    private Weapon equippedWeapon;
    private Room currentRoom;
    private int level;
    private int experience;
    
    public Player(String name) {
        super(name, 100);
        this.inventory = new ArrayList<>();
        this.equippedWeapon = null;
        this.level = 1;
        this.experience = 0;
    }
    
    /**
     * Add item to inventory
     */
    public void addItem(Item item) {
        inventory.add(item);
    }
    
    /**
     * Remove item from inventory
     */
    public boolean removeItem(Item item) {
        return inventory.remove(item);
    }
    
    /**
     * Find item by name
     */
    public Item findItem(String itemName) {
        for (Item item : inventory) {
            if (item.getName().equalsIgnoreCase(itemName)) {
                return item;
            }
        }
        return null;
    }
    
    /**
     * Equip a weapon
     */
    public void equipWeapon(Weapon weapon) {
        this.equippedWeapon = weapon;
    }
    
    /**
     * Calculate attack damage
     * Demonstrates: Method Overriding, Polymorphism
     */
    public int calculateDamage() {
        int baseDamage = 5;
        if (equippedWeapon != null) {
            baseDamage = equippedWeapon.getDamage();
        }
        // Level scaling
        return baseDamage + (level * 2);
    }
    
    /**
     * Gain experience
     */
    public void gainExperience(int exp) {
        experience += exp;
        if (experience >= level * 100) {
            levelUp();
        }
    }
    
    /**
     * Level up player
     */
    private void levelUp() {
        level++;
        heal(20);
        maxHP += 10;
    }
    
    // Getters
    public ArrayList<Item> getInventory() {
        return inventory;
    }
    
    public Weapon getEquippedWeapon() {
        return equippedWeapon;
    }
    
    public Room getCurrentRoom() {
        return currentRoom;
    }
    
    public void setCurrentRoom(Room room) {
        currentRoom = room;
    }
    
    public int getLevel() {
        return level;
    }
    
    public int getExperience() {
        return experience;
    }
    
    public int getInventorySize() {
        return inventory.size();
    }
}
