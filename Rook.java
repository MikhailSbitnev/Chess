public class Rook extends ChessPiece {
    public Rook(String color) {
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
        if (startLine != endLine && startColumn != endColumn) { return false; }
        if (chessBoard.board[endLine][endColumn].getColor().equals(this.color)) { return false; }
        if (chessBoard.board[startLine][startColumn] == null) { return false; }
        else return true;
    }

    @Override
    public String getSymbol() {
        return "R";
    }
}
