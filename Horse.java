public class Horse extends ChessPiece {

    public Horse(String color) {
        super(color);
    }

    public String getColor(){
        return color;
    }
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (!chessBoard.checkPos(line) || !chessBoard.checkPos(column)
                || !chessBoard.checkPos(toLine) || !chessBoard.checkPos(toColumn)) { return false; }
        if (line == toLine || column == toColumn) { return false; }
        if (chessBoard.board[toLine][toColumn].getColor().equals(this.color)) { return false; }
        if (chessBoard.board[line][column] == null) { return false; }
        else return true;
    }

    @Override
    public String getSymbol() {
        return "H";
    }
}
