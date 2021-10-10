package by.training.task07.controller;

import by.training.task07.beans.Component;
import by.training.task07.beans.ComponentId;
import by.training.task07.beans.Composite;
import by.training.task07.services.creator.CreatorFactory;
import by.training.task07.services.creator.TextCreator;
import by.training.task07.services.exception.ServicesException;

public class View {
    public static void main ( String [] args) throws ServicesException {
        TextCreator textCreator = CreatorFactory.getInstance().getTextCreator();
        Component text = textCreator.createFromFile("text");
        System.out.println(text.collect());
    }
}
