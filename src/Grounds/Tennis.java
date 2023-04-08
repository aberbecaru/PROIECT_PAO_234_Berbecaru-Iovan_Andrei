package Grounds;

import Useful.Surfaces;
import Useful.Exposure;
import Useful.Lighting;

public class Tennis extends Ground{

    private Surfaces surface;

    public Tennis(int id, int capacity, Exposure exposure, Lighting lighting, Surfaces surface) {
        super(id, capacity, exposure, lighting);
        this.surface = surface;
    }

    public Surfaces getSurface() {
        return surface;
    }

    public void setSurface(Surfaces surface) {
        this.surface = surface;
    }

    @Override
    public String toString() {
        return "Tennis{" +
                "surface=" + surface +
                '}';
    }
}
