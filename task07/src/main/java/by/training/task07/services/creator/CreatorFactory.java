package by.training.task07.services.creator;

import by.training.task07.services.creator.impl.TextCreatorImpl;
import by.training.task07.services.creator.impl.TextTestCreatorImpl;

public class CreatorFactory {
    private static final CreatorFactory instance = new CreatorFactory();
    private final TextCreator textCreatorImpl = new TextCreatorImpl();
    private final TextCreator textTestCreatorImpl = new TextTestCreatorImpl();

    private CreatorFactory() {
    }

    public static CreatorFactory getInstance() {
        return instance;
    }
    public TextCreator getTextCreator() {
        return textCreatorImpl;
    }
    public TextCreator getTextTestCreator() { return textTestCreatorImpl;}

}
