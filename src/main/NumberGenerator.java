import java.util.*;

public class NumberGenerator {
    Regions regions = new Regions();
    Random random = new Random();
    Puzzle puzzle = Puzzle.getInstance();

    public void generateNumberForCell(Cell cell) {
        Integer generatedNumber = generateRandomNumber(cell);
        cell.setValue(generatedNumber);
        removePossibleValueForEachColumn(cell);
    }

    private int generateRandomNumber(Cell cell) {
        int index = random.nextInt(cell.getPossibleValues().size());
        return cell.getPossibleValues().get(index);
    }

    private void removePossibleValueForEachColumn(Cell cellWithValue) {
        int columnNumber = cellWithValue.getCoordinate().getRow();
        int rowNumber = cellWithValue.getCoordinate().getCol();

        for(Coordinate coordinateOfOtherCells : regions.columns.get(columnNumber)) {
            puzzle.grid.get(coordinateOfOtherCells.getRow()).get(coordinateOfOtherCells.getCol()).getPossibleValues().remove(cellWithValue.getValue());
        }

        for(Coordinate coordinateOfOtherCells : regions.rows.get(rowNumber)) {
            puzzle.grid.get(coordinateOfOtherCells.getRow()).get(coordinateOfOtherCells.getCol()).getPossibleValues().remove(cellWithValue.getValue());
        }
    }

}
