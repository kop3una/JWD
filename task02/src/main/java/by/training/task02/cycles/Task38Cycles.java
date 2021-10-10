package by.training.task02.cycles;
import by.training.task02.math.Math;

/**
 * This task is For a given natural number, determine whether its digits form an arithmetic progression.
 * It is assumed that there are at least three digits in the number. For example: 1357, 963
 */
public class Task38Cycles {
    private final int number;

    /**
     * @param number number from user
     */
    public Task38Cycles(int number) {
        this.number = number;
    }

    /**
     * Executes the task (see task description) and displays the result on the screen
     */
    public void isArithmeticProgression() {
        byte[] digits = Math.getDigitsArray(number);
        if (digits.length >= 3) {
            byte digit = digits[2];
            byte digitBefore = digits[1];
            byte d = (byte) (digits[1] - digits[0]);
            int indexCurrentDigits = 3;
            boolean isArithmeticProgression = true;
            while (isArithmeticProgression && (indexCurrentDigits < digits.length)) {
                if (digit == (digitBefore + d)) {
                    digitBefore = digit;
                    digit = digits[indexCurrentDigits];
                } else {
                    isArithmeticProgression = false;
                }
                indexCurrentDigits++;
            }

            if (isArithmeticProgression){
                System.out.println("Цифры числа состовляют арифметическую прогрессию");
            } else {
                System.out.println("Цифры числа не состовляют арифметическую прогрессию");
            }

        } else {
            System.out.println("Число должно быть не менее чем трехзначным");
        }


    }
}
