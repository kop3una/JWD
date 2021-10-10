package by.training.task07.services.chainofresponsible;

import by.training.task07.beans.Component;
import by.training.task07.beans.ComponentId;
import by.training.task07.beans.Composite;

public class WordHandler extends BaseHandler{

    @Override
    public Component handle(String data) {
        Composite word = new Composite(ComponentId.WORD);
        for (Character symbol : data.toCharArray()){
            Component symbolComponent = this.getNext().handle(symbol.toString());
            word.add(symbolComponent);
        }
        return word;
    }

}
