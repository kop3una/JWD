package by.training.task05.services.observer;

import by.training.task05.beans.Tetrahedron;
import by.training.task05.services.calculation.Calculation;

public class FigureCharacteristics implements SubscriberTetrahedron {
    private double volume;
    private double surfaceArea;

    @Override
    public void update(Tetrahedron tetrahedron) {
        Calculation calculation = new Calculation(tetrahedron);
        volume = calculation.volume();
        surfaceArea = calculation.surfaceArea();
    }

    public double getVolume() {
        return volume;
    }

    public double getSurfaceArea() {
        return surfaceArea;
    }
}
