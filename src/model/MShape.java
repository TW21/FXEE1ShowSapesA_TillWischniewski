package model;


/**
 * Base class for geometric shapes. Each shape has an explicit origin
 * represented by a point: (x,y).
 *
 * @ version 1.00 27 Apr 2009
 *
 * @author Gert Veltink, updated Agathe Merceron
 */
public class MShape {

    /** x-coordinate of the origin */
    protected double xOrigin;

    /** y-coordinate of the origin */
    protected double yOrigin;

    /**
     * Constructor for a shape taking as argument the two coordinates of the
     * origin.
     *
     * @param x
     *            the x-coordinate of the shapes' origin
     * @param y
     *            the y-coordinate of the shapes' origin
     *
     */
    public MShape(double x, double y) {
        xOrigin = x;
        yOrigin = y;
    }

    /**
     * returns the x-origin of this shape
     * @return the x-origin
     */

    public double getXOrigin() {
        return xOrigin;
    }

    /**
     * returns the y-origin of this shape
     * @return the y-origin
     */

    public double getYOrigin(){
        return yOrigin;
    }

    /**
     * calculate the area of a shape. the base shape is just point so it has no
     * area.
     *
     * @return the area of the shape
     */
    public double area() {
        return 0;
    }

    /**
     * calculate the circumference of a shape. the base shape is just point so
     * it has no circumference.
     *
     * @return the circumference of the shape
     */
    public double circumference() {
        return 0;
    }

    /**
     * constructs a textual representation of the origin in the form: "(x, y)".
     * *
     *
     * @return the origin on textual representation
     */
    public String origin() {
        return ("(" + xOrigin + ", " + yOrigin + ")");
    }

    /**
     * constructs a textual representation of the object.
     *
     * @return the current object in a textual representation
     */
    @Override
    public String toString() {
        return ("Shape with origin: " + origin());
    }
}