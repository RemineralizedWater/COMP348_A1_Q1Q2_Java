import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.lang.Double;

public class Main {
    public static void main(String[] args) {
        List<Shape> shapeArrayList = new java.util.ArrayList<>(List.of());

        try {
            File file = new File("src/inputShapes.txt");
            Scanner scanner = new Scanner(file);

            System.out.println("\nUnsorted CSV File of Shapes (with dimensions):");
            while (scanner.hasNextLine()) {
                String shape = scanner.nextLine();

                Rectangle rect = Rectangle.parse(shape);
                Circle circle = Circle.parse(shape);

                if (rect != null) {
                    System.out.println(shape);
                    shapeArrayList.add(rect);
                }
                else if (circle != null) {
                    System.out.println(shape);
                    shapeArrayList.add(circle);
                }
                else {
                    System.out.println("Unknown shape or format.");
                    System.exit(-1);
                }
            }

            scanner.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("FileNotFoundException");
            System.exit(-1);
        }
        catch (ClassCastException e) {
            System.out.println("ClassCastException");
            System.exit(-1);
        }
        catch (Exception e) {
            System.out.println("Exception");
            System.exit(-1);
        }

        System.out.println("\nUnsorted Array List of Shapes (with dimensions):");
        for (Shape i: shapeArrayList) {
            System.out.println(i);
        }

        // See more efficient working design of Comparator below
        Collections.sort(shapeArrayList, new Comparator<Shape>() {
            @Override
            public int compare(Shape a, Shape b) {
                int compareArea = Double.compare(a.getArea(), b.getArea());
                int compareName = a.getName().compareTo(b.getName());
                return (compareName == 0) ? compareArea : compareName;
            }
        });

        // Same functionality as above (replaced Collections.sort with list.sort, replaced Anonymous new with lambda,
        // replaced compareTo with Comparator.comparing, removed redundant casts, replaced lambda with method reference)
        /*shapeArrayList.sort(Comparator.comparing(Shape::getArea));
        shapeArrayList.sort(Comparator.comparing(Shape::getName));*/

        System.out.println("\nSorted Array List of Shapes (with area):");
        Printable.print(shapeArrayList.toArray(new PrintableObject[0]));
    }
}
