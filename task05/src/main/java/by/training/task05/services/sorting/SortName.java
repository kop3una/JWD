package by.training.task05.services.sorting;

import by.training.task05.beans.Tetrahedron;

;import java.util.Arrays;
import java.util.Comparator;

public class SortName implements Sorting {
    @Override
    public void sort(Tetrahedron[] tetrahedrons) {
        Arrays.sort(tetrahedrons, Comparator.comparing(Tetrahedron::getName));
    }
}
