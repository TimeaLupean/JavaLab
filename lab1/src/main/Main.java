package main;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

//Problem1
        Problem1 problem1 = new Problem1();
        int[] noten = new int[]{12, 27, 45, 89, 66, 100, 73, 92, 34, 22};

        int[] nicht_ausreichende_noten = problem1.nichtAusreichendeNoten(noten);
        System.out.println("Nicht ausreichende Noten: ");
        System.out.println(Arrays.toString(nicht_ausreichende_noten));
        System.out.println();

        int noten_durchschnitt = problem1.durchschnittnitt(noten);
        System.out.println("Durchschnitt: " + noten_durchschnitt);

        int[] abgerundete_noten = problem1.abgerundeteNoten(noten);
        System.out.println("Abgerundete Noten: ");
        System.out.println(Arrays.toString(abgerundete_noten));
        System.out.println();

        int maximale_abgerundete_note = problem1.maximaleAbgerundeteNote(noten);
        System.out.println("Maximale abgerundete Note:" + maximale_abgerundete_note);

        System.out.println();
        System.out.println();


//Problem 2
        Problem2 problem2 = new Problem2();
        int[] zahlen = new int[]{4, 8, 3, 10, 17};

        int max_zahl = problem2.maximaleZahl(zahlen);
        System.out.println("Maximale Zahl:" + max_zahl);

        int min_zahl = problem2.minimaleZahl(zahlen);
        System.out.println("Minimale Zahl:" + min_zahl);

        int max_summe = problem2.maximaleSumme(zahlen);
        System.out.println("Maximale Summe:" + max_summe);

        int min_summe = problem2.minimaleSumme(zahlen);
        System.out.println("Minimale Summe:" + min_summe);

        System.out.println();
        System.out.println();


//Problem3
        Problem3 problem3 = new Problem3();
        int[] zahl1 = new int[]{1, 3, 0, 0, 0, 0, 0, 0, 1};
        int[] zahl2 = new int[]{8, 7, 0, 0, 0, 0, 0, 0, 9};
        int[] zahl3 = new int[]{2, 6, 3, 0, 1, 4, 0, 0, 0};
        int[] zahl4 = new int[]{2, 6, 3, 0, 2, 3, 0, 0, 0};
        int[] zahl = new int[]{2, 3, 6, 0, 0, 0, 0, 0, 8};
        int ziffer = 2;

        int[] ziffer_summe = problem3.summe(zahl1, zahl2);
        System.out.print("Summe: ");
        System.out.println(Arrays.toString(ziffer_summe));
        System.out.println();

        int[] ziffer_differenz = problem3.differenz(zahl3, zahl4);
        System.out.println("Differenz: ");
        System.out.println(Arrays.toString(ziffer_differenz));
        System.out.println();

        int[] ziffer_multiplikation = problem3.multiplikation(zahl, ziffer);
        System.out.println("Multiplikation: ");
        System.out.println(Arrays.toString(ziffer_multiplikation));
        System.out.println();

        int[] ziffer_division = problem3.division(zahl, ziffer);
        System.out.println("Division: ");
        System.out.println(Arrays.toString(ziffer_division));
        System.out.println();

        System.out.println();
        System.out.println();


//Problem4
        Problem4 problem4 = new Problem4();
        int[] tastatur_preise = new int[]{40, 35, 70, 15, 45};
        int[] USB_preise = new int[]{21, 13, 40, 11};
        int budget = 60;

        int billigste_tastatur = problem4.billigsteTastatur(tastatur_preise);
        System.out.println("Billigste Tastatur: " + billigste_tastatur);

        int teuerste_gegenstand = problem4.teuersteGegenstand(tastatur_preise, USB_preise);
        System.out.println("Teuerste Gegenstand: " + teuerste_gegenstand);

        int teuerste_laufwerk = problem4.teuersteLaufwerk(USB_preise, budget);
        System.out.println("Teuerste Laufwerk: " + teuerste_laufwerk);

        int geld_betrag = problem4.geldbetrag(tastatur_preise, USB_preise, budget);
        System.out.println("Geldbetrag: " + geld_betrag);

    }
}