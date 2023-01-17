public class Extraction {

    int getX(String input) {
        StringBuilder num = new StringBuilder();
        for (int i = 1; i < input.length(); i++) {
            if (input.charAt(i) == ',') break;
            else {
                num.append(input.charAt(i));
            }
        }
        return Integer.parseInt(num.toString());
    }

    int getY(String input) {
        int startPoint = 0;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == ',') {
                startPoint = i;
                break;
            }
        }
        StringBuilder num = new StringBuilder();
        for (int i = startPoint + 1; i < input.length(); i++) {
            if (input.charAt(i) == ')') break;
            else {
                num.append(input.charAt(i));
            }
        }
        return Integer.parseInt(num.toString());
    }
}
