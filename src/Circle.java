import java.util.Arrays;
import java.util.List;
import java.text.DecimalFormat;
import java.util.Locale;

public class Circle extends PrintableObject implements Shape {
    private double radius;
    private final DecimalFormat format = new DecimalFormat();

    Circle () {
        format.setDecimalSeparatorAlwaysShown(false);
        setRadius(0.0);
    }

    Circle (double radius) {
        format.setDecimalSeparatorAlwaysShown(false);
        setRadius(radius);
    }

    public double getRadius() {
        return radius;
    }

    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public String getName() {
        return this.getClass().getSimpleName().toUpperCase();
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    // Overriding toString() method of String class
    @Override
    public String toString() {
        return super.toString() + "," + format.format(getRadius());
    }

    static Circle parse(String input) {
        try {
            List<String> result = Arrays.asList(input.split("\\s*,\\s*"));

            if (result.size() == 2 && result.get(0).toLowerCase(Locale.ENGLISH).equals("circle")) {
                double circRadius = Double.parseDouble(result.get(1));
                return new Circle(circRadius);
            }
        }
        catch (NullPointerException e) {
            System.out.println("NullPointerException");
            System.exit(-1);
        }
        catch (NumberFormatException e) {
            System.out.println("NumberFormatException");
            System.exit(-1);
        }

        return null;
    }
}
