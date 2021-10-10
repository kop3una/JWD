package by.training.task04.services.parse;

import by.training.task04.beans.Sentence;
import by.training.task04.beans.Word;

import java.util.regex.Pattern;

public class ParseString {

    public Sentence getSentence (String string){
        Sentence sentence = new Sentence();
        Pattern pattern = Pattern.compile("[\\s]");
        String [] stringWords = pattern.split(string);
        for (String word : stringWords){
            Word myWord = new Word();
            myWord.setValue(word);
            sentence.addWord(myWord);
            sentence.addSpace();
        }

        return sentence;
    }
}
