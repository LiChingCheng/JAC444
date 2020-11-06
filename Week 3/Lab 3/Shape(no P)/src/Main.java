import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;

public class Main {

    public static Shape[] addArray(Shape[] sourceArray) {
        Shape[] targetArray = new Shape[sourceArray.length + 1];
        System.arraycopy(sourceArray, 0, targetArray, 0, sourceArray.length);
        sourceArray = targetArray;
        return sourceArray;
    }

    public static Shape[] checkValid(String[] tokens, Shape[] sourceArray) {

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
            // Triangle check = new Triangle(Double.parseDouble(tokens[1]), Double.parseDouble(tokens[2]), Double.parseDouble(tokens[3]));
            sourceArray = addArray(sourceArray);
            sourceArray[sourceArray.length - 1] = new Triangle(Double.parseDouble(tokens[1]), Double.parseDouble(tokens[2]), Double.parseDouble(tokens[3]));
        }

        return sourceArray;


    /*    Shape[] targetArray = new Shape[sourceArray.length + 1];
        if (tokens[0].equals("Circle") && tokens.length == 2) {
            if (Double.parseDouble(tokens[1]) > 0) {
                System.arraycopy(sourceArray, 0, targetArray, 0, sourceArray.length);
                targetArray[sourceArray.length] = new Circle(Double.parseDouble(tokens[1]));
                sourceArray = targetArray;
            } else {
                throw new IllegalArgumentException("Invalid radius!");
                //System.out.println("Invalid radius!");
            }
        } else if (tokens[0].equals("Square") && tokens.length == 2) {
            if (Double.parseDouble(tokens[1]) > 0) {
                System.arraycopy(sourceArray, 0, targetArray, 0, sourceArray.length);
                targetArray[sourceArray.length] = new Square(Double.parseDouble(tokens[1]));
                sourceArray = targetArray;
            } else {
                throw new IllegalArgumentException("Invalid side!");
                //System.out.println("Invalid side!");
            }
        } else if (tokens[0].equals("Rectangle") && tokens.length == 3) {
            if (Double.parseDouble(tokens[1]) > 0 && Double.parseDouble(tokens[2]) > 0) {
                System.arraycopy(sourceArray, 0, targetArray, 0, sourceArray.length);
                targetArray[sourceArray.length] = new Rectangle(Double.parseDouble(tokens[1]), Double.parseDouble(tokens[2]));
                sourceArray = targetArray;
            } else {
                throw new IllegalArgumentException("Invalid side(s)!");
                //System.out.println("Invalid side(s)!");
            }
        } else if (tokens[0].equals("Parallelogram") && tokens.length == 3) {
            if (Double.parseDouble(tokens[1]) > 0 && Double.parseDouble(tokens[2]) > 0) {
                System.arraycopy(sourceArray, 0, targetArray, 0, sourceArray.length);
                targetArray[sourceArray.length] = new Parallelogram(Double.parseDouble(tokens[1]), Double.parseDouble(tokens[2]));
                sourceArray = targetArray;
            } else {
                throw new IllegalArgumentException("Invalid side(s)!");
                //System.out.println("Invalid side(s)!");
            }
        } else if (tokens[0].equals("Triangle") && tokens.length == 4) {
            Triangle check = new Triangle(Double.parseDouble(tokens[1]), Double.parseDouble(tokens[2]), Double.parseDouble(tokens[3]));
            if (check.valid(Double.parseDouble(tokens[1]), Double.parseDouble(tokens[2]), Double.parseDouble(tokens[3]))) {
                System.arraycopy(sourceArray, 0, targetArray, 0, sourceArray.length);
                targetArray[sourceArray.length] = check;
                sourceArray = targetArray;
            } else {
                throw new IllegalArgumentException("Invalid side(s)!");
                //System.out.println("Invalid side(s)!");
            }
        }
        return sourceArray;

     */
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
                }
                    catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
            }

            System.out.println("\n" + shape.length + " shapes were created:");
            for (Shape i : shape) {
                System.out.println(i.toString()+"\n");
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
