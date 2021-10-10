package by.training.task08.controller.command.impl;

import by.training.task08.beans.Candy;
import by.training.task08.controller.command.Command;
import by.training.task08.controller.exception.ControllerException;

import java.util.Set;

public class WrongRequest implements Command {
    @Override
    public Set<Candy> execute(Object... arguments) throws ControllerException {
        throw new ControllerException("No command");
    }
}