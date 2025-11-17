package hk.edu.polyu.comp.comp2021.clevis.model;

/**
 * Represents a line segment defined by two endpoints.
 * A line can be moved, described, and tested for intersection
 * with other shapes.
 */
public class Line extends Shape {

    /** x-coordinate of the first endpoint */
    private double x;
    /** y-coordinate of the first endpoint */
    private double y;
    /** x-coordinate of the second endpoint */
    private double x2;
    /** y-coordinate of the second endpoint */
    private double y2;

    /**
     * Constructs a Line object.
     *
     * @param name   the name of the line
     * @param x      x-coordinate of the first endpoint
     * @param y      y-coordinate of the first endpoint
     * @param x2     x-coordinate of the second endpoint
     * @param y2     y-coordinate of the second endpoint
     * @param zOrder rendering order
     */
    public Line(String name, double x, double y, double x2, double y2, int zOrder) {
        super(name, zOrder);
        this.setX(x);
        this.setY(y);
        this.setX2(x2);
        this.setY2(y2);
    }
<<<<<<< HEAD

    /**
     * Moves the line by the given delta values.
     *
     * @param dx amount to move along the x-axis
     * @param dy amount to move along the y-axis
     */
=======
    
    @Override
>>>>>>> 811ac88c650e8e5ef141c07a634f810b30771d36
    public void move(double dx, double dy){
        setX(getX() + dx);
        setY(getY() + dy);
        setX2(getX2() + dx);
        setY2(getY2() + dy);
    }

<<<<<<< HEAD
    /**
     * Returns the bounding box of the line segment.
     *
     * @return an array [minX, minY, maxX, maxY]
     */
=======
    @Override
>>>>>>> 811ac88c650e8e5ef141c07a634f810b30771d36
    public double[] getBoundingBox(){
        double minX = Math.min(getX(), getX2());
        double minY = Math.min(getY(), getY2());
        double width = Math.abs(getX2() - getX());
        double height = Math.abs(getY2() - getY());
        return new double[]{minX, minY, width, height};
    }

<<<<<<< HEAD
    /**
     * Checks whether the line covers the given point.
     *
     * @param px x-coordinate of the point
     * @param py y-coordinate of the point
     * @return true if the point lies on the line segment, false otherwise
     */
=======
    @Override
>>>>>>> 811ac88c650e8e5ef141c07a634f810b30771d36
    public boolean coverPoint(double px, double py){
        double dx = getX2() - getX();
        double dy = getY2() - getY();
        double length = Math.sqrt(dx*dx + dy*dy);

        double distance = Math.abs((px - getX()) * dy - (py - getY()) * dx) / length;
        double dot = (px - getX()) * dx + (py - getY()) * dy;

        if(dot < 0){
            return false;
        }
        if(dot > dx * dx + dy * dy){
            return false;
        }

        return true;
    }

<<<<<<< HEAD
    /**
     * Checks whether this line intersects with another shape.
     *
     * @param other the other shape
     * @return true if the line intersects with the other shape
     */
=======
    @Override
>>>>>>> 811ac88c650e8e5ef141c07a634f810b30771d36
    public boolean intersect(Shape other) {
        if (other instanceof Line) {
            Line line2 = (Line) other;

            double d1 = (line2.getX() - getX()) * (getY2() - getY()) - (line2.getY() - getY()) * (getX2() - getX());
            double d2 = (line2.getX2() - getX()) * (getY2() - getY()) - (line2.getY2() - getY()) * (getX2() - getX());
            double d3 = (getX() - line2.getX()) * (line2.getY2() - line2.getY()) - (getY() - line2.getY()) * (line2.getX2() - line2.getX());
            double d4 = (getX2() - line2.getX()) * (line2.getY2() - line2.getY()) - (getY2() - line2.getY()) * (line2.getX2() - line2.getX());

            return (d1 * d2 < 0) && (d3 * d4 < 0);
        } else {
            double[] b1 = this.getBoundingBox();
            double[] b2 = other.getBoundingBox();
            return (b1[0] < b2[0] + b2[2] &&
                    b2[0] < b1[0] + b1[2] &&
                    b1[1] < b2[1] + b2[3] &&
                    b2[1] < b1[1] + b1[3]);
        }
    }

<<<<<<< HEAD
    /**
     * Returns a textual description of the line.
     *
     * @return formatted description string
     */
    public String describe() {
        return String.format("Line %s: (%.2f,%.2f) -> (%.2f,%.2f)", name, x, y, x2, y2);
    }

    /**
     * Returns the minimum x-coordinate of the line.
     *
     * @return min x-coordinate
     */
=======
        @Override
        public String describe() {
            return String.format("Line %s: (%.2f,%.2f) -> (%.2f,%.2f)", name, getX(), getY(), getX2(), getY2());
        }
        
    @Override
>>>>>>> 811ac88c650e8e5ef141c07a634f810b30771d36
    public double getX() {
        return Math.min(x, getX2());
    }
<<<<<<< HEAD

    /**
     * Returns the minimum y-coordinate of the line.
     *
     * @return min y-coordinate
     */
=======
    @Override
>>>>>>> 811ac88c650e8e5ef141c07a634f810b30771d36
    public double getY() {
        return Math.min(y, getY2());
    }
<<<<<<< HEAD

    /** @return x-coordinate of the first endpoint */
    public double getX1() { return x; }
    /** @return y-coordinate of the first endpoint */
    public double getY1() { return y; }
    /** @return x-coordinate of the second endpoint */
=======
    
    public double getX1() { return getX(); }
    public double getY1() { return getY(); }
>>>>>>> 811ac88c650e8e5ef141c07a634f810b30771d36
    public double getX2() { return x2; }
    /** @return y-coordinate of the second endpoint */
    public double getY2() { return y2; }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setX2(double x2) {
        this.x2 = x2;
    }

    public void setY2(double y2) {
        this.y2 = y2;
    }
}
