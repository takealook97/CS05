public class Output {
    void terms() {
        System.out.println("---------------------------------------------------");
        System.out.println("1. 좌표는 소괄호를 통해 입력합니다.");
        System.out.println("2. 각 좌표를 '-'로 이어서 입력합니다. ex) (a,b)-(c,d)");
        System.out.println("3. 좌표의 개수는 2개 이상입니다.");
        System.out.println("4. 좌표가 3개 이상일 경우 도형을 그리는 순서대로 좌표를 입력하세요.");
        System.out.println("---------------------------------------------------");
        System.out.println("좌표를 입력하세요.");
    }

    void printFrame(String[] input) {
        int[] arrX = new int[input.length];
        int[] arrY = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            arrX[i] = new Extraction().getX(input[i]);
            arrY[i] = new Extraction().getY(input[i]);
        }

        String[] coordinate = new String[27];
        coordinate[0] = "  X";
        coordinate[1] = "24|                                                ";//48
        coordinate[2] = "  |                                                ";
        coordinate[3] = "22|                                                ";
        coordinate[4] = "  |                                                ";
        coordinate[5] = "20|                                                ";
        coordinate[6] = "  |                                                ";
        coordinate[7] = "18|                                                ";
        coordinate[8] = "  |                                                ";
        coordinate[9] = "16|                                                ";
        coordinate[10] = "  |                                                ";
        coordinate[11] = "14|                                                ";
        coordinate[12] = "  |                                                ";
        coordinate[13] = "12|                                                ";
        coordinate[14] = "  |                                                ";
        coordinate[15] = "10|                                                ";
        coordinate[16] = "  |                                                ";
        coordinate[17] = " 8|                                                ";
        coordinate[18] = "  |                                                ";
        coordinate[19] = " 6|                                                ";
        coordinate[20] = "  |                                                ";
        coordinate[21] = " 4|                                                ";
        coordinate[22] = "  |                                                ";
        coordinate[23] = " 2|                                                ";
        coordinate[24] = "  |                                                ";
        coordinate[25] = "  +―――――――――――――――――――――――――――――――――――――――――――――――――― Y";
        coordinate[26] = "  0   2   4   6   8   10  12  14  16  18  20  22  24";

        for (int i = 0; i < input.length; i++) {
//            coordinate[25 - arrX[i]].charAt(3 + 2 * arrY[i]) = '·';
            StringBuilder sb = new StringBuilder(coordinate[25 - arrY[i]]);
            sb.setCharAt(3 + 2 * arrX[i], '·');
            coordinate[25 - arrY[i]] = sb.toString();
        }
        for(int i = 0; i < 27; i++){
            System.out.println(coordinate[i]);
        }
        System.out.println();
    }

    void printDistance() {
        System.out.print("∴ 두 점 사이의 거리는 ");
    }

    void printTriangle() {
        System.out.print("∴ 삼각형의 넓이는 ");
    }

    void printRectangle() {
        System.out.print("∴ 사각형의 넓이는 ");
    }

    void printPolygon() {
        System.out.print("∴ 다각형의 넓이는 ");
    }

    void printFormError() {
        System.out.println("※ 잘못된 형식입니다. 다시 입력하세요.");
    }
//    void printNumberError(){
//        System.out.println("점의 개수가 적습니다. 다시 입력하세요.");
//    }
//    void printOutOfRange(){
//        System.out.println("범위 밖의 좌표입니다. 다시 입력하세요.");
//    }
}
