
public class Game {

    public static void main(String [] args) {
        Grid grid = Grid.getInstance();
        grid.generateNumbersForEachCell();
        grid.printGrid();
    }
}
