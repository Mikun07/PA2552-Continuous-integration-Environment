import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TicTacToeTest {
    private TicTacToe game;

    @BeforeEach
    void setUp() {
        game = new TicTacToe('X'); // Start game with player 'X'
    }

    @Test
    void testResetBoard() {
        // Simulate some moves
        game.buttons[0][0].setText("X");
        game.buttons[1][1].setText("O");

        // Reset the board
        game.resetBoard();

        // Verify all cells are empty
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                assertEquals(" ", game.buttons[i][j].getText());
            }
        }
    }
}
