package by.training.task05test.validation;

import by.training.task05.beans.Dot;
import by.training.task05.beans.Repository;
import by.training.task05.beans.Tetrahedron;
import by.training.task05.services.creator.CreatorFactory;
import by.training.task05.services.creator.TetrahedronCreator;
import by.training.task05.services.exception.ServicesException;
import by.training.task05.services.observer.ObserverManager;
import by.training.task05.services.validation.FigureValidator;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Map;


public class MainTest {
    public MainTest() throws ServicesException {
    }

    @Test(description = "TestObserver")
    public void testFigureValidator() throws ServicesException {
        TetrahedronCreator tetrahedronCreator = CreatorFactory.getInstance().getTetrahedronCreator();
        Repository figureRepository = tetrahedronCreator.createFromFile("data");
        ObserverManager.setObserver(figureRepository.toArray()); // volume == 3 can look in controller runner
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
        tetrahedron.setFirstDot(dot); // volume == 9 !!!!!
        Assert.assertEquals(tetrahedron.getPublisher().getSubscriber().getVolume(), 9.0);
    }
}
