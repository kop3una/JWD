package by.training.task07.services.sorting;

import by.training.task07.beans.Component;
import by.training.task07.beans.ComponentId;
import by.training.task07.beans.Composite;

import java.util.Comparator;

public class SortWord implements SortingText{
    @Override
    public void sort(Component component) {
        if ( isValid(component) ){
           Composite text = (Composite) component;
           for (Component paragraph: text.getChildren()){
               for (Component sentence : ((Composite) paragraph).getChildren()){
                  ((Composite) sentence).getChildren().sort(Comparator.comparingInt(this::sizeOfLexeme));
               }
           }
        }
    }

    private boolean isValid (Component component){
        return (((Composite) component).getId() == ComponentId.TEXT);
    }

    private int sizeOfLexeme (Component component){
        Composite lexeme = (Composite) component;
        Composite word = (Composite) lexeme.getChildren().get(0);
        return word.getChildren().size();
    }
}
