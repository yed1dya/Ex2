// 207404997
package exe.ex2;

/**
 * Introduction to Computer Science 2023, Ariel University,
 * Ex2: arrays, static functions and JUnit
 *
 * This class represents a set of functions on a polynom - represented as array of doubles.
 * The array {0.1, 0, -3, 0.2} represents the following polynom: 0.2x^3-3x^2+0.1
 * This is the main Class you should implement (see "add your code here")
 *
 * @author boaz.benmoshe
 */

//

public class Ex2 {
	/** Epsilon value for numerical computation, it serves as a "close enough" threshold. */
	public static final double EPS = 0.001; // the epsilon to be used for approximation.
	/** The zero polynom is represented as an array with a single (0) entry. */
	public static final double[] ZERO = {0};

	/**
	 * Computes the f(x) value of the polynom at x.
	 * @param poly
	 * @param x
	 * @return f(x) - the polynom value at x.
	 */
	public static double f(double[] poly, double x) {
		double ans = 0; int length;
		if(poly==null){ length = 0; } else{ length = poly.length; }
		for(int i=0;i<length;i++) {
			double c = Math.pow(x, i);
			ans +=c*poly[i];
		}
		return ans;
	}

	/** Given a polynom (p), a range [x1,x2] and an epsilon eps.
	 * This function computes an x value (x1<=x<=x2) for which |p(x)| < eps,
	 * assuming p(x1)*p(x1) <= 0.
	 * This function should be implemented recursively.
	 * @param p - the polynom
	 * @param x1 - minimal value of the range
	 * @param x2 - maximal value of the range
	 * @param eps - epsilon (positive small value (often 10^-3, or 10^-6).
	 * @return an x value (x1<=x<=x2) for which |p(x)| < eps.
	 */
	public static double root_rec(double[] p, double x1, double x2, double eps) {
		double f1 = f(p,x1);
		double f2 = f(p,x2);
		double x12 = (x1+x2)/2;
		double f12 = f(p,x12);
		if (f1*f2<=0 && Math.abs(f12)<eps) {return x12;}
		if(f12*f1<=0) {return root_rec(p, x1, x12, eps);} else {return root_rec(p, x12, x2, eps);}
	}

	/**
	 * This function computes a polynomial representation from a set of 2D points on the polynom.
	 * The solution is based on:
	 * http://stackoverflow.com/questions/717762/how-to-calculate-the-vertex-of-a-parabola-given-three-points
	 * Note: this function only works for a set of points containing up to 3 points, else returns null.
	 * @param xx
	 * @param yy
	 * @return an array of doubles representing the coefficients of the polynom.
	 */
	// in general: every 2 points on a graph are connected by a single line function,
	// every 3 points are connected by a single parabola.
	// this function gets 2 arrays: representing 'x' values and 'y' values; together they represent points.
	// if 2 points - calculate the line function that connects them.
	// if 3 points - calculate the parabola that connects them.
	// if two of the points have the same x value - they represent a vertical line, not a polynom.
	// so returns an empty array.
	// otherwise, returns an array representing the polynom that connects the points.
	public static double[] PolynomFromPoints(double[] xx, double[] yy) {
		// default return value is an empty array:
		double [] ans = {};
		int lx = xx.length, ly = yy.length;
		// if arrays represent 2 or 3 points:
		if(xx!=null && yy!=null && lx==ly && lx>1 && lx<4) {
			double x0=xx[0], x1=xx[1], y0=yy[0], y1=yy[1];
			// 2 points - line function:
			if (lx == 2) {
				// if the 2 points have the same x value,
				// it's a vertical line and not a polynom. otherwise:
				if(xx[0]!=xx[1]){
					ans = new double[2];
					double m = (y0-y1)/(x0-x1);
					ans[0] = y0 - m*x0; ans[1] = m;
				}
			} else if(lx == 3){
				// 3 points - parabola
				// if 2 points have the same x value, it's an error,
				// and will return an empty array. otherwise:
				if(xx[0]!=xx[1] && xx[0]!=xx[2] && xx[1]!=xx[2]) {
					double x2=xx[2], y2=yy[2]; ans = new double[3];
					// finds A, B, C for y=Ax^2+Bx+C; source: stackoverflow.com
					double dnm = (x0-x1)*(x0-x2)*(x1-x2);
					ans[2] = (x2*(y1-y0) + x1*(y0-y2) + x0*(y2 - y1)) / dnm;
					ans[1] = (x2*x2*(y0-y1) + x1*x1*(y2-y0) + x0*x0*(y1-y2)) / dnm;
					ans[0] = (x1*x2*(x1-x2)*y0 + x2*x0*(x2-x0)*y1 + x0*x1*(x0-x1)*y2) / dnm;
				}
			}
		}
		return ans;
	}

	/** Two polynoms are equal if and only if they have the same values f(x) for 1+n values of x,
	 * where n is the max degree (over p1, p2) - up to an epsilon (aka EPS) value.
	 * @param p1 first polynom
	 * @param p2 second polynom
	 * @return true if p1 represents the same polynom as p2.
	 */
	// checks if two polynoms are equal (according to the definition above);
	// find the high power and use the f() function to compare n+1 x values.
	// if at any x value, the polynoms are more than eps apart, they're not equal.
	public static boolean equals(double[] p1, double[] p2) {
		boolean ans = true;
		int pwr1 = 0, pwr2 = 0, points = 0;
		// find the highest power of each polynom;
		// the highest index that isn't zero:
		for(int i = 0; i < p1.length; i++) {
			if(p1[i] != 0) { pwr1 = i; }
		}
		for(int i = 0; i < p2.length; i++) {
			if(p2[i] != 0) { pwr2 = i; }
		}
		// set points as the higher power +1: the amount of points to check:
		points = Math.max(pwr2, pwr1)+1;
		for(double i=0; i<=points; i++) {
			// if values are more than EPS apart:
			if(Math.abs(f(p1, i) - f(p2, i)) > EPS) {
				ans = false; break;
			}
		}
		return ans;
	}

	/**
	 * Computes a String representing the polynom.
	 * For example the array {2,0,3.1,-1.2} will be presented as the following String  "-1.2x^3 +3.1x^2 +2.0"
	 * @param poly the polynom represented as an array of doubles
	 * @return String representing the polynom:
	 */
	// this function uses a 'for' loop to iterate over poly[] (the inputted array);
	// every time, create a string to add to ans: <coefficient>x^<power>;
	// coefficient is the value in poly[i], power is the value of 'i':
	public static String poly(double[] poly) {
		String ans = "";
		if(poly!=null && poly.length>0){
			for(int i=0; i<poly.length; i++) {
				// if coefficient is 0, don't add it:
				if(poly[i] != 0){
					// if the coefficient is negative, write the number as it is;
					// if the number is positive, add a '+' before it;
					// if coefficient is 1 or -1, write only 'x' or '-x'
					if(i==0){
						// coefficient of 'x^0':
						if(poly[0] < 0) { ans+= poly[0]; } else { ans+= "+"+poly[0]; }
					} else if(i==1) {
						// coefficient of 'x^1':
						if(poly[1]==-1){ ans= "-x "+ans; }
						else if(poly[1]==1){ ans= "+x "+ans; }
						else if(poly[1] < 0) { ans= poly[1]+"x "+ans; }
						else { ans= "+"+poly[1]+"x "+ans; }
					} else {
						if(poly[i]==-1){ ans= "-x^"+i+" "+ans; }
						else if(poly[i]==1){ ans= "+x^"+i+" "+ans; }
						else if(poly[i] < 0) { ans= poly[i]+"x^"+i+" "+ans; }
						else { ans= "+"+poly[i]+"x^"+i+" "+ans; }
					}
				}
			}
			// remove '+' from beginning of string, and empty spaces from beginning/end:
			if(ans.length()>1) {
				if(ans.startsWith("+")){ ans = ans.substring(1); }
				ans = ans.strip();
			}
			// if input was the zero polynom, 'ans' will be blank;
			// we want the output to be "0":
			if(ans.equals("")){ ans = "0"; }
		}
		return ans;
	}

	/**
	 * Given two polynoms (p1,p2), a range [x1,x2] and an epsilon eps. This function computes an x value (x1<=x<=x2)
	 * for which |p1(x) -p2(x)| < eps, assuming (p1(x1)-p2(x1)) * (p1(x2)-p2(x2)) <= 0.
	 * @param p1 - first polynom
	 * @param p2 - second polynom
	 * @param x1 - minimal value of the range
	 * @param x2 - maximal value of the range
	 * @param eps - epsilon (positive small value (often 10^-3, or 10^-6).
	 * @return an x value (x1<=x<=x2) for which |p1(x) - p2(x)| < eps.
	 */
	// this function works recursively, similar to root_rec.
	// for each x1, x2; finds x12 (middle point) and checks if x12 is the sameValue point,
	// (distance between y values of p1, p2 is less than eps). if yes, return x12;
	// otherwise, check if the polynoms cross in range x1-x12, or x12-x2, and call sameValue
	// with the new range (x1-x12, or x12-x2). default answer is x1.
	// source - inspired by root_rec.
	public static double sameValue(double[] p1, double[] p2, double x1, double x2, double eps) {
		double ans = x1;
		double p1x1 = f(p1,x1); // value of p1 at x1
		double p1x2 = f(p1,x2); // value of p1 at x2
		double p2x1 = f(p2,x1); // value of p2 at x1
		double p2x2 = f(p2,x2); // value of p2 at x2
		double x12 = (x1+x2)/2; // middle point between x1, x2
		double p1x12 = f(p1,x12); // value of p1(x12)
		double p2x12 = f(p2,x12); // value of p2(x12)
		// check that polynoms cross in range:
		if((p1x1-p2x1)*(p1x2-p2x2) < 0){ ans = x12;
			// if |p1(x12)-p2(x12)| < eps, x12 is the sameValue point, so return x12;
			// otherwise, it will call sameValue again, with updated 'x1' and 'x2':
			if(Math.abs(p1x12-p2x12) > eps){
				// if the polynoms cross somewhere between x1 and x12:
				if((p1x1-p2x1)*(p1x12-p2x12)<=0) {
					// call sameValue  with x1, x12:
					return sameValue(p1, p2, x1, x12, eps);
				}
				// call sameValue with x12, x2:
				else{ return sameValue(p1, p2, x12, x2, eps); }
			}
		}
		return ans;
	}

	//
	/**
	 * Given a polynom (p), a range [x1,x2] and an integer with the number (n) of sample points.
	 * This function computes an approximation of the length of the function between f(x1) and f(x2)
	 * using n inner sample points and computing the segment-path between them.
	 * assuming x1 < x2.
	 * This function should be implemented iteratively (none recursive).
	 * @param p - the polynom
	 * @param x1 - minimal value of the range
	 * @param x2 - maximal value of the range
	 * @param numberOfSegments - (A positive integer value (1,2,...).
	 * @return the length approximation of the function between f(x1) and f(x2).
	 */
	// this function works as described above; sets segment length by the distance from x1-x2,
	// and calculates the approximated length of the polynom in each segment.
	public static double length(double[] p, double x1, double x2, int numberOfSegments) {
		double ans = 0;
		// set segment length:
		double s = (x2-x1)/numberOfSegments;
		for(int i=0; i<numberOfSegments; i++) {
			// calculate with pythagorean theorem: A^2+B^2=C^2
			// A = segment length; B = distance between p1(x1), p1(x1+s):
			ans += Math.sqrt(Math.pow(s, 2) + Math.pow(Ex2.f(p, x1+s)-Ex2.f(p, x1), 2));
			// advance x1 by s for next segment:
			x1+=s;
		}
		return ans;
	}

	/**
	 * Given two polynoms (p1,p2), a range [x1,x2] and an integer representing the number of Trapezoids
	 * between the functions (number of samples in on each polynom).
	 * This function computes an approximation of the area between the polynoms within the x-range.
	 * The area is computed using Riemann's like integral (https://en.wikipedia.org/wiki/Riemann_integral)
	 * @param p1 - first polynom
	 * @param p2 - second polynom
	 * @param x1 - minimal value of the range
	 * @param x2 - maximal value of the range
	 * @param numberOfTrapezoid - a natural number representing the number of Trapezoids between x1 and x2.
	 * @return the approximated area between the two polynoms within the [x1,x2] range.
	 */
	// this function uses the Riemann integral method for area approximation:
	// divides the length between x1-x2 into the required number of segments;
	// in each segment, finds the length of the bases of the trapezoid.
	// then checks if the next meeting point of the polynoms is within the segment;
	// if yes, finds the area of the triangles - base of each triangle is the base of the trapezoid;
	// the triangles share a point - the meet point of the polynoms.
	// otherwise, calculates the trapezoid area; the trapezoid height is constant - the segment length.
	public static double area(double[] p1,double[]p2, double x1, double x2, int numberOfTrapezoid) {
		double ans = 0, meet = 0, s = (x2-x1)/numberOfTrapezoid;
		double a, b;
		for(int i=0; i<numberOfTrapezoid; i++) {
			// x1 is the x value for the first base of the trapezoid;
			// set x2 as x value for the second base:
			x2=x1+s;
			// set a, b as trapezoid bases length; the distance between y values of p1, p2 at x1, x2:
			a = Math.abs(Ex2.f(p1, x1) - Ex2.f(p2, x1));
			b = Math.abs(Ex2.f(p1, x2) - Ex2.f(p2, x2));
			// set 'meet' as next meeting point of the polynoms, between x1 & x2:
			meet = Ex2.sameValue(p1, p2, x1, x2, Ex2.EPS);
			// if the next meet point of the polynoms is in the next segment:
			// calculate the area of that segment by the area of the triangles
			// between the meet point and the trapezoid bases:
			if(meet>x1 && meet<(x1+s)) {
				ans += (a*(meet-x1)/2) + (b*(x2-meet)/2);
			} else {
				// calculate trapezoid area:
				ans += ((a+b)/2)*s;
			}
			// advance x1 for next segment:
			x1=x2;
		}
		return ans;
	}

	/**
	 * This function computes the array representation of a polynom from a String
	 * representation. Note:given a polynom represented as a double array,
	 * getPolynomFromString(poly(p)) should return an array equals to p.
	 *
	 * @param p - a String representing polynom.
	 * @return
	 */

	//	according to assignment instructions, input to getPolynomFromString()
	// 	can be assumed to be an output from poly(), so we'll assume lowercase 'x'.
	// 	the function has 2 parts:
	// 	1) edit the string to a uniform format that's easier to work with
	// 	2) parse the data from the string
	public static double[] getPolynomFromString(String p) {
		double [] ans = {};
		// check that the string isn't blank:
		if(p.length()>0){
			// part 1: remove spaces:
			p = p.replace(" ", "");
			// add '+' to beginning:
			if(p.charAt(0)!='+' && p.charAt(0)!='-'){ p = "+"+p; }
			// if the last part of the string is 'x', change it to 'x^1':
			if(p.charAt(p.length()-1)=='x'){ p = p+"^1"; }
			// if the 'x' is in the middle of the string, it will be 'x+...' or 'x-...';
			// change it to 'x^1+...' or 'x^1-...':
			p = p.replace("x+", "x^1+");
			p = p.replace("x-", "x^1-");
			// change 'x' to '1x', and '-x' to '-1x'
			p = p.replace("+x", "+1x");
			p = p.replace("-x", "-1x");
			// part 2: create array of substrings from p, split by '-' and '+':
			String[] sp = p.split("((?=[+-]))");
			// if the last index in the array does not contain '^',
			// it's the coefficient of 'x^0'; add 'x^0' to it:
			if(!sp[sp.length-1].contains("^")){ sp[sp.length-1] = sp[sp.length-1]+"x^0"; }
			// find the high power of p and create array 'ans' of that length;
			// the coefficient will be everything before '^', power will be after '^';
			// get strings containing coefficient and power, and parse double/int from them:
			String strPwr, strCo; double doubleCo;
			int pwrPlace = sp[0].indexOf('^');
			if(pwrPlace!=-1){ strPwr = sp[0].substring(pwrPlace+1); } else{ strPwr = "0"; }
			int intPwr = Integer.parseInt(strPwr);
			ans = new double[intPwr+1];
			// for each index in sp, parse coefficient and power (same way as in sp[0]);
			// insert coefficient to 'ans' in the index of 'power':
			for(int i=0; i<sp.length; i++){
				pwrPlace = sp[i].indexOf('^');
				strPwr = sp[i].substring(pwrPlace+1);
				intPwr = Integer.parseInt(strPwr);
				strCo = sp[i].substring(0, pwrPlace-1);
				doubleCo = Double.parseDouble(strCo);
				ans[intPwr] = doubleCo;
			}
		}
		return ans;
	}

	/**
	 * This function computes the polynom which is the sum of two polynoms (p1,p2)
	 * @param p1
	 * @param p2
	 * @return
	 */
	// the power of the sum of 2 polynoms is the higher power of both polynoms;
	// so 'ans' length will be the length of the longer array.
	// for each index in the smaller array:
	// insert the sum of the coefficients from both array into the same index in 'ans'.
	// for the rest of the indexes in 'ans', insert the coefficients from the longer array.
	public static double[] add(double[] p1, double[] p2) {
		double [] ans = {};
		// if at least one of the arrays isn't empty:
		if(p1.length != 0 || p2.length != 0){
			// set 'ans' to size of the longer array:
			int big = Math.max(p1.length, p2.length),
					small = Math.min(p1.length, p2.length), i=0;
			ans = new double[big];
			// for each index in the smaller array, add the coefficients from p1, p2:
			for(i=0; i<small; i++) { ans[i] = p1[i]+p2[i]; }
			// add the rest of the coefficients from the longer array:
			while(i<big) {
				if(p1.length == big) { ans[i] = p1[i]; } else { ans[i] = p2[i]; } i++;
			}
		}
		// if the sum of the arrays is zero:
		if(ArrIsZero(ans)){ ans = ZERO; }
		return ans;
	}

	/**
	 * This function computes the polynom which is the multiplication of two polynoms (p1,p2)
	 * @param p1
	 * @param p2
	 * @return
	 */
	// the power of the product of polynom multiplication
	// is the sum of the high powers of both polynoms;
	// so 'ans' length is the sum of both polynom lengths.
	// (minus 1, because the length is greater than the high power by 1)
	// using impeded 'for' loops, to make sure that every coefficient
	// from p1 is multiplied by every coefficient of p2;
	// add the product of the coefficients to 'ans' in the index of the sum of the powers.
	public static double[] mul(double[] p1, double[] p2) {
		double [] ans = {};
		int a = p1.length, b = p2.length;
		if(a!=0 && b!=0){
			ans = new double[]{};
		}
		// if one of the polynoms is zero, ans is zero:
		if(!ArrIsZero(p1) && !ArrIsZero(p2)){
			// create array for ans:
			ans = new double[a+b-1];
			// multiply every coefficient in p1 by every one in p2;
			// the place for the product is the sum of the powers:
			for(int i=0; i<a; i++) {
				for(int j=0; j<b; j++) { ans[i+j] += p1[i]*p2[j]; }
			}
		}
		return ans;
	}

	/**
	 * This function computes the derivative polynom:.
	 * @param po
	 * @return
	 */
	// the power of a derivative polynom is one less than the original polynom.
	// so 'ans' length is one less than 'po' length. 'pwr' is the index of the coefficient.
	// for each index of 'po', calculate (pwr*coefficient)x^(pwr-1). insert to 'ans[pwr-1]:
	public static double[] derivative (double[] po) {
		double [] ans = {};
		// if p length is 1, it's only the coefficient of x^0 and the derivative is 0:
		if(po.length==1){
			ans = new double[]{0};
		}
		else if(po.length > 1){
			// high power of the derivative is high power of polynom minus 1:
			ans = new double[po.length-1];
			// for each element in po:
			for(int i=1; i<po.length; i++) { ans[i-1] = i*po[i]; }
		}
		return ans;
	}

	// custom auxiliary function:
	// check if an array representing a polynom is all zeroes:
	public static boolean ArrIsZero(double[] p){
		boolean ArrIsZero = true; int i=0;
		// check if value at any index is different from 0:
		while(!(p==null) && ArrIsZero && i<p.length){
			ArrIsZero = p[i]=='0'; i++;
		}
		return ArrIsZero;
	}
}