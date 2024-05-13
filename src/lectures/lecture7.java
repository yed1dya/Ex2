package lectures;

public class lecture7 {
    // intro to OOP
    public static void main(String[] args){


    }

    public static final boolean DEBUG = false;
    public static long gcd1(long x, long y) {
        if(DEBUG) {System.out.println("gcd1("+x+","+y+")");}
        if(x<y) {return gcd1(y,x);}
        if(x%y==0) {
            System.out.println("gcd1("+x+","+y+") = "+y);
            return y;}
        return gcd1(y,x%y);
    }
}
