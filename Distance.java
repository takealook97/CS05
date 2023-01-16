public class Distance {
    int x1;
    int y1;
    int x2;
    int y2;

    double getDistance(String[] input) {
        x1 = getX(input[0]);
        y1 = getY(input[0]);
        x2 = getX(input[1]);
        y2 = getY(input[1]);
        return Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
    }

    int getX(String input) {
        String num = "";
        for (int i = 1; i < input.length(); i++) {
            if (input.charAt(i) == ',') break;
            else {
                num += input.charAt(i);
            }
        }
        return Integer.parseInt(num);
    }

    int getY(String input) {
        int startPoint = 0;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == ',') {
                startPoint = i;
                break;
            }
        }
        String num = "";
        for (int i = startPoint + 1; i < input.length(); i++) {
            if (input.charAt(i) == ')') break;
            else {
                num += input.charAt(i);
            }
        }
        return Integer.parseInt(num);
    }
}
