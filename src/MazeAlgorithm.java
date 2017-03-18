import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

class MazeAlgorithm {

    private static final String file = "files/Maze.txt";

    public void print(Maze maze) {

        for (int y = 0; y < maze.getHeight(); y++) {
            for (int x = 0; x < maze.getWidth(); x++) {
                if (maze.getData()[x][y] == MazeFactory.WALL) {
                    System.out.print("[]");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }

    public void printToFile(Maze maze) {
        System.out.println("Opening " + file);
        try {
            BufferedWriter outputWriter = new BufferedWriter(new FileWriter(file));
            for (int y = 0; y < maze.getHeight(); y++) {
                for (int x = 0; x < maze.getWidth(); x++) {
                    if (maze.getData()[x][y] == MazeFactory.WALL) {
                        outputWriter.write("[]");
                    } else {
                        outputWriter.write("  ");
                    }
                }
                outputWriter.newLine();
            }
            outputWriter.flush();
            outputWriter.close();

        } catch (IOException ex) {
            System.out.println("Terminated with exception: " + ex);
        }
        System.out.println("File write successful");
    }
}