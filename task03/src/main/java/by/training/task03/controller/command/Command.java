package by.training.task03.controller.command;

import by.training.task03.beans.Entity;
import by.training.task03.controller.exception.ControllerException;

public interface Command {
    Entity execute(String ... arguments) throws ControllerException;
}

