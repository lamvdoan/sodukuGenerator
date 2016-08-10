import java.util.ArrayList;
import java.util.List;

public class Regions {
    private List<List<Coordinate>> columns = new ArrayList<>();
    private List<List<Coordinate>> rows = new ArrayList<>();
    private List<List<Coordinate>> blocks = new ArrayList<>();

    public Regions() {
        addCoordinatesToRowAndColumnRegions();
        addCoordinatesToBlockRegion();
    }

    private void addCoordinatesToRowAndColumnRegions() {
        for(int row = 0; row < 9; row++) {
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

    private void addCoordinatesToBlockRegion() {
        for(int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if(row % 3 == 0 && col % 3 == 0) {
                    addToBlocks(row, col);
                }
            }
        }
    }

    private void addToBlocks(Integer initialRow, Integer initialColumn) {
        List<Coordinate> blockList = new ArrayList<>();

        for (int row = initialRow; row < initialRow + 3; row++) {
            for (int col = initialColumn; col < initialColumn + 3; col++) {
                blockList.add(new Coordinate(col, row));
            }
        }

        blocks.add(blockList);
    }

    public List<List<Coordinate>> getColumns() {
        return columns;
    }

    public List<List<Coordinate>> getRows() {
        return rows;
    }

    public List<List<Coordinate>> getBlocks() {
        return blocks;
    }
}
