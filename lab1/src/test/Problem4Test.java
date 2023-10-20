package test;
import main.Problem4;
import org.junit.jupiter.api.Test;

public class Problem4Test {

    @Test
    public void billigsteTastaturTest() {
        Problem4 problem4 = new Problem4();
        int[] tastatur_preise = new int[]{40, 35, 70, 15, 45};
        assert problem4.billigsteTastatur(tastatur_preise) == 15 : "Soll 15 sein";
//        assert problem4.billigsteTastatur(tastatur_preise) == 35 : "Falsch-Soll 15 sein";
    }

    @Test
    public void teuersteGegenstandTest() {
        Problem4 problem4 = new Problem4();
        int[] tastatur_preise = new int[]{40, 35, 70, 15, 45};
        int[] USB_preise = new int[]{20, 15, 40, 15};
        assert problem4.teuersteGegenstand(tastatur_preise, USB_preise) == 70 : "Soll 70 sein";
//        assert problem4.teuersteGegenstand(tastatur_preise, USB_preise) == 35 : "Falsch-Soll 70 sein";
    }

    @Test
    public void teuersteLaufwerkTest() {
        Problem4 problem4 = new Problem4();
        int[] USB_preise = new int[]{21, 13, 40, 11, 65};
        int budget = 60;

        assert problem4.teuersteLaufwerk(USB_preise, budget) == 40 : "Soll 40 sein";
//        assert problem4.teuersteLaufwerk(USB_preise, budget) == 65 : "Falsch-Soll 40 sein,denn Budget ist 60";
    }

    @Test
    public void geldbetragTest() {
        Problem4 problem4 = new Problem4();
        int[] tastatur_preise = new int[]{40, 50, 60};
        int[] USB_preise = new int[]{8, 12};
        int budget = 60;
        assert problem4.geldbetrag(tastatur_preise, USB_preise, budget) == 58 : "Soll 58 sein";
        assert problem4.geldbetrag(new int[]{50}, new int[]{25}, budget) == -1 : "Soll -1 sein,denn Summe is grosser als Budget";
//        assert problem4.geldbetrag(tastatur_preise, USB_preise, budget) == 65 : "Falsch-Soll 58 sein";
    }

}
