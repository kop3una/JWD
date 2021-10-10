package by.training.task05.services.creator;

import by.training.task05.services.creator.impl.TetrahedronCreatorImpl;

public class CreatorFactory {
    private static final CreatorFactory instance = new CreatorFactory();
    private final TetrahedronCreator tetrahedronImpl = new TetrahedronCreatorImpl();

    private CreatorFactory() {
    }

    public static CreatorFactory getInstance() {
        return instance;
    }

    public TetrahedronCreator getTetrahedronCreator() {
        return tetrahedronImpl;
    }

}
