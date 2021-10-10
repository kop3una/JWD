package by.training.task07.services.sorting;

import by.training.task07.beans.Component;
import by.training.task07.beans.ComponentId;
import by.training.task07.beans.Composite;
import by.training.task07.beans.Leaf;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;

public class SortLexeme implements SortingText {
    private final char symbol;

    public SortLexeme(char symbol) {
        this.symbol = symbol;
    }

    public void sort(Component component) {
        if (isValid(component)) {
            Composite text = (Composite) component;
            for (Component paragraph : text.getChildren()) {
                for (Component sentence : ((Composite) paragraph).getChildren()) {
                    ((Composite) sentence).getChildren().sort(Comparator.comparingInt(this::countOfEntry));
                    sortingSentenceAlphabet(sentence);
                }
            }
        }
    }

    private boolean isValid(Component component) {
        return (((Composite) component).getId() == ComponentId.TEXT);
    }

    private int countOfEntry(Component component) {
        int countEntry = 0;
        Composite lexeme = (Composite) component;
        Composite word = (Composite) lexeme.getChildren().get(0);
        for (Component currentSymbol : word.getChildren()) {
            if (((Leaf) currentSymbol).getValue() == this.symbol) {
                countEntry++;
            }
        }
        return -countEntry;
    }

    private List<Component> copyCollections(List<Component> components, int from, int to) {
        List<Component> copyComponents = new ArrayList<>();
        for (int i = from; i < to; i++) {
            copyComponents.add(components.get(i));
        }
        return copyComponents;
    }

    private void sortingSentenceAlphabet(Component sentence) {
        List<Component> lexemes = ((Composite) sentence).getChildren();
        List<Component> sortLexemes = new ArrayList<>();
        int[] countOfEntry = new int[lexemes.size()];
        int a = 0;
        for (Component lexeme : lexemes) {
            countOfEntry[a] = -countOfEntry(lexeme);
            a++;
        }
        int indexFrom = 0;
        while ((indexFrom < lexemes.size()) && (lexemes.size() != 1)) {
            int currentCountOfEntry = countOfEntry[indexFrom];
            int indexTo = indexFrom + 1;
            while ((indexTo < countOfEntry.length) && (currentCountOfEntry == countOfEntry[indexTo])) {
                indexTo++;
            }
            List<Component> lexemesForSort = copyCollections(lexemes, indexFrom, indexTo);
            lexemesForSort.sort(Comparator.comparing(o -> o.collect().toLowerCase(Locale.ROOT)));
            sortLexemes.addAll(lexemesForSort);
            indexFrom = indexTo;
        }
        if (!sortLexemes.isEmpty()) {
            ((Composite) sentence).setChildren(sortLexemes);
        }
    }

}
