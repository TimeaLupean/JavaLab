package test;
import main.Problem3;
import org.junit.jupiter.api.Test;
public class Problem3Test {

    @Test
    public void SummeTest() {
        Problem3 problem3 = new Problem3();
        int[] zahl1 = new int[]{1, 3, 0, 0, 0, 0, 0, 0, 1};
        int[] zahl2 = new int[]{8, 7, 0, 0, 0, 0, 0, 0, 9};
        int[] summe = new int[]{1, 0, 0, 0, 0, 0, 0, 0, 1, 0};
        int[] result = problem3.Summe(zahl1, zahl2);
        for (int i = 0; i < zahl1.length; i++) {
            assert result[i] == summe[i] : "Soll gleich sein";
        }
        assert result.length == summe.length : "Soll gleich sein";
//        assert result[0] == 2 : "Falsch-Soll 1 sein";

    }

    @Test
    public void DifferenzTest() {
        Problem3 problem3 = new Problem3();
        int[] zahl1 = new int[]{5, 4, 0, 0, 0, 0, 0, 0, 1};
        int[] zahl2 = new int[]{8, 3, 0, 0, 0, 0, 0, 0, 9};
        int[] differenz = new int[]{2, 9, 0, 0, 0, 0, 0, 0, 0};
        int[] result = problem3.Differenz(zahl1, zahl2);
        for (int i = 0; i < differenz.length-1; i++) {
            assert result[i] == differenz[i] : "Soll gleich sein";
        }
//        assert result[0] == 3 : "Falsch-Soll 2 sein";
    }

    @Test
    public void MultiplikationTest() {
        Problem3 problem3 = new Problem3();
        int zahl[] = new int[]{2, 3, 6, 0, 0, 0, 0, 0, 0};
        int ziffer = 2;
        int[] multiplikation = new int[]{4, 7, 2, 0, 0, 0, 0, 0, 0};
        int[] result = problem3.Multiplikation(zahl, ziffer);
        for (int i = 0; i < zahl.length; i++) {
            assert result[i] == multiplikation[i] : "Soll gleich sein";
        }
//        assert result[0] == 5 : "Falsch-Soll 4 sein";
    }

    @Test
    public void DivisionTest() {
        Problem3 problem3 = new Problem3();
        int zahl[] = new int[]{2, 3, 6, 0, 0, 0, 0, 0, 0};
        int ziffer = 2;
        int[] division = new int[]{1, 1, 8, 0, 0, 0, 0, 0, 0};
        int[] result = problem3.Division(zahl, ziffer);

        assert result[0] == division[0] : "Soll gleich sein";
        assert result[1] == 1 : "Soll 1 sein";
        assert result[2] == 8 : "Soll 8 sein";
//        assert result[3] == 8 : "Falsch-Soll 0 sein";

    }
}
