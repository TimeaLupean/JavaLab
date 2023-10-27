package main;

public class Problem3 {
    public int[] summe(int[] zahl1, int[] zahl2) {
        if (zahl1.length != zahl2.length) {
            System.out.println("Die Zahlen haben eine verschiedene Anzahl von Ziffern");
            return null;
        }
        int[] summe = new int[zahl1.length];
        int ziffer_summe;
        int geht_weiter = 0;
        for (int i = zahl1.length - 1; i >= 0; i--) {
            ziffer_summe = zahl1[i] + zahl2[i] + geht_weiter;
            summe[i] = ziffer_summe % 10;
            geht_weiter = ziffer_summe / 10;

        }
        if (geht_weiter > 0) {
            int[] erweiterte_summe = new int[zahl1.length + 1];
            for (int i = summe.length - 1; i >= 0; i--) {
                erweiterte_summe[i + 1] = summe[i];
            }
            erweiterte_summe[0] = geht_weiter;
            return erweiterte_summe;
        }

        return summe;
    }

    public int[] differenz(int[] zahl1, int[] zahl2) {
        if (zahl1.length != zahl2.length) {
            System.out.println("Die Zahlen haben eine verschiedene Anzahl von Ziffern");
            return null;
        }
        int[] differenz = new int[zahl1.length];
        int borgen = 0;
        int ziffer_differenz;

        int index = 0;
        int ct = 0;
        while (zahl1[index] == zahl2[index]) {
            index++;
            ct++;
        }

        for (int i = zahl1.length - 1; i >= 0; i--) {
            if (zahl1[ct] > zahl2[ct]) {
                ziffer_differenz = zahl1[i] - zahl2[i] - borgen;
            } else
                ziffer_differenz = zahl2[i] - zahl1[i] - borgen;
            if (ziffer_differenz < 0) {
                ziffer_differenz += 10;
                borgen = 1;
            } else
                borgen = 0;
            differenz[i] = ziffer_differenz;
        }

        return differenz;
    }

    public int[] multiplikation(int[] zahl, int ziffer) {
        if (ziffer > 9) {
            System.out.println("Zahl soll nur eine Ziffer haben");
            return null;
        }


        int geht_weiter = 0;
        int[] multiplikation = new int[zahl.length];
        int ziffer_multiplikation = 0;

        for (int i = zahl.length - 1; i >= 0; i--) {
            ziffer_multiplikation = zahl[i] * ziffer + geht_weiter;
            multiplikation[i] = ziffer_multiplikation % 10;
            geht_weiter = ziffer_multiplikation / 10;
        }
        if (geht_weiter > 0) {
            int[] erweiterte_multiplikation = new int[zahl.length + 1];

            for (int i = multiplikation.length - 1; i >= 0; i--) {
                erweiterte_multiplikation[i + 1] = multiplikation[i];
            }
            erweiterte_multiplikation[0] = geht_weiter;
            return erweiterte_multiplikation;
        }
        return multiplikation;
    }

    public int[] division(int[] zahl, int ziffer) {
        if(ziffer==0){
            System.out.println("Divisor darf nicht null sein");
        }
        int[] division = new int[zahl.length];
        int bleibt = 0;
        int dividend = 0;

        if (ziffer == 0)
            return null;

        for (int i = 0; i < zahl.length; i++) {
            dividend = bleibt * 10 + zahl[i];
            division[i] = dividend / ziffer;
            bleibt = dividend % ziffer;
        }

        return division;
    }
}
