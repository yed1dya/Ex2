package exe.ex2;
import static org.junit.jupiter.api.Assertions.*;

import java.awt.geom.Arc2D.Double;
import java.util.Arrays;

import org.junit.jupiter.api.Test;
/**
 * This JUnit class represents a very simple unit testing for Ex2.
 * This class should be improved and generalized significantly.
 * Make sure you add documentations to this Tesing class.
 * @author boaz.ben-moshe
 *
 */
/**
 * ID: 318845500
 * @author Shalom Ofstein
 * I left the old tests at the bottom of the page
 * and wrote new tests at the top.
 * each test is to check a specific function in the Ex2 class.
 * testing the seven polynomials:
 * p1= 8x^5-2x^4+x^2+5x
 * p2= -2x^5+x^3-x^2+3
 * p3= 5x^3-5x^2+3x-6
 * p4= 0
 * p5= -1
 * p6= -2x^2+3x-3
 * p7= 5x^2-6
 * the first two polynomials have the same degree but the varies.
 * p3 has a different degree.
 * p4 and p5 are to test unusual inputs into the different functions.
 * p6 and p7 were added to calculate the area function.
 * each test plays with the different inputs to see if the expected outcome happens.
 * each test tests exactly one and only one function to make sure the error is identified easily.
 * in some of the tests the function will print out an error message.
 * this is to be expected because the test will try to run functions with an invalid input.
 *
 */
class Ex2TestShalom {
    //the polynomials we will use for the tests:
    static double[] p1= {0,5,1,0,-2,8}, p2= {3,0,-1,1,0,-2}, p3= {-6,3,-5,5}, p4= {}, p5= {-1};
    static double[] p6= {-3,3,-2}, p7= {-6,0,5};

    /**
     * tests the first function in Ex2:
     * the equals function
     * we check that giving the function two equal arrays returns true
     * and that inputing unequal arrays returns false
     * different array sizes and different combinations of the arrays return different answers
     * and that is what this test confirms.
     */
    @Test
    void testEquals() {
        assertEquals(Ex2.equals(p1,p1),true);
        assertEquals(Ex2.equals(p4,p4),true);
        assertEquals(Ex2.equals(p1,p3),Ex2.equals(p2,p5));
        assertNotEquals(Ex2.equals(p1,p1),Ex2.equals(p1,p2));
        double[] ptest= {-6,3,-5,5} ;
        assertTrue(Ex2.equals(ptest,p3));
    }

    /**
     * tests the second function in Ex2:
     * the f function
     * here we input into the function different polynomials and different values for x
     * and then we compare the answers we pre-calculated to the output of the function.
     */
    @Test
    void testF() {
        double fx1 = Ex2.f(p1, 0);
        double fx2 = Ex2.f(p2, 1);
        double fx3 = Ex2.f(p3, 2);
        double fx4 = Ex2.f(p4, -3);
        double fx5 = Ex2.f(p5, -5);
        assertEquals(fx1,0);
        assertEquals(fx2,1);
        assertEquals(fx3,20);
        assertEquals(fx4,0);
        assertEquals(fx5,-1);
    }

    /**
     * tests the third function in Ex2:
     * the function String from Poly
     * the function takes a polynomial represented as an array of the coefficients
     *  and returns a string of the polynomial.
     *  here we know what the string should look like so we compare that to the output of the function
     *  again, we especially want to check that the function works for different inputs like p4 and p5
     */
    @Test
    void testStringFromPoly() {
        assertEquals("8.0x^5 -2.0x^4 +x^2 +5.0x",Ex2.poly(p1));
        assertEquals("-2.0x^5 +x^3 -x^2 +3.0",Ex2.poly(p2));
        assertEquals("5.0x^3 -5.0x^2 +3.0x -6.0",Ex2.poly(p3));
        assertEquals("",Ex2.poly(p4));
        assertEquals("-1.0",Ex2.poly(p5));
    }

    /**
     * tests the fourth function in Ex2:
     * the root_rec function.
     * this function calculates the root_rec of a polynomial between two given values for X
     * here we pre-calculated the expected x value of the polynomials,
     * and compared them to the output of the function.
     * please note that the polynomial p5 (-1) does NOT have a root_rec
     * and therefore we make sure that the test on p5 is expected to print an error
     * the test used for that is the AssertNotEquals test
     */
//    @Test
//    void testroot_rec() {
//        double t1 = Ex2.root_rec(p1, -5, 5, Ex2.EPS);
//        assertEquals(t1, 0, Ex2.EPS);
//        double t2 = Ex2.root_rec(p2, -5, 5, Ex2.EPS);
//        assertEquals(t2, 1.09232 , Ex2.EPS);
//        double t3 = Ex2.root_rec(p3, -5, 5, Ex2.EPS);
//        assertEquals(t3, 1.2709 , Ex2.EPS);
//        double t4 = Ex2.root_rec(p4, -5, 5, Ex2.EPS);
//        assertEquals(t4, 0 , Ex2.EPS);
//        double t5 = Ex2.root_rec(p5, -5, 5, Ex2.EPS);
//        assertNotEquals(t5, -1, Ex2.EPS);
//    }

    /**
     * tests the fifth function in Ex2:
     * the root_rec recursive function
     * similar to the fourth function and the fourth test
     * this function calculates the root_rec but this time using a recursive function
     * again, the fifth polynomial should print out an error message/ this is expected as explained before
     */
//    @Test
//    void testroot_recRec() {
//        double t1 = Ex2.root_rec(p1, -5, 5, Ex2.EPS);
//        assertEquals(t1, 0, Ex2.EPS);
//        double t2 = Ex2.root_rec(p2, -5, 5, Ex2.EPS);
//        assertEquals(t2, 1.09232 , Ex2.EPS);
//        double t3 = Ex2.root_rec(p3, -5, 5, Ex2.EPS);
//        assertEquals(t3, 1.2709 , Ex2.EPS);
//        double t4 = Ex2.root_rec(p4, -5, 5, Ex2.EPS);
//        assertEquals(t4, 0 , Ex2.EPS);
//        double t5 = Ex2.root_rec(p5, -5, 5, Ex2.EPS);
//        assertNotEquals(t5, -1 , Ex2.EPS);
//    }

    /**
     * tests the sixth function in Ex2:
     * the Same Value function
     * this function takes in two polynomials and finds their intersection between two values for x
     * here we take two functions and calculate the intersection within the precision of an epsilon (EPS)
     * because the function is not precise we shortened the numbers into a 4-7 digit decimal representation
     *
     */
    void testSameValue() {
        double t1 = Ex2.sameValue(p1,p2,-5, 10, Ex2.EPS);
        assertEquals(t1, 0.492471, Ex2.EPS);
        double t2 = Ex2.sameValue(p2,p3,-5, 10, Ex2.EPS);
        assertEquals(t2, 1.176 , Ex2.EPS);
        double t3 = Ex2.sameValue(p3,p4,-5, 10, Ex2.EPS);
        assertEquals(t3, 1.2709 , Ex2.EPS);
        double t4 = Ex2.sameValue(p1,p5,-5, 10, Ex2.EPS);
        assertEquals(t4, -0.20724 , Ex2.EPS);
        double t5 = Ex2.sameValue(p2,p5,-5, 10, Ex2.EPS);
        assertNotEquals(t5, 0.0 , Ex2.EPS);
    }

    /**
     * tests the seventh function in Ex2:
     * the Area function
     * this function calculates the area between two polynomials within a range of x
     * using integrals I calculated the intersections and the expected outcome
     * I used the first 20 digits of the decimal representation for my answer
     * and then I compare it to the output from the function.
     */
    @Test
    void testArea() {
        //the manual test was done by hand and given the first 20 digits of the answers:
        double x1= -0.4745464829280682139;
        double x2= 0.9031179114994967854;
        double calculatorArea = 3.0505425876610367843;
        int boxes= 100;
        double area = Ex2.area(p6, p7, x1, x2, boxes);
        assertTrue(calculatorArea-area<Ex2.EPS);
    }

    /**
     * tests the eighth function in Ex2:
     * the String to Poly function
     * this function takes a string of a polynomial and turns it into an array of the polynomials coefficients
     * i compare the results of the original array to the array created by the function/
     * please note: the fourth polynomial p4= {} is an empty array
     * i wanted to see that the function can take an empty string and return an empty array.
     * the function will print out an error and return an empty array
     */
    @Test
    void testStringToPoly() {
        assertArrayEquals( p1,Ex2.getPolynomFromString("8x^5-2x^4+x^2+5x") );
        double[] p1g= Ex2.getPolynomFromString("8x^5-2x^4+x^2+5x");
        assertEquals(p1[0], p1g[0],Ex2.EPS);
        assertEquals(p1[1], p1g[1],Ex2.EPS);
        assertEquals(p1.length, p1g.length);

        assertArrayEquals(p3,Ex2.getPolynomFromString("5x^3-5x^2+3x-6"));
        double[] p3g= Ex2.getPolynomFromString("5x^3-5x^2+3x-6");
        assertEquals(p3[0], p3g[0],Ex2.EPS);
        assertEquals(p3[1], p3g[1],Ex2.EPS);
        assertEquals(p3.length, p3g.length);

        assertArrayEquals(p4,Ex2.getPolynomFromString(""));
        double[] p4g= Ex2.getPolynomFromString("");
        assertEquals(p4.length, p4g.length);

        assertArrayEquals(p5,Ex2.getPolynomFromString("-1"));
        double[] p5g= Ex2.getPolynomFromString("-1");
        assertEquals(p5[0], p5g[0],Ex2.EPS);
        assertEquals(p5.length, p5g.length);


    }

    /**
     * tests the ninth function in Ex2:
     * the Add function
     * this function calculates the sum of two polynomials and returns an array of the sum
     * here I manually calculated the sum and compare it to the output of the function
     */
    @Test
    void testAdd() {
        double[] p12= {3,5,0,1,-2,6};
        assertArrayEquals(Ex2.add(p1, p2),p12);
        double[] p12a = Ex2.add(p1, p2);
        assertEquals(p12[0], p12a[0],Ex2.EPS);
        assertEquals(p12[1], p12a[1],Ex2.EPS);
        assertEquals(p12.length, p12a.length);

        double[] p34= {-6,3,-5,5};
        assertArrayEquals(Ex2.add(p3, p4),p34);
        double[] p34a = Ex2.add(p3, p4);
        assertEquals(p34[0], p34a[0],Ex2.EPS);
        assertEquals(p34[1], p34a[1],Ex2.EPS);
        assertEquals(p34.length, p34a.length);

        double[] p25= {2,0,-1,1,0,-2};
        assertArrayEquals(Ex2.add(p2, p5),p25);
        double[] p25a = Ex2.add(p2, p5);
        assertEquals(p25[0], p25a[0],Ex2.EPS);
        assertEquals(p25[1], p25a[1],Ex2.EPS);
        assertEquals(p25.length, p25a.length);

    }

    /**
     * tests the tenth function in Ex2:
     * the Mul (Multiply) function
     * this function calculates the multiplication of two polynomials and returns an array
     * containing the new polynomial of the multiplication
     * here I  also manually pre-calculated the answer and I compare it to the output of the function
     */
    @Test
    void testMul() {
        double[] p12= {0,15,3,-5,-2,25,-8,-12,8,4,-16};
        assertArrayEquals(Ex2.mul(p1, p2),p12);
        double[] p12m = Ex2.mul(p1, p2);
        assertEquals(p12[0], p12m[0],Ex2.EPS);
        assertEquals(p12[1], p12m[1],Ex2.EPS);
        assertEquals(p12.length, p12m.length);

        double[] p34= {};
        assertTrue(Ex2.equals(Ex2.mul(p3, p4),p34));
        double[] p34m = Ex2.mul(p3, p4);
        assertArrayEquals(p34, p34m);
        assertEquals(p34.length, p34m.length);
        double[] p25= {-3,0,1,-1,0,2};
        assertArrayEquals(Ex2.mul(p2, p5),p25);
        double[] p25m = Ex2.mul(p2, p5);
        assertEquals(p25[0], p25m[0],Ex2.EPS);
        assertEquals(p25[1], p25m[1],Ex2.EPS);
        assertEquals(p25.length, p25m.length);

    }

    /**
     * tests the eleventh function in Ex2:
     * the Derivative function
     * this function takes in a polynomial and returns the derivative of that polynomial
     * I pre-calculate the answers manually and compare it to the functions output
     * please note: in polynomials p4 and p5 there doesn't exist a derivative because they are not a function of x
     * I instructed the function to return an empty array and to print out an error message
     */
    @Test
    void testDerivative() {
        double[] d1= {5,2,0,-8,40};
        double[] deriv1= Ex2.derivative(p1);
        assertArrayEquals(Ex2.derivative(p1),d1);
        assertEquals(d1.length, deriv1.length);


        double[] d3= {3,-10,15};
        double[] deriv3= Ex2.derivative(p3);
        assertArrayEquals(Ex2.derivative(p3),d3);
        assertEquals(d3.length, deriv3.length);

        double[] d4= {};
        double[] deriv4= Ex2.derivative(p4);
        assertTrue(Ex2.equals(Ex2.derivative(p4),d4));
        assertEquals(d4.length, deriv4.length);

        double[] d5= {0};
        double[] deriv5= Ex2.derivative(p5);
        assertArrayEquals(Ex2.derivative(p5),d5);
        assertEquals(d5[0], deriv5[0]);
        assertEquals(d5.length, deriv5.length);
    }

    /**
     * tests the last function in Ex2:
     * the Polynom from Points function
     * this function takes in an array of three values for x and an array of three values for y
     * each index on these arrays represents a point (for example: x1[0],y1[0] is a point in p1)
     * i created for this test new polynomials with a degree of 2 because the assignment required
     * to take in only three points and create a 2 degree polynomial.
     * here too if the number of points entered is incorrect the function returns null
     * and prints out an error message
     */
    @Test
    void testPolynomFromPoints() {
        double[] p1= {-14,5,4};
        double[] x1= {1,2,-3};
        double[] y1= {-5,12,7};
        assertArrayEquals(Ex2.PolynomFromPoints(x1, y1),p1);

        double[] p2= {0,-2,6};
        double[] x2= {1,2,3};
        double[] y2= {4,20,48};
        double[] p3= Ex2.PolynomFromPoints(x2, y2);
        assertArrayEquals(p3,p2);

        double[] p4= {27,0,-3};
        double[] x4= {1,3};
        double[] y4= {24,15,0};
        double[] result4= Ex2.PolynomFromPoints(x4, y4);
        assertNotEquals(result4,p4);

        double[] p5= {27,0,-3};
        double[] x5= {1,2,3};
        double[] y5= {15,0};
        double[] result5= Ex2.PolynomFromPoints(x5, y5);
        assertNotEquals(result5,p5);

    }



    /**
     * tests that were here before:
     */

    static double[] po1={2,0,3,-1,0}, po2 = {0.1,0,1, 0.1,3};

    @Test
    void testStringPoly() {
        assertEquals(Ex2.poly(po1),"-x^3 +3.0x^2 +2.0");
    }

    @Test
    void testF1() {
        double fx0 = Ex2.f(po1, 0);
        double fx1 = Ex2.f(po1, 1);
        double fx2 = Ex2.f(po1, 2);
        assertEquals(fx0,2);
        assertEquals(fx1,4);
        assertEquals(fx2,6);
    }

    @Test
    void testroot_rec1() {
        double x12 = Ex2.root_rec(po1, 0, 10, Ex2.EPS);
        assertEquals(x12, 3.1958, Ex2.EPS);
    }

    @Test
    void testAdd1() {
        double[] p12 = Ex2.add(po1, po2);
        double[] minus1 = {-1};
        double[] pp2 = Ex2.mul(po2, minus1);
        double[] p1 = Ex2.add(p12, pp2);
        assertEquals(Ex2.poly(po1), Ex2.poly(p1));
    }

    @Test
    void testMulDoubleArrayDoubleArray() {
        double[] p12 = Ex2.add(po1, po2);
        double dd = Ex2.f(p12, 5);
        assertEquals(dd, 1864.6, Ex2.EPS);
    }

    @Test
    void testDerivativeArrayDoubleArray() {
        double[] p = {1,2,3}; // 3X^2+2x+1
        double[] dp1 = {2,6}; // 6x+2
        double[] dp2 = Ex2.derivative(p);
        assertEquals(dp1[0], dp2[0],Ex2.EPS);
        assertEquals(dp1[1], dp2[1],Ex2.EPS);
        assertEquals(dp1.length, dp2.length);
    }

    @Test
    public void testFromString() {
        double[] p = {-1.1,2.3,3.1}; // 3.1X^2.3x-1.1
        String sp = Ex2.poly(p);
        double[] p1 = Ex2.getPolynomFromString(sp);
        boolean isSame = Ex2.equals(p1, p);
        if(!isSame) {fail();}
        assertEquals(sp, Ex2.poly(p1));
    }
}