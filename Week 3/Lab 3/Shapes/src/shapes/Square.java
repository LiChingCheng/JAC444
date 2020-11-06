package shapes;

public class Square implements Shape {
    private double side;

    public Square(double side) throws SquareException{
        if(side > 0) {
            this.side = side;
        }
        else {
            throw new SquareException();
        }
    }

    public void setSide(double length) throws SquareException{
        if (side > 0) {
            this.side = side;
        }
        else {
            throw new SquareException();
        }
    }

    public double getSide() {
        return side;
    }

    public double getPerimeter() {
        return 4.0D * (getSide());
    }

    public String toString() {
        return String.format("Square {s=" + getSide() + "} perimeter = ") + String.format("%g", getPerimeter());
    }
}


