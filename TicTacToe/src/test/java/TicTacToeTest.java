import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
// import javax.swing.*;

public class TicTacToeTest {

    @Test
    void testHorizontalWin() {
        TicTacToe game = new TicTacToe('X');
        game.buttons[0][0].setText("X");
        game.buttons[0][1].setText("X");
        game.buttons[0][2].setText("X");

        assertTrue(game.checkWinner(), "Horizontal win condition failed.");
    }

    @Test
    void testVerticalWin() {
        TicTacToe game = new TicTacToe('X');
        game.buttons[0][0].setText("X");
        game.buttons[1][0].setText("X");
        game.buttons[2][0].setText("X");

        assertTrue(game.checkWinner(), "Vertical win condition failed.");
    }

    @Test
    void testDiagonalWin() {
        TicTacToe game = new TicTacToe('X');
        game.buttons[0][0].setText("X");
        game.buttons[1][1].setText("X");
        game.buttons[2][2].setText("X");

        assertTrue(game.checkWinner(), "Diagonal win condition failed.");
    }
}
