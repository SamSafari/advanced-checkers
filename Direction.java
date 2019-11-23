public enum Direction {

    N(-1, 0), S(1, 0), NW(-1, -1), NE(-1, 1), SW(1, -1), SE(1, 1);

    private int row, col;

    Direction(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public Cell findNewCell(Cell startCell) {
        return new Cell.EmptyCell(startCell.getRow() + row, startCell.getCol() + col);
    }

}