package by.training.task08.beans;

import java.util.Set;

public class Result {
    private boolean state;
    private Set<Candy> candies;

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public Set<Candy> getCandies() {
        return candies;
    }

    public void setCandies(Set<Candy> table) {
        this.candies = table;
    }
}
