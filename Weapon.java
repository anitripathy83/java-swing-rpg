package rpg.model.items;

import rpg.model.entities.Player;

/**
 * Weapon class extending Item
 * Demonstrates: Inheritance, Polymorphism override
 */
public class Weapon extends Item {
    private int damage;
    
    public Weapon(String name, String description, int damage) {
        super(name, description);
        this.damage = Math.max(1, damage);
    }
    
    /**
     * Using a weapon equips it to the player
     * Demonstrates: Polymorphism - different use() behavior than Potion
     */
    @Override
    public void use(Player player) {
        player.equipWeapon(this);
    }
    
    @Override
    public String getItemType() {
        return "Weapon";
    }
    
    public int getDamage() {
        return damage;
    }
    
    public void setDamage(int damage) {
        this.damage = Math.max(1, damage);
    }
    
    @Override
    public String toString() {
        return super.toString() + " [Damage: " + damage + "]";
    }
}
