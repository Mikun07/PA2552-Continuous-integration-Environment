import java.awt.Font;

import javax.swing.JButton;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TC08Test {

    private TicTacToe game;

    @BeforeEach
    public void setUp() {
        //create a new TicTacToe game
        game= new TicTacToe('X');
        //set button name to test
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                game.buttons[i][j].setName("button" + i + j);
            }
        }
    }

    @Test
    public void testJButtonsProperties() {
        // check button array is initialized
        assertNotNull(game.buttons, "buttons array should be initialized");
        assertEquals(3, game.buttons.length, "should have 3 rows of buttons");
        // check each button
        for (int row = 0; row < 3; row++) {
            assertEquals(3, game.buttons[row].length, "No." + row + " row should have 3 buttons");
            
            for (int col = 0; col < 3; col++) {
                JButton button = game.buttons[row][col];
                assertNotNull(button, "location[" + row + "][" + col + "] should have a button");
                assertEquals("button" + row + col, button.getName(), "button should have correct name");
                assertEquals(" ", button.getText(), "button should have empty text");
                
                assertEquals(new Font("Arial", Font.PLAIN, 60), button.getFont(), "button should have correct font");
                assertTrue(!button.isFocusPainted(), "button should not be focus painted");
            }
        }
    }
}