package by.training.task04.beans;

import java.util.ArrayList;

public class Text { // TODO equals and hash code
    private Sentence header;
    private final ArrayList<Sentence> bodySentence = new ArrayList<>();

    public void addBody(Sentence sentence) {
        bodySentence.add(sentence);
    }

    public void addLineBreak (){
        Word word = new Word();
        word.setValue("\r\n");
        Sentence sentence = new Sentence();
        sentence.addWord(word);
        bodySentence.add(sentence);
    }

    public String getBody() {
        StringBuilder body = new StringBuilder();
        for (Sentence sentence : bodySentence) {
            body.append(sentence.toString());
        }
        return body.toString();
    }

    public String getHeader() {
        return header.toString();
    }

    public void setHeader(Sentence sentence) {
        this.header = sentence;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Sentence sentence : bodySentence){
            result.append(sentence.toString());
        }
        return result.toString();
    }

}
