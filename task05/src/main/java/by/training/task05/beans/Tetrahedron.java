package by.training.task05.beans;

import by.training.task05.services.observer.Publisher;

import java.util.Objects;

public class Tetrahedron {
    private String name;
    private Dot firstDot = null;
    private Dot secondDot = null;
    private Dot thirdDot = null;
    private Dot fourthDot = null;
    private Publisher publisher;

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
        this.publisher.notifySubscriber(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tetrahedron that = (Tetrahedron) o;
        return name.equals(that.name) && firstDot.equals(that.firstDot) && secondDot.equals(that.secondDot) && thirdDot.equals(that.thirdDot) && fourthDot.equals(that.fourthDot);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, firstDot, secondDot, thirdDot, fourthDot);
    }

    @Override
    public String toString() {
        return "Tetrahedron{" +
                "name='" + name + '\'' +
                ", firstDot=" + firstDot.toString() +
                ", secondDot=" + secondDot.toString() +
                ", thirdDot=" + thirdDot.toString() +
                ", fourthDot=" + fourthDot.toString() +
                '}';
    }

    public String getName() {
            return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Dot getFirstDot() {
        return firstDot;
    }

    public void setFirstDot(Dot firstDot) {
        this.firstDot = firstDot;
        if ( this.publisher != null){
            this.publisher.notifySubscriber(this);
        }
    }

    public Dot getSecondDot() {
        return secondDot;
    }

    public void setSecondDot(Dot secondDot) {
        this.secondDot = secondDot;
        if ( this.publisher != null){
            this.publisher.notifySubscriber(this);
        }
    }

    public Dot getThirdDot() {
        return thirdDot;
    }

    public void setThirdDot(Dot thirdDot) {
        this.thirdDot = thirdDot;
        if ( this.publisher != null){
            this.publisher.notifySubscriber(this);
        }
    }

    public Dot getFourthDot() {
        return fourthDot;
    }

    public void setFourthDot(Dot fourthDot) {
        this.fourthDot = fourthDot;
        if ( this.publisher != null){
            this.publisher.notifySubscriber(this);
        }
    }

}
