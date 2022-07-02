public class King extends ChessPiece {
    public King(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int startLine, int startColumn, int endLine, int endColumn) {
        if (!chessBoard.checkPos(startLine) || !chessBoard.checkPos(startColumn)
                || !chessBoard.checkPos(endLine) || !chessBoard.checkPos(endColumn)) { return false; }
        if (startLine == endLine && startColumn == endColumn) { return false; }
        if (Math.abs(endLine - startLine) != 1 && Math.abs(endColumn - startColumn) != 1) { return false; }
        if (chessBoard.board[endLine][endColumn].getColor().equals(this.color)) { return false; }
        if (chessBoard.board[startLine][startColumn] == null) { return false; }
        else return true;
    }

    @Override
    public String getSymbol() {
        return "K";
    }
    public boolean isUnderAttack(ChessBoard chessBoard, int line, int column) {
        if (chessBoard.checkPos(line) && chessBoard.checkPos(column)) {
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (chessBoard.board[i][j] != null) {
                        if (!chessBoard.board[i][j].getColor().equals(this.color)) {
                            chessBoard.board[i][j].canMoveToPosition(chessBoard, i, j, line, column);
                        }
                    }
                }
            } return true;
        } else return false;
        }
}