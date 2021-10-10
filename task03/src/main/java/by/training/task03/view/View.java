package by.training.task03.view;

import by.training.task03.beans.Entity;
import by.training.task03.controller.Controller;
import by.training.task03.controller.exception.ControllerException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

import java.util.InputMismatchException;
import java.util.Scanner;

public class View {

    private static final String ERROR_INPUT = "Некорректный ввод";
    private static final char DELIMITER = ' ';
    private static final char DELIMITER_UNDERSСORE = '_';
    private static final char DELIMITER_ARGS = (char) 1;
    private static final Controller controller = new Controller();
    private static final Logger logger = (Logger) LogManager.getLogger(View.class);

    public static void main(String[] args){ // TODO class runner
        var answer = "0";
        var exit = "3";
        while (!answer.equals(exit)) {
            mainMenu();
            answer = choice();
            logger.info("Main Menu choice: " + answer);
            try {
                switch (answer) {
                    case "1": {
                        array("ARR" + DELIMITER);
                        break;
                    }
                    case "2": {
                        matrix("MATR" + DELIMITER);
                        break;
                    }
                    default: {
                        break;
                    }
                }
            } catch (InputMismatchException e) {
                logger.warn(ERROR_INPUT);
            }
        }
    }

    private static String choice() {
        var in = new Scanner(System.in);
        return in.nextLine();
    }

    private static void mainMenu() {
        System.out.println("1. Массивы\n" +
                "2. Матрица\n" +
                "3. Выход");
    }

    private static void arrayMenu() {
        System.out.println("1. Сортировка пузырьком\n" +
                "2. «Шейкер-сортировка»\n" +
                "3. Сортировка методом простого выбора\n" +
                "4. Сортировка вставками\n" +
                "5. Сортировка вставками (метод хеширования)\n" +
                "6. Сортировка бинарным слиянием\n" +
                "7. Сортировка Шелла\n" +
                "8. Выход");
    }

    private static void matrixMenu() {
        System.out.println("1. Сложение\n" +
                "2. Вычитание\n" +
                "3. Умножение\n" +
                "4. Степень\n" +
                "5. Транспонирование\n" +
                "6. Выход");
    }
    
    private static void matrixMultiplyMenu () {
        System.out.println("1. Умножение двух матриц\n" +
                "2. Умножение матрицы на число\n" +
                "3. Выход");
    }

    private static void sortMenu() {
        System.out.println("1. По возрастанию\n" +
                "2. По убыванию\n" +
                "3. Выход");
    }

    private static void sort (String command){
        sortMenu();
        try {
            switch (choice()) {
                case "1": {
                    oneFile(command + "INCREASE" + DELIMITER);
                    break;
                }
                case "2": {
                    oneFile(command + "DECREASE" + DELIMITER);
                    break;
                }
                default: {
                    break;
                }
            }
        } catch (InputMismatchException e) {
            logger.error(ERROR_INPUT);
        }
    }

    private static void oneFile(String command){
        Scanner in = new Scanner(System.in);
        System.out.print("Введите имя файла (файл расположен в папке с проектом): ");
        String fileName = in.nextLine();
        try {
            Entity entity = controller.executeTask(command + fileName);
            System.out.println(entity);
        } catch (ControllerException e){
            logger.error("Matrix error: " + e);
        }

    } // name is maybe more information

    private static void array(String command) {
        arrayMenu();
        try {
            switch (choice()) {
                case "1": {
                    sort(command + "BUBBLE_SORT" + DELIMITER);
                    break;
                }
                case "2": {
                    sort(command + "SHAKER_SORT" + DELIMITER);
                    break;
                }
                case "3": {
                    sort(command + "SIMPLE_CHOICE_SORT" + DELIMITER);
                    break;
                }
                case "4": {
                    sort(command + "INSERTION_SORT" + DELIMITER);
                    break;
                }
                case "5": {
                    sort(command + "HASHING_SORT" + DELIMITER);
                    break;
                }
                case "6": {
                    sort(command + "MERGE_SORT" + DELIMITER);
                    break;
                }
                case "7": {
                    sort(command + "SHELL_SORT" + DELIMITER);
                    break;
                }
                default: {
                    break;
                }
            }
        } catch (InputMismatchException e) {
            System.out.println(ERROR_INPUT);
            logger.error(ERROR_INPUT);
        }
    }

    private static void twoFile(String command){
        Scanner in = new Scanner(System.in);
        System.out.print("Введите имя файла первой матрицы (файл расположен в папке с проектом): ");
        String firstFileName = in.nextLine();
        System.out.print("Введите имя файла второй матрицы (файл расположен в папке с проектом): ");
        String secondFileName = in.nextLine();
        try {
            Entity entity = controller.executeTask(command+firstFileName+ DELIMITER_ARGS +secondFileName);
            System.out.println(entity);
        } catch (ControllerException e) {
            logger.error("Matrix error: " + e);
        }



    } //name is maybe more information

    private static void fileAndNum(String command){
        Scanner in = new Scanner(System.in);
        System.out.print("Введите имя файла матрицы (файл расположен в папке с проектом): ");
        String fileName = in.nextLine();
        System.out.print("Введите число n (натуральное): ");
        int number = in.nextInt();
        try {
            Entity entity = controller.executeTask(command+fileName+ DELIMITER_ARGS +number);
            System.out.println(entity);
        } catch (ControllerException e) {
            logger.error("Matrix error: " + e);
        }

    }

    private static void matrix(String command) {
        matrixMenu();
        try {
            switch (choice()) {
                case "1": {
                    twoFile(command + "SUM" + DELIMITER);
                    break;
                }
                case "2": {
                    twoFile(command + "SUB" + DELIMITER);
                    break;
                }
                case "3": {
                    matrixMultiply(command + "MULTIPLY" + DELIMITER_UNDERSСORE);
                    break;
                }
                case "4": {
                    fileAndNum(command + "POW" + DELIMITER);
                    break;
                }
                case "5": {
                    oneFile(command + "TRANSPOSE" + DELIMITER);
                    break;
                }
                default: {
                    break;
                }
            }
        } catch (InputMismatchException e) {
            logger.error(ERROR_INPUT);
        }
    }
    
    private static void matrixMultiply (String command){
        matrixMultiplyMenu();
        try {
            switch (choice()) {
                case "1": {
                    twoFile(command + "MATRIX" + DELIMITER);
                    break;
                }
                case "2": {
                    fileAndNum(command + "NUMBER" + DELIMITER);
                    break;
                }
                default: {
                    break;
                }
            }
        } catch (InputMismatchException e) {
            logger.error(ERROR_INPUT);
        }
    }
}
