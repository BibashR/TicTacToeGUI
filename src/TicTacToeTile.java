import javax.swing.JButton;

public class TicTacToeTile extends JButton {
    private final int row;
    private final int col;

    public TicTacToeTile(int row, int col) {
        this.row = row;
        this.col = col;
        setText(" ");
        setFont(getFont().deriveFont(40f));
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public boolean isEmpty() {
        return getText().equals(" ");
    }

    public void reset() {
        setText(" ");
    }
}
