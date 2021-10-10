package by.training.task02.cycles;

/**
 * This task is given natural n. calculate: 1 + 1/2 + 1/3 + 1/4 + ... + 1 / n.
 */
public class Task14Cycles {
    private final int n;

    /**
     * @param n n
     */
    public Task14Cycles(int n) {
        this.n = n;
    }

    /**
     * perform sum: 1 + 1/2 + 1/3 + 1/4 + ... + 1 / n
     */
    public void performSum () {
        if (n > 0){
            double sum = 0;
            for (int i = 1; i <=n; i++){
                sum += 1./i;
            }
            System.out.println("Сумма = "+ sum);
        } else {
            System.out.println("Введенное число должно быть натуральным");
        }
    }
}
