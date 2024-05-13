// 207404997
package exe.ex2;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *  * Introduction to Computer Science 2023, Ariel University,
 *  * Ex2: arrays, static functions and JUnit
 * This JUnit class represents a JUnit (unit testing) for Ex2 -
 * It contains few testing functions for the polynum functions as define in Ex2.
 * Note: you should add additional JUnit testing functions to this class.
 *
 * @author boaz.ben-moshe
 */

class Ex2TestTemp {
    // arrays representing polynoms:
    static final double[] P1 ={2,0,3, -1,0}, P2 = {0.1,0,1, 0.1,3};
    static double[] po1 = {2,2}, po2 = {-3, 0.61, 0.2}, po3 = {2,1,-0.7, -0.02,0.02}, po4 = {-3, 0.61, 0.2};
    double[] po5 = {5}, po6 = {5, 0, 0}, po7 = {1, 0, 1};
    static double[] po8 = {2,1,-0.7,-0.02,0.02,0.1,23}, po9 = {6, 0.1, -0.2}; // blue
    double[] po10 = {2, 5}, po11 = {0, -5}, po12 = {0, 1}, po13 = {0, 0, 0}, po14 = {1+Ex2.EPS/2};
    double[] po15 = {1}, po16 = {2, 1, -0.7, -0.02, 0.0, 0.02, 0.1, 0, 23, -2.98765};
    static double[] po17 = {1, -1.4, -0.06, 0, 0.1, 0.6, 0, 184, -26.88885}, po18 = {-1}, po19 = {0,-1};
    double[]  po20 = {0,0,-1}, po21 = {-0.7, 0, 1}, po22 = {0, -1}, po23 = {0}, po24 = {0};
    double[] po25 = {-200, 200}, po26 = {200, -200}, po27 = {0, 1};
    double[] po28 = {3.0, -0.3999999999999999, -0.76, -0.02, 0.12000000000000001, 0.7, 23.0, 184.0, -26.88885};
    double[] po29 = {0, 0.5};

    // expected strings:
    String es1 = "2.0x +2.0", es2 = "0.2x^2 +0.61x -3.0", es3 = "0.02x^4 -0.02x^3 -0.7x^2 +x +2.0";
    String es4 = "0.2x^2 +0.61x -3.0", es5 = "5.0", es6 = "x^2", es7 = "x^2 +1.0";
    String es8 = "23.0x^6 +0.1x^5 +0.02x^4 -0.02x^3 -0.7x^2 +x +2.0", es9 = "-0.2x^2 +0.1x +6.0";
    String es10 = "5.0x +2.0", es11 = "-5.0x", es12 = "x", es13 = "0", es14 = "1.0005", es15 = "1.0";
    String es16 = "-2.98765x^9 +23.0x^8 +0.1x^6 +0.02x^5 -0.02x^3 -0.7x^2 +x +2.0";
    String es17 = "-26.88885x^8 +184.0x^7 +0.6x^5 +0.1x^4 -0.06x^2 -1.4x +1.0", es18 = "-1.0", es19 = "-x", es20 = "-x^2";
    String es21 = "x^2 -0.7", es22 = "-x", es23 = "0", es24 = "0", es25 = "12.73x^762", es27 = "x";

    // testing strings:
    String ts1 = "2x+2", ts2 = "0.2x^2+0.61x -3", ts3 = "0.02x^4 -0.02x^3 -0.7x^2 +x +2", ts4 = "0.2x^2+0.61x -3";
    String ts5 = "5", ts6 = "x^2", ts7 = "x^2 +1";
    String ts8 = "+23x^6 +0.1x^5 +0.02x^4 -0.02x^3 -0.7x^2 +1x^1 +2x^0", ts9 = "-0.2x^2 +0.1x+6";
    String ts10 = "5x +2", ts11 = "-5x", ts12 = "x", ts13 = "0", ts14 = "1.0005", ts15 = "1";
    String ts16 = "-2.98765x^9 +23x^8 +0.1x^6 +0.02x^5 -0.02x^3 -0.7x^2 +x +2";
    String ts17 = "-26.88885x^8+184x^7 +0.6x^5 +0.1x^4-0.06x^2 -1.4x +1", ts18 = "-1", ts19 = "-x", ts20 = "-x^2";
    String ts21 = "x^2 -0.7", ts22 = "-1x", ts23 = "-0x", ts24 = "+0x", ts25 = "12.73x^762 +0", ts27 = "1x";

    @Test
    /**
     * tests getPolynomFromString() with complex and potentially problematic strings:
     */
    public void testGetFromString(){
        assertTrue(Ex2.equals(Ex2.getPolynomFromString(ts8), po8));
        assertTrue(Ex2.equals(Ex2.getPolynomFromString(ts9), po9));
        assertTrue(Ex2.equals(Ex2.getPolynomFromString(ts10), po10));
        assertTrue(Ex2.equals(Ex2.getPolynomFromString(ts11), po11));
        assertTrue(Ex2.equals(Ex2.getPolynomFromString(ts12), po12));
        assertTrue(Ex2.equals(Ex2.getPolynomFromString(ts13), po13));
        assertTrue(Ex2.equals(Ex2.getPolynomFromString(ts14), po14));
        assertTrue(Ex2.equals(Ex2.getPolynomFromString(ts15), po15));
        assertTrue(Ex2.equals(Ex2.getPolynomFromString(ts17), po17));
        assertTrue(Ex2.equals(Ex2.getPolynomFromString(ts18), po18));
        assertTrue(Ex2.equals(Ex2.getPolynomFromString(ts19), po19));
        assertTrue(Ex2.equals(Ex2.getPolynomFromString(ts20), po20));
        assertTrue(Ex2.equals(Ex2.getPolynomFromString(ts21), po21));
        assertTrue(Ex2.equals(Ex2.getPolynomFromString(ts22), po22));
        assertTrue(Ex2.equals(Ex2.getPolynomFromString(ts23), po23));
        assertTrue(Ex2.equals(Ex2.getPolynomFromString(ts24), po24));
        assertTrue(Ex2.equals(Ex2.getPolynomFromString(ts27), po27));

    }

    @Test
    /**
     * test that getPolynomFromString(poly(p)) == p
     */
    public void testGetFromStringAndPoly(){
        assertTrue(Ex2.equals(Ex2.getPolynomFromString(Ex2.poly(po1)), po1));
        assertTrue(Ex2.equals(Ex2.getPolynomFromString(Ex2.poly(po2)), po2));
        assertTrue(Ex2.equals(Ex2.getPolynomFromString(Ex2.poly(po3)), po3));
        assertTrue(Ex2.equals(Ex2.getPolynomFromString(Ex2.poly(po4)), po4));
        assertTrue(Ex2.equals(Ex2.getPolynomFromString(Ex2.poly(po5)), po5));
        assertTrue(Ex2.equals(Ex2.getPolynomFromString(Ex2.poly(po6)), po6));
        assertTrue(Ex2.equals(Ex2.getPolynomFromString(Ex2.poly(po7)), po7));
        assertTrue(Ex2.equals(Ex2.getPolynomFromString(Ex2.poly(po8)), po8));
        assertTrue(Ex2.equals(Ex2.getPolynomFromString(Ex2.poly(po9)), po9));
        assertTrue(Ex2.equals(Ex2.getPolynomFromString(Ex2.poly(po10)), po10));
        assertTrue(Ex2.equals(Ex2.getPolynomFromString(Ex2.poly(po11)), po11));
        assertTrue(Ex2.equals(Ex2.getPolynomFromString(Ex2.poly(po12)), po12));
        assertTrue(Ex2.equals(Ex2.getPolynomFromString(Ex2.poly(po13)), po13));
        assertTrue(Ex2.equals(Ex2.getPolynomFromString(Ex2.poly(po14)), po14));
        assertTrue(Ex2.equals(Ex2.getPolynomFromString(Ex2.poly(po15)), po15));
        assertTrue(Ex2.equals(Ex2.getPolynomFromString(Ex2.poly(po16)), po16));
        assertTrue(Ex2.equals(Ex2.getPolynomFromString(Ex2.poly(po17)), po17));
        assertTrue(Ex2.equals(Ex2.getPolynomFromString(Ex2.poly(po18)), po18));
        assertTrue(Ex2.equals(Ex2.getPolynomFromString(Ex2.poly(po19)), po19));
        assertTrue(Ex2.equals(Ex2.getPolynomFromString(Ex2.poly(po20)), po20));
        assertTrue(Ex2.equals(Ex2.getPolynomFromString(Ex2.poly(po21)), po21));
        assertTrue(Ex2.equals(Ex2.getPolynomFromString(Ex2.poly(po22)), po22));
        assertTrue(Ex2.equals(Ex2.getPolynomFromString(Ex2.poly(po23)), po23));
        assertTrue(Ex2.equals(Ex2.getPolynomFromString(Ex2.poly(po24)), po24));
        assertTrue(Ex2.equals(Ex2.getPolynomFromString(Ex2.poly(po27)), po27));
    }

    @Test
    /**
     * test that poly(getPolynomFromString(s)) == s
     */
    public void testGetFromStringAndPoly2(){
        assertEquals(es1, Ex2.poly(Ex2.getPolynomFromString(ts1)));
        assertEquals(es2, Ex2.poly(Ex2.getPolynomFromString(ts2)));
        assertEquals(es3, Ex2.poly(Ex2.getPolynomFromString(ts3)));
        assertEquals(es4, Ex2.poly(Ex2.getPolynomFromString(ts4)));
        assertEquals(es5, Ex2.poly(Ex2.getPolynomFromString(ts5)));
        assertEquals(es6, Ex2.poly(Ex2.getPolynomFromString(ts6)));
        assertEquals(es7, Ex2.poly(Ex2.getPolynomFromString(ts7)));
        assertEquals(es8, Ex2.poly(Ex2.getPolynomFromString(ts8)));
        assertEquals(es9, Ex2.poly(Ex2.getPolynomFromString(ts9)));
        assertEquals(es10, Ex2.poly(Ex2.getPolynomFromString(ts10)));
        assertEquals(es11, Ex2.poly(Ex2.getPolynomFromString(ts11)));
        assertEquals(es12, Ex2.poly(Ex2.getPolynomFromString(ts12)));
        assertEquals(es13, Ex2.poly(Ex2.getPolynomFromString(ts13)));
        assertEquals(es14, Ex2.poly(Ex2.getPolynomFromString(ts14)));
        assertEquals(es15, Ex2.poly(Ex2.getPolynomFromString(ts15)));
        assertEquals(es16, Ex2.poly(Ex2.getPolynomFromString(ts16)));
        assertEquals(es17, Ex2.poly(Ex2.getPolynomFromString(ts17)));
        assertEquals(es18, Ex2.poly(Ex2.getPolynomFromString(ts18)));
        assertEquals(es19, Ex2.poly(Ex2.getPolynomFromString(ts19)));
        assertEquals(es20, Ex2.poly(Ex2.getPolynomFromString(ts20)));
        assertEquals(es21, Ex2.poly(Ex2.getPolynomFromString(ts21)));
        assertEquals(es22, Ex2.poly(Ex2.getPolynomFromString(ts22)));
        assertEquals(es23, Ex2.poly(Ex2.getPolynomFromString(ts23)));
        assertEquals(es24, Ex2.poly(Ex2.getPolynomFromString(ts24)));
        assertEquals(es25, Ex2.poly(Ex2.getPolynomFromString(ts25)));
        assertEquals(es27, Ex2.poly(Ex2.getPolynomFromString(ts27)));
    }

    @Test
    /**
     * Tests that f(x) == poly(x).
     */
    void testF() {
        double fx0 = Ex2.f(po1, 0);
        double fx1 = Ex2.f(po1, 1);
        double fx2 = Ex2.f(po1, 2);
        double fx3 = Ex2.f(po5, Math.PI);
        double fx4 = Ex2.f(po6, Math.E);
        double fx5 = Ex2.f(po7, Math.E);
        double fx6 = Ex2.f(po7, Math.E*-1);
        double fx7 = Ex2.f(po3, 1.9);
        assertEquals(2, fx0, Ex2.EPS);
        assertEquals(4, fx1, Ex2.EPS);
        assertEquals(6, fx2, Ex2.EPS);
        assertEquals(fx3, fx4, Ex2.EPS);
        assertEquals(fx5, fx6, Ex2.EPS);
        assertEquals(1.496462, fx7, Ex2.EPS);
        assertEquals(-5.678, Ex2.root_rec(po4, -10, 0, Ex2.EPS), 0.1);
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
     * Tests that p1 + (-p1) == 0:
     */
    void testAdd4() {
        assertTrue(Ex2.equals(Ex2.ZERO, Ex2.add(po17, Ex2.mul(po17, po18))));
    }

    @Test
    /**
     * Tests add with potentially problematic polynoms:
     */
    void testAdd5() {
        assertTrue(Ex2.equals(Ex2.ZERO, Ex2.add(po23, po24)));
        assertTrue(Ex2.equals(po28, Ex2.add(po8, po17)));
    }

    @Test
    /**
     * tests that p1+p1 == p1*2
     */
    void testAddMul(){
        double[] p1 = Ex2.add(po8, po8);
        double[] p2 = Ex2.add(po15, po15);
        double[] p3 = Ex2.mul(po8, p2);
        assertTrue(Ex2.equals(p1, p3));
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
     * tests complicated derivative, till 0
     */
    void testDerivative(){
        assertTrue(Ex2.equals(Ex2.derivative(po16), po17));
        double[] d1 = Ex2.derivative(po16);
        double[] d2 = Ex2.derivative(d1);
        double[] d3 = Ex2.derivative(d2);
        double[] d4 = Ex2.derivative(d3);
        double[] d5 = Ex2.derivative(d4);
        double[] d6 = Ex2.derivative(d5);
        double[] d7 = Ex2.derivative(d6);
        double[] d8 = Ex2.derivative(d7);
        double[] d9 = Ex2.derivative(d8);
        double[] d10 = Ex2.derivative(d9);
        assertFalse(Ex2.equals(Ex2.ZERO, d9));
        assertTrue(Ex2.equals(Ex2.ZERO, d10));
        assertEquals("-215.11079999999998x^7 +1288.0x^6 +3.0000000000000004x^4 +0.4x^3 -0.12x -1.4", Ex2.poly(d2));
    }

    @Test
    /**
     * Tests the parsing of a polynom in a String like form.
     */
    public void testFromString() {
        double[] p = {-1.1,2.3,3.1}; // 3.1X^2 +2.3x -1.1
        String sp = Ex2.poly(p);
        String sp2 = "3.1x^2 +2.3x -1.1";
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
            assertTrue(Ex2.equals(d1[i], d2[i]));
        }
        for(int i=0;i<d1.length;i=i+1) {
            assertFalse(Ex2.equals(d1[i], xx[i]));
        }
        assertTrue(Ex2.equals(Ex2.ZERO, po13));
    }

    @Test
    /**
     * Tests if the sameValue function is symmetric.
     */
    public void testSameValue2() {
        double x1=-4, x2=0;
        double rs1 = Ex2.sameValue(po1,po2, x1, x2, Ex2.EPS);
        double rs2 = Ex2.sameValue(po2,po1, x1, x2, Ex2.EPS);
        assertEquals(rs1,rs2,Ex2.EPS);
    }

    @Test
    /**
     * Tests sameValue on functions that have a small range where they are closer than EPS:
     */
    public void testSameValue3() {
        assertEquals(1,Ex2.sameValue(po25, po26, 0.02, 3.02, Ex2.EPS), Ex2.EPS);
    }

    @Test
    /**
     * Test the area function - it should be symmetric.
     */
    public void testArea() {
        double x1=-4, x2=0;
        double a1 = Ex2.area(po1, po2, x1, x2, 100);
        double a2 = Ex2.area(po2, po1, x1, x2, 100);
        assertEquals(a1, a2, Ex2.EPS);
    }

    @Test
    /**
     * test area with different levels of precision: expect to get different results
     */
    public void testArea2(){
        double x1=Ex2.sameValue(po3, po9, -10, 0, 8), x2=6;
        double a1 = Ex2.area(po3, po9, x1, x2, 8);
        double a2 = Ex2.area(po3, po9, x1, x2, 100);
        assertNotEquals(a1, a2);
    }

    @Test
    /**
     * test area that should be 0
     */
    public void testArea3(){
        double a1 = Ex2.area(po3, po3, 0, 12, 20);
        assertEquals(0, a1, Ex2.EPS);
    }

    @Test
    /**
     * test that area under a line function is equal to the manual calculation:
     */
    public void testArea4(){
        double a1 = Ex2.area(po29, Ex2.ZERO, 0, 8, 1);
        double a2 = Ex2.area(po29, Ex2.ZERO, 0, 8, 10);
        double a3 = Ex2.area(po29, Ex2.ZERO, 0, 8, 100);
        assertEquals(16, a1);
        assertEquals(16, a2);
        assertEquals(16, a3, Ex2.EPS);
    }

    @Test
    /**
     * test root_rec: that it returns the correct root of a function:
     */
    public void testRoot(){
        assertEquals(-5.687, Ex2.root_rec(po2, -10, 10, Ex2.EPS), Ex2.EPS);
        assertEquals(2.637, Ex2.root_rec(po2, 0, 10, Ex2.EPS), Ex2.EPS);
    }

    @Test
    /**
     *  test PolynomFromPoints with difficult arrays;
     *  test that f(x) of the resulted polynom is equal to y of input array:
     *  if the input returns 0, expect f(x) to be 0:
     *  if xx.length != yy.length, expect null:
     *  if two 'x' values are equal, expect null:
     */
    public void testPolynomFromPoints(){
        double[] a1 = Ex2.PolynomFromPoints(po2, po4);
        for(int i=0; i<3; i++){ assertEquals(po4[i], Ex2.f(a1, po2[i]), Ex2.EPS); }
        double[] a2 = Ex2.PolynomFromPoints(po2, po6);
        for(int i=0; i<3; i++){ assertEquals(po6[i], Ex2.f(a2, po2[i]), Ex2.EPS); }
        double[] a3 = Ex2.PolynomFromPoints(po2, po7);
        for(int i=0; i<3; i++){ assertEquals(po7[i], Ex2.f(a3, po2[i]), Ex2.EPS); }
        double[] a4 = Ex2.PolynomFromPoints(po2, po8);
        for(int i=0; i<3; i++){ assertEquals(0, Ex2.f(a4, po2[i]), Ex2.EPS); }
        double[] a5 = Ex2.PolynomFromPoints(po6, po9);
        for(int i=0; i<3; i++){ assertEquals(0, Ex2.f(a5, po6[i]), Ex2.EPS); }
        double[] a6 = Ex2.PolynomFromPoints(po1, po27);
        assertEquals(null, a6);
        double[] a7 = Ex2.PolynomFromPoints(po10, po11);
        for(int i=0; i<2; i++){ assertEquals(po11[i], Ex2.f(a7, po10[i]), Ex2.EPS); }
        double[] a8 = Ex2.PolynomFromPoints(po1, po5);
        assertEquals(null, a8);
    }

    @Test
    /**
     * test length() with different options:
     */
    public void testLength(){
        double a0 = Ex2.length(Ex2.ZERO, -12, 7.9, 100);
        double a1 = Ex2.length(P1, -12, 7.9, 100);
        double a2 = Ex2.length(P2, -12, 7.9, 100);
        double a3 = Ex2.length(po10, -12, 7.9, 100);
        double a4 = Ex2.length(po11, -12, 7.9, 100);
        double a5 = Ex2.length(po12, 0, 1, 1);
        double a6 = Ex2.length(po12, 0, 1, 99999);
        double a7 = Ex2.length(po8, -3, 1, 999);
        double a8 = Ex2.length(po8, -10, -6, 999);
        double a9 = Ex2.length(po10, -7, -3, 999);
        double a10 = Ex2.length(po10, -3, 1, 999);
        double a11 = Ex2.length(po21, 0, 0.5, 99);
        double a12 = Ex2.length(po21, 0.5, 1, 99);
        double a13 = Ex2.length(po21, -1, -0.5, 99);
        double a14 = Ex2.length(po13, -16, 22.5, 9999);
        assertEquals(19.9, a0, Ex2.EPS);
        assertEquals(38.5, a14, Ex2.EPS);
        assertNotEquals(a1, a2);
        assertEquals(a3, a4, Ex2.EPS);
        assertEquals(a5, a6, Ex2.EPS);
        assertEquals(a5, Math.sqrt(2), Ex2.EPS);
        assertNotEquals(a7, a8);
        assertEquals(a9, a10, Ex2.EPS);
        assertNotEquals(a11, a12);
        assertEquals(a13, a12, Ex2.EPS);
    }
}