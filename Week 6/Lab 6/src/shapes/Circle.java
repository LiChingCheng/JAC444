package shapes;

public class Circle implements Shape {
    private double radius;
    private ShapeFunctionalInterface circleAreaObj = () -> getRadius() * getRadius() * Math.PI;

    public Circle(double radius) throws CircleException{
        if(radius > 0) {
            this.radius = radius;
        }
        else {
            throw new CircleException();
        }
    }

    public void setRadius(double radius) throws CircleException{
        if(radius > 0) {
            this.radius = radius;
        }
        else {
            throw new CircleException();
        }
    }

    public double getRadius() { return radius; }

    public double getPerimeter() { return 2 * getRadius() * Math.PI; }

    //Lab 6

    public String toString() { return String.format("Circle {r=" + getRadius() + "} perimeter = ") + String.format("%g", getPerimeter()) + " Area = " + String.format("%g", circleAreaObj.getArea()) ;}
}
