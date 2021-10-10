package by.training.task04.controller.command.impl;

import by.training.task04.beans.Text;
import by.training.task04.controller.command.Command;
import by.training.task04.controller.exception.ControllerException;

public class WrongRequest implements Command {
    @Override
    public Text execute(Object... arguments) throws ControllerException {
        throw new ControllerException("No command");
    }
}