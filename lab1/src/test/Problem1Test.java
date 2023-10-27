package test;

import main.Problem1;
import org.junit.jupiter.api.Test;

public class Problem1Test {

    @Test
    public void nichtAusreichendeNotenTest() {
        Problem1 problem1 = new Problem1();
        int[] noten = new int[]{12, 27, 45, 89, 66, 100, 73, 92, 34, 22};
        int[] nichtAusreichendeNoten = new int[]{12, 27, 34, 22};
        int[] result = problem1.nichtAusreichendeNoten(noten);
        assert result[0] == nichtAusreichendeNoten[0] : "Soll gleich sein";
        assert result[result.length - 1] == nichtAusreichendeNoten[nichtAusreichendeNoten.length - 1] : "Soll gleich sein";
        assert result[1] == 27 : "Soll 27 sein";

    }

    @Test
    public void nichtAusreichendeNotenTest_unerwartet() {
        Problem1 problem1 = new Problem1();
        int[] noten = new int[]{12, 27, 45, 89, -66, 100, 73, 92, -34, 22};
        int[] result = problem1.nichtAusreichendeNoten(noten);
        assert result == null : "nichtAusreichendeNotenTest_unerwartet ist nicht gelungen";

    }


    @Test
    public void roundTest() {
        Problem1 problem1 = new Problem1();
        int[] noten = new int[]{12, 27, 45, 89, 66, 100, 73, 92, 34, 22};
        int[] gerundeteNoten = new int[noten.length];
        for (int i = 0; i < noten.length; i++) {
            gerundeteNoten[i] = problem1.round(noten[i]);
        }
        assert gerundeteNoten[0] == 12 : "Soll 12 sein";
        assert gerundeteNoten[3] == 90 : "Soll 90 sein";
        assert gerundeteNoten[5] == 100 : "Soll 100 sein";
    }


    @Test
    public void addToArrayTest() {
        Problem1 problem1 = new Problem1();
        int[] noten = new int[]{10, 20, 30};
        int newElement = 50;
        int[] result = problem1.addToArray(noten, newElement);
        assert noten[0] == result[0] : "Soll gleich sein";
        assert noten[2] == result[2] : "Soll gleich sein";
        assert result[3] == newElement : "Soll gleich sein";
    }

    @Test
    public void durchschnittTest() {
        Problem1 problem1 = new Problem1();
        int[] noten = new int[]{12, 27, 45, 89, 66, 100, 73, 92, 34, 22};
        assert problem1.durchschnittnitt(noten) == 56 : "Soll 56 sein";
        assert problem1.durchschnittnitt(new int[]{42, 73}) == 58 : "Soll 58 sein";
        assert problem1.durchschnittnitt(new int[]{66}) == 66 : "Soll 66 sein";
    }

    @Test
    public void durchschnittTest_unexpected() {
        Problem1 problem1 = new Problem1();
        int[] noten = new int[]{12, 27, 45, 89, -66, 100, 73, 92, 34, -22};
        int result = problem1.durchschnittnitt(noten);
        assert result == 0 : "durchschnittTest_unexpected ist nicht gelungen";
    }


    @Test
    public void abgerundeteNotenTest() {
        Problem1 problem1 = new Problem1();
        int[] noten = new int[]{12, 27, 45, 89, 66, 100, 73, 92, 34, 22};
        int[] abgerundete_noten = new int[]{12, 27, 45, 90, 66, 100, 75, 92, 34, 22};
        int[] result = problem1.abgerundeteNoten(noten);
        assert abgerundete_noten[0] == result[0] : "Soll gleich sein";
        assert abgerundete_noten[3] == result[3] : "Soll gleich sein";
        assert abgerundete_noten[5] == result[5] : "Soll gleich sein";
        assert result[6] == 75 : "Soll 75 sein";
    }

    @Test
    public void abgerundeteNotenTest_unerwartet() {
        Problem1 problem1 = new Problem1();
        int[] noten = new int[]{12, 27, 45, -89, 66, 100, 73, 92, -34, 22};
        int[] result = problem1.abgerundeteNoten(noten);
        assert result == null : "abgerundeteNotenTest_unerwartet ist nicht gelungen";
    }

    @Test
    public void maximaleAbgerundeteNotenTest() {
        Problem1 problem1 = new Problem1();
        int[] noten = new int[]{12, 27, 45, 89, 66, 100, 73, 92, 34, 22};
        assert problem1.maximaleAbgerundeteNote(noten) == 90 : "Soll 90 sein";
        assert problem1.maximaleAbgerundeteNote(noten) == problem1.round(89) : "Soll gleich sein";
    }

    @Test
    public void maximaleAbgerundeteNotenTest_unerwartet() {
        Problem1 problem1 = new Problem1();
        int[] noten = new int[]{12, 27, 45, 89, 66, -100, 73, 92, 34, -22};
        int result = problem1.maximaleAbgerundeteNote(noten);
        assert result == 0 : "maximaleAbgerundeteNotenTest_unerwartet failed";
    }


}
