package test;
import main.Problem2;
import org.junit.jupiter.api.Test;

public class Problem2Test {

    @Test
    public void MaximTest() {

        Problem2 problem2 = new Problem2();
        int[] zahlen = new int[]{4, 8, 3, 10, 17};
        assert problem2.Maxim(zahlen) == 17 : "Soll 17 sein";
//        assert problem2.Maxim(zahlen) == 8 : "Falsch-Soll 17 sein";
    }

    @Test
    public void MinimalTest() {
        Problem2 problem2 = new Problem2();
        int[] zahlen = new int[]{4, 8, 3, 10, 17};
        assert problem2.Minim(zahlen) == 3 : "Soll 3 sein";
//        assert problem2.Minim(zahlen) == 8 : "Falsch-Soll 3 sein";
    }

    @Test
    public void maxSummeTest() {
        Problem2 problem2 = new Problem2();
        int[] zahlen = new int[]{4, 8, 3, 10, 17};
        assert problem2.maxSumme(zahlen) == 39 : "Soll 39 sein";
        //assert problem2.minSumme(zahlen) == 38 : "Falsch-Soll 39 sein";
    }

    @Test
    public void minSummeTest() {
        Problem2 problem2 = new Problem2();
        int[] zahlen = new int[]{4, 8, 3, 10, 17};
        assert problem2.minSumme(zahlen) == 25 : "Soll 25 sein";
//        assert problem2.minSumme(zahlen) == 24 : "Falsch-Soll 25 sein";
    }
}
