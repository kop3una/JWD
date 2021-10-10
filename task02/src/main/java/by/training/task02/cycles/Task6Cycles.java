package by.training.task02.cycles;

/**
 * This task is 2rite a program where the user enters any positive integer.
 * And the program sums all numbers from 1 to a user-entered number.
 */
public class Task6Cycles {
    private final int a;

    /**
     * @param a a
     */
    public Task6Cycles(int a) {
        this.a = a;
    }

    /**
     * perform sum and write result on console
     */
    public void performSum (){
        if (a > 0){
            var sum = 0;
            for (var i = 1; i<=a; i++){
                sum += i;
            }
            System.out.println("Сумма = "+sum);
        } else {
            System.out.println("Введенное число должно быть натуральным");
        }
    }
}
