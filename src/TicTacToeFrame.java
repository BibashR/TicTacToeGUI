import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TicTacToeFrame extends JFrame implements ActionListener {
    private TicTacToe game;
    private TicTacToeTile[][] tiles;
    private JButton quitButton;

    public TicTacToeFrame() {
        game = new TicTacToe();
        tiles = new TicTacToeTile[3][3];
        setTitle("Tic Tac Toe");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        JPanel boardPanel = new JPanel(new GridLayout(3, 3));
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                tiles[r][c] = new TicTacToeTile(r, c);
                tiles[r][c].addActionListener(this);
                boardPanel.add(tiles[r][c]);
            }
        }
        add(boardPanel, BorderLayout.CENTER);
        quitButton = new JButton("Quit");
        quitButton.addActionListener(e -> System.exit(0));
        add(quitButton, BorderLayout.SOUTH);
        setSize(400, 450);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        TicTacToeTile tile = (TicTacToeTile) e.getSource();
        if (!tile.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Invalid move. Try again.");
            return;
        }
        tile.setText(game.getCurrentPlayer());
        int row = tile.getRow();
        int col = tile.getCol();
        game.makeMove(row, col);
        if (game.getMoveCount() >= 5 && game.isWin(game.getCurrentPlayer())) {
            JOptionPane.showMessageDialog(this, "Player " + game.getCurrentPlayer() + " wins!");
            resetBoard();
            return;
        }
        if (game.getMoveCount() >= 7 && game.isTie()) {
            JOptionPane.showMessageDialog(this, "It's a tie!");
            resetBoard();
            return;
        }
        game.switchPlayer();
    }

    private void resetBoard() {
        int response = JOptionPane.showConfirmDialog(this, "Play again?", "Game Over", JOptionPane.YES_NO_OPTION);
        if (response == JOptionPane.YES_OPTION) {
            game.reset();
            for (int r = 0; r < 3; r++) {
                for (int c = 0; c < 3; c++) {
                    tiles[r][c].reset();
                }
            }
        } else {
            System.exit(0);
        }
    }
}
