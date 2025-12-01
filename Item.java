package rpg.model.items;

import rpg.model.entities.Player;

/**
 * Abstract Item class
 * Demonstrates: Abstract Classes, Polymorphism, Interface pattern
 */
public abstract class Item {
    protected String name;
    protected String description;
    
    public Item(String name, String description) {
        this.name = name;
        this.description = description;
    }
    
    /**
     * Abstract use method - must be implemented by subclasses
     */
    public abstract void use(Player player);
    
    /**
     * Abstract method to get item type
     */
    public abstract String getItemType();
    
    public String getName() {
        return name;
    }
    
    public String getDescription() {
        return description;
    }
    
    @Override
    public String toString() {
        return name + " - " + description;
    }
}
