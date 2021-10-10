package by.training.task02.math;
import java.util.ArrayList;

/**
 * This class describe some simple task with numbers.
 */

public final class Math {

    private Math() {

    }

    /**
     * compare two number
     * @param a first number
     * @param b second number
     * @return if 1 - a>b, if -1 - a<b, if 0 - a = b
     */
    public static int compare(double a, double b) {
        if (a > b) {
            return 1;
        } else if (a < b) {
            return -1;
        } else {
            return 0;
        }
    }

    /**
     * sum three number
     * @param a a
     * @param b b
     * @param c c
     * @return sum of a+b+c
     */
    public static double sum(double a, double b, double c) {
        return a + b + c;
    }

    /**
     * Absolute value for double
     * @param a number
     * @return absolute value of a
     */
    public static double abc(double a) {
        if (a < 0) {
            return -a;
        } else {
            return a;
        }
    }

    /**
     * Absolute value for int
     * @param a number
     * @return absolute value of a
     */
    public static int abc(int a) {
        if (a < 0) {
            return -a;
        } else {
            return a;
        }
    }

    /**
     * Return byte array, when single byte - is a single digit in number.
     * @param number
     * @return byte array of digits from the number.
     */
    public static byte[] getDigitsArray(int number) {
        ArrayList<Byte> digitArray = new ArrayList<>();
        if (number != 0){
            number = abc(number);
            while (number != 0) {
                digitArray.add((byte) (number % 10));
                number /= 10;
            }
        } else {
            digitArray.add((byte) 0);
        }

        byte[] digits = new byte[digitArray.size()];
        int i = digits.length - 1;
        for (Byte digit : digitArray) {
            digits[i] = digit;
            i--;
        }

        return digits;
    }

    /**
     * Convert roman digit to arabic digit
     * @param romanNumber
     * @return arabic number
     */
    public static int romanToArabic(char romanNumber) {
        switch (romanNumber) {
            case 'I': {
                return 1;
            }
            case 'V': {
                return 5;
            }
            case 'X': {
                return 10;
            }
            case 'L': {
                return 50;
            }
            case 'C': {
                return 100;
            }
            case 'D': {
                return 500;
            }
            case 'M': {
                return 1000;
            }
            default: {
                return -1;
            }
        }
    }
}
