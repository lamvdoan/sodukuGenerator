import java.util.*;

public class NumberGenerator {
    private Regions regions = new Regions();
    private Random random = new Random();
    private Grid grid = Grid.getInstance();

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
//        removeValueFromEachCellInEachColumn(cellWithValue);
//        removeValueFromEachCellInEachRow(cellWithValue);
        removeValueFromEachCellInEachBlock(cellWithValue);
    }

    private void removeValueFromEachCellInEachBlock(Cell cellWithValue) {
        Integer blockNumber;
        Integer rowOfCell = cellWithValue.getCoordinate().getRow();
        Integer colOfCell = cellWithValue.getCoordinate().getCol();

        if(colOfCell < 3) {
            blockNumber = getBlockNumber(rowOfCell, 0);
        } else if(colOfCell >= 3 && colOfCell < 6) {
            blockNumber = getBlockNumber(rowOfCell, 3);
        } else {
            blockNumber = getBlockNumber(rowOfCell, 6);
        }

        for(Coordinate coordinateOfOtherCells : regions.getBlocks().get(blockNumber)) {
            grid.getCell(coordinateOfOtherCells).getPossibleValues().remove(cellWithValue.getValue());
        }
    }

    private Integer getBlockNumber(Integer rowOfCell, Integer rowOfBlocks) {
        if (rowOfCell < 3) {
            return rowOfBlocks;
        } else if(rowOfCell >= 3 && rowOfCell < 6) {
            rowOfBlocks++;
            return rowOfBlocks;
        } else {
            rowOfBlocks += 2;
            return rowOfBlocks;
        }
    }

    private void removeValueFromEachCellInEachColumn(Cell cellWithValue) {
        for(Coordinate coordinateOfOtherCells : regions.getColumns().get(cellWithValue.getCoordinate().getCol())) {
            grid.getCell(coordinateOfOtherCells).getPossibleValues().remove(cellWithValue.getValue());
        }
    }

    private void removeValueFromEachCellInEachRow(Cell cellWithValue) {
        for(Coordinate coordinateOfOtherCells : regions.getRows().get(cellWithValue.getCoordinate().getRow())) {
            grid.getCell(coordinateOfOtherCells).getPossibleValues().remove(cellWithValue.getValue());
        }
    }
}
