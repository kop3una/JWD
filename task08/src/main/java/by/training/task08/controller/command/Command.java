package by.training.task08.controller.command;

import by.training.task08.beans.Candy;
import by.training.task08.controller.exception.ControllerException;

import java.util.Set;

public interface Command {
    Set<Candy> execute(Object ... arguments) throws ControllerException;
}
