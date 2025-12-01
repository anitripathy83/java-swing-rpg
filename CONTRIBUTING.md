# 🤝 Contributing Guidelines

Thank you for your interest in contributing to the Java Swing RPG project! This document provides guidelines and instructions for contributing.

## 📋 Table of Contents

- [Code of Conduct](#code-of-conduct)
- [Getting Started](#getting-started)
- [Development Workflow](#development-workflow)
- [Coding Standards](#coding-standards)
- [Commit Guidelines](#commit-guidelines)
- [Pull Request Process](#pull-request-process)
- [Reporting Issues](#reporting-issues)
- [Feature Requests](#feature-requests)

---

## 📜 Code of Conduct

All contributors are expected to follow these principles:

- **Be Respectful**: Treat all contributors with respect and professionalism
- **Be Constructive**: Provide helpful feedback and suggestions
- **Be Inclusive**: Welcome diverse perspectives and backgrounds
- **Be Collaborative**: Work together to improve the project
- **Follow Standards**: Adhere to Java coding standards and conventions

---

## 🚀 Getting Started

### Prerequisites

- Java 8 or higher installed
- Git installed and configured
- Text editor or IDE (VS Code, IntelliJ, Eclipse recommended)
- Basic knowledge of Java and Git

### Fork and Clone

1. **Fork the repository**
   - Go to [https://github.com/anitripathy83/java-swing-rpg](https://github.com/anitripathy83/java-swing-rpg)
   - Click **Fork** button

2. **Clone your fork**
   ```bash
   git clone https://github.com/YOUR_USERNAME/java-swing-rpg.git
   cd java-swing-rpg
   ```

3. **Add upstream remote**
   ```bash
   git remote add upstream https://github.com/anitripathy83/java-swing-rpg.git
   ```

### Set Up Development Environment

```bash
# Compile the project
javac -d . rpg/model/Entities/*.java rpg/model/Items/*.java \
        rpg/model/Rooms/*.java rpg/model/GameFactory.java \
        rpg/controller/GameController.java rpg/view/GameFrame.java \
        rpg/view/GamePanel.java

# Run the game to verify setup
java rpg.view.GameFrame
```

---

## 💻 Development Workflow

### Create a Feature Branch

```bash
# Update your local repository
git fetch upstream
git rebase upstream/main

# Create a new branch for your feature
git checkout -b feature/your-feature-name
```

### Branch Naming Conventions

Use descriptive branch names:

- `feature/new-monster-type` - Add new feature
- `bugfix/inventory-display` - Fix a bug
- `docs/installation-guide` - Documentation updates
- `refactor/game-factory` - Code refactoring
- `test/combat-system` - Add tests

### Make Your Changes

1. **Edit Java files** in the appropriate directories
2. **Test your changes** thoroughly
3. **Compile regularly** to catch errors early

Example:
```bash
# Make changes to a file
# Then recompile
javac -d . rpg/model/Entities/Player.java

# Test the changes
java rpg.view.GameFrame
```

### Commit Changes

See [Commit Guidelines](#commit-guidelines) for proper commit messages.

```bash
git add .
git commit -m "feat: add new weapon type - lightning sword"
```

### Push and Create Pull Request

```bash
# Push to your fork
git push origin feature/your-feature-name

# Go to GitHub and create a Pull Request
# Compare your branch with upstream/main
```

---

## 📝 Coding Standards

### Java Style Guide

#### 1. Class Naming
```java
// ✅ Good: PascalCase for classes
public class GameFactory { }
public class DarkSorcerer extends Monster { }

// ❌ Bad: camelCase for classes
public class gameFactory { }
```

#### 2. Method Naming
```java
// ✅ Good: camelCase for methods
public void takeDamage(int damage) { }
public String getPlayerName() { }

// ❌ Bad: PascalCase for methods
public void TakeDamage(int damage) { }
```

#### 3. Variable Naming
```java
// ✅ Good: Descriptive names
int playerHealth = 100;
ArrayList<Weapon> inventory;
String currentRoomName;

// ❌ Bad: Single letters (except loops)
int h = 100;
ArrayList<Weapon> inv;
String crn;
```

#### 4. Constants
```java
// ✅ Good: UPPER_CASE for constants
private static final int MAX_INVENTORY = 10;
private static final int BOSS_HP = 150;

// ❌ Bad: Regular naming for constants
private static final int maxInventory = 10;
```

### Code Organization

#### 1. File Structure
```java
package rpg.model.entities;

// Imports at top
import java.util.ArrayList;

// Class documentation
/**
 * Represents a game entity with health and name.
 */
public class Entity {
    
    // Fields first
    private String name;
    private int health;
    
    // Constructor
    public Entity(String name, int health) {
        this.name = name;
        this.health = health;
    }
    
    // Methods
    public String getName() {
        return name;
    }
    
    public void takeDamage(int damage) {
        health -= damage;
    }
}
```

#### 2. Method Documentation
```java
/**
 * Inflicts damage on this entity.
 * 
 * @param damage The amount of damage to inflict
 */
public void takeDamage(int damage) {
    this.health -= damage;
}

/**
 * Gets the current health of this entity.
 * 
 * @return Current health value
 */
public int getHealth() {
    return health;
}
```

#### 3. Comments
```java
// Use comments to explain WHY, not WHAT
// ✅ Good: Explains the reason
// Check if monster is defeated before removing from room
if (monster.getHealth() <= 0) {
    room.removeMonster(monster);
}

// ❌ Bad: Obvious from code
// Decrease health by damage amount
health = health - damage;
```

### Formatting

#### 1. Indentation
- Use **4 spaces** (no tabs)
- Consistent indentation throughout

#### 2. Line Length
- Keep lines under 100 characters
- Break long lines appropriately

```java
// ✅ Good
if (player.getHealth() > 0 && 
    room.hasMonsters() && 
    player.hasWeapons()) {
    // combat logic
}

// ❌ Bad: Too long
if (player.getHealth() > 0 && room.hasMonsters() && player.hasWeapons()) {
```

#### 3. Braces
```java
// ✅ Good: Opening brace on same line
public void attack() {
    // implementation
}

// ❌ Bad: Opening brace on new line
public void attack()
{
    // implementation
}
```

### Best Practices

#### 1. Use Meaningful Names
```java
// ✅ Good
ArrayList<Monster> enemiesInRoom = room.getMonsters();

// ❌ Bad
ArrayList<Monster> m = room.getMonsters();
```

#### 2. Keep Methods Small
```java
// ✅ Good: Single responsibility
private boolean isPlayerAlive() {
    return health > 0;
}

private void processVictory() {
    updateScore();
    saveProgress();
    displayMessage("You won!");
}
```

#### 3. Use Constants
```java
// ✅ Good
private static final int STARTING_HEALTH = 100;
int health = STARTING_HEALTH;

// ❌ Bad: Magic numbers
int health = 100;
```

#### 4. Handle Null Checks
```java
// ✅ Good: Check for null
if (player != null && player.hasWeapon()) {
    player.attack();
}

// ❌ Bad: No null check
player.attack();  // Might throw NullPointerException
```

---

## 📝 Commit Guidelines

### Commit Message Format

Use the following format:

```
<type>: <subject>

<body>

<footer>
```

### Types

- `feat`: New feature
- `fix`: Bug fix
- `docs`: Documentation only
- `style`: Code style changes
- `refactor`: Code refactoring
- `perf`: Performance improvement
- `test`: Test additions
- `chore`: Maintenance

### Examples

#### Good Commits
```
feat: add dragon boss to dragon's lair

- Implement Ancient Dragon monster
- Add special boss abilities
- Create boss victory condition

Fixes #42
```

```
fix: correct inventory overflow bug

- Check inventory size before adding items
- Display error message if full
- Prevent item loss

Fixes #15
```

```
docs: update installation instructions

- Clarify Java version requirement
- Add Windows-specific steps
- Include troubleshooting section
```

#### Bad Commits
```
❌ fixed stuff
❌ update
❌ asdf
❌ todo: implement feature
```

---

## 🔄 Pull Request Process

### Before Submitting

1. **Sync with upstream**
   ```bash
   git fetch upstream
   git rebase upstream/main
   ```

2. **Test thoroughly**
   ```bash
   javac -d . rpg/model/Entities/*.java rpg/model/Items/*.java \
           rpg/model/Rooms/*.java rpg/model/GameFactory.java \
           rpg/controller/GameController.java rpg/view/GameFrame.java \
           rpg/view/GamePanel.java
   java rpg.view.GameFrame
   ```

3. **Review your own changes** before submitting

### Pull Request Template

```markdown
## Description
Brief description of changes

## Type of Change
- [ ] New feature
- [ ] Bug fix
- [ ] Documentation update
- [ ] Code refactoring

## Related Issues
Fixes #[issue number]

## Testing
- [ ] Compiled successfully
- [ ] Game runs without errors
- [ ] Tested new feature thoroughly

## Screenshots (if applicable)
[Add screenshots here]

## Checklist
- [ ] Code follows style guidelines
- [ ] Added appropriate comments
- [ ] Updated documentation
- [ ] No breaking changes
```

### What Happens Next

1. **Code Review**: Maintainers will review your code
2. **Feedback**: You may receive suggestions or requests for changes
3. **Updates**: Update your PR based on feedback
4. **Merge**: Once approved, your PR will be merged

---

## 🐛 Reporting Issues

### Before Reporting

- Check existing issues to avoid duplicates
- Verify you're using the latest version
- Compile and test your setup

### How to Report

Click **Issues** on GitHub and use this template:

```markdown
## Description
Clear description of the bug

## Steps to Reproduce
1. Run the game
2. Go to [location]
3. Execute command: [command]

## Expected Behavior
What should happen

## Actual Behavior
What actually happens

## Environment
- OS: [Windows/Mac/Linux]
- Java Version: [e.g., 11.0.12]
- Game Version: [e.g., 2.0]

## Screenshots
[If applicable]

## Error Message
[Include any error messages]
```

---

## 💡 Feature Requests

### How to Request

1. Check existing feature requests first
2. Click **Issues** → **New Issue**
3. Select **Feature Request** template

### Feature Request Template

```markdown
## Description
What feature would you like?

## Use Case
Why would this feature be useful?

## Proposed Solution
How should it be implemented?

## Alternatives
Other possible approaches?

## Example
Show how it would be used
```

---

## 🎯 Good First Issues

Looking to get started? Check for issues labeled:
- `good first issue` - Easy for beginners
- `help wanted` - Needs assistance
- `documentation` - Docs improvements

---

## 📚 Additional Resources

- [Java Coding Standards](https://www.oracle.com/java/technologies/javase/codeconventions-contents.html)
- [GitHub Contributing Guide](https://docs.github.com/en/get-started/quickstart/contributing-to-projects)
- [Git Documentation](https://git-scm.com/doc)
- [Object-Oriented Programming](https://en.wikipedia.org/wiki/Object-oriented_programming)

---

## ❓ Questions?

- Check existing documentation
- Review closed issues for similar questions
- Open a new discussion on GitHub

---

## 🎉 Thank You!

Your contributions help make this project better for everyone. Thank you for your time and effort!

---

**Version**: 1.0 | **Last Updated**: December 2025  
**Status**: ✅ Active Development

🎮 **Happy contributing!** 🚀⚔️🐉

**[⬆ back to top](#-contributing-guidelines)**