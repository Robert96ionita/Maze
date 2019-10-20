package models;

public class Maze {
    public static final byte WALL = 0;
    public static final byte SPACE = 1;

    private byte[][] data;
    private int width;
    private int height;

    public Maze(int width, int height) {
        this.width = width;
        this.height = height;
        this.data = new byte[width][];
    }

    public byte[][] getData() {
        return data;
    }

    public void setData(byte[][] data) {
        this.data = data;
    }

    public void setSpecificData(int x, int y, byte value) {
        this.data[x][y] = value;
    }

    public void setSpecificData(int x, byte[] value) {
        this.data[x] = value;
     }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
