package by.training.task07.services.creator;

import by.training.task07.beans.Component;
import by.training.task07.services.exception.ServicesException;

public interface TextCreator {
    Component createFromFile (String fileName) throws ServicesException;
}
