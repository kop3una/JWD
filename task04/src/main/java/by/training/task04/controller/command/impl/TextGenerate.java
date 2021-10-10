package by.training.task04.controller.command.impl;

import by.training.task04.beans.Text;
import by.training.task04.controller.command.Command;
import by.training.task04.controller.exception.ControllerException;
import by.training.task04.services.creator.ArrStringCreator;
import by.training.task04.services.creator.CreatorFactory;
import by.training.task04.services.creator.TextCreator;
import by.training.task04.services.exception.ServicesException;
import by.training.task04.services.manager.ManagerFactory;
import by.training.task04.services.manager.TextManager;
import by.training.task04.services.strings.ShakeArray;

public class TextGenerate implements Command { // TODO разделить на две команды, запись в файл и возвращение текста, уведомление пользователя
    private static final String GENERATE_NAME = "generate";
    @Override
    public Text execute(Object... arguments) throws ControllerException {
        ArrStringCreator arrStringCreator = CreatorFactory.getInstance().getArrStringCreator();
        TextCreator textCreator = CreatorFactory.getInstance().getTextCreator();
        TextManager textManager = ManagerFactory.getInstance().getTextManager();
        try {
            String [][] textArr = arrStringCreator.createFromFile(GENERATE_NAME);
            ShakeArray shakeArray = new ShakeArray();
            shakeArray.shake(textArr);
            Text text = textCreator.createFromArr(textArr);
            textManager.writeInFile(text,arguments[0].toString());
            return new Text();
        } catch (ServicesException e){
            throw new ControllerException(e);
        }

    }
}
