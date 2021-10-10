package by.training.task07.services.sorting;

import by.training.task07.beans.Component;
import by.training.task07.beans.ComponentId;
import by.training.task07.beans.Composite;

import java.util.Comparator;

public class SortParagraph implements SortingText{
    @Override
    public void sort(Component component) {
        if ( isValid(component) ){
            ((Composite) component).getChildren().sort(Comparator.comparingInt(o -> -((Composite) o).getChildren().size()));
        }
    }

    private boolean isValid (Component component){
        return (((Composite) component).getId() == ComponentId.TEXT);
    }
}