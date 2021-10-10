package by.training.task05.services.validation;

import java.util.regex.Pattern;

/**
 * Only a text document is validated
 */

public class LineValidator {
    private static final String REG_EXP_TWO_DOTS= ":";
    private static final String REG_EXP_SPACE = "\\s+";
    private static final String REG_EXP_SEMICOLON = ";";
    private static final String REG_EXP_DIGIT = "[+-]?[0-9]*[.,]?[0-9]";
    private static final int COUNT_DOTS = 4;
    private static final int COUNT_COORDINATES = 3;

    private LineValidator(){}

    public static boolean isValid(String line){
        if (!line.isEmpty()){
            String [] nameAndDots = Pattern.compile(REG_EXP_TWO_DOTS).split(line);
            if (nameAndDots.length == 2){
                String [] dots = Pattern.compile(REG_EXP_SPACE).split(nameAndDots[1].trim());
                if (dots.length == COUNT_DOTS){
                    for (String dot : dots){
                        String [] digits = Pattern.compile(REG_EXP_SEMICOLON).split(dot);
                        if (digits.length == COUNT_COORDINATES){
                            for (String digit : digits)
                            {
                                if (!Pattern.matches(REG_EXP_DIGIT,digit)) {
                                    return false;
                                }
                            }
                        }
                        else {
                            return false;
                        }
                    }
                    return true;
                }
            }
        }
        return false;
    }

}
