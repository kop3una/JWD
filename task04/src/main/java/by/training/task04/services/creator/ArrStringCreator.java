package by.training.task04.services.creator;

import by.training.task04.services.exception.ServicesException;

public interface ArrStringCreator {
    String[][] createFromFile(String fileName) throws ServicesException;
}
