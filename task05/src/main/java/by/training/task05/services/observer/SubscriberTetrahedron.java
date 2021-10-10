package by.training.task05.services.observer;

import by.training.task05.beans.Tetrahedron;


public interface SubscriberTetrahedron {
    void update (Tetrahedron tetrahedron);
    double getVolume ();
    double getSurfaceArea();

}
