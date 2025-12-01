package rpg.model.entities;

/**
 * Monster class extending Entity
 * Demonstrates: Inheritance, Polymorphism
 */
public class Monster extends Entity {
    private int attackDamage;
    private int experienceReward;
    
    public Monster(String name, int maxHP, int attackDamage, int experienceReward) {
        super(name, maxHP);
        this.attackDamage = attackDamage;
        this.experienceReward = experienceReward;
    }
    
    /**
     * Monster attacks returning damage value
     */
    public int attack() {
        // Random variation in damage (±25%)
        double variation = 0.75 + (Math.random() * 0.5);
        return (int)(attackDamage * variation);
    }
    
    public int getAttackDamage() {
        return attackDamage;
    }
    
    public int getExperienceReward() {
        return experienceReward;
    }
    
    public void setAttackDamage(int damage) {
        this.attackDamage = Math.max(1, damage);
    }
}
