package by.training.task08.controller.command.impl;

import by.training.task08.beans.Candy;
import by.training.task08.controller.command.Command;
import by.training.task08.controller.exception.ControllerException;
import by.training.task08.services.builder.CandiesStaxBuilder;
import by.training.task08.services.exception.ServicesException;

import java.util.Set;

public class StaxParser implements Command {
    @Override
    public Set<Candy> execute(Object... arguments) throws ControllerException {
        try {
            CandiesStaxBuilder staxBuilder = new CandiesStaxBuilder();
            staxBuilder.buildSetCandies((String) arguments[0]);
            return staxBuilder.getCandies();
        } catch (ServicesException e) {
            throw new ControllerException(e);
        }
    }
}
