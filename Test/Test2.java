package Test;

public class Test2
{
    public static void main(String[] args) {
        Test2 w = new Test2(); Test2 w2 = new Test2();
        w2 = go(w, w2);

        System.out.println(w2 == w);

    }
    static Test2 go(Test2 wr1, Test2 wr2)
    {
        Test2 wr3 = wr1; wr1 = wr2; wr2 = wr3;

        return wr3;
    }

}