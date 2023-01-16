public class Output {
    void terms(){
        System.out.println("-------------------------------------------------");
        System.out.println("1. 좌표는 소괄호를 통해 입력합니다.");
        System.out.println("2. 각 좌표를 '-'로 이어서 입력합니다. ex) (a,b)-(c,d)");
        System.out.println("3. 좌표의 개수는 2개 이상입니다.");
        System.out.println("-------------------------------------------------");
        System.out.println("좌표를 입력하세요.");
    }
    void printFrame() {
        System.out.println("|");
        System.out.println("|");
        System.out.println("|");
        System.out.println("|");
        System.out.println("|");
        System.out.println("|");
        System.out.println("|");
        System.out.println("|");
        System.out.println("|");
        System.out.println("|");
        System.out.println("|");
        System.out.println("|");
        System.out.println("|");
        System.out.println("|");
        System.out.println("|");
        System.out.println("|");
        System.out.println("|");
        System.out.println("|");
        System.out.println("|");
        System.out.println("|____________________________________________________________");
    }
    void printDistance(){
        System.out.print("두 점 사이의 거리는 ");
    }
    void printTriangle(){
        System.out.print("삼각형의 넓이는 ");
    }
    void printRectangle(){
        System.out.print("사각형의 넓이는 ");
    }
    void printPolygon(){
        System.out.print("다각형의 넓이는 ");
    }
    void printFormError(){
        System.out.println("잘못된 형식입니다. 다시 입력하세요.");
    }
    void printNumberError(){
        System.out.println("점의 개수가 적습니다. 다시 입력하세요.");
    }
    void printOutOfRange(){
        System.out.println("범위 밖의 좌표입니다. 다시 입력하세요.");
    }
}
