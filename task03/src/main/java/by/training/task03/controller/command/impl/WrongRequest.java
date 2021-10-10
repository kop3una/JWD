package by.training.task03.controller.command.impl;

import by.training.task03.beans.Entity;
import by.training.task03.controller.command.Command;
import by.training.task03.controller.exception.ControllerException;

public class WrongRequest implements Command {
    @Override
    public Entity execute(String... arguments) throws ControllerException {
        throw new ControllerException("No command");
    }
}
