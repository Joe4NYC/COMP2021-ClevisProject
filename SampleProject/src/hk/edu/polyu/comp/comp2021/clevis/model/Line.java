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
        this.x = x;
        this.y = y;
        this.x2 = x2;
        this.y2 = y2;
    }

    /**
     * Moves the line by the given delta values.
     *
     * @param dx amount to move along the x-axis
     * @param dy amount to move along the y-axis
     */
    public void move(double dx, double dy){
        x += dx;
        y += dy;
        x2 += dx;
        y2 += dy;
    }

    /**
     * Returns the bounding box of the line segment.
     *
     * @return an array [minX, minY, maxX, maxY]
     */
    public double[] getBoundingBox(){
        double minX = Math.min(x, x2);
        double minY = Math.min(y, y2);
        double width = Math.abs(x2 - x);
        double height = Math.abs(y2 -y);
        return new double[]{minX, minY, width, height};
    }

    /**
     * Checks whether the line covers the given point.
     *
     * @param px x-coordinate of the point
     * @param py y-coordinate of the point
     * @return true if the point lies on the line segment, false otherwise
     */
    public boolean coverPoint(double px, double py){
        double dx = x2 - x;
        double dy = y2 -y;
        double length = Math.sqrt(dx*dx + dy*dy);

        double distance = Math.abs((px -x) * dy - (py - y) * dx) / length;
        double dot = (px - x) * dx + (py - y) * dy;

        if(dot < 0){
            return false;
        }
        if(dot > dx * dx + dy * dy){
            return false;
        }

        return true;
    }

    /**
     * Checks whether this line intersects with another shape.
     *
     * @param other the other shape
     * @return true if the line intersects with the other shape
     */
    public boolean intersect(Shape other) {
        if (other instanceof Line) {
            Line line2 = (Line) other;

            double d1 = (line2.x - x) * (y2 - y) - (line2.y - y) * (x2 - x);
            double d2 = (line2.x2 - x) * (y2 - y) - (line2.y2 - y) * (x2 - x);
            double d3 = (x - line2.x) * (line2.y2 - line2.y) - (y - line2.y) * (line2.x2 - line2.x);
            double d4 = (x2 - line2.x) * (line2.y2 - line2.y) - (y2 - line2.y) * (line2.x2 - line2.x);

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
    public double getX() {
        return Math.min(x, x2);
    }

    /**
     * Returns the minimum y-coordinate of the line.
     *
     * @return min y-coordinate
     */
    public double getY() {
        return Math.min(y, y2);
    }

    /** @return x-coordinate of the first endpoint */
    public double getX1() { return x; }
    /** @return y-coordinate of the first endpoint */
    public double getY1() { return y; }
    /** @return x-coordinate of the second endpoint */
    public double getX2() { return x2; }
    /** @return y-coordinate of the second endpoint */
    public double getY2() { return y2; }
}
