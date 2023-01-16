import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Output output = new Output();
        output.terms();
        while (true) {
            System.out.print("> ");
            String[] input = br.readLine().split("-");
            if (input.length <= 1) {//입력된 좌표의 길이가 1개 이하일경우
                output.printFormError();
            } else if (input.length == 2) {
                output.printDistance();
                System.out.printf("%,6f",new Distance().getDistance(input));
                System.out.println();
            }
        }
    }
}
