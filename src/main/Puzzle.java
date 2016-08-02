import java.util.ArrayList;
import java.util.List;

/**
 * Created by lamvdoan on 8/2/16.
 */
public class Puzzle {
    private static Puzzle instance = null;

    List<List<Integer>> grid = new ArrayList<List<Integer>>();

    private Puzzle() {

    }

    public static Puzzle getInstance() {
        if(instance == null) {
            instance = new Puzzle();
        }

        return instance;
    }
}
