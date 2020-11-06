package shapes;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;

public class Main {
    //add array length and copy its content
    public static Shape[] addArray(Shape[] sourceArray) {
        Shape[] targetArray = new Shape[sourceArray.length + 1];
        System.arraycopy(sourceArray, 0, targetArray, 0, sourceArray.length);
        sourceArray = targetArray;
        return sourceArray;
    }
    //check if data is correct
    public static Shape[] checkValid(String[] tokens, Shape[] sourceArray) throws CircleException, SquareException, ParallelogramException, TriangleException{
            if (tokens[0].equals("Circle") && tokens.length == 2) {
                sourceArray = addArray(sourceArray);
                sourceArray[sourceArray.length - 1] = new Circle(Double.parseDouble(tokens[1]));
            } else if (tokens[0].equals("Square") && tokens.length == 2) {
                sourceArray = addArray(sourceArray);
                sourceArray[sourceArray.length - 1] = new Square(Double.parseDouble(tokens[1]));
            } else if (tokens[0].equals("Rectangle") && tokens.length == 3) {
                sourceArray = addArray(sourceArray);
                sourceArray[sourceArray.length - 1] = new Rectangle(Double.parseDouble(tokens[1]), Double.parseDouble(tokens[2]));
            } else if (tokens[0].equals("Parallelogram") && tokens.length == 3) {
                sourceArray = addArray(sourceArray);
                sourceArray[sourceArray.length - 1] = new Parallelogram(Double.parseDouble(tokens[1]), Double.parseDouble(tokens[2]));
            } else if (tokens[0].equals("Triangle") && tokens.length == 4) {
                sourceArray = addArray(sourceArray);
                sourceArray[sourceArray.length - 1] = new Triangle(Double.parseDouble(tokens[1]), Double.parseDouble(tokens[2]), Double.parseDouble(tokens[3]));
            }
        return sourceArray;
    }
    //delete the min Triangle and max Circle
    public static Shape[] deleteShape(Shape[] shape) {
        double minT = 0;
        double maxC = 0;
        for (Shape i : shape) {
            if (i.getClass().getSimpleName().equals("Triangle")) {  //get min
                if (i.getPerimeter() < minT || minT == 0) {
                    minT = i.getPerimeter();
                }
            }
            if (i.getClass().getSimpleName().equals("Circle")) {    //get max
                if (i.getPerimeter() > maxC) {
                    maxC = i.getPerimeter();
                }
            }
        }
        for (int i = 0; i < shape.length; i++) {
            if (shape[i] != null) {
                if (shape[i].getClass().getSimpleName().equals("Triangle")) {  //delete min
                    if (shape[i].getPerimeter() == minT) {
                        shape[i] = null;
                    }
                }
                if (shape[i] != null) {
                    if (shape[i].getClass().getSimpleName().equals("Circle")) {    //delete max
                        if (shape[i].getPerimeter() == maxC) {
                            shape[i] = null;
                        }
                    }
                }
            }
        }
        return shape;
    }

    public static void calculateTotal(Shape[] shape) {
        double totalP = 0;
        double totalT = 0;
        for (Shape i : shape) {
            if (i != null) {
                if (i.getClass().getSimpleName().equals("Parallelogram")) {
                    totalP += i.getPerimeter();
                }
                if (i.getClass().getSimpleName().equals("Triangle")) {
                    totalT += i.getPerimeter();
                }
            }
        }
        System.out.println("Total perimeter of Parallelogram is: " + totalP);  //116.1999999999999
        System.out.println("Total perimeter of Triangle is: " + totalT);  //86.4
    }


    public static void main(String[] args) {
        Shape[] shape = new Shape[0];
        String s;
        System.out.println("------->JAC 444 Assignment 1<-------");
        System.out.println("------->Task 1 ... <-------");
        try (BufferedReader br = new BufferedReader(new FileReader("shapes.txt"))) {
            while ((s = br.readLine()) != null) {
                try {
                    String[] tokens = s.split(",");
                    shape = checkValid(tokens, shape);
                } catch (CircleException | SquareException | ParallelogramException | TriangleException e) {
                    System.out.println(e.getMessage());
                }
            }
            System.out.println("\n" + shape.length + " shapes were created:");
            for (Shape i : shape) {
                System.out.println(i + "\n");
            }

            System.out.println("------->Task 2 ... <-------");
            shape = deleteShape(shape);
            for (Shape i : shape) {
                if (i != null) {
                    System.out.println(i + "\n");
                }
            }
            System.out.println("------->Task 3 ... <-------");
            calculateTotal(shape);

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
