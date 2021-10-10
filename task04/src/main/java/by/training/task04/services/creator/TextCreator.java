package by.training.task04.services.creator;

import by.training.task04.beans.Text;
import by.training.task04.services.exception.ServicesException;

public interface TextCreator {
    Text createFromFile(String fileName) throws ServicesException;
    Text createFromArr (String [][] array);
}
