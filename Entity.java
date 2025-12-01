package rpg.model.entities;

/**
 * Abstract base class representing any living entity in the game.
 * Demonstrates: Abstract Classes, Encapsulation, Inheritance
 */
public abstract class Entity {
    protected String name;
    protected int currentHP;
    protected int maxHP;
    
    /**
     * Constructor for Entity
     * @param name Entity's name
     * @param maxHP Maximum health points
     */
    public Entity(String name, int maxHP) {
        this.name = name;
        this.maxHP = maxHP;
        this.currentHP = maxHP;
    }
    
    /**
     * Apply damage to entity
     * @param damage Damage amount
     */
    public void takeDamage(int damage) {
        if (damage < 0) {
            throw new IllegalArgumentException("Damage cannot be negative");
        }
        this.currentHP = Math.max(0, currentHP - damage);
    }
    
    /**
     * Restore health to entity
     * @param amount Healing amount
     */
    public void heal(int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Healing amount cannot be negative");
        }
        this.currentHP = Math.min(maxHP, currentHP + amount);
    }
    
    /**
     * Check if entity is alive
     * @return true if currentHP > 0
     */
    public boolean isAlive() {
        return currentHP > 0;
    }
    
    // Getters and Setters
    public String getName() {
        return name;
    }
    
    public int getCurrentHP() {
        return currentHP;
    }
    
    public int getMaxHP() {
        return maxHP;
    }
    
    public void setName(String name) {
        this.name = name;
    }
}
