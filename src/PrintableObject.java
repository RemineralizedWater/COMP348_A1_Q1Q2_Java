abstract class PrintableObject implements NamedObject, Printable {
    // Overriding toString() method of String class
    @Override
    public String toString() {
        return getName();
    }

    public void print() {
        System.out.println(toString());
    }
}
