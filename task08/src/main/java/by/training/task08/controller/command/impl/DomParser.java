package by.training.task08.controller.command.impl;

import by.training.task08.beans.Candy;
import by.training.task08.controller.command.Command;
import by.training.task08.controller.exception.ControllerException;
import by.training.task08.services.builder.CandiesDomBuilder;
import by.training.task08.services.exception.ServicesException;

import java.io.File;
import java.util.Set;

public class DomParser implements Command {
    @Override
    public Set<Candy> execute(Object... arguments) throws ControllerException {
        try {
            CandiesDomBuilder domBuilder = new CandiesDomBuilder();
            domBuilder.buildSetCandies((String) arguments[0]);
            return domBuilder.getCandies();
        } catch (ServicesException e) {
            throw new ControllerException(e);
        }
    }
}
