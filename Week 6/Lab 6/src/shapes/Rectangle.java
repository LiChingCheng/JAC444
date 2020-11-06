package shapes;

public class Rectangle extends Parallelogram {

    public Rectangle(double length, double width) throws ParallelogramException{
        super(length, width);
    }

    //Lab 6
    ShapeFunctionalInterface rectangleAreaObj = () -> {
        return getWidth() * getWidth() ;
    };

    public String toString() {
        return String.format("Rectangle {w=" + super.getWidth() + ", h=" + super.getWidth() + "} perimeter = ") + String.format("%g", getPerimeter()) + " Area = " + String.format("%g", rectangleAreaObj.getArea());
    }
}
