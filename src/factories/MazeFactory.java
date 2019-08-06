package factories;

import models.Maze;
import java.util.Random;

public class MazeFactory {
    public static Maze create(int width, int length) {
        Maze maze = new Maze(width, length);
        createMargins(maze);
        createEmptyInterior(maze);
        carve(maze, 2, 2);
        clearEntryAndExit(maze, 3, 3);

        return maze;
    }

    private static void createMargins(Maze maze) {
        for (int x = 0; x < maze.getWidth(); x++) {
            maze.setSpecificData(x, new byte[maze.getHeight()]);
            for (int y = 0; y < maze.getHeight(); y++) {
                maze.setSpecificData(x, y, Maze.WALL);
            }
        }
    }

    private static void createEmptyInterior(Maze maze) {
        for (int x = 0; x < maze.getWidth(); x++) {
            maze.setSpecificData(x, 0, Maze.SPACE);
            maze.setSpecificData(x, maze.getHeight() - 1, Maze.SPACE);
        }
        for (int y = 0; y < maze.getHeight(); y++) {
            maze.setSpecificData(0, y, Maze.SPACE);
            maze.setSpecificData(maze.getWidth() - 1, y, Maze.SPACE);
        }
    }

    private static void carve(Maze maze, int x, int y) {
        final int[] upx = {1, -1, 0, 0};
        final int[] upy = {0, 0, 1, -1};

        int dir = new Random().nextInt(4);
        int count = 0;
        while (count < 4) {
            final int x1 = x + upx[dir];
            final int y1 = y + upy[dir];
            final int x2 = x1 + upx[dir];
            final int y2 = y1 + upy[dir];
            if (maze.getData()[x1][y1] == Maze.WALL && maze.getData()[x2][y2] == Maze.WALL) {
                maze.setSpecificData(x1, y1, Maze.SPACE);
                maze.setSpecificData(x2, y2, Maze.SPACE);
                carve(maze, x2, y2);
            } else {
                dir = (dir + 1) % 4;
                count += 1;
            }
        }
    }

    private static void clearEntryAndExit(Maze maze, int entry, int exit) {
        for (int level = 1; level <= 2; level++) {
            maze.setSpecificData(maze.getWidth() - entry, maze.getHeight() - level, Maze.SPACE);
            maze.setSpecificData(exit, level, Maze.SPACE);
        }
    }
}
