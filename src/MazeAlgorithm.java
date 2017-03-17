class MazeAlgorithm {

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
}