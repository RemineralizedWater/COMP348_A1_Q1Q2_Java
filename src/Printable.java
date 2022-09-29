interface Printable {
    void print();

    static void print(PrintableObject... args) {
        for (PrintableObject i : args) {
            i.print();
        }
    }
}
