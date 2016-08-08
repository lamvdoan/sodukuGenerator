import java.util.ArrayList;
import java.util.List;
import static java.lang.System.out;


public class Puzzle {
    private static Puzzle instance = null;
    List<List<Cell>> grid = new ArrayList<>();

    public static Puzzle getInstance() {
        if(instance == null) {
            instance = new Puzzle();
        }

        return instance;
    }

    private Puzzle() {
        initializeGrid();
    }

    public void generateNumbersForEachCell() {
        NumberGenerator numberGenerator = new NumberGenerator();

        for(int row = 0; row < 9; row++) {
            for(int col = 0; col < 9; col++) {
                numberGenerator.generateNumberForCell(grid.get(row).get(col));
            }
        }

    }

    public void printGrid() {
        out.println("+-------+-------+-------+");

        for(int row = 0; row < 9; row++) {
            out.print("|");

            for(int col = 0; col < 9; col++) {
//                NumberGenerator.generateNumberForCell(grid.get(row).get(col));
                if(col  == 3 || col == 6) {
                    out.print("|");
                }

                if(col == 0 || col == 3 || col == 6) {
                    out.print(" ");
                }

                out.print(grid.get(row).get(col).getValue() + " ");
            }

            out.println("|");

            if(row == 2 || row == 5) {
                out.println("|-------|-------|-------|");
            }
        }

        out.println("+-------+-------+-------+");
    }

    private void initializeGrid() {
        for(int row = 0; row < 9; row++) {
            List<Cell> columns = new ArrayList<>();

            for(int col = 0; col < 9; col++) {
                columns.add(new Cell(new Coordinate(row, col)));
            }

            grid.add(columns);
        }
    }
}
