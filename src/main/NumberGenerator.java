import java.util.*;

public class NumberGenerator {
    ColumnRegion columnRegion = new ColumnRegion();

    private int generateRandomNumber(Cell cell) {
        Random random = new Random();
        int index = random.nextInt(cell.getPossibleValues().size());
//        System.out.println("index " + index);
        System.out.println("value " + cell.getPossibleValues().get(index));
        return cell.getPossibleValues().get(index);
    }

    public void generateNumberForCell(Cell cell) {
        Integer insertedNumber = generateRandomNumber(cell);
        cell.setValue(insertedNumber);

        // Iterate thru each Column Region
        for(List<Cell> listOfCells : columnRegion.columns) {
            for(Cell currentCell : listOfCells) {
                if(currentCell.getCoordinate() != cell.getCoordinate()) {
                    currentCell.getPossibleValues().remove(insertedNumber);
                }
            }
        }

//        for (int row = 0; row < 9; row++) {
//            for (int col = 0; col < 9; col++) {
//            }
//        }
    }

}
