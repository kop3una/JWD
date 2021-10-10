package by.training.task04.services.manager;

import by.training.task04.beans.Text;
import by.training.task04.services.exception.ServicesException;

public interface TextManager {
    void writeInFile (Text text, String fileName) throws ServicesException;
}
