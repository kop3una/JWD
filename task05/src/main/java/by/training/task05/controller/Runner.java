package by.training.task05.controller;

import by.training.task05.beans.Dot;
import by.training.task05.beans.Repository;
import by.training.task05.beans.Tetrahedron;
import by.training.task05.services.creator.CreatorFactory;
import by.training.task05.services.creator.TetrahedronCreator;
import by.training.task05.services.exception.ServicesException;
import by.training.task05.services.observer.FigureCharacteristics;
import by.training.task05.services.observer.ObserverManager;
import by.training.task05.services.observer.Publisher;
import by.training.task05.services.observer.SubscriberTetrahedron;

import java.util.Map;

public class Runner {
    public static void main (String [] args) throws ServicesException {
        TetrahedronCreator tetrahedronCreator = CreatorFactory.getInstance().getTetrahedronCreator();
        Repository figureRepository = tetrahedronCreator.createFromFile("data");
        ObserverManager.setObserver(figureRepository.toArray());
        for (Tetrahedron tetrahedron : figureRepository.toArray()){
           System.out.println( tetrahedron.getPublisher().getSubscriber().getVolume()) ;
           System.out.println( tetrahedron.getPublisher().getSubscriber().getSurfaceArea());
        }
        Map<Boolean,Tetrahedron> result = figureRepository.getById(0);
        Tetrahedron tetrahedron = null;
        if (result.containsKey(Boolean.TRUE)){
            tetrahedron = result.get(Boolean.TRUE);
        }
        Dot dot = new Dot();
        dot.setX(3);
        dot.setY(5);
        dot.setZ(8);
        tetrahedron.setFirstDot(dot);
        System.out.println( tetrahedron.getPublisher().getSubscriber().getVolume()) ;
        System.out.println( tetrahedron.getPublisher().getSubscriber().getSurfaceArea());
    }
}
