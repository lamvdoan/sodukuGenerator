import java.util.ArrayList;
import java.util.List;

public class Regions {
    private List<List<Coordinate>> columns = new ArrayList<>();
    private List<List<Coordinate>> rows = new ArrayList<>();

    public Regions() {
        for (int row = 0; row < 9; row++) {
            List<Coordinate> columnList = new ArrayList<>();
            List<Coordinate> rowList = new ArrayList<>();

            for (int col = 0; col < 9; col++) {
                columnList.add(new Coordinate(col, row));
                rowList.add(new Coordinate(row, col));
            }

            columns.add(columnList);
            rows.add(rowList);
        }
    }

    public List<List<Coordinate>> getColumns() {
        return columns;
    }

    public List<List<Coordinate>> getRows() {
        return rows;
    }
}
