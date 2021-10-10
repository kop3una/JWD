package by.training.task05.services.reader;

import by.training.task05.services.exception.ServicesException;

import java.util.List;

public interface DataReader {
    List<String> readFromFile(String fileName) throws ServicesException;
}
