public class Extraction {
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
