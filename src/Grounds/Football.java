package Grounds;

import Useful.Exposure;
import Useful.Lighting;

public class Football extends Ground {

    private int length;
    private int width;

    public Football(int id, int capacity, Exposure exposure, Lighting lighting, int length, int width) {
        super(id, capacity, exposure, lighting);
        this.length = length;
        this.width = width;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    @Override
    public String toString() {
        return "Football{" +
                "length=" + length +
                ", width=" + width +
                '}';
    }
}
