π― CS05 λ€κ°ν λμ΄
-

---
# κΈ°λ³Έμ©μ΄

### ν΄λμ€(class)

- κ°μ²΄λ₯Ό μ μνλ ν λλ μ€κ³λ
- μλ°μμλ ν΄λμ€λ₯Ό κ°μ§κ³  μ¬λ¬ κ°μ²΄λ₯Ό μμ±νμ¬ μ¬μ©
- ν΄λμ€μ κ΅¬μ±
  - νλ : κ°μ²΄μ μνλ₯Ό λνλ΄λ ν΄λμ€μ ν¬ν¨λ λ³μ
  - λ©μλ : κ°μ²΄μ νλμΌλ‘ νΉμ  μμμ μννκΈ° μν λͺλ Ήλ¬Έμ μ§ν©

### κ°μ²΄(object)

- μ€μ λ‘ μ‘΄μ¬νλ κ². μ¬λ¬Ό λλ κ°λ
- κ°μ²΄κ° κ°μ§κ³  μλ κΈ°λ₯κ³Ό μμ±μ λ°λΌ μ©λκ° λ€λ¦
- κ°μ²΄ = μμ±(λ³μ) + κΈ°λ₯(λ©μλ)

### μΈμ€ν΄μ€(instance)

- μ΄λ€ ν΄λμ€λ‘λΆν° λ§λ€μ΄μ§ κ°μ²΄λ₯Ό κ·Έ ν΄λμ€μ μΈμ€ν΄μ€λΌκ³  νλ€.
- ν΄λμ€λ‘λΆν° κ°μ²΄λ₯Ό λ§λλ κ³Όμ μ ν΄λμ€μ 'μΈμ€ν΄μ€ν'λΌκ³  νλ€.
---
# νλ‘κ·Έλλ° κ΅¬μ‘°

- νλ‘νΌν°(property)
  - νλ(λ°μ΄ν° λ©€λ²)μ λ©μλ κ° κΈ°λ₯μ μ€κ°μΈ ν΄λμ€ λ©€λ²μ νΉμν μ ν
  - κ²ν°(getter)μ μΈν°(setter) λ©μλ νΈμΆλ‘ λ³ν
- λ©μλ(method)
  - κ°μ²΄κ°μ νλ ₯νλ κ΅¬μ‘°λ₯Ό μ€κ³νκ³  κ΅¬ννκΈ° μν΄μ λ°λμ νμν κ°μ²΄μ νλ
- μΊ‘μν(encapsulation)
  - λ°μ΄ν°(μμ±)κ³Ό κΈ°λ₯(λ©μλ)μ λ°λ‘ μ μνλ κ²μ΄ μλ, νλμ κ°μ²΄ μμ λ£μ΄μ λ¬Άλ κ²
- μμ(inheritance)
  - λΆλͺ¨ ν΄λμ€μ νΉμ§μ μμ ν΄λμ€κ° λ¬Όλ €λ°λ κ²
  - κΈ°λ³Έ ν΄λμ€(base class)μ νΉμ§μ νμ ν΄λμ€(derived class)κ° μμλ°λλ€.
- λ€νμ±(polymorphism)
  - νλμ λΆλͺ¨ ν΄λμ€λ₯Ό μμλ°μ μμ ν΄λμ€λ€μ΄ "λ€μν νν"λ₯Ό κ°μ§ μ μλ κ²
  - λΆλͺ¨ ν΄λμ€λ‘λΆν° μμλ°μ§λ§, λ€νμ±μ ν΅ν΄μ κ°μμ λ°©μλλ‘ λμν  μ μλ€.

---
# Mission 1. μ§μ  κΈΈμ΄
### Extraction ν΄λμ€
```java
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
```
- μλ ₯λ λͺ¨λ  μ’νλ Extraction ν΄λμ€λ₯Ό ν΅ν΄μ μ’νκ°μ μΆμΆνλ€.
- Main ν΄λμ€μμ μλ ₯μ λ°°μ΄μ΄λ©° κ° κ°μ²΄λ μκ΄νΈμ λ°μ μ΄ ν¬ν¨λμ΄μλ€.
- (a,b)μ κ°μ ννμμ
  - xκ°μ 2λ²μ§Έ μΊλ¦­ν°λΆν° λ°μ  μ κΉμ§μ΄λ€.
  - yκ°μ λ°μ μ§νλΆν° μκ΄νΈ μ§μ κΉμ§μ΄λ€.
  
### Distance ν΄λμ€
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
- Extraction ν΄λμ€λ₯Ό ν΅ν΄ μλ ₯λ°μ λ μ μ μ’νλ₯Ό νλ x1,y1,x2,y2μ λ£λλ€.
- λ μ  μ¬μ΄μ κ±°λ¦¬λ₯Ό νΌνκ³ λΌμ€ μ λ¦¬λ₯Ό ν΅ν΄ λ¦¬ν΄νλ€.

---
# Mission 2. μΌκ°ν λμ΄
### Triangle ν΄λμ€
```java
public class Triangle extends Shape {
  double distance1;
  double distance2;
  double distance3;

  @Override
  double getSize(String[] input) {//ν€λ‘ μ κ³΅μ
    Distance distance = new Distance();
    distance1 = distance.getDistance(new String[]{input[0], input[1]});
    distance2 = distance.getDistance(new String[]{input[0], input[2]});
    distance3 = distance.getDistance(new String[]{input[1], input[2]});
    double s = (distance1 + distance2 + distance3) / 2;
    return Math.sqrt(s * (s - distance1) * (s - distance2) * (s - distance3));
  }
}
```
- μΌκ°νμ λμ΄λ λ°λ³xλμ΄ κ³΅μμΌλ‘ κ΅¬ν΄λ λ¬΄λ°©νλ λμ΄μ ν΄λΉνλ μ κ³Ό μ§μ μ¬μ΄μ κ±°λ¦¬λ₯Ό κ΅¬νκΈ°λ λ²κ±°λ‘­λ€.
- κΈ°μ‘΄μ μμ±ν μ  μ¬μ΄μ κ±°λ¦¬λ₯Ό κ΅¬νλ λ©μλλ₯Ό ν΅ν΄ μΈ λ³μ κΈΈμ΄λ₯Ό μ μ μμΌλ―λ‘ ν€λ‘ μ κ³΅μμ μ¬μ©νλ€.
- ν€λ‘ μ κ³΅μμ λ€μκ³Ό κ°λ€.
  - μ¬κΈ°μ a,b,c λ μΈ λ³μ κΈΈμ΄μ΄λ€.
  - ![image](https://user-images.githubusercontent.com/118447769/212664500-3ef0e1d7-1860-43e1-ad4e-1ac48e226b5f.png)
  - ![image](https://user-images.githubusercontent.com/118447769/212664676-3f9caa30-79f0-4a28-ac98-09b0005d7f34.png)
---
# Mission 3. μ¬κ°ν λμ΄
### Rectangle ν΄λμ€
```java
import java.util.Arrays;

public class Rectangle extends Shape{//μ§μ¬κ°νλ§ νμ©
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
```
- λ¬Έμ μμ μ£Όμ΄μ§ μ¬κ°νμ μ‘°κ±΄μ μ§μ¬κ°ν λΏμ΄λ―λ‘ κ°λ‘xμΈλ‘ κ³΅μμ ν΅ν΄ κ°μ κ΅¬νλ€.
  - +μΌκ°νμ λμ΄λ₯Ό κ΅¬νλ€ x2λ₯Ό νλ λ°©λ²μ΄ μμΌλ κ°λ‘xμΈλ‘ λ₯Ό ν΅ν΄ κ΅¬νλΌλ μ‘°κ±΄μ΄ μμΌλ―λ‘ κ°λ‘μ μΈλ‘μ κΈΈμ΄λ₯Ό κ΅¬νλ€.
- μλ ₯λ°μ xyμ’νλ‘ μ΄λ£¨μ΄μ§ λ°°μ΄μμ ν μ μ κΈ°μ€μ μΌλ‘ μ‘λλ€.
- getDistance λ©μλλ₯Ό ν΅ν΄ κΈ°μ€μ κ³Ό λλ¨Έμ§ μΈ μ  μ¬μ΄μ κ±°λ¦¬λ₯Ό κ°κ° κ΅¬νλ€.
- κ°μ₯ κΈ΄ λ³μ ν΄λΉνλ μ’νλ μ¬κ°νμ κΈ°μ€μΌλ‘ κΈ°μ€μ κ³Ό λκ°μ μ μμΉν λ³μ΄λ€.
- λλ¨Έμ§ λ λ³μ κΈΈμ΄κ° κ°λ‘μ μΈλ‘μ ν΄λΉνλ―λ‘ μ μΈνλ widthμ heightμ λ£μ΄μ€λ€.
---
# Mission 4. λ€κ°ν λμ΄
### Polygon ν΄λμ€
```java
public class Polygon extends Shape {
  double sum1;
  double sum2;

  @Override
  double getSize(String[] input) {//μ λ°λκ³΅μ
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
- λ€κ°νμ κ²½μ° μ°κ·Έλ¬μ§ κ²½μ°λ κ³ λ €νμ§ μμλ€.
- μ λ°λ κ³΅μμ μ¬μ©νμ¬ κ°μ κ΅¬νκΈ° μν΄ μλ ₯νλ μ’νλ€μ κ°μ λνμ κ·Έλ¦¬λ μμμ μ€νκ²λ μ‘°κ±΄μ μ ννλ€.
  - μ’νκ° λλ€μΌλ‘ μ£Όμ΄μ§λλΌλ μ λ ¬μ ν  μ μλ λ°©λ²μ μλ€.
  - ![image](https://user-images.githubusercontent.com/118447769/212666344-77decb44-d003-45e7-9e27-fe2ebd0d92ef.png)
  - κ°μ₯ νλ¨μ μμΉνλ μ μ κΈ°μ€μ μΌλ‘ μ‘κ³  λλ¨Έμ§ μ λ€κ³Ό μ΄μμ λμ κΈ°μΈκΈ°λ₯Ό κ΅¬νμ¬ μμλ₯Ό λ°°μΉν΄λλλ€.
  - κ·Έλ¬λ μ£Όμ΄μ§ μ μ΄ κΈ°μ€μ κ³Ό λμΌν xμ’νμ΄κ±°λ yμ’νμΌ κ²½μ° κΈ°μΈκΈ°κ° 0μ μλ ΄νκ±°λ λ¬΄νλλ‘ λ°μ°νλ κ²½μ°κ° μμΌλ―λ‘ κΉλ€λ‘μΈ κ² κ°μμ μ‘°κ±΄μ μ ννλ€.
- μ’νμ λ°°μ΄μ λνμ κ·Έλ¦¬λ μμμ λμΌνλ―λ‘ μ λ°λ κ³΅μμ ν΅ν΄ λμ΄λ₯Ό κ΅¬νλ€.
---
# μΆκ° ν΄λμ€
### Output ν΄λμ€
```java
public class Output {
  void printTerms() {
    System.out.println("---------------------------------------------------");
    System.out.println("1. μ’νλ μκ΄νΈλ₯Ό ν΅ν΄ μλ ₯ν©λλ€.");
    System.out.println("2. κ° μ’νλ₯Ό '-'λ‘ μ΄μ΄μ μλ ₯ν©λλ€. ex) (a,b)-(c,d)");
    System.out.println("3. μ’νμ κ°μλ 2κ° μ΄μμλλ€.");
    System.out.println("4. μ’νκ° 3κ° μ΄μμΌ κ²½μ° λνμ κ·Έλ¦¬λ μμλλ‘ μ’νλ₯Ό μλ ₯νμΈμ.");
    System.out.println("5. μ’νμ λ²μ 0 <= x ,y <= 24");
    System.out.println("---------------------------------------------------");
    System.out.println("μ’νλ₯Ό μλ ₯νμΈμ.");
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
    coordinate[25] = "  +ββββββββββββββββββββββββββββββββββββββββββββββββββ Y";
    coordinate[26] = "  0   2   4   6   8   10  12  14  16  18  20  22  24";

    for (int i = 0; i < input.length; i++) {
      StringBuilder sb = new StringBuilder(coordinate[25 - arrY[i]]);
      sb.setCharAt(3 + 2 * arrX[i], 'Β·');
      coordinate[25 - arrY[i]] = sb.toString();
    }
    for(int i = 0; i < 27; i++){
      System.out.println(coordinate[i]);
    }
    System.out.println();
  }

  void printDistance() {
    System.out.print("β΄ λ μ  μ¬μ΄μ κ±°λ¦¬λ ");
  }

  void printTriangle() {
    System.out.print("β΄ μΌκ°νμ λμ΄λ ");
  }

  void printRectangle() {
    System.out.print("β΄ μ¬κ°νμ λμ΄λ ");
  }

  void printPolygon() {
    System.out.print("β΄ λ€κ°νμ λμ΄λ ");
  }

  void printFormError() {
    System.out.println("β» μλͺ»λ νμμλλ€. λ€μ μλ ₯νμΈμ.");
  }
}
```
- Output ν΄λμ€μλ μΆλ ₯κ³Ό κ΄λ ¨ν λ©μλλ€μ΄ ν¬ν¨λμ΄ μλ€.
- μ’ν μΆλ ₯μ κ²½μ° κ° μ€μ coordinateλΌλ String λ°°μ΄μ λ΄μκ³  μ’νλ€μ " "(μ€νμ΄μ€)λ‘ μ±μ λ€.
- μ’ν μλ ₯μ΄ λ€μ΄μ€λ©΄ μ’νμ ν΄λΉνλ coordinate λ°°μ΄μ μΈλ±μ€λ₯Ό μ°Ύλλ€(yκ°)
- StringBuilderμ setCharAtμ ν΅ν΄(xκ°) " "(μ€νμ΄μ€)λ₯Ό μ (Β·)μΌλ‘ λ?μ΄μμ μ’νμμ ν΄λΉνλ μ μ΄ μΆλ ₯λ  μ μλλ‘ νμλ€.
- μ΄μΈμ λ©μλλ€μ μλ ₯μ λ°λΌ Main ν΄λμ€μ μ μ ν λ°°μΉνλ€.

### Main ν΄λμ€

```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    Output output = new Output();
    output.printTerms();
    while (true) {
      System.out.print("> ");
      String[] input = br.readLine().split("-");
      if (input.length <= 1) {//μλ ₯λ μ’νμ κΈΈμ΄κ° 1κ° μ΄νμΌκ²½μ°
        if (input[0].equals("close")) {
          System.out.println("---end---");
          break;
        } else output.printFormError();
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
      } else {//input.length >= 5 (λ€κ°ν)
        output.printFrame(input);
        output.printPolygon();
        System.out.printf("%,6f\n\n", new Polygon().getSize(input));
      }
    }
  }
}
```
- Main ν΄λμ€λ μλ ₯κ³Ό μΆλ ₯μ λ°λ κΈ°λ₯μ νλ€.
- μλ ₯μ StringBuilderλ₯Ό ν΅ν΄ '-'λ₯Ό κΈ°μ€μΌλ‘ λλλ String λ°°μ΄λ‘ λ°λλ€.
- μ μ κ°μκ° 1κ° μ΄νμΌ κ²½μ° μλ¬ λ©μΈμ§λ₯Ό μΆλ ₯νλ©° μ΄μΈμ κ²½μ° ν΄λΉνλ μ’νμ λμ΄ λ±μ μΆλ ₯νλ€.
---
# μΆλ ₯μ΄λ―Έμ§
### μλ ₯
![image](https://user-images.githubusercontent.com/118447769/212670650-9008d4c2-18e8-4664-b546-19ad3c339845.png)

### μ§μ  κΈΈμ΄ μΆλ ₯
![image](https://user-images.githubusercontent.com/118447769/212670874-a88da5a8-a936-44c3-80ff-14f323f5a998.png)

### μΌκ°ν λμ΄ μΆλ ₯
![image](https://user-images.githubusercontent.com/118447769/212671092-8db229c0-0eea-467e-aced-1e8f77dc315a.png)

### μ¬κ°ν λμ΄ μΆλ ₯
![image](https://user-images.githubusercontent.com/118447769/212671266-ec65fd68-965c-4425-8948-344857768b90.png)

### λ€κ°ν λμ΄ μΆλ ₯
![image](https://user-images.githubusercontent.com/118447769/212672021-c10d2a81-c444-4df5-918c-7f37fa6462bb.png)

### μλ¬ μΆλ ₯
![image](https://user-images.githubusercontent.com/118447769/212672269-0d75bca6-0220-4921-ac45-8150f0112130.png)