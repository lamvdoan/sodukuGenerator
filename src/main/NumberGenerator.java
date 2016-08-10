import java.util.*;

public class NumberGenerator {
    private Regions regions = new Regions();
    private Random random = new Random();
    private Puzzle puzzle = Puzzle.getInstance();

    public void generateNumberForCell(Cell cell) {
        Integer generatedNumber = generateRandomNumberForACell(cell);
        cell.setValue(generatedNumber);
        removePossibleValueForEachColumn(cell);
    }

    private int generateRandomNumberForACell(Cell cell) {
        int index = random.nextInt(cell.getPossibleValues().size());
        return cell.getPossibleValues().get(index);
    }

    private void removePossibleValueForEachColumn(Cell cellWithValue) {
        removeValueFromEachCellInEachColumn(cellWithValue);
        removeValueFromEachCellInEachRow(cellWithValue);
    }

    private void removeValueFromEachCellInEachColumn(Cell cellWithValue) {
        for(Coordinate coordinateOfOtherCells : regions.getColumns().get(cellWithValue.getCoordinate().getCol())) {
            puzzle.getCell(coordinateOfOtherCells).getPossibleValues().remove(cellWithValue.getValue());
        }
    }

    private void removeValueFromEachCellInEachRow(Cell cellWithValue) {
        for(Coordinate coordinateOfOtherCells : regions.getRows().get(cellWithValue.getCoordinate().getRow())) {
            puzzle.getCell(coordinateOfOtherCells).getPossibleValues().remove(cellWithValue.getValue());
        }
    }

}
