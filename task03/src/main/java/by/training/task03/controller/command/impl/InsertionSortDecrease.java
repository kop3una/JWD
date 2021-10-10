package by.training.task03.controller.command.impl;

import by.training.task03.beans.Array;
import by.training.task03.beans.Entity;
import by.training.task03.controller.command.Command;
import by.training.task03.controller.exception.ControllerException;
import by.training.task03.dao.exception.DaoException;
import by.training.task03.services.array.InsertionSort;
import by.training.task03.services.array.Sorting;
import by.training.task03.services.creator.ArrayCreator;
import by.training.task03.services.creator.impl.ArrayCreatorImpl;
import by.training.task03.services.exception.ServicesException;
import by.training.task03.services.manager.ArrayManager;
import by.training.task03.services.manager.impl.ArrayManagerImpl;

public class InsertionSortDecrease implements Command {
    @Override
    public Entity execute(String... arguments) throws ControllerException {
        ArrayCreator arrayCreator = new ArrayCreatorImpl();
        ArrayManager arrayManager = new ArrayManagerImpl();
        try {
            Array array = arrayCreator.createFromFile(arguments[0]);
            Sorting insertionSort = new InsertionSort();
            insertionSort.sortDecrease(array);
            arrayManager.writeInFile(array, arguments[0]);
            return array;
        } catch (ServicesException | DaoException e){
            throw new ControllerException(e);
        }

    }
}
