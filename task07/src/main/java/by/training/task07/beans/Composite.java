package by.training.task07.beans;

import java.util.*;

public class Composite implements Component { // TODO переименовать id
    private final ComponentId id;
    private List<Component> children = new ArrayList<>();

    public ComponentId getId() {
        return id;
    }

    public Composite(ComponentId id){
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Composite composite = (Composite) o;
        return children.equals(composite.children);
    }

    @Override
    public int hashCode() {
        return Objects.hash(children);
    }

    @Override
    public String toString() {
        return "Composite{" +
                "children=" + children +
                '}';
    }

    @Override
    public String collect() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Component component : children){
            stringBuilder.append(component.collect());
        }
        if (id == ComponentId.LEXEME){
            stringBuilder.append(" ");
        }
        if (id == ComponentId.PARAGRAPH){
            stringBuilder.append("\r\n");
        }
        return stringBuilder.toString();
    }

    public void add (Component component){
        children.add(component);
    }

    public List<Component> getChildren (){
        return this.children;
    }

    public void setChildren(List<Component> children) {
        this.children = children;
    }

}
