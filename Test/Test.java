package Test;
import static java.lang.Math.*;

public class Test {
    public static void main(String[] args) {
        double a, b, c, m, n, t, z;

        a = 2.3;
        b = 3.4;
        c = 2.1;
        t = 32;

        m = sqrt(2*a*a+2*c*c-pow(b,2));
        n = log10(c*c*c*c) - 2*b*c*cos(t*3.1416/180);
        z = (3*tan(2*t*3.1416/180)+log(a))/(b+c);

        System.out.println("m = " + m + " n = " + n + " z = " + z);
    }
}
