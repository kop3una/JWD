package by.training.task06.services.creator;

import by.training.task06.services.creator.impl.InfoDataCreatorImpl;
import by.training.task06.services.creator.impl.MatrixCreatorImpl;
import by.training.task06.services.creator.impl.SquareMatrixCreatorImpl;

public class CreatorFactory {
    private static final CreatorFactory instance = new CreatorFactory();
    private final MatrixCreator matrixCreatorImpl = new MatrixCreatorImpl();
    private final InfoDataCreator infoDataCreatorImpl = new InfoDataCreatorImpl();
    private final SquareMatrixCreator squareMatrixCreatorImpl = new SquareMatrixCreatorImpl();

    private CreatorFactory() {
    }

    public static CreatorFactory getInstance() {
        return instance;
    }

    public MatrixCreator getMatrixCreator() {
        return matrixCreatorImpl;
    }

    public InfoDataCreator getInfoDataCreator() { return infoDataCreatorImpl; }

    public SquareMatrixCreator getSquareMatrixCreator() { return squareMatrixCreatorImpl; }

}
