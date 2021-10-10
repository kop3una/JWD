package by.training.task05.services.calculation;
import by.training.task05.beans.Tetrahedron;

/**
 * The class contains methods for determining the volume of a tetrahedron,
 * surface area, as well as methods that determine whether a facet in the same and coordinate planes
 */

public class Calculation {
    private static final int X = 0;
    private static final int Y = 1;
    private static final int Z = 2;
    private Tetrahedron tetrahedron;
    private double x1, y1, z1;
    private double x2, y2, z2;
    private double x3, y3, z3;
    private double x4, y4, z4;

    public Calculation (){

    }

    public Calculation(Tetrahedron tetrahedron) {
        this.tetrahedron = tetrahedron;
        calcCoordinates();
    }

    public Tetrahedron getTetrahedron() {
        return tetrahedron;
    }

    public void setTetrahedron(Tetrahedron tetrahedron) {
        this.tetrahedron = tetrahedron;
        calcCoordinates();
    }

    public double volume() {
        double[] vectorX = {x1 - x2, y1 - y2, z1 - z2};
        double[] vectorY = {x1 - x3, y1 - y3, z1 - z3};
        double[] vectorZ = {x1 - x4, y1 - y4, z1 - z4};

        double determinant = vectorX[X] * vectorY[Y] * vectorZ[Z] +
                vectorY[X] * vectorZ[Y] * vectorX[Z] +
                vectorX[Y] * vectorY[Z] * vectorZ[X] -
                vectorX[Z] * vectorY[Y] * vectorZ[X] -
                vectorY[Z] * vectorZ[Y] * vectorX[X] -
                vectorX[Y] * vectorY[X] * vectorZ[Z];

        return (1. / 6) * Math.abs(determinant);
    }

    public double surfaceArea() {
        double[] a1a2 = {x2 - x1, y2 - y1, z2 - z1};
        double[] a1a3 = {x3 - x1, y3 - y1, z3 - z1};
        double[] a1a4 = {x4 - x1, y4 - y1, z4 - z1};
        double[] a2a3 = {x3 - x2, y3 - y2, z3 - z2};
        double[] a2a4 = {x4 - x2, y4 - y2, z4 - z2};

        double absA1A2 = Math.sqrt(Math.pow(a1a2[X], 2) + Math.pow(a1a2[Y], 2) + Math.pow(a1a2[Z], 2));
        double absA1A3 = Math.sqrt(Math.pow(a1a3[X], 2) + Math.pow(a1a3[Y], 2) + Math.pow(a1a3[Z], 2));
        double absA1A4 = Math.sqrt(Math.pow(a1a4[X], 2) + Math.pow(a1a4[Y], 2) + Math.pow(a1a4[Z], 2));
        double absA2A3 = Math.sqrt(Math.pow(a2a3[X], 2) + Math.pow(a2a3[Y], 2) + Math.pow(a2a3[Z], 2));
        double absA2A4 = Math.sqrt(Math.pow(a2a4[X], 2) + Math.pow(a2a4[Y], 2) + Math.pow(a2a4[Z], 2));

        double sa1a2a3 = 1. / 2 * absA1A2 * absA1A3 *
                Math.sqrt(1 - Math.pow((a1a2[X] * a1a3[X] + a1a2[Y]* a1a3[Y]+ a1a2[Z]* a1a3[Z])/(absA1A2*absA1A3), 2));
        double sa1a2a4 = 1. / 2 * absA1A2 * absA1A4 *
                Math.sqrt(1 - Math.pow((a1a2[X] * a1a4[X] + a1a2[Y]* a1a4[Y]+ a1a2[Z]* a1a4[Z])/(absA1A2*absA1A4), 2));
        double sa1a3a4 = 1. / 2 * absA1A3 * absA1A4 *
                Math.sqrt(1 - Math.pow((a1a3[X] * a1a4[X] + a1a3[Y]* a1a4[Y]+ a1a3[Z]* a1a4[Z])/(absA1A3*absA1A4), 2));
        double sa2a3a4 = 1. / 2 * absA2A3 * absA2A4 *
                Math.sqrt(1 - Math.pow((a2a3[X] * a2a4[X] + a2a3[Y]* a2a4[Y]+ a2a3[Z]* a2a4[Z])/(absA2A3*absA2A4), 2));
        return sa1a2a3 + sa1a2a4 + sa1a3a4 + sa2a3a4;
    }

    public boolean isPlaneXY (){
        int flag = 0;
        double [] coordinatesZ = {z1,z2,z3,z4};
        for (double z : coordinatesZ){
            if (z == 0){
                flag++;
            }
        }
        return flag==3;
    }

    public boolean isPlaneYZ (){
        int flag = 0;
        double [] coordinatesX = {x1,x2,x3,x4};
        for (double x : coordinatesX){
            if (x == 0){
                flag++;
            }
        }
        return flag==3;
    }

    public boolean isPlaneXZ (){
        int flag = 0;
        double [] coordinatesY = {y1,y2,y3,y4};
        for (double y : coordinatesY){
            if (y == 0){
                flag++;
            }
        }
        return flag==3;
    }

    private void calcCoordinates() {
        x1 = tetrahedron.getFirstDot().getX();
        y1 = tetrahedron.getFirstDot().getY();
        z1 = tetrahedron.getFirstDot().getZ();
        x2 = tetrahedron.getSecondDot().getX();
        y2 = tetrahedron.getSecondDot().getY();
        z2 = tetrahedron.getSecondDot().getZ();
        x3 = tetrahedron.getThirdDot().getX();
        y3 = tetrahedron.getThirdDot().getY();
        z3 = tetrahedron.getThirdDot().getZ();
        x4 = tetrahedron.getFourthDot().getX();
        y4 = tetrahedron.getFourthDot().getY();
        z4 = tetrahedron.getFourthDot().getZ();
    }

}
