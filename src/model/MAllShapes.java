package model;

/**
 * a fabric for Shape-Objects.
 * @author Agathe Merceron
 */

import java.util.Arrays;

public class MAllShapes {

    /**
     * construct a number of Rectangle and Circle objects,
     * stores them in an array and returns it
     * @return an array filled with Rectangle or Circle objects
     */

    public static MShape[] getDefaultShapes(){
        MShape[] allshapes= new MShape[5];
        allshapes[0] = new MRectangle( 255, 125, 30, 25);
        allshapes[1] = new MRectangle( 155, 75, 10, 40);
        allshapes[2] = new MCircle( 80, 80, 10);
        allshapes[3] = new MRectangle( 45, 105, 80, 40);
        allshapes[4] = new MCircle( 200, 100, 50);
        return allshapes;
    }

    public static void main(String[] args) {
        MShape[] mix =  MAllShapes.getDefaultShapes();
        System.out.println(Arrays.deepToString(mix));
    }

}