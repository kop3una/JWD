package by.training.task04.controller.command;

import by.training.task04.beans.Text;
import by.training.task04.controller.exception.ControllerException;

public interface Command {
    Text execute(Object ... arguments) throws ControllerException;
}
