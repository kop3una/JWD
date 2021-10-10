package by.training.task03.services.creator;

import by.training.task03.beans.Array;
import by.training.task03.services.exception.ServicesException;

public interface ArrayCreator {
    void fillRandomized(Array array, int minValue, int maxValue);
    Array createFromFile(String fileName) throws ServicesException;
}
