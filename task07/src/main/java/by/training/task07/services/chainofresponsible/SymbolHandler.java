package by.training.task07.services.chainofresponsible;

import by.training.task07.beans.Component;
import by.training.task07.beans.ComponentId;
import by.training.task07.beans.Leaf;

public class SymbolHandler extends BaseHandler{

    @Override
    public Component handle(String data) {
        Leaf symbol = new Leaf(ComponentId.SYMBOL);
        symbol.setValue(data.toCharArray()[0]);
        return symbol;
    }
}
