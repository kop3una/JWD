package by.training.task04.controller.command.impl;

import by.training.task04.beans.Text;
import by.training.task04.controller.command.Command;
import by.training.task04.controller.exception.ControllerException;
import by.training.task04.services.creator.CreatorFactory;
import by.training.task04.services.creator.TextCreator;
import by.training.task04.services.exception.ServicesException;

public class TextRead implements Command {

    @Override
    public Text execute(Object... arguments) throws ControllerException {
        TextCreator textCreator = CreatorFactory.getInstance().getTextCreator();
        try {
            String fileName = arguments[0].toString();
            return textCreator.createFromFile(fileName);
        } catch (ServicesException e){
            throw new ControllerException(e);
        }
    }
}
