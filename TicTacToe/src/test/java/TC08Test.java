import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Test case to verify that the TicTacToe interface is created properly
 * and JButtons are loaded correctly.
 */
public class TC08Test {

    private JFrame frame;
    private TicTacToe game;

    @BeforeEach
    public void setUp() {
        // Create a frame to host the TicTacToe interface
        frame = new JFrame("TicTacToe Test");
        
        // Create the TicTacToe game
        game = new TicTacToe('X');
        
        // Create a JFrame to hold the game's buttons for testing
        frame.setLayout(new GridLayout(3, 3));
        
        // Add buttons to the frame
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                // Set button names for easier identification in testing
                game.buttons[i][j].setName("button" + i + j);
                frame.add(game.buttons[i][j]);
            }
        }
        
        // Make the frame visible
        frame.setSize(300, 300);
        frame.setVisible(true);
    }
    
    @Test
    public void testJButtonsAreLoadedCorrectly() {
        // Verify the frame has the right layout
        assertTrue(frame.getLayout() instanceof GridLayout);
        
        // Verify the buttons exist and are placed in the UI
        assertEquals(9, frame.getContentPane().getComponentCount(), 
                "Frame should contain 9 buttons");
        
        // Verify each button's properties
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                JButton button = game.buttons[row][col];
                
                // Verify button exists
                assertNotNull(button, "Button at position [" + row + "][" + col + "] should exist");
                
                // Verify button is in the frame
                assertTrue(frame.getContentPane().isAncestorOf(button),
                        "Button should be added to the frame");
                
                // Verify button name
                assertEquals("button" + row + col, button.getName(), 
                        "Button should have correct name");
                
                // Verify initial button state
                assertEquals(" ", button.getText(), 
                        "Button should have empty text initially");
                
                // Verify button styling
                assertEquals(new Font("Arial", Font.PLAIN, 60), button.getFont(), 
                        "Button should have correct font");
                
                // Verify button appearance
                assertTrue(!button.isFocusPainted(), 
                        "Button should not have focus painting");
                
                // Verify button visibility
                assertTrue(button.isVisible(), 
                        "Button should be visible");
            }
        }
    }
    
    @AfterEach
    public void tearDown() {
        // Clean up resources after test
        if (frame != null) {
            frame.dispose();
        }
    }
}