package by.training.task02.cycles;
import by.training.task02.math.Math;

/**
 * This task is write a program that converts Roman numerals to Arabic numerals
 */
public class Task30Cycles {

    /**
     * Convert roman number to arabic number and print result in console.
     * @param c symbol from user
     */
    public void romanToArabic (char c){
        if(Math.romanToArabic(c) != -1){
            System.out.println("Римская цифра: " + c + " = " + Math.romanToArabic(c));
        } else {
            System.out.println("Символ: " + c + " не обозначает цифру");
        }
    }

}
