package by.training.task04.services.creator;

import by.training.task04.services.creator.impl.ArrStringCreatorImpl;
import by.training.task04.services.creator.impl.TextCreatorImpl;

public class CreatorFactory {
    private static final CreatorFactory instance = new CreatorFactory();
    private final TextCreator textCreatorImpl = new TextCreatorImpl();
    private final ArrStringCreator arrStringCreatorImpl = new ArrStringCreatorImpl();

    private CreatorFactory() {
    }

    public static CreatorFactory getInstance() {
        return instance;
    }

    public TextCreator getTextCreator() {
        return textCreatorImpl;
    }

    public ArrStringCreator getArrStringCreator() { return arrStringCreatorImpl; }
}
