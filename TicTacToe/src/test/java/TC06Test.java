import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TC06Test {

    @Test
    void testPlayerAlternatesAfterEachMove() {
        TicTacToe game = new TicTacToe('X'); // Start game with player 'X'

        // Simulate actual button clicks
        game.buttons[0][0].doClick(); // X moves
        assertEquals('O', game.currentPlayer, "After X moves, it should be O's turn");

        game.buttons[0][1].doClick(); // O moves
        assertEquals('X', game.currentPlayer, "After O moves, it should be X's turn");

        game.buttons[0][2].doClick(); // X moves
        assertEquals('O', game.currentPlayer, "After X moves, it should be O's turn");
    }

    @Test
    void testTurnDoesNotChangeIfMoveIsInvalid() {
        TicTacToe game = new TicTacToe('X');

        // X moves
        game.buttons[1][1].doClick();
        assertEquals('O', game.currentPlayer, "After X moves, it should be O's turn");

        // O tries to overwrite the same cell (invalid move)
        game.buttons[1][1].doClick();
        assertEquals('O', game.currentPlayer, "Turn should not change if move is invalid");

        // O makes a valid move
        game.buttons[2][2].doClick();
        assertEquals('X', game.currentPlayer, "After O moves, it should be X's turn");
    }

    @Test
    void testTurnDoesNotChangeAfterWin() {
        TicTacToe game = new TicTacToe('X');

        // Simulating a winning sequence for X
        game.buttons[0][0].doClick();
        game.buttons[1][1].doClick();
        game.buttons[0][1].doClick();
        game.buttons[2][2].doClick();
        game.buttons[0][2].doClick(); // X wins

        // Print board state for debugging
        System.out.println("Board State After Moves:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(game.buttons[i][j].getText() + " ");
            }
            System.out.println();
        }

        assertTrue(game.checkWinner(), "X should have won the game");

        char winner = game.currentPlayer;

        // O tries to make a move after X has won
        game.buttons[2][0].doClick();
        assertEquals(winner, game.currentPlayer, "Turn should not change after a win");
    }
}
