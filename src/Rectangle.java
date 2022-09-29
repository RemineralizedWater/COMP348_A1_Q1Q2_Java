import java.util.Arrays;
import java.util.List;
import java.text.DecimalFormat;
import java.util.Locale;

public class Rectangle extends PrintableObject implements Shape {
    private double length;
    private double width;
    private final DecimalFormat format = new DecimalFormat();

    Rectangle () {
        format.setDecimalSeparatorAlwaysShown(false);
        setLength(0.0);
        setWidth(0.0);
    }

    Rectangle (double length, double width) {
        format.setDecimalSeparatorAlwaysShown(false);
        setLength(length);
        setWidth(width);
    }

    public double getLength() {
        return length;
    }

    public double getWidth() {
        return width;
    }

    @Override
    public double getPerimeter() {
        return 2 * length + 2 * width;
    }

    @Override
    public double getArea() {
        return length * width;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    // Overriding toString() method of String class
    @Override
    public String toString() {
        return super.toString() + "," + format.format(getLength()) + "," + format.format(getWidth());
    }

    static Rectangle parse(String input) {
        try {
            List<String> result = Arrays.asList(input.split("\\s*,\\s*"));

            if (result.size() == 3 && result.get(0).toLowerCase(Locale.ENGLISH).equals("rectangle")) {
                double rectLength = Double.parseDouble(result.get(1));
                double rectWidth = Double.parseDouble(result.get(2));
                return new Rectangle(rectLength, rectWidth);
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
