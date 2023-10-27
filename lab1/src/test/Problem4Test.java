package test;

import main.Problem4;
import org.junit.jupiter.api.Test;

public class Problem4Test {

    @Test
    public void billigsteTastaturTest() {
        Problem4 problem4 = new Problem4();
        int[] tastatur_preise = new int[]{40, 35, 70, 15, 45};
        assert problem4.billigsteTastatur(tastatur_preise) == 15 : "Soll 15 sein";
    }

    @Test
    public void billigsteTastaturTest_unerwartet() {
        Problem4 problem4 = new Problem4();
        int[] tastatur_preise = new int[]{40, -35, 70, 15, 45};
        int result = problem4.billigsteTastatur(tastatur_preise);
        assert result == 0 : "billigsteTastaturTest_unerwartet ist nicht gelungen";
    }


    @Test
    public void teuersteGegenstandTest() {
        Problem4 problem4 = new Problem4();
        int[] tastatur_preise = new int[]{40, 35, 70, 15, 45};
        int[] USB_preise = new int[]{20, 15, 40, 15};
        assert problem4.teuersteGegenstand(tastatur_preise, USB_preise) == 70 : "Soll 70 sein";

    }

    @Test
    public void teuersteGegenstandTest_unerwartet() {
        Problem4 problem4 = new Problem4();
        int[] tastatur_preise = new int[]{40, 35, -70, 15, 45};
        int[] USB_preise = new int[]{20, -15, 40, 15};
        int result = problem4.teuersteGegenstand(tastatur_preise, USB_preise);
        assert result == 0 : "teuersteGegenstandTest_unerwartet ist nicht gelungen";

    }


    @Test
    public void teuersteLaufwerkTest() {
        Problem4 problem4 = new Problem4();
        int[] USB_preise = new int[]{21, 13, 40, 11, 65};
        int budget = 60;
        assert problem4.teuersteLaufwerk(USB_preise, budget) == 40 : "Soll 40 sein";
    }

    @Test
    public void teuersteLaufwerkTest_unerwartet() {
        Problem4 problem4 = new Problem4();
        int[] USB_preise = new int[]{21, 13, 40, 11, 65};
        int budget = 10;
        int result = problem4.teuersteLaufwerk(USB_preise, budget);
        assert result == 0 : "teuersteLaufwerkTest_unerwartet ist nicht gelungen";
    }

    @Test
    public void geldbetragTest() {
        Problem4 problem4 = new Problem4();
        int[] tastatur_preise = new int[]{40, 50, 60};
        int[] USB_preise = new int[]{8, 12};
        int budget = 60;
        assert problem4.geldbetrag(tastatur_preise, USB_preise, budget) == 58 : "Soll 58 sein";
    }

    @Test
    public void geldbetragTest_unerwartet() {
        Problem4 problem4 = new Problem4();
        int[] tastatur_preise = new int[]{40, 50, 60};
        int[] USB_preise = new int[]{8, 12};
        int budget = 20;
        int result = problem4.geldbetrag(tastatur_preise, USB_preise, budget);
        assert result == -1 : "geldbetragTest_unerwartet ist nicht gelungen";
    }

}
