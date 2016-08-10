import java.util.ArrayList;
import java.util.List;

import static java.lang.System.out;


public class Grid {
    private static Grid instance = null;
    private List<List<Cell>> gridList = new ArrayList<>();

    public static Grid getInstance() {
        if(instance == null) {
            instance = new Grid();
        }

        return instance;
    }

    private Grid() {
        initializeGrid();
    }

    public Cell getCell(Coordinate coordinate) {
        return gridList.get(coordinate.getRow()).get(coordinate.getCol());
    }

    public void generateNumbersForEachCell() {
        NumberGenerator numberGenerator = new NumberGenerator();
        int count = 0;
        for(int row = 0; row < 9; row++) {
            for(int col = 0; col < 9; col++) {

                if(gridList.get(row).get(col).getPossibleValues().size() == 0) {
                    for(int i = 1; i < 10; i++) {
                        gridList.get(row).get(col).getPossibleValues().add(i);
                    }

                    col--;
                    gridList.get(row).get(col).getPossibleValues().add(gridList.get(row).get(col).getValue());
                }
                numberGenerator.generateNumberForCell(gridList.get(row).get(col));
                out.println("Numbers generated: " + ++count);
            }
        }
    }

    public void printGrid() {
        out.println("+-------+-------+-------+");

        for(int row = 0; row < 9; row++) {
            out.print("|");

            for(int col = 0; col < 9; col++) {
                if(col  == 3 || col == 6) {
                    out.print("|");
                }

                if(col == 0 || col == 3 || col == 6) {
                    out.print(" ");
                }

                out.print(gridList.get(row).get(col).getValue() + " ");
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

            gridList.add(columns);
        }
    }
}
