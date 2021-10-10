package by.training.task06.services.creator;

import by.training.task06.beans.InfoData;
import by.training.task06.beans.Matrix;
import by.training.task06.services.exception.ServicesException;

public interface InfoDataCreator {
    InfoData createFromFile(String fileName) throws ServicesException;
}
