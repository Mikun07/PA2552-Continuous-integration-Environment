import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Test case to verify that the TicTacToe interface is created properly
 * and JButtons are loaded correctly.
 */
public class TC08Test {

    private TicTacToe game;
    private JPanel panel;

    @BeforeEach
    public void setUp() {
        
        // Create the TicTacToe game
        game = new TicTacToe('X');
        
        panel = new JPanel(new GridLayout(3, 3));
        // Add buttons to the frame
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                // Set button names for easier identification in testing
                game.buttons[i][j].setName("button" + i + j);
                panel.add(game.buttons[i][j]);
            }
        }
    }
    
    @Test
    public void testJButtonsAreLoadedCorrectly() {
        // Verify the frame has the right layout
        assertTrue(panel.getLayout() instanceof GridLayout);
        
        // Verify the buttons exist and are placed in the UI
        assertEquals(9, panel.getComponentCount(), 
                "Panel should contain 9 buttons");
        
        // Verify each button's properties
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                JButton button = game.buttons[row][col];
                
                // Verify button exists
                assertNotNull(button, "Button at position [" + row + "][" + col + "] should exist");
                
                // Verify button is in the panel
                assertTrue(panel.isAncestorOf(button),
                        "Button should be added to the panel");
                
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
       panel.removeAll();
       panel = null;
       game = null;    
    }
}