🎯 CS05 다각형 넓이
-

---
# 기본용어

### 클래스(class)

- 객체를 정의하는 틀 또는 설계도
- 자바에서는 클래스를 가지고 여러 객체를 생성하여 사용
- 클래스의 구성
  - 필드 : 객체의 상태를 나타내는 클래스에 포함된 변수
  - 메서드 : 객체의 행동으로 특정 작업을 수행하기 위한 명령문의 집합

### 객체(object)

- 실제로 존재하는 것. 사물 또는 개념
- 객체가 가지고 있는 기능과 속성에 따라 용도가 다름
- 객체 = 속성(변수) + 기능(메서드)

### 인스턴스(instance)

- 어떤 클래스로부터 만들어진 객체를 그 클래스의 인스턴스라고 한다.
- 클래스로부터 객체를 만드는 과정을 클래스의 '인스턴스화'라고 한다.
---
# 프로그래밍 구조

- 프로퍼티(property)
  - 필드(데이터 멤버)와 메소드 간 기능의 중간인 클래스 멤버의 특수한 유형
  - 게터(getter)와 세터(setter) 메소드 호출로 변환
- 메소드(method)
  - 객체간의 협력하는 구조를 설계하고 구현하기 위해서 반드시 필요한 객체의 행동
- 캡슐화(encapsulation)
  - 데이터(속성)과 기능(메서드)을 따로 정의하는 것이 아닌, 하나의 객체 안에 넣어서 묶는 것
- 상속(inheritance)
  - 부모 클래스의 특징을 자식 클래스가 물려받는 것
  - 기본 클래스(base class)의 특징을 파생 클래스(derived class)가 상속받는다.
- 다형성(polymorphism)
  - 하나의 부모 클래스를 상속받은 자식 클래스들이 "다양한 형태"를 가질 수 있는 것
  - 부모 클래스로부터 상속받지만, 다형성을 통해서 각자의 방식대로 동작할 수 있다.

---
# Mission 1. 직선 길이
### Extraction 클래스
```java
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
```
- 입력된 모든 좌표는 Extraction 클래스를 통해서 좌표값을 추출한다.
- Main 클래스에서 입력은 배열이며 각 개체는 소괄호와 반점이 포함되어있다.
- (a,b)와 같은 형태에서
  - x값은 2번째 캐릭터부터 반점 전까지이다.
  - y값은 반점직후부터 소괄호 직전까지이다.
  
### Distance 클래스
```java
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
```
- Extraction 클래스를 통해 입력받은 두 점의 좌표를 필드 x1,y1,x2,y2에 넣는다.
- 두 점 사이의 거리를 피타고라스 정리를 통해 리턴한다.

---
# Mission 2. 삼각형 넓이
### Triangle 클래스
```java
public class Triangle {
    double distance1;
    double distance2;
    double distance3;

    double getSize(String[] input) {//헤론의 공식
        distance1 = new Distance().getDistance(new String[]{input[0], input[1]});
        distance2 = new Distance().getDistance(new String[]{input[0], input[2]});
        distance3 = new Distance().getDistance(new String[]{input[1], input[2]});
        double s = (distance1 + distance2 + distance3) / 2;
        return Math.sqrt(s * (s - distance1) * (s - distance2) * (s - distance3));
    }
}
```
- 삼각형의 넓이는 밑변x높이 공식으로 구해도 무방하나 높이에 해당하는 점과 직선사이의 거리를 구하기는 번거롭다.
- 기존에 생성한 점 사이의 거리를 구하는 메소드를 통해 세 변의 길이를 알 수 있으므로 헤론의 공식을 사용한다.
- 헤론의 공식은 다음과 같다.
  - 여기서 a,b,c 는 세 변의 길이이다.
  - ![image](https://user-images.githubusercontent.com/118447769/212664500-3ef0e1d7-1860-43e1-ad4e-1ac48e226b5f.png)
  - ![image](https://user-images.githubusercontent.com/118447769/212664676-3f9caa30-79f0-4a28-ac98-09b0005d7f34.png)
---
# Mission 3. 사각형 넓이
### Rectangle 클래스
```java
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
```
- 문제에서 주어진 사각형의 조건은 직사각형 뿐이므로 가로x세로 공식을 통해 값을 구한다.
  - +삼각형의 넓이를 구한뒤 x2를 하는 방법이 있으나 가로x세로 를 통해 구하라는 조건이 있으므로 가로와 세로의 길이를 구한다.
- 입력받은 xy좌표로 이루어진 배열에서 한 점을 기준점으로 잡는다.
- getDistance 메서드를 통해 기준점과 나머지 세 점 사이의 거리를 각각 구한다.
- 가장 긴 변에 해당하는 좌표는 사각형을 기준으로 기준점과 대각선에 위치한 변이다.
- 나머지 두 변의 길이가 가로와 세로에 해당하므로 선언했던 width와 height에 넣어준다.
---
# Mission 4. 다각형 넓이
### Polygon 클래스
```java
public class Polygon {
    double sum1;
    double sum2;

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
```
- 다각형의 경우 찌그러진 경우는 고려하지 않았다.
- 신발끈 공식을 사용하여 값을 구하기 위해 입력하는 좌표들의 값은 도형을 그리는 순서에 준하게끔 조건을 제한했다.
  - 좌표가 랜덤으로 주어지더라도 정렬을 할 수 있는 방법은 있다.
  - ![image](https://user-images.githubusercontent.com/118447769/212666344-77decb44-d003-45e7-9e27-fe2ebd0d92ef.png)
  - 가장 하단에 위치하는 점을 기준점으로 잡고 나머지 점들과 이었을 때의 기울기를 구하여 순서를 배치해도된다.
  - 그러나 주어진 점이 기준점과 동일한 x좌표이거나 y좌표일 경우 기울기가 0에 수렴하거나 무한대로 발산하는 경우가 있으므로 까다로울 것 같아서 조건을 제한했다.
- 좌표의 배열은 도형을 그리는 순서와 동일하므로 신발끈 공식을 통해 넓이를 구한다.
---
# 추가 클래스
### Output 클래스
```java
public class Output {
    void terms() {
        System.out.println("---------------------------------------------------");
        System.out.println("1. 좌표는 소괄호를 통해 입력합니다.");
        System.out.println("2. 각 좌표를 '-'로 이어서 입력합니다. ex) (a,b)-(c,d)");
        System.out.println("3. 좌표의 개수는 2개 이상입니다.");
        System.out.println("4. 좌표가 3개 이상일 경우 도형을 그리는 순서대로 좌표를 입력하세요.");
        System.out.println("5. 좌표의 범위 0 <= x ,y <= 24");
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
        coordinate[1] = "24|                                                 ";// ' ' = 49
        coordinate[2] = "  |                                                 ";
        coordinate[3] = "22|                                                 ";
        coordinate[4] = "  |                                                 ";
        coordinate[5] = "20|                                                 ";
        coordinate[6] = "  |                                                 ";
        coordinate[7] = "18|                                                 ";
        coordinate[8] = "  |                                                 ";
        coordinate[9] = "16|                                                 ";
        coordinate[10] = "  |                                                 ";
        coordinate[11] = "14|                                                 ";
        coordinate[12] = "  |                                                 ";
        coordinate[13] = "12|                                                 ";
        coordinate[14] = "  |                                                 ";
        coordinate[15] = "10|                                                 ";
        coordinate[16] = "  |                                                 ";
        coordinate[17] = " 8|                                                 ";
        coordinate[18] = "  |                                                 ";
        coordinate[19] = " 6|                                                 ";
        coordinate[20] = "  |                                                 ";
        coordinate[21] = " 4|                                                 ";
        coordinate[22] = "  |                                                 ";
        coordinate[23] = " 2|                                                 ";
        coordinate[24] = "  |                                                 ";
        coordinate[25] = "  +―――――――――――――――――――――――――――――――――――――――――――――――――― Y";
        coordinate[26] = "  0   2   4   6   8   10  12  14  16  18  20  22  24";

        for (int i = 0; i < input.length; i++) {
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
}
```
- Output 클래스에는 출력과 관련한 메서드들이 포함되어 있다.
- 좌표 출력의 경우 각 줄을 coordinate라는 String 배열에 담았고 좌표들을 " "(스페이스)로 채웠다.
- 좌표 입력이 들어오면 좌표에 해당하는 coordinate 배열의 인덱스를 찾는다(y값)
- StringBuilder의 setCharAt을 통해(x값) " "(스페이스)를 점(·)으로 덮어씌워 좌표위에 해당하는 점이 출력될 수 있도록 하였다.
- 이외의 메서드들은 입력에 따라 Main 클래스에 적절히 배치했다.

### Main 클래스
```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Output output = new Output();
        output.terms();
        while (true) {
            System.out.print("> ");
            String[] input = br.readLine().split("-");
            if (input.length <= 1) {//입력된 좌표의 길이가 1개 이하일경우
                if(input[0].equals("close")){
                    System.out.println("---end---");
                    break;
                }
                else output.printFormError();
            } else if (input.length == 2) {
                output.printFrame(input);
                output.printDistance();
                System.out.printf("%,6f\n\n", new Distance().getDistance(input));
            } else if (input.length == 3) {
                output.printFrame(input);
                output.printTriangle();
                System.out.printf("%,6f\n\n", new Triangle().getSize(input));
            } else if (input.length == 4) {
                output.printFrame(input);
                output.printRectangle();
                System.out.printf("%,6f\n\n", new Rectangle().getSize(input));
            } else {//input.length >= 5 (다각형)
                output.printFrame(input);
                output.printPolygon();
                System.out.printf("%,6f\n\n", new Polygon().getSize(input));
            }
        }
    }
}
```
- Main 클래스는 입력과 출력을 받는 기능을 한다.
- 입력은 StringBuilder를 통해 '-'를 기준으로 나뉘는 String 배열로 받는다.
- 점의 개수가 1개 이하일 경우 에러 메세지를 출력하며 이외의 경우 해당하는 좌표와 넓이 등을 출력한다.