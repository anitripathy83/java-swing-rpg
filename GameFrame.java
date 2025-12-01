package rpg.view;


import java.awt.image.BufferedImage;
import javax.swing.*;
import java.awt.*;

/**
 * Main GUI frame for the RPG game with player name input
 * Demonstrates: Swing, event handling, dialogs
 */
public class GameFrame extends JFrame {
    private GamePanel gamePanel;
    
    public GameFrame() {
        setTitle("⚔ Text-Based RPG Adventure - Java Swing GUI ⚔");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1200, 800);
        setLocationRelativeTo(null);
        setResizable(true);
        setIconImage(createIcon());
        
        // Get player name from user
        String playerName = getPlayerName();
        
        // Create game panel with player name
        gamePanel = new GamePanel(playerName);
        add(gamePanel);
        
        setVisible(true);
    }
    
    /**
     * Prompt user for player name
     */
    private String getPlayerName() {
        String name = JOptionPane.showInputDialog(
            null,
            "Welcome to the RPG Adventure!\n\nEnter your character name:",
            "Character Creation",
            JOptionPane.QUESTION_MESSAGE
        );
        
        // If user cancels or enters empty string, use default
        if (name == null || name.trim().isEmpty()) {
            name = "Hero";
        }
        
        return name.trim();
    }
    
    /**
     * Create a simple game icon
     */
    private Image createIcon() {
        BufferedImage image = new BufferedImage(64, 64, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = image.createGraphics();
        g2d.setColor(new Color(50, 50, 150));
        g2d.fillRect(0, 0, 64, 64);
        g2d.setColor(new Color(255, 215, 0));
        g2d.fillRect(20, 20, 24, 24);
        g2d.dispose();
        return image;
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new GameFrame());
    }
}
