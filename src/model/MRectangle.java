package model;

/**
 * represents a Rectangle.
 * A Rectangle is a Shape with a length and a width.
 * @author Gert Veltink, updated Agathe Merceron
 *
 */

public class MRectangle extends MShape {

    private double xDelta;
    private double yDelta;

    /**
     * constructs a rectangle object
     *
     * @param xOrigin
     *            the x-coordinate of the shape's origin
     * @param yOrigin
     *            the y-coordinate of the shape's origin
     * @param xDelta
     *            half of the length
     * @param yDelta
     *            half of the width
     *
     */

    public MRectangle(double xOrigin, double yOrigin, double xDelta, double yDelta) {
        super(xOrigin, yOrigin);
        this.xDelta = xDelta;
        this.yDelta = yDelta;
    }

    /**
     * returns half the length of the rectangle
     * @return half the length
     */

    public double getXDelta() {
        return xDelta;
    }

    /**
     * returns half the width of the rectangle
     * @return half the width
     */

    public double getYDelta(){
        return yDelta;
    }

    public void setxDelta(double xDelta)
    {
        this.xDelta = xDelta;
    }

    public void setyDelta(double yDelta)
    {
        this.yDelta = yDelta;
    }

    /**
     * calculate the area of this rectangle.
     *
     * @return the area of the rectangle
     */
    @Override
    public double area() {
        return (2*this.xDelta) * (2*this.yDelta);
    }

    /**
     * calculate the circumference of this rectangle.
     *
     * @return the circumference of the rectangle
     */
    @Override
    public double circumference() {
        return (4*this.xDelta) + (4*this.yDelta);
    }

    /**
     * constructs a textual representation of the object.
     *
     * @return the current object in a textual representation
     */
    @Override
    public String toString() {
        return "Rectangle with origin: " + origin() +
                ", xDelta: " + this.xDelta + ", yDelta: ";
    }

}