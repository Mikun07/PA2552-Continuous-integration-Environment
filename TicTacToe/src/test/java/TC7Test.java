import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import javax.swing.*;

public class TC7Test { // No package declarations
    private TicTacToe game;

    @BeforeEach
    void setUp() {
        game = new TicTacToe('X'); // Initialize game with player 'X'
        // game.setVisible(true); // Ensure UI is loaded before interacting with buttons
    }

    @Test
    void testPlayerMoves() {
        JButton button1 = game.buttons[0][0]; // First move (X)
        JButton button2 = game.buttons[1][1]; // Second move (O)

        button1.doClick(); // Player 'X' clicks
        assertEquals("X", button1.getText(), "Button should display 'X'");
        assertEquals('O', game.currentPlayer, "Next turn should be 'O'");

        button2.doClick(); // Player 'O' clicks
        assertEquals("O", button2.getText(), "Button should display 'O'");
        assertEquals('X', game.currentPlayer, "Turn should switch back to 'X'");
    }
}
