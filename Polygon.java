public class Polygon extends Shape {
    double sum1;
    double sum2;

    @Override
    double getSize(String[] input) {//신발끈공식
        int[] arrX = new int[input.length + 1];
        int[] arrY = new int[input.length + 1];
        for (int i = 0; i < input.length; i++) {
            arrX[i] = new Extraction().getX(input[i]);
            arrY[i] = new Extraction().getY(input[i]);
        }
        arrX[input.length] = arrX[0];
        arrY[input.length] = arrY[0];
        for (int i = 0; i < input.length; i++) {
            sum1 += (arrX[i] * arrY[i + 1]);
            sum2 += (arrX[i + 1] * arrY[i]);
        }
        return Math.abs((sum1 - sum2) / 2);
    }
}