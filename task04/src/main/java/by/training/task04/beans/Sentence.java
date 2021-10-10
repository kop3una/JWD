package by.training.task04.beans;

import java.util.ArrayList;
import java.util.Objects;

public class Sentence {
    private final ArrayList<Word> valueWord = new ArrayList<>();

    public void addWord(Word word) {
        valueWord.add(word);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Word word: valueWord){
            result.append(word);
        }
        return result.toString();
    }

    public void addSpace(){
        Word space = new Word();
        space.setValue(" ");
        valueWord.add(space);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sentence sentence = (Sentence) o;
        if (valueWord.size() != sentence.valueWord.size()){
            return false;
        }
        for (int index = 0; index < valueWord.size(); index++){
            if (!valueWord.get(index).equals(sentence.valueWord.get(index))){
                return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hash(valueWord);
    }
}
