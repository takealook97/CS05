import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Output output = new Output();
        output.printTerms();
        while (true) {
            System.out.print("> ");
            String[] input = br.readLine().split("-");
            if (input.length <= 1) {//입력된 좌표의 길이가 1개 이하일경우
                if (input[0].equals("close")) {
                    System.out.println("---end---");
                    break;
                } else output.printFormError();
            } else if (input.length == 2) {
                output.printFrame(input);
                output.printDistance();
                System.out.printf("%,6f\n\n", new Distance().getDistance(input));
            } else if (input.length == 3) {
                output.printFrame(input);
                output.printTriangle();
                System.out.printf("%,6f\n\n", new Triangle().getSize(input));
            } else if (input.length == 4) {
                output.printFrame(input);
                output.printRectangle();
                System.out.printf("%,6f\n\n", new Rectangle().getSize(input));
            } else {//input.length >= 5 (다각형)
                output.printFrame(input);
                output.printPolygon();
                System.out.printf("%,6f\n\n", new Polygon().getSize(input));
            }
        }
    }
}