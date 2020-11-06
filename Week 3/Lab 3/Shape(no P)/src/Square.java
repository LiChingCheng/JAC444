
public class Square implements Shape {

    private double side;

    public Square(double side){
        if(side > 0) {
            this.side = side;
        }
        else {
            throw new IllegalArgumentException("Invalid side!");
        }
    }

    public void setSide(double length){
        if (side > 0) {
            this.side = side;
        }
        else {
            throw new IllegalArgumentException("Invalid side!");
        }
    }

    public double getSide() {
        return side;
    }

    public double getPerimeter() {
        return 4.0D * (getSide());
    }

    public String toString() { return String.format("Square {s=" + getSide() + "} perimeter = " + getPerimeter()); }
}
