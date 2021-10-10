package by.training.task05.services.creator;

import by.training.task05.beans.FiguresRepository;
import by.training.task05.beans.Tetrahedron;
import by.training.task05.services.exception.ServicesException;

public interface TetrahedronCreator {
    FiguresRepository createFromFile (String fileName) throws ServicesException;
}
