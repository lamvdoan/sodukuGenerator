import java.util.ArrayList;
import java.util.List;

public class ColumnRegion implements Region {
    List<List<Cell>> columns = new ArrayList<>();
    Puzzle puzzle = Puzzle.getInstance();

//    List<Cell> column0 = new ArrayList<>();
//    List<Cell> column1 = new ArrayList<>();
//    List<Cell> column2 = new ArrayList<>();
//    List<Cell> column3 = new ArrayList<>();
//    List<Cell> column4 = new ArrayList<>();
//    List<Cell> column5 = new ArrayList<>();
//    List<Cell> column6 = new ArrayList<>();
//    List<Cell> column7 = new ArrayList<>();
//    List<Cell> column8 = new ArrayList<>();

//    Map<Integer, Cell> column1 = new HashMap<>();
//    Map<Integer, Cell> column2 = new HashMap<>();
//    Map<Integer, Cell> column3 = new HashMap<>();
//    Map<Integer, Cell> column4 = new HashMap<>();
//    Map<Integer, Cell> column5 = new HashMap<>();
//    Map<Integer, Cell> column6 = new HashMap<>();
//    Map<Integer, Cell> column7 = new HashMap<>();
//    Map<Integer, Cell> column8 = new HashMap<>();
//    Map<Integer, Cell> column9 = new HashMap<>();

//            column0.add(puzzle.grid.get(row).get(0));
//            column1.add(puzzle.grid.get(row).get(1));
//            column2.add(puzzle.grid.get(row).get(2));
//            column3.add(puzzle.grid.get(row).get(3));
//            column4.add(puzzle.grid.get(row).get(4));
//            column5.add(puzzle.grid.get(row).get(5));
//            column6.add(puzzle.grid.get(row).get(6));
//            column7.add(puzzle.grid.get(row).get(7));
//            column8.add(puzzle.grid.get(row).get(8));

    public ColumnRegion() {

        for (int i = 0; i < 9; i++) {
            List<Cell> columnList = new ArrayList<>();

            for (int j = 0; j < 9; j++) {
                columnList.add(puzzle.grid.get(j).get(i));
            }

            columns.add(columnList);
        }
    }
}
