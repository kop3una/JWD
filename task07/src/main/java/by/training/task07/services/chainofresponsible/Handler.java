package by.training.task07.services.chainofresponsible;

import by.training.task07.beans.Component;

public interface Handler {

    void setNext(Handler handler);
    Handler getNext();
    Component handle (String data);
}
