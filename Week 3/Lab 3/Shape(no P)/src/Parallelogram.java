public class Parallelogram implements Shape {
    private double length;
    private double width;
    private static double to;

    public Parallelogram(double var1, double var3) throws IllegalArgumentException{
        if (var1 > 0 && var3 > 0) {
            this.width = var3;
            this.length = var1;
        }
        else {
            throw new IllegalArgumentException("Invalid side(s)!");
        }
    }

    public void setLength(double var1) throws IllegalArgumentException{
        if(var1 > 0) {
            length = var1;
        }
        else {
            throw new IllegalArgumentException("Invalid side(s)!");
        }
    }

    public double getLength() {
        return length;
    }

    public void setWidth(double var1) throws IllegalArgumentException{
        if(var1 > 0) {
            width = var1;
        }
        else {
            throw new IllegalArgumentException("Invalid side(s)!");
        }
    }

    public double getWidth() {
        return width;
    }

    public double getPerimeter() {
        return 2.0D * (getLength() + getWidth());
    }

    public String toString() {
        return String.format("Parallelogram {w=" + getWidth() + ", h=" + getLength() + "} perimeter = " + getPerimeter());
    }
}
