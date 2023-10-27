package test;

import main.Problem3;
import org.junit.jupiter.api.Test;

public class Problem3Test {

    @Test
    public void summeTest() {
        Problem3 problem3 = new Problem3();
        int[] zahl1 = new int[]{1, 3, 0, 0, 0, 0, 0, 0, 1};
        int[] zahl2 = new int[]{8, 7, 0, 0, 0, 0, 0, 0, 9};
        int[] summe = new int[]{1, 0, 0, 0, 0, 0, 0, 0, 1, 0};
        int[] result = problem3.summe(zahl1, zahl2);
        for (int i = 0; i < zahl1.length; i++) {
            assert result[i] == summe[i] : "Soll gleich sein";
        }
        assert result.length == summe.length : "Soll gleich sein";
    }

    @Test
    public void summeTest_unerwartet() {
        Problem3 problem3 = new Problem3();
        int[] zahl1 = new int[]{1, 3, 0, 0, 0, 0, 0, 0, 1};
        int[] zahl2 = new int[]{8, 7, 0, 0, 0, 0, 0};
        int[] result = problem3.summe(zahl1, zahl2);
        assert result == null : "summeTest_unexpected ist nicht gelungen";

    }

    @Test
    public void differenzTest() {
        Problem3 problem3 = new Problem3();
        int[] zahl1 = new int[]{5, 4, 0, 0, 0, 0, 0, 0, 1};
        int[] zahl2 = new int[]{8, 3, 0, 0, 0, 0, 0, 0, 9};
        int[] differenz = new int[]{2, 9, 0, 0, 0, 0, 0, 0, 0};
        int[] result = problem3.differenz(zahl1, zahl2);
        for (int i = 0; i < differenz.length - 1; i++) {
            assert result[i] == differenz[i] : "Soll gleich sein";
        }
    }

    @Test
    public void differenzTest_unerwartet() {
        Problem3 problem3 = new Problem3();
        int[] zahl1 = new int[]{1, 3, 0, 0, 1};
        int[] zahl2 = new int[]{8, 7, 0, 0, 0, 0, 0};
        int[] result = problem3.summe(zahl1, zahl2);
        assert result == null : "differenzTest_unexpected ist nicht gelungen";

    }

    @Test
    public void multiplikationTest() {
        Problem3 problem3 = new Problem3();
        int zahl[] = new int[]{2, 3, 6, 0, 0, 0, 0, 0, 0};
        int ziffer = 2;
        int[] multiplikation = new int[]{4, 7, 2, 0, 0, 0, 0, 0, 0};
        int[] result = problem3.multiplikation(zahl, ziffer);
        for (int i = 0; i < zahl.length; i++) {
            assert result[i] == multiplikation[i] : "Soll gleich sein";
        }
    }

    @Test
    public void multiplikationTest_unerwartet() {
        Problem3 problem3 = new Problem3();
        int zahl[] = new int[]{2, 3, 6, 0, 0, 0, 0, 0, 0};
        int ziffer = 32;
        int[] result = problem3.multiplikation(zahl, ziffer);
        assert result == null : "multiplikationTest_unexpected ist nicht gelungen";

    }

    @Test
    public void divisionTest() {
        Problem3 problem3 = new Problem3();
        int zahl[] = new int[]{2, 3, 6, 0, 0, 0, 0, 0, 0};
        int dividend = 2;
        int[] division = new int[]{1, 1, 8, 0, 0, 0, 0, 0, 0};
        int[] result = problem3.division(zahl, dividend);

        assert result[0] == division[0] : "Soll gleich sein";
        assert result[1] == 1 : "Soll 1 sein";
        assert result[2] == 8 : "Soll 8 sein";
    }

    @Test
    public void divisionTest_unerwartet() {
        Problem3 problem3 = new Problem3();
        int zahl[] = new int[]{2, 3, 6, 0, 0, 0, 0, 0, 0};
        int dividend = 0;
        int[] result = problem3.division(zahl, dividend);

        assert result == null : "divisionTest_unexpected ist nicht gelungen";
    }
}
