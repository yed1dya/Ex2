package exe.ex2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        double a1 = Ex2.area(Ex2Test.po9, Ex2Test.po8, Ex2.sameValue(Ex2Test.po9, Ex2Test.po8, -10, 0, Ex2.EPS), Ex2.sameValue(Ex2Test.po9, Ex2Test.po8, 0, 10, Ex2.EPS), 10000);
        System.out.println(Ex2.poly(Ex2Test.po9));
        System.out.println(Ex2.poly(Ex2Test.po8));
        System.out.println(a1);
        System.out.println(a1<5);
    }

}