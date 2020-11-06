public class Triangle implements Shape {
    private double a;
    private double b;
    private double c;

    public Triangle(double a, double b, double c) {
        if(a > 0 && b > 0 && c > 0 && valid(a, b, c)) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
        else {
            throw new IllegalArgumentException("Invalid side(s)!");
        }
    }

    public void setA(double a) throws IllegalArgumentException{
        if(a > 0) {
            this.a = a;
        }
        else {
            throw new IllegalArgumentException("Invalid side(s)!");
        }
    }

    public double getA() {
        return a;
    }

    public void setB(double b) throws IllegalArgumentException{
        if(b > 0) {
            this.b = b;
        }
        else {
            throw new IllegalArgumentException("Invalid side(s)!");
        }
    }

    public double getB() {
        return b;
    }

    public void setC(double c) throws IllegalArgumentException{
        if(c > 0) {
            this.c = c;
        }
        else {
            throw new IllegalArgumentException("Invalid side(s)!");
        }
    }

    public double getC() {
        return c;
    }

    public boolean valid(double a, double b, double c) {
        boolean check = true;
        if (a < 0 || b < 0 || c < 0) {
            check = false;
        } else if (a > 0 && b > 0 && c > 0) {
            if (((a + b) < c) || ((a + c) < b) || ((b + c) < a)) {
                check = false;
            }
        }
        return check;
    }

    public double getPerimeter() {
        return getA() + getB() + getC();
    }

    public String toString() {
        return String.format("Triangle {s1=" + getA() + ", s2=" + getB() + ", s3=" + getC() + "} perimeter = " + getPerimeter());
    }
}