package by.training.task03.services.array;

import by.training.task03.beans.Array;

public class MergeSort implements Sorting {
    @Override
    public void sortIncrease(Array array) {
        mergeSortIncrease(array);
    }

    @Override
    public void sortDecrease(Array array) {
        mergeSortDecrease(array);
    }

    private void mergeSortIncrease(Array array) {
        double[] tmp;
        double[] currentSrc = array.getValues();
        double[] currentDest = new double[array.length()];

        int size = 1;
        while (size < array.length()) {
            for (int i = 0; i < array.length(); i += 2 * size) {
                mergeIncrease(currentSrc, i, currentSrc, i + size, currentDest, i, size);
            }

            tmp = currentSrc;
            currentSrc = currentDest;
            currentDest = tmp;

            size = size * 2;

        }
    }

    private void mergeIncrease(double[] src1, int src1Start, double[] src2, int src2Start, double[] dest,
                              int destStart, int size) {
        int index1 = src1Start;
        int index2 = src2Start;

        int src1End = Math.min(src1Start + size, src1.length);
        int src2End = Math.min(src2Start + size, src2.length);

        int iterationCount = src1End - src1Start + src2End - src2Start;

        for (int i = destStart; i < destStart + iterationCount; i++) {
            if (index1 < src1End && (index2 >= src2End || src1[index1] < src2[index2])) {
                dest[i] = src1[index1];
                index1++;
            } else {
                dest[i] = src2[index2];
                index2++;
            }
        }
    }

    private void mergeSortDecrease(Array array) {
        double[] tmp;
        double[] currentSrc = array.getValues();
        double[] currentDest = new double[array.length()];

        int size = 1;
        while (size < array.length()) {
            for (int i = 0; i < array.length(); i += 2 * size) {
                mergeDecrease(currentSrc, i, currentSrc, i + size, currentDest, i, size);
            }

            tmp = currentSrc;
            currentSrc = currentDest;
            currentDest = tmp;

            size = size * 2;

        }
    }

    private void mergeDecrease(double[] src1, int src1Start, double[] src2, int src2Start, double[] dest,
                               int destStart, int size) {
        int index1 = src1Start;
        int index2 = src2Start;

        int src1End = Math.min(src1Start + size, src1.length);
        int src2End = Math.min(src2Start + size, src2.length);

        int iterationCount = src1End - src1Start + src2End - src2Start;

        for (int i = destStart; i < destStart + iterationCount; i++) {
            if (index1 < src1End && (index2 >= src2End || src1[index1] > src2[index2])) {
                dest[i] = src1[index1];
                index1++;
            } else {
                dest[i] = src2[index2];
                index2++;
            }
        }
    }

}
