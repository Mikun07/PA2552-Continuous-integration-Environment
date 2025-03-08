import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import javax.swing.SwingUtilities;

public class TC02Test {

    private void clickButton(TicTacToe game, int row, int col) {
        SwingUtilities.invokeLater(() -> game.buttons[row][col].doClick());
        try {
            Thread.sleep(100); // Wait for the UI to update
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    @Test
    void testHorizontalWin() {
        TicTacToe game = new TicTacToe('X');
        game.testMode = true; // Enable test mode (disables player switching)

        clickButton(game, 0, 0);
        clickButton(game, 0, 1);
        clickButton(game, 0, 2);

        assertEquals("X", game.buttons[0][0].getText());
        assertEquals("X", game.buttons[0][1].getText());
        assertEquals("X", game.buttons[0][2].getText());
    }

    @Test
    void testVerticalWin() {
        TicTacToe game = new TicTacToe('X');
        game.testMode = true;

        clickButton(game, 0, 0);
        clickButton(game, 1, 0);
        clickButton(game, 2, 0);

        assertEquals("X", game.buttons[0][0].getText());
        assertEquals("X", game.buttons[1][0].getText());
        assertEquals("X", game.buttons[2][0].getText());
    }

    @Test
    void testDiagonalWin() {
        TicTacToe game = new TicTacToe('X');
        game.testMode = true;

        clickButton(game, 0, 0);
        clickButton(game, 1, 1);
        clickButton(game, 2, 2);

        assertEquals("X", game.buttons[0][0].getText());
        assertEquals("X", game.buttons[1][1].getText());
        assertEquals("X", game.buttons[2][2].getText());
    }
}
