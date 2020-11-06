import java.text.DecimalFormat;

public class Circle implements Shape {
    private double radius;

    public Circle(double radius){
        if(radius > 0) {
            this.radius = radius;
        }
        else {
            throw new IllegalArgumentException("Invalid radius!");
        }
    }

    public void setRadius(double radius){
        if(radius > 0) {
            this.radius = radius;
        }
        else {
            throw new IllegalArgumentException("Invalid radius!");
        }
    }

    public double getRadius() { return radius; }

    public double getPerimeter() { return 2 * radius * Math.PI; }

    public String toString() { return String.format("Circle {r=" + getRadius() + "} perimeter = " + getPerimeter()); }
}