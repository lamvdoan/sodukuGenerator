import java.util.ArrayList;
import java.util.List;

public class Regions {
    List<List<Coordinate>> columns = new ArrayList<>();
    List<List<Coordinate>> rows = new ArrayList<>();

    public Regions() {
        for (int i = 0; i < 9; i++) {
            List<Coordinate> columnList = new ArrayList<>();
            List<Coordinate> rowList = new ArrayList<>();

            for (int j = 0; j < 9; j++) {
                columnList.add(new Coordinate(i, j));
                rowList.add(new Coordinate(j, i));
            }

            columns.add(columnList);
            rows.add(rowList);
        }
    }
}
