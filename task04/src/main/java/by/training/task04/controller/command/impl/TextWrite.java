package by.training.task04.controller.command.impl;

import by.training.task04.beans.Text;
import by.training.task04.controller.command.Command;
import by.training.task04.controller.exception.ControllerException;
import by.training.task04.services.exception.ServicesException;
import by.training.task04.services.manager.ManagerFactory;
import by.training.task04.services.manager.TextManager;

public class TextWrite implements Command {
    @Override
    public Text execute(Object... arguments) throws ControllerException {
        TextManager textManager = ManagerFactory.getInstance().getTextManager();
        try {
            Text text = (Text) arguments[1];
            textManager.writeInFile(text,arguments[0].toString());
            return text;
        } catch (ServicesException e){
            throw new ControllerException(e);
        }

    }
}
