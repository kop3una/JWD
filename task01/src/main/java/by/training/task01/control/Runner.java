package by.training.task01.control;

import by.training.task01.service.*;
import org.apache.logging.log4j.LogManager;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * This is main class in program. It displays a simple menu to the console to select the task to run.
 *
 * @author Kirill Albert
 * @version 1.0
 * @see Task6
 * @see Task14
 * @see Task22
 * @see Task30
 * @see Task38
 */

public class Runner {

    /**
     * Start point of the program.
     *
     * @param args command line values.
     */
    public static void main(String[] args) {
        final var logger = LogManager.getLogger(Runner.class);
        var in = new Scanner(System.in);
        var answer = "0";
        var exit = "6";
        while (!answer.equals(exit)) {
            System.out.println("1. Задача 6  \n" +
                    "2. Задача 14  \n" +
                    "3. Задача 22  \n" +
                    "4. Задача 30  \n" +
                    "5. Задача 38  \n" +
                    "6. Выход  ");
            logger.info("1. Задача 6  \n" +
                    "2. Задача 14  \n" +
                    "3. Задача 22  \n" +
                    "4. Задача 30  \n" +
                    "5. Задача 38  \n" +
                    "6. Выход  ");
            answer = choice();
            logger.info("Coice: " + answer);
            try {
                switch (answer) {

                    case "1": {
                        System.out.println("Задача 6: Написать код для решения задачи. В n малых бидонах 80 л молока. Сколько литров молока в m больших бидонах, \n" +
                                "если в каждом большом бидоне на 12 л. больше, чем в малом?\n" +
                                "Введите n: ");
                        var task6 = new Task6(in.nextInt());
                        if (task6.getSizeLargeBuckets() == -1) {
                            System.out.println("Количество бидонов - натуральное число");
                            logger.warn("Количество бидонов - натуральное число");
                        } else {
                            System.out.println("В большом бидоне: " + task6.getSizeLargeBuckets() + " л");
                        }
                        break;
                    }
                    case "2": {
                        System.out.println("Задача 14: Вычислить длину окружности и площадь круга одного и того же заданного радиуса R. \n"
                                + "Введите R: ");
                        var task14 = new Task14(in.nextDouble());
                        if ((task14.circumference() == -1)) {
                            System.out.println("Радиус - неотрицательно число");
                            logger.warn("Радиус - неотрицательное число");
                        }
                        System.out.printf("Длина окружности  = %.3f Площадь круга = %.3f \n", task14.circumference(), task14.areaCircle());
                        break;
                    }

                    case "3": {
                        System.out.println("Задача 22: Дано натуральное число Т, которое представляет длительность прошедшего времени в секундах. Вывести данное \n" +
                                "значение длительности в часах, минутах и секундах в следующей форме:\n" +
                                "ННч ММмин SSc." +
                                "Введите T: ");
                        var task22 = new Task22(in.nextInt());
                        System.out.println(task22.getTime());
                        break;
                    }

                    case "4": {
                        System.out.println("Задача 30: Три сопротивления R1 R2, и R3 соединены параллельно. Найдите сопротивление соединения.\n"
                                + "Введите r1,r2,r3: ");
                        var task30 = new Task30(in.nextDouble(), in.nextDouble(), in.nextDouble());
                        if (task30.getResistance() == -1) {
                            System.out.println("Значение сопротивления больше 0");
                            logger.warn("Значение сопротивления больше 0");
                        } else {
                            System.out.printf("Общее сопротивление = %.3f \n", task30.getResistance());
                        }
                        break;
                    }

                    case "5": {
                        System.out.println("Задача 38: Для данных областей составить линейную программу, которая печатает true, если точка с координатами (х, у) \n" +
                                "принадлежит закрашенной области, и false — в противном случае:\n" +
                                "Введите x,y: ");
                        var task38 = new Task38(in.nextDouble(), in.nextDouble());
                        System.out.println("Область А: " + task38.isEnterA() + " Область В: " + task38.isEnterB() + " Область С: " + task38.isEnterC());
                        break;
                    }
                }
                logger.info("All good");
            } catch (InputMismatchException e) {
                System.out.println("Ошибка ввода.");
                logger.error("Not number");
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
}
