package by.training.task05.services.validation;

import by.training.task05.beans.Tetrahedron;
import by.training.task05.services.calculation.Calculation;

/**
 * Validation group of dot, and can we create the tetrahedron
 */

public class FigureValidator {

    private FigureValidator(){}

    public static boolean isValid(Tetrahedron tetrahedron){
        Calculation calculation = new Calculation(tetrahedron);
        return calculation.volume() != 0;
    }

}
