package by.training.task07.services.chainofresponsible;

import by.training.task07.beans.Component;

public abstract class BaseHandler implements Handler{
    private Handler next;

    @Override
    public void setNext(Handler handler) {
        this.next = handler;
    }

    @Override
    public Handler getNext() {
        return next;
    }

    @Override
    public Component handle(String data) {
        if (next != null){
            return next.handle(data);
        } else {
            return null;
        }
    }
}
