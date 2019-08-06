import factories.MazeFactory;
import models.Maze;
import utils.MazePrinter;

public class Main {
    public static void main(String[] args) {
        testMode();
    }

    private static void testMode() {
        Maze maze = MazeFactory.create(21, 23);
        MazePrinter.printToFile(maze);
        MazePrinter.print(maze);
    }
}
