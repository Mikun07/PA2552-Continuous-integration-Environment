import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TC06Test {

    @Test
    void testPlayerAlternatesAfterEachMove() {
        TicTacToe game = new TicTacToe('X');
        System.out.println("Starting test: testPlayerAlternatesAfterEachMove");

        game.simulateMove(0, 0); // X moves
        assertEquals('O', game.getCurrentPlayer(), "After X moves, it should be O's turn");

        game.simulateMove(0, 1); // O moves
        assertEquals('X', game.getCurrentPlayer(), "After O moves, it should be X's turn");

        game.simulateMove(0, 2); // X moves
        assertEquals('O', game.getCurrentPlayer(), "After X moves, it should be O's turn");
    }

    @Test
    void testTurnDoesNotChangeIfMoveIsInvalid() {
        TicTacToe game = new TicTacToe('X');
        System.out.println("Starting test: testTurnDoesNotChangeIfMoveIsInvalid");

        game.simulateMove(1, 1); // X moves
        assertEquals('O', game.getCurrentPlayer(), "After X moves, it should be O's turn");

        game.simulateMove(1, 1); // O tries invalid move
        assertEquals('O', game.getCurrentPlayer(), "Turn should not change if move is invalid");

        game.simulateMove(2, 2); // O makes valid move
        assertEquals('X', game.getCurrentPlayer(), "After O moves, it should be X's turn");
    }

    @Test
    void testTurnDoesNotChangeAfterWin() {
        TicTacToe game = new TicTacToe('X');
        System.out.println("Starting test: testTurnDoesNotChangeAfterWin");

        game.simulateMove(0, 0); // X
        game.simulateMove(1, 1); // O
        game.simulateMove(0, 1); // X
        game.simulateMove(2, 2); // O
        game.simulateMove(0, 2); // X wins

        assertTrue(game.checkWinner(), "X should have won the game");

        char winner = game.getCurrentPlayer();

        game.simulateMove(2, 0); // O tries to move after win
        assertEquals(winner, game.getCurrentPlayer(), "Turn should not change after a win");
    }
}
