package by.training.task07.beans;

import java.util.Objects;

public class Leaf implements Component{
    private final ComponentId id;
    private char value;

    public Leaf(ComponentId id){
        this.id = id;
    }

    @Override
    public String toString() {
        return "Leaf{" +
                "value=" + value +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Leaf leaf = (Leaf) o;
        return value == leaf.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String collect() {
        return String.valueOf(value);
    }

    public void setValue(char value) {
        this.value = value;
    }

    public char getValue() {
        return value;
    }
}
