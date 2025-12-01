package rpg.model.items;

import rpg.model.entities.Player;

/**
 * Potion class extending Item
 * Demonstrates: Inheritance, Polymorphism override
 */
public class Potion extends Item {
    private int healAmount;
    
    public Potion(String name, String description, int healAmount) {
        super(name, description);
        this.healAmount = Math.max(1, healAmount);
    }
    
    /**
     * Using a potion heals the player and removes the potion
     * Demonstrates: Polymorphism - different use() behavior than Weapon
     */
    @Override
    public void use(Player player) {
        player.heal(healAmount);
        player.removeItem(this);
    }
    
    @Override
    public String getItemType() {
        return "Potion";
    }
    
    public int getHealAmount() {
        return healAmount;
    }
    
    public void setHealAmount(int amount) {
        this.healAmount = Math.max(1, amount);
    }
    
    @Override
    public String toString() {
        return super.toString() + " [Restore: " + healAmount + " HP]";
    }
}
