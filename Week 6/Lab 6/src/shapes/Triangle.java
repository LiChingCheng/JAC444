package shapes;

public class Triangle implements Shape {
    private double a;
    private double b;
    private double c;

    public Triangle(double a, double b, double c) throws TriangleException{
        if(a > 0 && b > 0 && c > 0 && validCheck(a, b, c)) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
        else {
            throw new TriangleException();
        }
    }

    public void setA(double a) throws TriangleException{
        if(a > 0) {
            if(b != 0 && c != 0 && validCheck(a, b, c)) {
                this.a = a;
            }
            else if(b == 0 || c == 0) {
                this.a = a;
            }
            else {
                throw new TriangleException();
            }
        }
        else {
            throw new TriangleException();
        }
    }

    public double getA() {
        return a;
    }

    public void setB(double b) throws TriangleException{
        if(b > 0) {
            if(a != 0 && c != 0 && validCheck(a, b, c)) {
                this.b = b;
            }
            else if(a == 0 || c == 0) {
                this.b = b;
            }
            else {
                throw new TriangleException();
            }
        }
        else {
            throw new TriangleException();
        }
    }

    public double getB() {
        return b;
    }

    public void setC(double c) throws TriangleException{
        if(c > 0) {
            if(a != 0 && b != 0 && validCheck(a, b, c)) {
                this.c = c;
            }
            else if(a == 0 || b == 0) {
                this.c = c;
            }
            else {
                throw new TriangleException();
            }
        }
        else {
            throw new TriangleException();
        }
    }

    public double getC() {
        return c;
    }

    public boolean validCheck(double a, double b, double c) {
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
        return String.format("Triangle {s1=" + getA() + ", s2=" + getB() + ", s3=" + getC() + "} perimeter = ") + String.format("%g", getPerimeter());
    }
}