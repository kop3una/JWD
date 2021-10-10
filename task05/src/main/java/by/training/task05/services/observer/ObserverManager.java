package by.training.task05.services.observer;
import by.training.task05.beans.Tetrahedron;

/**
 * A repository with a list of shapes is created initially without an observer pattern. This class assigns a publisher to each shape
 */

public class ObserverManager {

    private ObserverManager() {
    }

    public static void setObserver(Object[] figures){
        for ( Object figure : figures){
            Publisher publisher = new Publisher();
            publisher.subscribe(new FigureCharacteristics());
            ((Tetrahedron) figure).setPublisher(publisher);
        }
    }
}
