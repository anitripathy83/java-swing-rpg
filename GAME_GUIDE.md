# 📚 Game World Guide & Reference

Complete guide to the Java Swing RPG game world, monsters, items, and locations.

## 🗺️ Table of Contents

- [World Overview](#world-overview)
- [Room Descriptions](#room-descriptions)
- [Monster Database](#monster-database)
- [Weapon Database](#weapon-database)
- [Potion Database](#potion-database)
- [Game Strategy](#game-strategy)
- [Progression Path](#progression-path)

---

## 🗺️ World Overview

### Map Layout

```
                    GUARD TOWER
                         |
CASTLE ENTRANCE - HALLWAY (HUB) - THRONE ROOM
        |            |
    COURTYARD    DEEP DUNGEON
                      |
                 BOSS CHAMBER
             (Dragon's Lair)
```

### Room Connections

| From | North | South | East | West | Up | Down |
|------|-------|-------|------|------|----|----|
| Castle Entrance | Hallway | - | - | - | - | - |
| Hallway | Throne Room | Courtyard | Guard Tower | Castle Entrance | - | Deep Dungeon |
| Courtyard | Hallway | - | - | - | - | - |
| Guard Tower | - | - | - | Hallway | - | - |
| Throne Room | - | Hallway | - | - | - | - |
| Deep Dungeon | Hallway | - | - | - | - | Boss Chamber |
| Boss Chamber | Deep Dungeon | - | - | - | - | - |

---

## 🏰 Room Descriptions

### Castle Entrance (START)
- **Difficulty**: Easy
- **Description**: The grand entrance to an ancient castle
- **Features**: Stone doors, castle flags, torches
- **Monsters**: None (Safe zone)
- **Items**: Wooden Staff
- **NPCs**: None
- **Purpose**: Starting location and safe zone

### Hallway (Hub)
- **Difficulty**: Easy
- **Description**: Central corridor with multiple exits
- **Features**: Torches, stone walls, fountain
- **Monsters**: Raven (1)
- **Items**: Small Potion (1)
- **NPCs**: None
- **Purpose**: Central connection point for all rooms

### Courtyard
- **Difficulty**: Easy
- **Description**: Open courtyard with gardens and benches
- **Features**: Overgrown gardens, broken fountain, stone benches
- **Monsters**: Skeleton Guard (1), Ghost Prisoner (1)
- **Items**: Rusty Dagger, Regular Potion
- **NPCs**: None
- **Purpose**: Beginner training area

### Guard Tower
- **Difficulty**: Medium
- **Description**: Tall tower with observation decks
- **Features**: Spiral stairs, guard posts, bell
- **Monsters**: Armored Knight (1)
- **Items**: Steel Sword, Large Potion
- **NPCs**: None
- **Purpose**: Training before boss

### Throne Room
- **Difficulty**: Medium
- **Description**: Royal chamber with king's throne
- **Features**: Golden throne, royal banners, jewels
- **Monsters**: Cursed Librarian (1)
- **Items**: Iron Longsword, Great Potion
- **NPCs**: None
- **Purpose**: Mid-level challenge

### Deep Dungeon
- **Difficulty**: Hard
- **Description**: Dark underground chambers and tunnels
- **Features**: Chains, torches, stone floors
- **Monsters**: Dark Sorcerer (1), Shadow Demon (1), Temple Guardian (1)
- **Items**: Enchanted Blade, Flaming Sword, Full Health Elixir
- **NPCs**: None
- **Purpose**: Advanced training before boss

### Boss Chamber (Dragon's Lair)
- **Difficulty**: Extreme
- **Description**: Massive cavern with golden hoard
- **Features**: Dragon throne, gold piles, lava channels
- **Monsters**: Ancient Dragon (BOSS)
- **Items**: None (Victory upon defeat)
- **NPCs**: None
- **Purpose**: Final boss battle and victory condition

---

## 🐉 Monster Database

### Easy Tier (1-3 Threat Level)

#### Raven
- **Location**: Hallway
- **Health**: 15 HP
- **Damage**: 2 DMG
- **Experience**: 10 XP
- **Weakness**: Any weapon
- **Strategy**: Easy target, good for practice
- **Loot**: Small Potion (occasional)

#### Skeleton Guard
- **Location**: Courtyard
- **Health**: 25 HP
- **Damage**: 4 DMG
- **Experience**: 15 XP
- **Weakness**: Blunt weapons
- **Strategy**: Straightforward combat
- **Loot**: Small Potion

#### Ghost Prisoner
- **Location**: Courtyard
- **Health**: 20 HP
- **Damage**: 3 DMG
- **Experience**: 12 XP
- **Weakness**: Magical weapons
- **Strategy**: Fast but weak
- **Loot**: Regular Potion

### Medium Tier (4-6 Threat Level)

#### Cursed Librarian
- **Location**: Throne Room
- **Health**: 40 HP
- **Damage**: 8 DMG
- **Experience**: 25 XP
- **Weakness**: Enchanted weapons
- **Strategy**: Uses ranged attacks, keep distance
- **Loot**: Large Potion

#### Alchemical Golem
- **Location**: Deep Dungeon
- **Health**: 45 HP
- **Damage**: 9 DMG
- **Experience**: 28 XP
- **Weakness**: Fire weapons
- **Strategy**: High defense, need strong weapons
- **Loot**: Great Potion

#### Armored Knight
- **Location**: Guard Tower
- **Health**: 50 HP
- **Damage**: 10 DMG
- **Experience**: 30 XP
- **Weakness**: Piercing weapons
- **Strategy**: Heavy armor but slow
- **Loot**: Large Potion

### Hard Tier (7-9 Threat Level)

#### Dark Sorcerer
- **Location**: Deep Dungeon
- **Health**: 70 HP
- **Damage**: 15 DMG
- **Experience**: 40 XP
- **Weakness**: Holy weapons
- **Strategy**: Magic attacks, dodge when possible
- **Loot**: Full Health Elixir

#### Shadow Demon
- **Location**: Deep Dungeon
- **Health**: 75 HP
- **Damage**: 16 DMG
- **Experience**: 42 XP
- **Weakness**: Light weapons
- **Strategy**: Very fast and dangerous
- **Loot**: Full Health Elixir

#### Temple Guardian
- **Location**: Deep Dungeon
- **Health**: 80 HP
- **Damage**: 17 DMG
- **Experience**: 45 XP
- **Weakness**: Blessed weapons
- **Strategy**: High damage, brings healing potions
- **Loot**: Full Health Elixir

#### Lava Beast
- **Location**: Deep Dungeon
- **Health**: 85 HP
- **Damage**: 18 DMG
- **Experience**: 48 XP
- **Weakness**: Ice/water weapons (unavailable)
- **Strategy**: Strongest regular enemy, prepare well
- **Loot**: Full Health Elixir

### Boss Tier (10+ Threat Level)

#### Ancient Dragon
- **Location**: Dragon's Lair
- **Health**: 150 HP
- **Damage**: 25 DMG
- **Experience**: 100 XP
- **Weakness**: Dragon Slayer sword
- **Strategy**: 
  - Must have Dragon Slayer weapon
  - Use Full Health Elixirs liberally
  - Dodge high damage attacks
  - Persistence is key
- **Victory Condition**: Defeating this boss wins the game!

---

## ⚔️ Weapon Database

### Tier 1: Beginner Weapons

#### Wooden Staff
- **Damage**: 6 DMG
- **Location**: Castle Entrance
- **Requirement**: None
- **Description**: Basic wooden staff, first weapon
- **Best For**: Learning combat
- **Upgrade Path**: → Rusty Dagger

#### Rusty Dagger
- **Damage**: 8 DMG
- **Location**: Courtyard
- **Requirement**: 20+ XP
- **Description**: Old rusty dagger, worn but functional
- **Best For**: Early combat
- **Upgrade Path**: → Steel Sword

### Tier 2: Early Game Weapons

#### Steel Sword
- **Damage**: 12 DMG
- **Location**: Guard Tower
- **Requirement**: 50+ XP
- **Description**: Solid steel blade, reliable weapon
- **Best For**: Mid-level enemies
- **Upgrade Path**: → Iron Longsword

#### Iron Longsword
- **Damage**: 16 DMG
- **Location**: Throne Room
- **Requirement**: 100+ XP
- **Description**: Heavy iron longsword, balanced weapon
- **Best For**: Medium-hard enemies
- **Upgrade Path**: → Enchanted Blade

### Tier 3: Mid Game Weapons

#### Enchanted Blade
- **Damage**: 20 DMG
- **Location**: Deep Dungeon
- **Requirement**: 150+ XP
- **Description**: Glowing enchanted sword with magic
- **Best For**: Hard enemies
- **Upgrade Path**: → Flaming Sword

#### Flaming Sword
- **Damage**: 24 DMG
- **Location**: Deep Dungeon
- **Requirement**: 180+ XP
- **Description**: Sword engulfed in magical flames
- **Best For**: Late game enemies
- **Upgrade Path**: → Dragon Slayer

### Tier 4: Legendary Weapons

#### Cursed Scythe
- **Damage**: 28 DMG
- **Location**: Deep Dungeon
- **Requirement**: 200+ XP
- **Description**: Dark weapon with mysterious power
- **Best For**: Alternative powerful weapon
- **Note**: High damage but risky

#### Dragon Slayer
- **Damage**: 35 DMG
- **Location**: Deep Dungeon (or drops from boss)
- **Requirement**: 250+ XP
- **Description**: Ultimate weapon forged to slay dragons
- **Best For**: Defeating Ancient Dragon
- **Special**: Bonus damage vs. dragon enemies

---

## 🧪 Potion Database

### Small Potions

#### Small Potion
- **Healing**: +15 HP
- **Location**: Hallway
- **Rarity**: Common
- **Best For**: Early game
- **Stack Limit**: 3
- **Value**: Low

#### Regular Potion
- **Healing**: +25 HP
- **Location**: Courtyard, various locations
- **Rarity**: Common
- **Best For**: Early-mid game
- **Stack Limit**: 5
- **Value**: Low-Medium

### Medium Potions

#### Large Potion
- **Healing**: +50 HP
- **Location**: Guard Tower, Throne Room
- **Rarity**: Uncommon
- **Best For**: Mid game
- **Stack Limit**: 3
- **Value**: Medium

#### Great Potion
- **Healing**: +75 HP
- **Location**: Throne Room, Deep Dungeon
- **Rarity**: Rare
- **Best For**: Late game
- **Stack Limit**: 2
- **Value**: High

### Ultimate Potions

#### Full Health Elixir
- **Healing**: +100 HP (Full restore)
- **Location**: Deep Dungeon
- **Rarity**: Very Rare
- **Best For**: Emergency/Boss fights
- **Stack Limit**: 1
- **Value**: Very High
- **Special**: Completely restores health regardless of max HP

---

## 🎯 Game Strategy

### Combat Strategy

#### Early Game (Levels 1-3)
- Focus on gaining XP from easy monsters
- Collect beginner weapons
- Learn combat mechanics
- Build up potion supplies

#### Mid Game (Levels 4-6)
- Upgrade to better weapons
- Take on medium difficulty enemies
- Explore all available rooms
- Collect rare items

#### Late Game (Levels 7-9)
- Prepare for boss battle
- Upgrade to legendary weapons
- Stock up on Full Health Elixirs
- Practice dodge and combat timing

#### Boss Battle (Level 10+)
- Must have Dragon Slayer weapon
- Minimum 3x Full Health Elixir
- Keep moving to avoid damage
- Be patient, whittle down boss health

### Resource Management

#### Weapon Management
```
Priority: Get Dragon Slayer before boss
- Upgrade steadily as you find new weapons
- Always carry best available weapon
- Don't get attached to old weapons
```

#### Potion Management
```
Budget:
- Use Small/Regular potions for regular combat
- Save Large/Great potions for emergencies
- Hoard Full Health Elixirs for boss
- Never use Full Health in regular combat
```

#### Experience Management
```
Path:
- Battle weak monsters for quick XP
- Progress to harder enemies gradually
- Don't skip levels
- Check level requirements for items
```

---

## 📍 Progression Path

### Recommended Route (Optimal Path)

```
1. START at Castle Entrance
   - Get Wooden Staff
   - Learn controls with "help"
   - Practice with "look" and "go"

2. GO to Hallway (north)
   - Battle Raven (easy practice)
   - Get Small Potion if dropped
   - Return to Hallway (south)

3. GO to Courtyard (south)
   - Battle Skeleton Guard
   - Get Rusty Dagger
   - Battle Ghost Prisoner
   - Get Regular Potion

4. RETURN to Hallway
   - Equip Rusty Dagger
   - Rest and heal

5. GO to Guard Tower (east)
   - Battle Armored Knight
   - Get Steel Sword
   - Get Large Potion
   - Upgrade weapon

6. GO to Throne Room (north from Hallway)
   - Battle Cursed Librarian
   - Get Iron Longsword
   - Get Great Potion

7. GO to Deep Dungeon (down from Hallway)
   - Battle Alchemical Golem
   - Battle Dark Sorcerer
   - Collect Enchanted Blade
   - Collect Full Health Elixir (save it!)

8. CONTINUE Deep Dungeon
   - Battle Shadow Demon
   - Battle Temple Guardian
   - Collect Flaming Sword
   - Collect more Full Health Elixirs

9. GET Dragon Slayer
   - This is crucial for boss battle

10. GO to Boss Chamber (down from Deep Dungeon)
    - Battle Ancient Dragon
    - Use Full Health Elixirs wisely
    - Victory! 🏆
```

### Alternative Routes

**Speed Run Path**
- Skip weak monsters
- Go straight for best weapons
- Risk: Less XP, harder boss fight

**Exploration Path**
- Visit all rooms first
- Understand layout
- Collect all items
- Safe: Well-prepared for boss

**Power Leveling Path**
- Fight all monsters repeatedly
- Max out experience
- Boss becomes trivial
- Time: Takes longer

---

## 💡 Pro Tips

### Combat Tips
- Never face 2+ strong monsters at once
- Dodge by moving to adjacent rooms
- Heal before HP reaches 25%
- Use stronger weapons early to save potions

### Item Collection Tips
- Explore every direction from each room
- Check "look" output for all items
- Some items are hidden or rare
- Dragon Slayer may only be available in Deep Dungeon

### Survival Tips
- Always carry 1+ healing potion
- Don't get cornered by 2+ monsters
- Retreat to safe zones if overwhelmed
- Save progress by remembering room layouts

### Boss Battle Tips
- Enter with full health
- Have Dragon Slayer equipped
- Carry minimum 3x Full Health Elixir
- Take breaks between rounds if needed
- Never give up!

---

## 🎮 Game Statistics Tracking

### Achievements Possible
- Battle 100 times
- Defeat all monster types
- Collect all weapons
- Use 50 potions
- Defeat the Ancient Dragon
- Complete in under 1 hour

### Personal Best Records
```
Speed Run: __ minutes
Highest Level Reached: __
Most Potions Used: __
Most Damage in One Battle: __
```

---

**Version**: 2.0 | **Last Updated**: December 2025

🎮 **Good luck on your adventure!** 🚀⚔️🐉

**[⬆ back to top](#-table-of-contents)**