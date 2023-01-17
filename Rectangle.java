import java.util.Arrays;

public class Rectangle extends Shape{//직사각형만 허용
    double width;
    double height;

    @Override
    double getSize(String[] input) {
        Distance distance = new Distance();
        double[] length = new double[3];
        length[0] = distance.getDistance(new String[]{input[0], input[1]});
        length[1] = distance.getDistance(new String[]{input[0], input[2]});
        length[2] = distance.getDistance(new String[]{input[0], input[3]});
        Arrays.sort(length);
        width = length[0];
        height = length[1];
        return width * height;
    }
}
