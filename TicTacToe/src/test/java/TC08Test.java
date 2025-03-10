import java.awt.Component;
import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TC08Test {

    private JFrame frame;
    private TicTacToe game;

    @BeforeEach
    public void setUp() {
        // Ensure the tests are run in headless mode
        System.setProperty("java.awt.headless", "true");

        // Create the TicTacToe GUI and show it in a frame
        frame = new JFrame("TicTacToe");
        game = new TicTacToe('X');
        
        // Create a panel to hold the game buttons
        JPanel panel = new JPanel(new GridLayout(3, 3));
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                game.buttons[i][j].setName("button" + i + j);
                panel.add(game.buttons[i][j]);
            }
        }
        
        frame.setContentPane(panel);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    @AfterEach
    public void tearDown() {
        // Clean up resources and close the window after each test
        if (frame != null) {
            frame.dispose();
        }
    }

    @Test
    public void testJButtonsAreLoadedCorrectly() {
        Container contentPane = frame.getContentPane();
        assertNotNull(contentPane);

        // Verify that the TicTacToe buttons are loaded correctly
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                Component component = findComponentByName(contentPane, "button" + row + col);
                assertNotNull(component, "Button button" + row + col + " should be present");
                assertTrue(component instanceof JButton, "Button button" + row + col + " should be a JButton");
                assertTrue(component.isVisible(), "Button button" + row + col + " should be visible");
            }
        }
    }

    private Component findComponentByName(Container container, String name) {
        for (Component component : container.getComponents()) {
            if (name.equals(component.getName())) {
                return component;
            } else if (component instanceof Container) {
                Component nestedComponent = findComponentByName((Container) component, name);
                if (nestedComponent != null) {
                    return nestedComponent;
                }
            }
        }
        return null;
    }
}