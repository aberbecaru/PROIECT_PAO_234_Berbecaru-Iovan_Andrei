package Grounds;

import Useful.Exposure;
import Useful.Lighting;

public abstract class Ground {

    protected int id;
    protected int capacity;
    protected Exposure exposure;

    protected Lighting lighting;


    public Ground(int id, int capacity, Exposure exposure, Lighting lighting){
        this.id = id;
        this.capacity = capacity;
        this.exposure = exposure;
        this.lighting = lighting;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public Exposure getExposure() {
        return exposure;
    }

    public void setExposure(Exposure exposure) {
        this.exposure = exposure;
    }

    public Lighting getLighting() {
        return lighting;
    }

    public void setLighting(Lighting lighting) {
        this.lighting = lighting;
    }
}
