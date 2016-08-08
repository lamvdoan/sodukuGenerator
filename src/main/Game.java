
public class Game {

    public static void main(String [] args) {
        Puzzle puzzle = Puzzle.getInstance();
        puzzle.generateNumbersForEachCell();
        puzzle.printGrid();
    }
}
