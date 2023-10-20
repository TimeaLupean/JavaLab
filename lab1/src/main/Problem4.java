package main;

public class Problem4 {
    public int billigsteTastatur(int[] tastaturen_preise) {
        int billigste_tastatur = Integer.MAX_VALUE;
        for (int i = 0; i < tastaturen_preise.length; i++) {
            if (tastaturen_preise[i] < billigste_tastatur)
                billigste_tastatur = tastaturen_preise[i];
        }
        return billigste_tastatur;
    }

    public int teuersteGegenstand(int[] tastaturen_preise, int[] USB_preise) {
        int teuerste_gegenstand = 0;
        for (int i = 0; i < tastaturen_preise.length; i++) {
            if (tastaturen_preise[i] > teuerste_gegenstand)
                teuerste_gegenstand = tastaturen_preise[i];
        }
        for (int i = 0; i < USB_preise.length; i++) {
            if (USB_preise[i] > teuerste_gegenstand)
                teuerste_gegenstand = USB_preise[i];
        }

        return teuerste_gegenstand;
    }

    public int teuersteLaufwerk(int[] USB_preise, int budget) {
        int teuerste_laufwerk = 0;
        for (int i = 0; i < USB_preise.length; i++) {
            if (USB_preise[i] <= budget && USB_preise[i] > teuerste_laufwerk)
                teuerste_laufwerk = USB_preise[i];
        }
        return teuerste_laufwerk;
    }

    public int geldbetrag(int[] tastatur_preise, int[] USB_preise, int budget) {
        int billigste_tastatur = Integer.MAX_VALUE;
        int billigste_USB = Integer.MAX_VALUE;
        int geld_betrag = 0;
        int max_preis = 0;
        for (int i = 0; i < tastatur_preise.length; i++) {
            if (tastatur_preise[i] < billigste_tastatur)
                billigste_tastatur = tastatur_preise[i];
        }
        for (int i = 0; i < USB_preise.length; i++) {
            if (USB_preise[i] < billigste_USB)
                billigste_USB = USB_preise[i];
        }
        if (billigste_tastatur + billigste_USB > budget)
            return -1;

        for (int i = 0; i < tastatur_preise.length; i++) {
            for (int j = 0; j < USB_preise.length; j++) {
                if (tastatur_preise[i] + USB_preise[j] > max_preis) {
                    int totaler_preis = tastatur_preise[i] + USB_preise[j];
                    if (totaler_preis <= budget && totaler_preis > geld_betrag)
                        geld_betrag = totaler_preis;
                }
            }
        }

        return geld_betrag;
    }
}
