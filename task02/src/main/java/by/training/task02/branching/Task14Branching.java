package by.training.task02.branching;
import by.training.task02.figure.Triangle;

/**
 * This Task14 is about determine if there is a triangle at given angles and its type.
 * @see Triangle
 */
public class Task14Branching {
    /**
     * object Triangle. With it we define, that it triangle or not.
     */
    private Triangle triangle;

    /**
     * Create object Triangle.
     * @param a thirst angle
     * @param b second angle
     */
    public Task14Branching(double a, double b){
        triangle = new Triangle(a,b);
    }

    /**
     * Determines if an object is a triangle
     */
    public void defineIsTriangle (){
        if (triangle.isTriangle()){
            System.out.println("Треугольник существует");
        } else {
            System.out.println("Треугольник не существует");
        }
    }

    /**
     * Determines if an object is a right triangle
     */
    public void defineIsRightTriangle (){
        if (triangle.isTriangle() && triangle.isRightTriangle()){
            System.out.println("Треугольник является прямоугольным");
        } else if (triangle.isTriangle() && !triangle.isRightTriangle()) {
            System.out.println("Треугольник не является прямоугльным");
        }
    }
}
