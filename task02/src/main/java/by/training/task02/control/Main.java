package by.training.task02.control;

import by.training.task02.branching.*;
import by.training.task02.cycles.*;
import org.apache.logging.log4j.LogManager;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * This is main class in program. It displays a simple menu to the console to select the task to run.
 *
 * @author Kirill Albert
 * @version 1.0
 * @see Task6Branching
 *  @see Task14Branching
 * @see Task22Branching
 * @see Task30Branching
 * @see Task38Branching
 * @see Task6Cycles
 * @see Task14Cycles
 * @see Task22Cycles
 * @see Task30Cycles
 * @see Task38Cycles
 */


public class Main {

    /**
     * Start point of the program.
     * @param args command line values.
     */
    public static void main(String[] args) {
        final var logger = LogManager.getLogger(Main.class);
        var answer = "0";
        var exit = "3";
        while (!answer.equals(exit)) {
            mainMenu();
            answer = choice();
            logger.info("Main Menu choice: " + answer);
            try {
                switch (answer) {
                    case "1": {
                        branching();
                        break;
                    }
                    case "2": {
                        cycles();
                        break;
                    }
                    default: {
                        break;
                    }
                }
            } catch (InputMismatchException e) {
                System.out.println("Некорректный ввод");
                logger.warn("Некорректный ввод");
            }
        }
    }

    /**
     * @return string, which was input
     */
    private static String choice() {
        var in = new Scanner(System.in);
        return in.nextLine();
    }

    /**
     * Text selection menu branching and cycles
     */
    private static void mainMenu() {
        System.out.println("1. Ветвления\n" +
                "2. Циклы \n" +
                "3. Выход");
    }

    /**
     * Text selection menu from the task
     */
    private static void tasksMenu() {
        System.out.println("1. Задача 6  \n" +
                "2. Задача 14  \n" +
                "3. Задача 22  \n" +
                "4. Задача 30  \n" +
                "5. Задача 38  \n" +
                "6. Выход  ");
    }

    /**
     * The branching part, describes the console user interaction
     */
    private static void branching() {
        final var logger = LogManager.getLogger(Main.class);
        Scanner in = new Scanner(System.in);
        var answer = "0";
        var exit = "6";
        while (!answer.equals(exit)) {
            tasksMenu();
            answer = choice();
            logger.info("Branching choice: " + answer);
            switch (answer) {
                case "1": {
                    System.out.println("Задача 6:  Составить программу: определения наибольшего из двух чисел а и b.\n" +
                            "Введите a и b: ");
                    var task6Branching = new Task6Branching();
                    task6Branching.compareTwoNumbers(in.nextDouble(), in.nextDouble());
                    break;
                }
                case "2": {
                    System.out.println("Задача 14: Даны два угла треугольника (в градусах). Определить, существует ли такой треугольник, и если да, то будет ли он\n" +
                            "прямоугольным.\n" +
                            "Введите два угла: ");
                    var task14Branching = new Task14Branching(in.nextDouble(), in.nextDouble());
                    task14Branching.defineIsTriangle();
                    task14Branching.defineIsRightTriangle();
                    break;
                }
                case "3": {
                    System.out.println("Задача 22: Перераспределить значения переменных х и у так, чтобы в х оказалось большее из этих значений, а в y - меньшее. \n" +
                            "Введите два x и y: ");
                    var task22Branching = new Task22Branching(in.nextDouble(), in.nextDouble());
                    task22Branching.distributeXY();
                    break;
                }
                case "4": {
                    System.out.println("Задача 30: Даны действительные числа а,b,с. Удвоить эти числа, если а > b > с, и заменить их абсолютными значениями, если\n" +
                            "это не так \n" +
                            "Введите три числа a,b и c: ");
                    var task30Branching = new Task30Branching(in.nextDouble(), in.nextDouble(), in.nextDouble());
                    task30Branching.performTask30();
                    break;
                }
                case "5": {
                    System.out.println("Задача 38: Вычислить значение функции: (смотреть в условии)\n" +
                            "Введите x: ");
                    var task38Branching = new Task38Branching(in.nextDouble());
                    System.out.println("Значение функции = " + task38Branching.performFunc());
                    break;
                }
                default: {
                    break;
                }
            }
        }
    }

    /**
     * The cycles part, describes the console user interaction
     */
    private static void cycles() {
        final var logger = LogManager.getLogger(Main.class);
        Scanner in = new Scanner(System.in);
        var answer = "0";
        var exit = "6";
        while (!answer.equals(exit)) {
            tasksMenu();
            answer = choice();
            logger.info("Cycles choice: " + answer);
            switch (answer) {
                case "1": {
                    System.out.println("Напишите программу, где пользователь вводит любое целое положительное число. А программа\n" +
                            "суммирует все числа от 1 до введенного пользователем числа.\n" +
                            "Введите число: ");
                    var task6Cycles = new Task6Cycles(in.nextInt());
                    task6Cycles.performSum();
                    break;
                }
                case "2": {
                    System.out.println("Задача 14: Дано натуральное n. вычислить: 1 + 1/2 + 1/3 + 1/4 + ... + 1/n.\n" +
                            "Введите n: ");
                    var task14Cycles = new Task14Cycles(in.nextInt());
                    task14Cycles.performSum();
                    break;
                }
                case "3": {
                    System.out.println("Задача 22: Составить программу для вычисления значений функции F(x) на отрезке [а, b] с шагом h. Результат\n" +
                            "представить в виде таблицы, первый столбец которой – значения аргумента, второй - соответствующие\n" +
                            "значения функции: F(x) = sin^2(x)\n" +
                            "Введите a, b и h: ");
                    var task22Cycles = new Task22Cycles(in.nextDouble(),in.nextDouble(),in.nextDouble());
                    task22Cycles.performFunc();
                    break;
                }
                case "4": {
                    System.out.println("Задача 30: Написать программу, переводящую римские цифры в арабские \n" +
                            "Введите число (со строки берется первая буква): ");
                    var task30Cycles = new Task30Cycles();
                    task30Cycles.romanToArabic(in.next().charAt(0));
                    break;
                }
                case "5": {
                    System.out.println("Задача 38: Для заданного натурального числа определить, образуют ли его цифры арифметическую\n" +
                            "прогрессию. Предполагается, что в числе не менее трёх цифр. Например: 1357, 963\n" +
                            "Введите число: ");
                    var task38Cycles = new Task38Cycles(in.nextInt());
                    task38Cycles.isArithmeticProgression();
                    break;
                }
                default: {
                    break;
                }
            }
        }
    }
}

