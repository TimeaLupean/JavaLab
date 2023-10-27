package test;

import main.Problem2;
import org.junit.jupiter.api.Test;

public class Problem2Test {

    @Test
    public void maximaleZahlTest() {
        Problem2 problem2 = new Problem2();
        int[] zahlen = new int[]{4, 8, 3, 10, 17};
        assert problem2.maximaleZahl(zahlen) == 17 : "Soll 17 sein";
    }


    @Test
    public void maximaleZahlTest_unerwartet() {
        Problem2 problem2 = new Problem2();
        int[] zahlen = new int[]{4, 8, 3, 10, -17};
        int result = problem2.maximaleZahl(zahlen);
        assert result == 0 : "maximaleZahlTest_unerwartet ist nicht gelungen";
    }


    @Test
    public void minimaleZahlTest() {
        Problem2 problem2 = new Problem2();
        int[] zahlen = new int[]{4, 8, 3, 10, 17};
        assert problem2.minimaleZahl(zahlen) == 3 : "Soll 3 sein";
    }

    @Test
    public void minimaleZahlTest_unerwartet() {
        Problem2 problem2 = new Problem2();
        int[] zahlen = new int[]{4, 8, 3, -10, 17};
        int result = problem2.minimaleZahl(zahlen);
        assert result == 0 : "minimaleZahlTest_unerwartet ist nicht gelungen";
    }


    @Test
    public void maximaleSummeTest() {
        Problem2 problem2 = new Problem2();
        int[] zahlen = new int[]{4, 8, 3, 10, 17};
        assert problem2.maximaleSumme(zahlen) == 39 : "Soll 39 sein";
    }

    @Test
    public void maximaleSummeTest_unerwartet() {
        Problem2 problem2 = new Problem2();
        int[] zahlen = new int[]{4, 8, -3, 10, 17};
        int result = problem2.maximaleSumme(zahlen);
        assert result == 0 : "maximaleSummeTest_unerwartet ist nicht gelungen";
    }


    @Test
    public void minimaleSummeTest() {
        Problem2 problem2 = new Problem2();
        int[] zahlen = new int[]{4, 8, 3, 10, 17};
        assert problem2.minimaleSumme(zahlen) == 25 : "Soll 25 sein";
    }

    @Test
    public void minimaleSummeTest_unerwartet() {
        Problem2 problem2 = new Problem2();
        int[] zahlen = new int[]{4, -8, 3, 10, 17};
        int result = problem2.minimaleSumme(zahlen);
        assert result == 0 : "minimaleSummeTest_unerwartet ist nicht gelungen";
    }


}
