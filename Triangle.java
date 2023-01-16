public class Triangle {
    double distance1;
    double distance2;
    double distance3;

    double getSize(String[] input) {
        distance1 = new Distance().getDistance(new String[]{input[0], input[1]});
        distance2 = new Distance().getDistance(new String[]{input[0], input[2]});
        distance3 = new Distance().getDistance(new String[]{input[1], input[2]});
        double s = (distance1 + distance2 + distance3) / 2;
        return Math.sqrt(s * (s - distance1) * (s - distance2) * (s - distance3));//헤론의공식
    }
}
