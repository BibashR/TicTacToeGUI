public class TicTacToe {
    private static final int ROW = 3;
    private static final int COL = 3;
    private String[][] board;
    private String currentPlayer;
    private int moveCount;

    public TicTacToe() {
        board = new String[ROW][COL];
        reset();
    }

    public void reset() {
        for (int r = 0; r < ROW; r++) {
            for (int c = 0; c < COL; c++) {
                board[r][c] = " ";
            }
        }
        currentPlayer = "X";
        moveCount = 0;
    }

    public boolean isCellEmpty(int row, int col) {
        return board[row][col].equals(" ");
    }

    public boolean makeMove(int row, int col) {
        if (!isCellEmpty(row, col)) return false;
        board[row][col] = currentPlayer;
        moveCount++;
        return true;
    }

    public int getMoveCount() {
        return moveCount;
    }

    public String getCurrentPlayer() {
        return currentPlayer;
    }

    public void switchPlayer() {
        currentPlayer = currentPlayer.equals("X") ? "O" : "X";
    }

    public boolean isWin(String player) {
        return isRowWin(player) || isColWin(player) || isDiagonalWin(player);
    }

    private boolean isRowWin(String player) {
        for (int r = 0; r < ROW; r++) {
            if (board[r][0].equals(player) &&
                    board[r][1].equals(player) &&
                    board[r][2].equals(player)) return true;
        }
        return false;
    }

    private boolean isColWin(String player) {
        for (int c = 0; c < COL; c++) {
            if (board[0][c].equals(player) &&
                    board[1][c].equals(player) &&
                    board[2][c].equals(player)) return true;
        }
        return false;
    }

    private boolean isDiagonalWin(String player) {
        if (board[0][0].equals(player) &&
                board[1][1].equals(player) &&
                board[2][2].equals(player)) return true;
        if (board[0][2].equals(player) &&
                board[1][1].equals(player) &&
                board[2][0].equals(player)) return true;
        return false;
    }

    public boolean isTie() {
        boolean xFlag, oFlag;
        for (int r = 0; r < ROW; r++) {
            xFlag = oFlag = false;
            if (board[r][0].equals("X") || board[r][1].equals("X") || board[r][2].equals("X")) xFlag = true;
            if (board[r][0].equals("O") || board[r][1].equals("O") || board[r][2].equals("O")) oFlag = true;
            if (!(xFlag && oFlag)) return false;
        }
        for (int c = 0; c < COL; c++) {
            xFlag = oFlag = false;
            if (board[0][c].equals("X") || board[1][c].equals("X") || board[2][c].equals("X")) xFlag = true;
            if (board[0][c].equals("O") || board[1][c].equals("O") || board[2][c].equals("O")) oFlag = true;
            if (!(xFlag && oFlag)) return false;
        }
        xFlag = oFlag = false;
        if (board[0][0].equals("X") || board[1][1].equals("X") || board[2][2].equals("X")) xFlag = true;
        if (board[0][0].equals("O") || board[1][1].equals("O") || board[2][2].equals("O")) oFlag = true;
        if (!(xFlag && oFlag)) return false;
        xFlag = oFlag = false;
        if (board[0][2].equals("X") || board[1][1].equals("X") || board[2][0].equals("X")) xFlag = true;
        if (board[0][2].equals("O") || board[1][1].equals("O") || board[2][0].equals("O")) oFlag = true;
        if (!(xFlag && oFlag)) return false;
        return true;
    }
}
