public class MazeFactory {

    protected static final byte WALL = 0;
    protected static final byte SPACE = 1;
    private java.util.Random rand;
    private Maze maze;

    public MazeFactory(Maze maze) {
        this.rand = new java.util.Random();
        this.maze = maze;
    }

    public void generate(int entry, int exit) {

        this.createMargins();
        this.createEmptyInterior();
        this.carve(2, 2);
        this.clearEntryAndExit(entry, exit);
    }

    private void carve(int x, int y) {

        final int[] upx = {1, -1, 0, 0};
        final int[] upy = {0, 0, 1, -1};

        int dir = rand.nextInt(4);
        int count = 0;
        while (count < 4) {
            final int x1 = x + upx[dir];
            final int y1 = y + upy[dir];
            final int x2 = x1 + upx[dir];
            final int y2 = y1 + upy[dir];
            if (this.maze.getData()[x1][y1] == WALL && this.maze.getData()[x2][y2] == WALL) {
                this.maze.setSpecificData(x1, y1, SPACE);
                this.maze.setSpecificData(x2, y2, SPACE);
                carve(x2, y2);
            } else {
                dir = (dir + 1) % 4;
                count += 1;
            }
        }
    }

    private void createMargins() {

        for (int x = 0; x < this.maze.getWidth(); x++) {
            this.maze.setSpecificData(x, new byte[this.maze.getHeight()]);
            for (int y = 0; y < this.maze.getHeight(); y++) {
                this.maze.setSpecificData(x, y, WALL);
            }
        }
    }

    private void createEmptyInterior() {

        for (int x = 0; x < this.maze.getWidth(); x++) {
            this.maze.setSpecificData(x, 0, SPACE);
            this.maze.setSpecificData(x, this.maze.getHeight() - 1, SPACE);
        }
        for (int y = 0; y < this.maze.getHeight(); y++) {
            this.maze.setSpecificData(0, y, SPACE);
            this.maze.setSpecificData(this.maze.getWidth() - 1, y, SPACE);
        }
    }

    private void clearEntryAndExit(int entry, int exit) {

        for (int level = 1; level <= 2; level++) {
            this.maze.setSpecificData(this.maze.getWidth() - entry, this.maze.getHeight() - level, SPACE);
            this.maze.setSpecificData(exit, level, SPACE);
        }
    }
}
