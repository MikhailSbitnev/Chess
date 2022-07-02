public class Pawn extends ChessPiece {

    public Pawn(String color) {
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
        if (chessBoard.board[endLine][endColumn].getColor().equals(this.color)) { return false; }
        if (chessBoard.board[startLine][startColumn] == null) { return false; }
        if (color.equals("White") && startLine == 1 && startColumn == endColumn && (endLine - startLine) < 3 && (endLine - startLine) > 0) { return true; }
        if (color.equals("White") && startLine != 1 && startColumn == endColumn && (endLine - startLine) == 1) { return true; }
        if (!color.equals("White") && startLine == 6 && startColumn == endColumn && (startLine - endLine) < 3 && (startLine - endLine) > 0) { return true; }
        if (!color.equals("White") && startLine != 6 && startColumn == endColumn && (startLine - endLine) == 1) { return true; }
        else return false;
    }

    @Override
    public String getSymbol() {
        return "P";
    }
}
