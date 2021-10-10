package by.training.task08.controller.command.impl;

import by.training.task08.beans.Candy;
import by.training.task08.controller.command.Command;
import by.training.task08.controller.exception.ControllerException;
import by.training.task08.services.builder.CandiesSaxBuilder;
import by.training.task08.services.builder.CandiesStaxBuilder;
import by.training.task08.services.exception.ServicesException;

import java.util.Set;

public class SaxParser implements Command {
    @Override
    public Set<Candy> execute(Object... arguments) throws ControllerException {
        try {
            CandiesSaxBuilder saxBuilder = new CandiesSaxBuilder();
            saxBuilder.buildSetCandies((String)arguments[0]);
  //          saxBuilder.buildSetCandies("src/main/resources/data/" + arguments[0]);
            return saxBuilder.getCandies();
        } catch (ServicesException e) {
            throw new ControllerException(e);
        }
    }
}
