public class Rectangle {
    double triangle;

    double getSize(String[] input) {
        triangle = new Triangle().getSize(new String[]{input[0], input[1], input[2]});
        return 2 * triangle;
    }
}
