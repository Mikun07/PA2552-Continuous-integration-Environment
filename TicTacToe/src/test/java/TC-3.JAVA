import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TicTacToeTest {
    private TicTacToe game;

    @BeforeEach
    void setUp() {
        game = new TicTacToe();
    }

    @Test
    void testGameInitialization() {
        assertNotNull(game);
    }

    @Test
    void testPlayerMove() {
        assertTrue(game.makeMove(0, 0, 'X'));
    }
}
