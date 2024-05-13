package exe.ex2;//ID- 207199282
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

/**
 *  * Introduction to Computer Science 2023, Ariel University,
 *  * Ex2: arrays, static functions and JUnit
 *
 * This JUnit class represents a JUnit (unit testing) for Ex2 -
 * It contains few testing functions for the polynum functions as define in Ex2.
 * Note: you should add additional JUnit testing functions to this class.
 *
 * @author boaz.ben-moshe
 */

class Ex2TestRoni {
    static final double[] P1 ={2,0,3, -1,0}, P2 = {0.1,0,1, 0.1,3};
    static double[] po1 = {2,2}, po2 = {-3, 0.61, 0.2};;
    static double[] po3 = {2,1,-0.7, -0.02,0.02};
    static double[] po4 = {-3, 0.61, 0.2};

    @Test
    /**
     * Tests that f(x) == poly(x).
     */
    void testF() {
        double fx0 = Ex2.f(po1, 0);
        double fx1 = Ex2.f(po1, 1);
        double fx2 = Ex2.f(po1, 2);
        assertEquals(fx0, 2, Ex2.EPS);
        assertEquals(fx1, 4, Ex2.EPS);
        assertEquals(fx2, 6, Ex2.EPS);
    }
    @Test
    /**
     * Tests that p1(x) + p2(x) == (p1+p2)(x)
     */
    void testF2() {
        double x = Math.PI;
        double[] po12 = Ex2.add(po1, po2);
        double f1x = Ex2.f(po1, x);
        double f2x = Ex2.f(po2, x);
        double f12x = Ex2.f(po12, x);
        assertEquals(f1x + f2x, f12x, Ex2.EPS);
    }
    @Test
    /**
     * Tests that p1+p2+ (-1*p2) == p1
     */
    void testAdd() {
        double[] p12 = Ex2.add(po1, po2);
        double[] minus1 = {-1};
        double[] pp2 = Ex2.mul(po2, minus1);
        double[] p1 = Ex2.add(p12, pp2);
//			System.out.println("test p1: "+Ex2.poly(p1));
//			System.out.println("test po1: "+Ex2.poly(po1));
        assertTrue(Ex2.equals(p1, po1));
    }
    @Test
    /**
     * Tests that p1+p2 == p2+p1
     */
    void testAdd2() {
        double[] p12 = Ex2.add(po1, po2);
        double[] p21 = Ex2.add(po2, po1);
        assertTrue(Ex2.equals(p12, p21));
    }
    @Test
    /**
     * Tests that p1+0 == p1
     */
    void testAdd3() {
        double[] p1 = Ex2.add(po1, Ex2.ZERO);
        assertTrue(Ex2.equals(p1, po1));
    }
    @Test
    /**
     * Tests that p1*0 == 0
     */
    void testMul1() {
        double[] p1 = Ex2.mul(po1, Ex2.ZERO);
        assertTrue(Ex2.equals(p1, Ex2.ZERO));
    }
    @Test
    /**
     * Tests that p1*p2 == p2*p1
     */
    void testMul2() {
        double[] p12 = Ex2.mul(po1, po2);
        double[] p21 = Ex2.mul(po2, po1);
        assertTrue(Ex2.equals(p12, p21));
    }
    @Test
    /**
     * Tests that p1(x) * p2(x) = (p1*p2)(x),
     */
    void testMulDoubleArrayDoubleArray() {
        double[] xx = {0,1,2,3,4.1,-15.2222};
        double[] p12 = Ex2.mul(po1, po2);
        for(int i = 0;i<xx.length;i=i+1) {
            double x = xx[i];
            double f1x = Ex2.f(po1, x);
            double f2x = Ex2.f(po2, x);
            double f12x = Ex2.f(p12, x);
            assertEquals(f12x, f1x*f2x, Ex2.EPS);
        }
    }
    @Test
    /**
     * Tests a simple derivative examples - till ZERO.
     */
    void testDerivativeArrayDoubleArray() {
        double[] p = {1,2,3}; // 3X^2+2x+1
        double[] pt = {2,6}; // 6x+2
        double[] dp1 = Ex2.derivative(p); // 2x + 6
        double[] dp2 = Ex2.derivative(dp1); // 2
        double[] dp3 = Ex2.derivative(dp2); // 0
        double[] dp4 = Ex2.derivative(dp3); // 0
        assertTrue(Ex2.equals(dp1, pt));
        assertTrue(Ex2.equals(Ex2.ZERO, dp3));
        assertTrue(Ex2.equals(dp4, dp3));
    }
    @Test
    /**
     * Tests the parsing of a polynom in a String like form.
     */
    public void testFromString() {
        double[] p = {-1.1,2.3,3.1}; // 3.1X^2+ 2.3x -1.1
        String sp2 = "3.1x^2+2.3x-1.1";
        String sp = Ex2.poly(p);
        double[] p1 = Ex2.getPolynomFromString(sp);
        double[] p2 = Ex2.getPolynomFromString(sp2);
        boolean isSame1 = Ex2.equals(p1, p);
        boolean isSame2 = Ex2.equals(p2, p);
        if(!isSame1) {fail();}
        if(!isSame2) {fail();}
        assertEquals(sp, Ex2.poly(p1));

    }
    @Test
    /**
     * Tests the equality of pairs of arrays.
     */
    public void testEquals() {
        double[][] d1 = {{0}, {1}, {1,2,0,0}};
        double[][] d2 = {Ex2.ZERO, {1+Ex2.EPS/2}, {1,2}};
        double[][] xx = {{-2*Ex2.EPS}, {1+Ex2.EPS*1.2}, {1,2,Ex2.EPS/2}};
        for(int i=0;i<d1.length;i=i+1) {
            if(!Ex2.equals(d1[i], d2[i])) {
            }
            assertTrue(Ex2.equals(d1[i], d2[i]));
        }
        for(int i=0;i<d1.length;i=i+1) {
            assertFalse(Ex2.equals(d1[i], xx[i]));
        }
    }

    @Test
    /**
     * Tests is the sameValue function is symmetric.
     */
    public void testSameValue2() {
        double x1=0, x2=4; //
        double rs1 = Ex2.sameValue(po1,po2, x1, x2, Ex2.EPS);
        double rs2 = Ex2.sameValue(po2,po1, x1, x2, Ex2.EPS);
        assertEquals(rs1,rs2,Ex2.EPS);
    }
    @Test
    /**
     * Test the area function - it should be symmetric.
     */
    public void testArea() {
        double x1=0, x2=4;
        double a1 = Ex2.area(po1, po2, x1, x2, 100);
        double a2 = Ex2.area(po2, po1, x1, x2, 100);
        assertEquals(a1,a2,Ex2.EPS);
    }
    /**The following tests were added to this file;
     * in order to examine each function written in this assignment in Ex2;
     */
    @Test
    /**
     * Tests that poly(getPolynomFromString(x)) == x;
     */
    public void testStringToPolyAndPolyToString(){
        String ePoly= "-36.7x^61 -6.0x^3 +x^2 -4.0x +8.0";
        double[] aPoly = Ex2.getPolynomFromString(ePoly);
        String sPoly= Ex2.poly(aPoly);
        assertEquals(sPoly,ePoly);
        String ePoly1= "";
        double[] aPoly1 = Ex2.getPolynomFromString(ePoly1);
        String sPoly1= Ex2.poly(aPoly1);
        assertEquals(sPoly1,ePoly1);
        String ePoly2= "-1.0";
        double[] aPoly2 = Ex2.getPolynomFromString(ePoly2);
        String sPoly2= Ex2.poly(aPoly2);
        assertEquals(sPoly2,ePoly2);
        String ePoly3= "x";
        double[] aPoly3 = Ex2.getPolynomFromString(ePoly3);
        String sPoly3= Ex2.poly(aPoly3);
        assertEquals(sPoly3,ePoly3);
        String ePoly4= "-x";
        double[] aPoly4 = Ex2.getPolynomFromString(ePoly4);
        String sPoly4= Ex2.poly(aPoly4);
        assertEquals(sPoly4,ePoly4);
    }
    @Test
    /**
     *test equals between roots of a polynom;
     */
    public  void testRoot_rec(){
        double[]p={-5.2,0,1};
        double x1 = Ex2.root_rec(p,-5 , 0 , Ex2.EPS);
        double x2 = Ex2.root_rec(p,0 , 5 , Ex2.EPS);
        assertEquals(-x1 , x2);
        double r1= -2.28;
        double r2= 2.28;
        assertTrue(x1-Ex2.EPS<=r1 && x2-Ex2.EPS<=r2);
        assertTrue(x1+Ex2.EPS<=r2 && x2+Ex2.EPS>=r1);
    }
    @Test
    /**
     * test get Polynom "d" From String "s"
     */
    public void testPolynomFromString2() {
        //In this test there is a long polynomial that contains many coefficients - zeros,
        //positive and negative values, natural and rational numbers;
        String s = "6.5x^7-x^6+x^4-2.0x^2-x";
        double[] d = {0.0,-1.0,-2.0,0.0,1.0,0.0,-1.0,6.5};
        assertEquals((Arrays.toString(d)),Arrays.toString(Ex2.getPolynomFromString(s)) );
    }
    @Test
    /**
     * test polynomFromPoints function;
     * test f function;
     * test for 3 points-A parabola is required;
     */
    public void testFrom3Points() {
        //The parabola in this example passes through (0,0);
        // we would like to put 0 in the x values of f(x) and get 0 in the y values.;
        double[] xx = {0, 0.128, 0.064};
        double[] yy = {0, 0, -0.032};
        double[] pxx = (Ex2.PolynomFromPoints(xx, yy));//ppx=7.8x^2-x
        double f = Ex2.f(pxx, 0);
        assertEquals(0, f,Ex2.EPS); //f(0)=0
    }
    @Test
    /**
     *test polynomFromPoints function;
     *from 2 points-A straight line is required;
     * test if same value of "y" affects the polynom;
     */
    public void testFrom2Points(){
        //The following points are all on the x-axis and therefore should express the same polynom;
        double[]xx1={0,-9};
        double[]yy1={0,0};
        double[]xx2={0,76.6};
        double[]yy2={0,0};
        double[] pxx1=Ex2.PolynomFromPoints(xx1,yy1);
        double[] pxx2=Ex2.PolynomFromPoints(xx2,yy2);
        assertArrayEquals(pxx1,pxx2,Ex2.EPS);
    }
    @Test
    /**
     * tests that if the "x" value of two or three points is same- it is not a polynom.
     * tests that the f(x) value of polynom at some point, is same value as the polynom get
     */
    public void testFromPoints2(){
        double[] x1= {2,2};
        double[] y1={3,4};
        double[] x2= {2,2,7};
        double[] y2={3,4,7};

        assertTrue(Ex2.equals(Ex2.PolynomFromPoints(x1, y1), Ex2Test.EMPTY));
        assertTrue(Ex2.equals(Ex2.PolynomFromPoints(x2,y2), Ex2Test.EMPTY));

        double[]p1=Ex2.PolynomFromPoints(po4,po4);
        assertEquals((Ex2.f(p1,-3)),-3,Ex2.EPS);
    }
    @Test
    /**
     *test that p1 !=p2
     *
     */
    public void testEquals2(){
        //p1 and p2 are Both consist of equal numbers. But The polynomial p2 has more zeros;
        double[]p1={4,3,2,1,0};
        double[]p2={0,0,4,3,2,1,0};
        assertFalse(Ex2.equals(p1, p2));
    }
    @Test
    /**Tests the equality of pairs of polynomials.
     *
     */
    public void testPoly1(){
        //test if zero in the first place make change in the String;
        //test if zero in the last place make change in the String;
        double[] pol2={0,0.01};
        double[] pol1={0,0,0.01};
        double[]pol3={0,0.01,0,0};
        String poly1=Ex2.poly(pol1);
        String poly2=Ex2.poly(pol2);
        String poly3=Ex2.poly(pol3);
        assertTrue(poly2!=poly1);
        assertTrue(poly2.equals(poly3));;
    }
    @Test
    /**Tests the equality of pairs of Strings.
     *
     */
    public void testPoly2(){
        //test if (-) change the String;
        double[]pol11={1,1,6.7};
        double[]pol22={1,-1,6.7};
        double[]pol33={1,1,6.7};
        double[] pol44 ={1,1,-6.7};
        String poly11=Ex2.poly(pol11);
        String poly22=Ex2.poly(pol22);
        String poly33=Ex2.poly(pol33);
        String poly44=Ex2.poly(pol44);
        assertTrue(!poly22.equals(poly11));;
        assertTrue(!poly33.equals(poly44));;
    }
    @Test
    /** This is a function written in order to delete the unnecessary zeros;
     * Tests that an array {0,0,0,0,1,0,0,0} will be presented without zeros;
     */
    public void testPolyWithoutZeros(){
        double[]po={0,0,0,0,1,0,0,0};
        double[]po0={0,0,0,0,1};
        assertEquals(Arrays.toString(polyWithoutZeros(po)),Arrays.toString(po0));
    }
    @Test
    /** Tests if polynom {0} is=0
     *
     */
    public void testPolyWithoutZeros2(){
        double[]po={0};
        assertEquals(polyWithoutZeros(po), (po));
    }
    @Test
    /**
     * Tests length between two points;
     */
    public void testLength1(){
        double[] po= {5};
        double x1=0;
        double x2=10;
        int numseg =3;
        assertEquals(Ex2.length(po,x1,x2,numseg),10);
    }
    @Test
    /**
     * Tests length with many segments;
     */
    public void testLength2(){
        double[] po = {0,1};
        double length= Ex2.length(po,0,1,100);
        assertEquals(length,Math.sqrt(2),Ex2.EPS);
    }
    @Test
    /**
     * Tests that symmetrical parts of a parabola are equal;
     * and that different parts of a parable aren't equals;
     */
    public void testLength3() {
        double[] p = {10, 0, 1};
        assertEquals(Ex2.length(p,-2,0,7),Ex2.length(p,0,2,7),Ex2.EPS);
        assertNotEquals(Ex2.length(p,0,1,55),Ex2.length(p,1,2,55),Ex2.EPS);
    }
    @Test
    /**
     * Tests derivative of polynom with one number;
     */
    public void testDerivative2(){
        double[]po={4};
        double[]zero= Ex2.ZERO;
        assertTrue(Ex2.equals(Ex2.derivative(po), zero));
    }
    @Test
    /**
     * Tests derivative of polynom "p" ;
     */
    public void testDerivative3(){
        double[]p={-5.2,0,1};//x^2-5.2
        double[]pd={0,2};
        double[]pd1=polyWithoutZeros(new double[]{0.0, 2.0, 0.0, 0.0, 0.0});
        assertArrayEquals(Ex2.derivative(p),pd);
        assertArrayEquals(Ex2.derivative(p),pd1);
    }
    @Test
    /**
     * Tests that "same value" function works on polynomials that have a very small range in which they are less than EPS apart ;
     */
    public void sameValue2() {
        double[]p1={-9000,9000};
        double[]p2={9000,-9000};
        assertEquals(1,Ex2.sameValue(p1,p2,-1,7,Ex2.EPS),Ex2.EPS);
    }
    @Test
    /** Tests 3 options:
     *check if the area is symetric between p1 and p2,  p2 and p1
     *check if area between the same polynom is 0
     *check when the range is 0 the area is 0
     */
    public void area2(){
        double[]p1= {2};
        double[]p2={0,1};
        double a= Ex2.area(p1,p2,0,2,2);
        assertEquals(a,2,Ex2.EPS);
        double a1= Ex2.area(p2,p1,0,2,2);
        assertEquals(a1,2,Ex2.EPS);
        assertEquals(a1,a,Ex2.EPS);
        double b= Ex2.area(p2,p2,1,5,3);
        assertEquals(b,0,Ex2.EPS);
        double c=Ex2.area(p1,p2,1,1,3);
        assertEquals(c,0,Ex2.EPS);
    }
    @Test
    /**
     * Tests if same polynoms and same range ,but different "number of trapezoids" gives a different area;
     *
     */
    public void area3(){
        double[] p1={0,0,1};
        double[] p2= {2,1,-0.7,-0.02,0.02};
        double a1=Ex2.area(p1,p2,0,2,15);
        double a2=Ex2.area(p1,p2,0,2,2);
        double[]p3={0,-1};
        double[]p4={0,1};
        double a3 =Ex2.area(p3,p4,0,5,10);
        assertEquals(25,a3,Ex2.EPS);
        assertNotEquals(a1,a2,Ex2.EPS);
    }

    public static double[] polyWithoutZeros (double[] po) {
        int lp = po.length;
        if (po.length == 1 && po[0] == 0) {
            return po;
        }
        double[] poly = new double[po.length];
        for(int i=0 ; i<lp; i++) {
            poly[i]=po[i];
        }
        while(po[lp-1]==0) {
            lp--;
        }
        po= new double[lp];
        for(int i=0 ; i<lp ; i++) {
            po[i]=poly[i];
        }
        return po;
    }
}

