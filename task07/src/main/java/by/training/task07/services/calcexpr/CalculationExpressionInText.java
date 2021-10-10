package by.training.task07.services.calcexpr;

import by.training.task07.beans.Component;
import by.training.task07.beans.ComponentId;
import by.training.task07.beans.Composite;
import by.training.task07.services.chainofresponsible.*;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CalculationExpressionInText {
    private static final String REG_EXP_DIGIT = "\\d+";

    public void calculateExpr (Component component){ //TODO интерпретатор выражение разделить на список чисел и операторов
        CalculationExpression calculationExpression = new CalculationExpression();
        Handler lexemeHandler = new LexemeHandler();
        Handler wordHandler = new WordHandler();
        Handler symbolHandler = new SymbolHandler();
        lexemeHandler.setNext(wordHandler);
        wordHandler.setNext(symbolHandler);
        if (isValid(component)){
            Composite text = (Composite) component;
            for (Component paragraph: text.getChildren()){
                for (Component sentence : ((Composite) paragraph).getChildren()){
                    List<Component> lexemes = ((Composite) sentence).getChildren();
                   for ( int i = 0; i < lexemes.size(); i++){
                       if ( isDigit(lexemes.get(i).collect().trim()) ){
                           String polishString = calculationExpression.makePolishString(lexemes.get(i).collect().trim());
                           int value = calculationExpression.calculateExpression(polishString);
                           Component lexeme = lexemeHandler.handle(String.valueOf(value));
                           lexemes.set(i,lexeme);
                       }
                   }
                   ((Composite) sentence).setChildren(lexemes);
                }
            }
        }
    }


    private boolean isValid (Component component){
        return (((Composite) component).getId() == ComponentId.TEXT);
    }

    private boolean isDigit(String symbol) {
        Pattern patternDigit = Pattern.compile(REG_EXP_DIGIT);
        Matcher matcherDigit = patternDigit.matcher(symbol);
        return matcherDigit.find();
    }
}
