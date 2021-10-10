package by.training.task03.controller.command.impl;

import by.training.task03.beans.Entity;
import by.training.task03.beans.Matrix;
import by.training.task03.beans.exception.MatrixExepction;
import by.training.task03.controller.command.Command;
import by.training.task03.controller.exception.ControllerException;
import by.training.task03.services.creator.MatrixCreator;
import by.training.task03.services.creator.impl.MatrixCreatorImpl;
import by.training.task03.services.exception.ServicesException;
import by.training.task03.services.manager.MatrixManager;
import by.training.task03.services.manager.impl.MatrixManagerImpl;
import by.training.task03.services.matrix.Transpose;
import by.training.task03.services.matrix.TransposeImpl;

public class MatrTranspose implements Command {
    @Override
    public Entity execute(String... arguments) throws ControllerException {
        MatrixCreator matrixCreator = new MatrixCreatorImpl();
        MatrixManager matrixManager = new MatrixManagerImpl();
        try {
            Matrix matrixFromFile = matrixCreator.createFromFile(arguments[0]);
            Transpose transposeMatrix = new TransposeImpl();
            Matrix matrix = transposeMatrix.transpose(matrixFromFile);
            matrixManager.writeInFile(matrix,"task03");
            return matrix;
        } catch (ServicesException | MatrixExepction e){
            throw new ControllerException(e);
        }
    }
}
