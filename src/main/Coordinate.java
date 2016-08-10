public class Coordinate {
    private int col;
    private int row;

    public Coordinate(int col, int row) {
        this.col = col;
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public int getRow() {
        return row;
    }

    public String printCoordinates() {
        return row + ", " + col;
    }
}
