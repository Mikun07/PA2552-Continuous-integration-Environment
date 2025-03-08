import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent; 
import java.awt.event.ActionListener;

public class TicTacToe extends JFrame implements ActionListener {
    JButton[][] buttons = new JButton[3][3];
    public char currentPlayer;
    public boolean isTestMode;

    // Normal constructor (for real gameplay)
    public TicTacToe(char chosenPlayer) {
        this(chosenPlayer, false); // Calls the second constructor with test mode disabled
    }

    // Test mode constructor (prevents GUI from showing)
    public TicTacToe(char chosenPlayer, boolean isTestMode) {
        this.currentPlayer = chosenPlayer;
        this.isTestMode = isTestMode; // Store test mode flag
        
        setTitle("Tic-Tac-Toe");
        setSize(300, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(3, 3));

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j] = new JButton(" ");
                buttons[i][j].setFont(new Font("Arial", Font.PLAIN, 60));
                buttons[i][j].setFocusPainted(false);
                buttons[i][j].addActionListener(this);
                add(buttons[i][j]);
            }
        }

        if (!isTestMode) {  // Only show UI if not in test mode
            setVisible(true);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton clickedButton = (JButton) e.getSource();
        if (!clickedButton.getText().equals(" ")) {
            return;
        }

        clickedButton.setText(String.valueOf(currentPlayer));
        if (checkWinner()) {
            JOptionPane.showMessageDialog(this, "Player " + currentPlayer + " wins!");
            resetBoard();
            return;
        }

        if (isBoardFull()) {
            JOptionPane.showMessageDialog(this, "It's a draw!");
            resetBoard();
            return;
        }

        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
    }

    public boolean checkWinner() {  
        for (int i = 0; i < 3; i++) {
            if (buttons[i][0].getText().equals(String.valueOf(currentPlayer)) &&
                buttons[i][1].getText().equals(String.valueOf(currentPlayer)) &&
                buttons[i][2].getText().equals(String.valueOf(currentPlayer))) {
                return true;
            }
            if (buttons[0][i].getText().equals(String.valueOf(currentPlayer)) &&
                buttons[1][i].getText().equals(String.valueOf(currentPlayer)) &&
                buttons[2][i].getText().equals(String.valueOf(currentPlayer))) {
                return true;
            }
        }
        return (buttons[0][0].getText().equals(String.valueOf(currentPlayer)) &&
                buttons[1][1].getText().equals(String.valueOf(currentPlayer)) &&
                buttons[2][2].getText().equals(String.valueOf(currentPlayer))) ||
               (buttons[0][2].getText().equals(String.valueOf(currentPlayer)) &&
                buttons[1][1].getText().equals(String.valueOf(currentPlayer)) &&
                buttons[2][0].getText().equals(String.valueOf(currentPlayer)));
    }

    public boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (buttons[i][j].getText().equals(" ")) {
                    return false;
                }
            }
        }
        return true;
    }

    void resetBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j].setText(" ");
            }
        }
    }

    public static void main(String[] args) {
        int option = JOptionPane.showOptionDialog(null, "Welcome to Tic-Tac-Toe!", "Tic-Tac-Toe",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null,
                new String[]{"New Game", "Exit"}, "New Game");

        if (option == 1) {
            System.exit(0);
        }

        String[] choices = {"X", "O"};
        String selected = (String) JOptionPane.showInputDialog(null, "Choose your symbol:",
                "Player Selection", JOptionPane.QUESTION_MESSAGE, null, choices, "X");

        if (selected == null) {
            System.exit(0);
        }

        new TicTacToe(selected.charAt(0));
    }
}
