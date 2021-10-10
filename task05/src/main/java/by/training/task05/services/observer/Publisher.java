package by.training.task05.services.observer;

import by.training.task05.beans.Tetrahedron;

/**
 * The publisher contains only one subscriber for storing surface area and volume
 */

public class Publisher {
    private SubscriberTetrahedron subscriber;
    public SubscriberTetrahedron getSubscriber() {
        return subscriber;
    }

    public boolean subscribe (SubscriberTetrahedron subscriber){
        if (this.subscriber == null){
            this.subscriber = subscriber;
            return true;
        } else {
            return false;
        }
    }
    public boolean unsubscribe (){
        if (this.subscriber != null){
            this.subscriber = null;
            return true;
        } else {
            return false;
        }
    }
    public void notifySubscriber (Tetrahedron tetrahedron){
        this.subscriber.update(tetrahedron);
    }

}
