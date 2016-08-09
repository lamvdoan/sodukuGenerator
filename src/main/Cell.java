import java.util.ArrayList;
import java.util.List;

public class Cell {
    private Coordinate coordinate;
    private int value;
    private List<Integer> possibleValues = new ArrayList<>();

    public Cell(Coordinate coordinate) {
        this.coordinate = coordinate;
        this.value = 0;

        for(int i = 1; i < 10; i++) {
            possibleValues.add(i);
        }
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public List<Integer> getPossibleValues() {
        return possibleValues;
    }
}
