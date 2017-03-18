import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        testMode();
//        productionMode();
    }

    private static void testMode() {

        Maze maze = new Maze(23, 21);
        MazeFactory factory = new MazeFactory(maze);
        MazeAlgorithm algorithm = new MazeAlgorithm();

        factory.generate(3, 2);
        algorithm.printToFile(maze);
        algorithm.print(maze);
    }

    private static void productionMode() {

        Scanner in = new Scanner(System.in);
        int entry;
        int exit;
        int width;
        int height;

        System.out.println("< Maze dimensions >");
        System.out.println("Height: ");
        height = in.nextInt();
        System.out.println("Width: ");
        width = in.nextInt();
        System.out.println("< Entry & Exit >");
        System.out.println("Recommended values: odd numbers greater than 9");
        System.out.println("Entry: ");
        entry = in.nextInt();
        System.out.println("Exit: ");
        exit = in.nextInt();


        Maze maze = new Maze(width, height);
        MazeFactory factory = new MazeFactory(maze);
        MazeAlgorithm algorithm = new MazeAlgorithm();

        factory.generate(entry, exit);
        algorithm.print(maze);
    }
}
