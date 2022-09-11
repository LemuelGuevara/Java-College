/*
* Converts math expressions in to java statements
* */

package MathConversion;
import java.util.*;
import static java.lang.Math.*;

public class MathConversion
{
    public static void main(String[] args)
    {
        // Declaration of variables

        double a, b, c, d, t, s, z;
        int x,y;

        x = 5;
        y = 10;
        // Converts degrees into radians then converts the value of the radian into degrees
        t = toRadians(toDegrees(30));
        z = toRadians(toDegrees(45));

        a = (1/3.0)*pow(((3*x*sin(t*y) + 5*pow(y, 3))), 1.0 / 5);
        b = toRadians((-y) - sqrt(abs(pow(y, 2) - (4 * x * (z)))) / 2*x+y + log10(3*pow(x, 1.0/4.0)));
        c = x*pow(1 + y/z, x*z);
        d = toDegrees(atan(x*z)) + pow(exp(4), x*y) + 3*log(x)/2*y;
        s = (exp(x) + 3*y) / toDegrees(atan(x)) + sin(toRadians(z));

        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);
        System.out.println(s);
    }
}
