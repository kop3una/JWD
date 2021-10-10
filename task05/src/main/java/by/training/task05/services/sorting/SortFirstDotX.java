package by.training.task05.services.sorting;

import by.training.task05.beans.Tetrahedron;

import java.util.Arrays;

public class SortFirstDotX implements Sorting {

    @Override
    public void sort(Tetrahedron[] tetrahedrons) {
        Arrays.sort(tetrahedrons, (o1, o2) -> (int) (o1.getFirstDot().getX() - o2.getFirstDot().getX()));
    }
}
