
public class Rectangle extends Parallelogram {

    public Rectangle(double length, double width) throws IllegalArgumentException{
        super(length, width);
    }

    public String toString() {
        return String.format("Rectangle {w=" + super.getWidth() + ", h=" + super.getWidth() + "} perimeter = " + getPerimeter());
    }
}
