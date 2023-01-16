public class Distance {
    int x1;
    int y1;
    int x2;
    int y2;
    public double getDistance(String[] input) {
        Extraction extraction = new Extraction();
        x1 = extraction.getX(input[0]);
        y1 = extraction.getY(input[0]);
        x2 = extraction.getX(input[1]);
        y2 = extraction.getY(input[1]);
        return Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
    }
}
