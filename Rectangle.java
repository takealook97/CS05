import java.util.Arrays;

public class Rectangle {//직사각형만 허용
    double width;
    double height;

    double getSize(String[] input) {
        double[] length = new double[3];
        length[0] = new Distance().getDistance(new String[]{input[0], input[1]});
        length[1] = new Distance().getDistance(new String[]{input[0], input[2]});
        length[2] = new Distance().getDistance(new String[]{input[0], input[3]});
        Arrays.sort(length);
        width = length[0];
        height = length[1];
        return width * height;
    }
}
