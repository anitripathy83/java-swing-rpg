# 🚀 Setup & Installation Guide

Complete step-by-step guide to set up and run the Java Swing RPG game on your computer.

## 📋 Table of Contents

- [System Requirements](#system-requirements)
- [Installation Steps](#installation-steps)
- [Compilation](#compilation)
- [Running the Game](#running-the-game)
- [Troubleshooting](#troubleshooting)
- [File Structure](#file-structure)

---

## 💻 System Requirements

### Minimum Requirements
- **Operating System**: Windows, macOS, or Linux
- **Java Version**: Java 8 or higher
- **RAM**: 512 MB minimum
- **Storage**: 50 MB free space
- **Terminal/Console**: Command Prompt, PowerShell, or Terminal

### Recommended Requirements
- **Java Version**: Java 11 or higher
- **RAM**: 2 GB or more
- **Modern OS**: Windows 10+, macOS 10.14+, or recent Linux

### Verify Java Installation

Check if Java is installed:
```bash
java -version
```

You should see output like:
```
java version "11.0.x" 2021-xx-xx
Java(TM) SE Runtime Environment (build 11.0.x+xxx)
```

If Java is not installed, download from [oracle.com/java](https://www.oracle.com/java/technologies/downloads/)

---

## 📥 Installation Steps

### Step 1: Clone or Download Repository

#### Option A: Clone with Git (Recommended)
```bash
cd Desktop
git clone https://github.com/anitripathy83/java-swing-rpg.git
cd java-swing-rpg
```

#### Option B: Download ZIP
1. Go to [https://github.com/anitripathy83/java-swing-rpg](https://github.com/anitripathy83/java-swing-rpg)
2. Click **Code** → **Download ZIP**
3. Extract the ZIP file to your Desktop
4. Open the extracted folder

### Step 2: Verify Project Structure

Ensure your folder structure looks like this:

```
java-swing-rpg/
├── rpg/
│   ├── model/
│   │   ├── Entities/
│   │   │   ├── Entity.java
│   │   │   ├── Player.java
│   │   │   └── Monster.java
│   │   ├── Items/
│   │   │   ├── Item.java
│   │   │   ├── Weapon.java
│   │   │   └── Potion.java
│   │   ├── Rooms/
│   │   │   └── Room.java
│   │   └── GameFactory.java
│   ├── controller/
│   │   └── GameController.java
│   └── view/
│       ├── GameFrame.java
│       └── GamePanel.java
├── README.md
├── SETUP.md (this file)
└── LICENSE
```

---

## 🔧 Compilation

### Windows (Command Prompt or PowerShell)

Navigate to the project root and run:

```bash
cd java-swing-rpg

javac -d . rpg/model/Entities/*.java rpg/model/Items/*.java ^
        rpg/model/Rooms/*.java rpg/model/GameFactory.java ^
        rpg/controller/GameController.java rpg/view/GameFrame.java ^
        rpg/view/GamePanel.java
```

### macOS or Linux (Terminal)

```bash
cd java-swing-rpg

javac -d . rpg/model/Entities/*.java rpg/model/Items/*.java \
        rpg/model/Rooms/*.java rpg/model/GameFactory.java \
        rpg/controller/GameController.java rpg/view/GameFrame.java \
        rpg/view/GamePanel.java
```

### Alternative: Compile Individual Files

If the above command doesn't work, compile files separately:

```bash
# Compile all Entities
javac -d . rpg/model/Entities/Entity.java
javac -d . rpg/model/Entities/Player.java
javac -d . rpg/model/Entities/Monster.java

# Compile all Items
javac -d . rpg/model/Items/Item.java
javac -d . rpg/model/Items/Weapon.java
javac -d . rpg/model/Items/Potion.java

# Compile remaining files
javac -d . rpg/model/Rooms/Room.java
javac -d . rpg/model/GameFactory.java
javac -d . rpg/controller/GameController.java
javac -d . rpg/view/GameFrame.java
javac -d . rpg/view/GamePanel.java
```

### Verification

After compilation, you should see `.class` files in your `rpg/` directories. Check:

```bash
ls -R rpg/  # On macOS/Linux
dir /s rpg  # On Windows
```

You should see files like `Entity.class`, `Player.class`, etc.

---

## ▶️ Running the Game

Once compiled, run the game from the project root:

```bash
java rpg.view.GameFrame
```

**Expected Output:**
- A new window opens with the game title
- A text input field prompts you to enter your character name
- The game starts in the Castle Entrance

### Troubleshooting Runtime Issues

**Error: `Could not find or load main class rpg.view.GameFrame`**
- Make sure you're in the correct directory (project root)
- Verify all files compiled successfully
- Try compiling again

**Error: `NoClassDefFoundError`**
- Check that all class files exist in the correct directories
- Recompile all files

**Game window doesn't appear:**
- Ensure Java can access the GUI
- Try running from Terminal instead of IDE
- Check if X11 is installed (macOS/Linux)

---

## 🎮 First Gameplay Steps

1. **Enter Name**: Type your character name when prompted
2. **Enter Game**: Press Enter to start
3. **View Commands**: Type `help` to see all available commands
4. **Explore**: Start with `look` to examine your current room
5. **Move**: Type `go north` to move to adjacent rooms
6. **Collect Items**: Use `get <item>` to pick up weapons and potions
7. **Attack**: Use `attack` to fight monsters in the room
8. **Progress**: Explore deeper into the dungeon
9. **Boss Battle**: Reach Dragon's Lair and defeat the Ancient Dragon
10. **Victory**: Complete the game! 🏆

---

## 📁 File Structure Explanation

### Model Layer (`rpg/model/`)
- **Entities/**: Player and Monster classes defining game characters
- **Items/**: Weapon and Potion classes for collectibles
- **Rooms/**: Room class defining dungeon locations
- **GameFactory.java**: Creates the entire game world

### Controller Layer (`rpg/controller/`)
- **GameController.java**: Handles all game logic and command processing

### View Layer (`rpg/view/`)
- **GameFrame.java**: Main application window
- **GamePanel.java**: GUI components and displays

---

## 🐛 Troubleshooting

### Compilation Issues

| Error | Cause | Solution |
|-------|-------|----------|
| `cannot find symbol` | Missing imports or incorrect class names | Verify spelling, check imports |
| `class X is public, should be declared in a file named X.java` | Class name doesn't match filename | Rename file to match class name |
| `'.java' expected` | Syntax error in Java code | Check for missing braces, semicolons |
| `incompatible types` | Type mismatch in assignment | Check variable types |

### Runtime Issues

| Error | Cause | Solution |
|-------|-------|----------|
| `NoClassDefFoundError` | Missing class file | Recompile all files |
| `Could not find main class` | Wrong class path | Ensure rpg.view.GameFrame exists |
| `OutOfMemoryError` | Not enough RAM | Close other applications |
| `NullPointerException` | Accessing null object | Restart game |

### Performance Issues

| Issue | Cause | Solution |
|-------|-------|----------|
| Game is slow | Too many monsters | Reduce monster count |
| Text is hard to read | Font size | Modify GamePanel.java font size |
| Game crashes | Out of memory | Increase Java heap: `java -Xmx512m rpg.view.GameFrame` |

---

## 🔄 Recompiling After Changes

If you modify any Java file, recompile:

```bash
# Full recompile
javac -d . rpg/model/Entities/*.java rpg/model/Items/*.java \
        rpg/model/Rooms/*.java rpg/model/GameFactory.java \
        rpg/controller/GameController.java rpg/view/GameFrame.java \
        rpg/view/GamePanel.java

# Or compile just the modified file
javac -d . rpg/[path]/[FileName].java
```

Then run again:
```bash
java rpg.view.GameFrame
```

---

## 💾 Save/Load (Future Feature)

Currently, the game does not save progress. Each session starts fresh. Future versions may include:
- Save/Load game state
- Player statistics tracking
- Achievement system
- Custom difficulty levels

---

## 🎓 Development Environment

### Using an IDE (Optional)

#### IntelliJ IDEA
1. Open IntelliJ IDEA
2. File → Open → Select `java-swing-rpg` folder
3. Right-click `GameFrame.java` → Run

#### Eclipse
1. File → Import → Existing Projects into Workspace
2. Select `java-swing-rpg` folder
3. Right-click project → Run As → Java Application

#### VS Code
1. Install Extension Pack for Java
2. Open folder in VS Code
3. Use integrated terminal to run commands above

---

## 📊 Project Statistics

- **Total Files**: 11 Java files
- **Lines of Code**: ~2,500
- **Compilation Time**: ~2-3 seconds
- **Game Size**: ~500 KB (including class files)
- **Memory Usage**: ~50-100 MB during gameplay

---

## ✅ Verification Checklist

After setup, verify:

- [ ] Java is installed and version 8+
- [ ] Project folder structure is correct
- [ ] All Java files are present
- [ ] Compilation completes without errors
- [ ] `.class` files are generated
- [ ] Game window opens when running
- [ ] Character name input works
- [ ] Game commands respond correctly
- [ ] Game is playable

---

## 🎯 Next Steps

1. ✅ Complete setup and compilation
2. ✅ Run the game and explore
3. ✅ Read [README.md](README.md) for game details
4. ✅ Check [CONTRIBUTING.md](CONTRIBUTING.md) for development
5. ✅ Review Java source files to understand code

---

## 📞 Support

For issues or questions:
1. Check [Troubleshooting](#troubleshooting) section
2. Review Java files for implementation details
3. Consult Java documentation
4. Check GitHub issues page

---

**Version**: 2.0 | **Last Updated**: December 2025  
**Status**: ✅ Ready to Use

🎮 **Happy gaming!** 🚀⚔️🐉

**[⬆ back to top](#-setup--installation-guide)**