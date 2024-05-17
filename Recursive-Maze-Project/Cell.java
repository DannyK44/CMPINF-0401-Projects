public enum Cell {
    WALL(0),
    PATH(1), 
    TRACK(2);

    final int mazenumber;

    // Constructor for Cells
    Cell (int mazeNumber) {
        this.mazenumber = mazeNumber;
    }
}
