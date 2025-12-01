package rpg.view;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import rpg.model.GameFactory;
import rpg.model.entities.Player;
import rpg.model.rooms.Room;
import rpg.model.items.Item;
import rpg.model.entities.Monster;
import rpg.controller.GameController;

/**
 * Enhanced GamePanel with professional UI, animations, and better layouts
 * Demonstrates: Advanced Swing, animations, event handling, layout management
 */
public class GamePanel extends JPanel {
    private GameController controller;
    private String playerName;
    private JTextArea roomDisplayArea;
    private JTextArea combatLogArea;
    private JTextArea inventoryArea;
    private JTextField commandInput;
    private JButton commandButton;
    private JButton moveNorthButton, moveSouthButton, moveEastButton, moveWestButton;
    private JLabel statusLabel;
    private JProgressBar healthBar;
    private JLabel levelLabel;
    private JLabel damageLabel;
    private JLabel equipmentLabel;
    private JPanel statsPanel;
    private JPanel playerAvatarPanel;
    private JLabel combatDamageLabel;
    private JLabel monsterHealthLabel;
    
    // Animation variables
    private float buttonHoverAlpha = 1.0f;
    private Timer animationTimer;
    private boolean isButtonHovered = false;
    
    public GamePanel(String playerName) {
        this.playerName = playerName;
        
        setLayout(new BorderLayout(15, 15));
        setBackground(new Color(20, 20, 30));
        setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        
        // Initialize controller with player name
        controller = new GameController();
        controller.getPlayer().setName(playerName);
        
        // Create UI components
        createPlayerInfoPanel();
        createMainGamePanel();
        createControlPanel();
        
        // Start animation timer
        startAnimationTimer();
        
        // Request focus for input
        commandInput.requestFocus();
    }
    
    /**
     * Create enhanced player info panel with avatar and stats
     */
    private void createPlayerInfoPanel() {
        JPanel topPanel = new JPanel(new BorderLayout(10, 10));
        topPanel.setBackground(new Color(25, 25, 40));
        topPanel.setBorder(new RoundedBorder(new Color(100, 100, 120), 3, 2));
        
        // Player Avatar Panel (Left)
        playerAvatarPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                drawPlayerAvatar(g);
            }
        };
        playerAvatarPanel.setBackground(new Color(30, 40, 60));
        playerAvatarPanel.setPreferredSize(new Dimension(120, 100));
        playerAvatarPanel.setBorder(new RoundedBorder(new Color(80, 100, 140), 3, 1));
        
        // Stats Panel (Center & Right)
        statsPanel = new JPanel(new GridLayout(4, 1, 5, 8));
        statsPanel.setBackground(new Color(25, 25, 40));
        statsPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        // Player Name
        statusLabel = new JLabel("▶ Player: " + playerName);
        statusLabel.setForeground(new Color(255, 215, 0));
        statusLabel.setFont(new Font("Arial", Font.BOLD, 14));
        
        // Health Bar
        healthBar = new JProgressBar(0, 100);
        healthBar.setValue(100);
        healthBar.setStringPainted(true);
        healthBar.setString("❤ HP: 100/100");
        healthBar.setForeground(new Color(0, 220, 80));
        healthBar.setBackground(new Color(40, 40, 50));
        healthBar.setFont(new Font("Arial", Font.BOLD, 11));
        healthBar.setBorder(new RoundedBorder(new Color(80, 100, 140), 3, 1));
        
        // Level & Experience
        levelLabel = new JLabel("⭐ Level: 1 | Exp: 0/100");
        levelLabel.setForeground(new Color(100, 200, 255));
        levelLabel.setFont(new Font("Arial", Font.BOLD, 12));
        
        // Damage & Equipment
        JPanel damageEquipPanel = new JPanel(new GridLayout(1, 2, 5, 5));
        damageEquipPanel.setBackground(new Color(25, 25, 40));
        
        damageLabel = new JLabel("⚔ DMG: 5");
        damageLabel.setForeground(new Color(255, 100, 100));
        damageLabel.setFont(new Font("Arial", Font.BOLD, 11));
        
        equipmentLabel = new JLabel("🛡 [None]");
        equipmentLabel.setForeground(new Color(200, 200, 100));
        equipmentLabel.setFont(new Font("Arial", Font.BOLD, 11));
        
        damageEquipPanel.add(damageLabel);
        damageEquipPanel.add(equipmentLabel);
        
        statsPanel.add(statusLabel);
        statsPanel.add(healthBar);
        statsPanel.add(levelLabel);
        statsPanel.add(damageEquipPanel);
        
        topPanel.add(playerAvatarPanel, BorderLayout.WEST);
        topPanel.add(statsPanel, BorderLayout.CENTER);
        
        add(topPanel, BorderLayout.NORTH);
    }
    
    /**
     * Draw player avatar as simple ASCII art
     */
    private void drawPlayerAvatar(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        int centerX = getWidth() / 2;
        int centerY = getHeight() / 2;
        
        // Head
        g2d.setColor(new Color(200, 150, 100));
        g2d.fillOval(centerX - 15, centerY - 35, 30, 30);
        
        // Body
        g2d.setColor(new Color(0, 150, 200));
        g2d.fillRect(centerX - 10, centerY - 5, 20, 25);
        
        // Arms
        g2d.fillRect(centerX - 20, centerY, 8, 20);
        g2d.fillRect(centerX + 12, centerY, 8, 20);
        
        // Legs
        g2d.setColor(new Color(100, 100, 100));
        g2d.fillRect(centerX - 8, centerY + 20, 7, 15);
        g2d.fillRect(centerX + 1, centerY + 20, 7, 15);
        
        // Eyes
        g2d.setColor(Color.WHITE);
        g2d.fillOval(centerX - 8, centerY - 28, 3, 3);
        g2d.fillOval(centerX + 5, centerY - 28, 3, 3);
    }
    
    /**
     * Create main game display panels (room, combat, inventory)
     */
    private void createMainGamePanel() {
        JPanel mainPanel = new JPanel(new GridLayout(1, 3, 12, 12));
        mainPanel.setBackground(new Color(20, 20, 30));
        
        // Room Display Panel
        roomDisplayArea = createStyledTextArea(new Color(30, 50, 80));
        mainPanel.add(createRoundedPanel("🏰 ROOM", roomDisplayArea));
        
        // Combat Log Panel with damage display
        JPanel combatPanel = new JPanel(new BorderLayout(5, 5));
        combatPanel.setBackground(new Color(80, 30, 30));
        combatPanel.setBorder(new RoundedBorder(new Color(150, 80, 80), 3, 2));
        combatPanel.setBorder(BorderFactory.createCompoundBorder(
            new RoundedBorder(new Color(150, 80, 80), 3, 2),
            BorderFactory.createEmptyBorder(8, 8, 8, 8)
        ));
        
        combatLogArea = createStyledTextArea(new Color(60, 20, 20));
        JScrollPane combatScroll = new JScrollPane(combatLogArea);
        combatScroll.setBackground(new Color(60, 20, 20));
        
        combatDamageLabel = new JLabel("Damage: 0");
        combatDamageLabel.setForeground(new Color(255, 100, 100));
        combatDamageLabel.setFont(new Font("Arial", Font.BOLD, 13));
        combatDamageLabel.setHorizontalAlignment(JLabel.CENTER);
        
        monsterHealthLabel = new JLabel("Monster: Healthy");
        monsterHealthLabel.setForeground(new Color(255, 150, 100));
        monsterHealthLabel.setFont(new Font("Arial", Font.BOLD, 11));
        monsterHealthLabel.setHorizontalAlignment(JLabel.CENTER);
        
        JPanel combatInfoPanel = new JPanel(new GridLayout(2, 1, 3, 3));
        combatInfoPanel.setBackground(new Color(80, 30, 30));
        combatInfoPanel.add(combatDamageLabel);
        combatInfoPanel.add(monsterHealthLabel);
        
        combatPanel.add(combatScroll, BorderLayout.CENTER);
        combatPanel.add(combatInfoPanel, BorderLayout.SOUTH);
        
        mainPanel.add(combatPanel);
        
        // Inventory Panel
        inventoryArea = createStyledTextArea(new Color(40, 80, 40));
        mainPanel.add(createRoundedPanel("🎒 INVENTORY", inventoryArea));
        
        add(mainPanel, BorderLayout.CENTER);
        updateDisplay();
    }
    
    /**
     * Create control panel with animated buttons
     */
    private void createControlPanel() {
        JPanel bottomPanel = new JPanel(new BorderLayout(10, 10));
        bottomPanel.setBackground(new Color(20, 20, 30));
        
        // Movement buttons with animation
        JPanel movementPanel = createAnimatedMovementPanel();
        
        // Command input panel
        JPanel commandPanel = new JPanel(new BorderLayout(5, 5));
        commandPanel.setBackground(new Color(20, 20, 30));
        
        JLabel cmdLabel = new JLabel("⌨ Command:");
        cmdLabel.setForeground(Color.WHITE);
        cmdLabel.setFont(new Font("Arial", Font.BOLD, 12));
        
        commandInput = new JTextField();
        commandInput.setBackground(new Color(40, 40, 50));
        commandInput.setForeground(new Color(100, 255, 100));
        commandInput.setFont(new Font("Monospaced", Font.PLAIN, 12));
        commandInput.setCaretColor(new Color(100, 255, 100));
        commandInput.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    handleCommand();
                }
            }
        });
        
        commandButton = createAnimatedButton("⚡ Execute", new Color(0, 180, 0));
        commandButton.addActionListener(e -> handleCommand());
        
        commandPanel.add(cmdLabel, BorderLayout.WEST);
        commandPanel.add(commandInput, BorderLayout.CENTER);
        commandPanel.add(commandButton, BorderLayout.EAST);
        
        bottomPanel.add(movementPanel, BorderLayout.NORTH);
        bottomPanel.add(commandPanel, BorderLayout.SOUTH);
        
        add(bottomPanel, BorderLayout.SOUTH);
    }
    
    /**
     * Create animated movement panel
     */
    private JPanel createAnimatedMovementPanel() {
        JPanel movementPanel = new JPanel(new GridLayout(2, 3, 8, 8));
        movementPanel.setBackground(new Color(20, 20, 30));
        movementPanel.setBorder(BorderFactory.createTitledBorder(
            BorderFactory.createLineBorder(new Color(100, 100, 120), 1),
            "🗺 Movement",
            0, 0,
            new Font("Arial", Font.BOLD, 11),
            new Color(100, 200, 255)
        ));
        
        movementPanel.add(new JLabel());
        moveNorthButton = createAnimatedButton("⬆ NORTH", new Color(0, 150, 200));
        moveNorthButton.addActionListener(e -> handleMovement("north"));
        movementPanel.add(moveNorthButton);
        movementPanel.add(new JLabel());
        
        moveSouthButton = createAnimatedButton("⬇ SOUTH", new Color(0, 150, 200));
        moveSouthButton.addActionListener(e -> handleMovement("south"));
        moveWestButton = createAnimatedButton("⬅ WEST", new Color(0, 150, 200));
        moveWestButton.addActionListener(e -> handleMovement("west"));
        moveEastButton = createAnimatedButton("➡ EAST", new Color(0, 150, 200));
        moveEastButton.addActionListener(e -> handleMovement("east"));
        
        movementPanel.add(moveSouthButton);
        movementPanel.add(moveWestButton);
        movementPanel.add(moveEastButton);
        
        return movementPanel;
    }
    
    /**
     * Handle movement with animation
     */
    private void handleMovement(String direction) {
        String result = controller.movePlayer(direction);
        addToCombatLog("▶ You moved " + direction);
        addToCombatLog(result);
        updateDisplay();
        playSound("move");
    }
    
    /**
     * Handle command execution
     */
    private void handleCommand() {
        String command = commandInput.getText().trim();
        if (command.isEmpty()) return;
        
        String result = controller.executeCommand(command);
        addToCombatLog("► " + command);
        addToCombatLog(result);
        commandInput.setText("");
        updateDisplay();
        
        if (result.contains("defeated") || result.contains("Victory")) {
            playSound("victory");
        } else if (result.contains("attack")) {
            playSound("hit");
        }
    }
    
    /**
     * Update all display panels with current game state
     */
    private void updateDisplay() {
        Player player = controller.getPlayer();
        
        // Update room display
        Room currentRoom = player.getCurrentRoom();
        if (currentRoom != null) {
            roomDisplayArea.setText(currentRoom.describe());
        }
        
        // Update inventory
        updateInventoryDisplay(player);
        
        // Update stats
        int hp = player.getCurrentHP();
        int maxHp = player.getMaxHP();
        int healthPercent = (hp * 100) / maxHp;
        healthBar.setValue(healthPercent);
        healthBar.setString("❤ HP: " + hp + "/" + maxHp);
        
        // Color health bar based on HP
        if (healthPercent > 50) {
            healthBar.setForeground(new Color(0, 220, 80));
        } else if (healthPercent > 25) {
            healthBar.setForeground(new Color(255, 200, 0));
        } else {
            healthBar.setForeground(new Color(255, 50, 50));
        }
        
        levelLabel.setText("⭐ Level: " + player.getLevel() + 
                          " | Exp: " + player.getExperience() + "/" + (player.getLevel() * 100));
        
        damageLabel.setText("⚔ DMG: " + player.calculateDamage());
        
        if (player.getEquippedWeapon() != null) {
            equipmentLabel.setText("🛡 " + player.getEquippedWeapon().getName());
        } else {
            equipmentLabel.setText("🛡 [None]");
        }
        
        // Update combat info
        Monster monster = currentRoom != null ? currentRoom.getMonster() : null;
        if (monster != null && monster.isAlive()) {
            combatDamageLabel.setText("⚔ Last Damage: 0");
            int monsterHp = monster.getCurrentHP();
            int monsterMaxHp = monster.getMaxHP();
            int healthPercent2 = (monsterHp * 100) / monsterMaxHp;
            
            String healthStatus = "Healthy";
            Color healthColor = new Color(100, 255, 100);
            if (healthPercent2 > 50) {
                healthStatus = "Healthy";
                healthColor = new Color(100, 255, 100);
            } else if (healthPercent2 > 25) {
                healthStatus = "Wounded";
                healthColor = new Color(255, 200, 0);
            } else {
                healthStatus = "Critical";
                healthColor = new Color(255, 50, 50);
            }
            
            monsterHealthLabel.setText("🔴 " + monster.getName() + ": " + healthStatus + 
                                       " (" + monsterHp + "/" + monsterMaxHp + ")");
            monsterHealthLabel.setForeground(healthColor);
        } else {
            combatDamageLabel.setText("✓ No Combat");
            monsterHealthLabel.setText("🟢 Area Clear");
            monsterHealthLabel.setForeground(new Color(100, 255, 100));
        }
        
        // Check game over
        if (!player.isAlive()) {
            showGameOver(false);
        } else if (currentRoom != null && currentRoom.getName().equals("Treasure Room") && 
                   (currentRoom.getMonster() == null || !currentRoom.getMonster().isAlive())) {
            showGameOver(true);
        }
    }
    
    /**
     * Update inventory display
     */
    private void updateInventoryDisplay(Player player) {
        StringBuilder sb = new StringBuilder();
        sb.append("ITEMS (").append(player.getInventorySize()).append(")\n");
        sb.append("═════════════════════════\n\n");
        
        if (player.getEquippedWeapon() != null) {
            sb.append("⚡ [EQUIPPED]\n");
            sb.append("  ").append(player.getEquippedWeapon().toString()).append("\n\n");
        }
        
        for (Item item : player.getInventory()) {
            if (!item.equals(player.getEquippedWeapon())) {
                sb.append("• ").append(item.toString()).append("\n");
            }
        }
        
        if (player.getInventorySize() == 0) {
            sb.append("(Empty)");
        }
        
        inventoryArea.setText(sb.toString());
    }
    
    /**
     * Add message to combat log
     */
    private void addToCombatLog(String message) {
        combatLogArea.append(message + "\n");
        combatLogArea.setCaretPosition(combatLogArea.getDocument().getLength());
    }
    
    /**
     * Show game over dialog
     */
    private void showGameOver(boolean won) {
        String title = won ? "🏆 Victory!" : "💀 Game Over!";
        String message = won ? 
            "You have defeated the Dragon and claimed the treasure!\n\nCongratulations!" :
            "Your adventure has ended.\nYou have been defeated.\n\nGame Over!";
        
        playSound(won ? "victory" : "death");
        
        JOptionPane.showMessageDialog(this, message, title, 
            won ? JOptionPane.INFORMATION_MESSAGE : JOptionPane.WARNING_MESSAGE);
    }
    
    /**
     * Create styled text area
     */
    private JTextArea createStyledTextArea(Color bgColor) {
        JTextArea area = new JTextArea();
        area.setEditable(false);
        area.setBackground(bgColor);
        area.setForeground(Color.WHITE);
        area.setFont(new Font("Monospaced", Font.PLAIN, 11));
        area.setLineWrap(true);
        area.setWrapStyleWord(true);
        area.setBorder(BorderFactory.createEmptyBorder(8, 8, 8, 8));
        return area;
    }
    
    /**
     * Create rounded panel with title
     */
    private JPanel createRoundedPanel(String title, JComponent component) {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(new Color(20, 20, 30));
        panel.setBorder(BorderFactory.createCompoundBorder(
            new RoundedBorder(new Color(100, 100, 120), 3, 2),
            BorderFactory.createEmptyBorder(8, 8, 8, 8)
        ));
        
        JLabel titleLabel = new JLabel(title);
        titleLabel.setForeground(new Color(150, 200, 255));
        titleLabel.setFont(new Font("Arial", Font.BOLD, 12));
        
        JScrollPane scrollPane = new JScrollPane(component);
        scrollPane.setBackground(new Color(30, 30, 40));
        scrollPane.getViewport().setBackground(new Color(30, 30, 40));
        
        panel.add(titleLabel, BorderLayout.NORTH);
        panel.add(scrollPane, BorderLayout.CENTER);
        return panel;
    }
    
    /**
     * Create animated button with hover effects
     */
    private JButton createAnimatedButton(String text, Color bgColor) {
        JButton button = new JButton(text) {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2d = (Graphics2D) g;
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                
                // Draw button with gradient
                GradientPaint gradient = new GradientPaint(0, 0, bgColor, 0, getHeight(), bgColor.darker());
                g2d.setPaint(gradient);
                g2d.fillRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 8, 8);
                
                // Draw border
                g2d.setColor(bgColor.brighter());
                g2d.setStroke(new BasicStroke(2));
                g2d.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 8, 8);
                
                // Draw text
                super.paintComponent(g);
            }
        };
        
        button.setBackground(bgColor);
        button.setForeground(Color.WHITE);
        button.setFont(new Font("Arial", Font.BOLD, 11));
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createEmptyBorder(8, 15, 8, 15));
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                button.setBackground(bgColor.brighter());
                button.repaint();
            }
            
            @Override
            public void mouseExited(MouseEvent e) {
                button.setBackground(bgColor);
                button.repaint();
            }
            
            @Override
            public void mousePressed(MouseEvent e) {
                button.setBackground(bgColor.darker());
                button.repaint();
            }
            
            @Override
            public void mouseReleased(MouseEvent e) {
                button.setBackground(bgColor.brighter());
                button.repaint();
            }
        });
        
        return button;
    }
    
    /**
     * Start animation timer
     */
    private void startAnimationTimer() {
        animationTimer = new Timer(30, e -> {
            playerAvatarPanel.repaint();
        });
        animationTimer.start();
    }
    
    /**
     * Play sound effect
     * Note: Requires audio files in resources folder
     * For now, this is a placeholder
     */
    private void playSound(String soundType) {
        try {
            // Placeholder for sound - would need audio files
            // Toolkit.getDefaultToolkit().beep();
        } catch (Exception e) {
            // Silent fail
        }
    }
    
    /**
     * Custom rounded border class
     */
    private static class RoundedBorder extends AbstractBorder {
        private Color color;
        private int radius;
        private int thickness;
        
        public RoundedBorder(Color color, int radius, int thickness) {
            this.color = color;
            this.radius = radius;
            this.thickness = thickness;
        }
        
        @Override
        public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
            Graphics2D g2d = (Graphics2D) g;
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.setColor(color);
            g2d.setStroke(new BasicStroke(thickness));
            g2d.drawRoundRect(x, y, width - 1, height - 1, radius, radius);
        }
        
        @Override
        public Insets getBorderInsets(Component c) {
            return new Insets(thickness + 2, thickness + 2, thickness + 2, thickness + 2);
        }
    }
}
