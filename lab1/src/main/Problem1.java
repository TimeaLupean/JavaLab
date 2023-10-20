package main;

public class Problem1 {

    public int[] nichtAusreichendeNoten(int[] note) {

        for (int i = 0; i < note.length; i++) {
            if (note[i] < 0 || note[i] > 100) {
                System.out.println("Noten soll zwischen 0 und 100 sein.");
                return null;
            }
        }
        int ct = 0;

        for (int i = 0; i < note.length; i++) {
            if (round(note[i]) < 40) {
                ct++;
            }
        }
        int[] nicht_ausreichende_noten = new int[ct];
        int index = 0;

        for (int i = 0; i < note.length; i++) {
            if (round(note[i]) < 40) {
                nicht_ausreichende_noten[index] = round(note[i]);
                index++;
            }
        }

        return nicht_ausreichende_noten;
    }


    public int round(int note) {
        if (note < 38) {
            return note;
        } else {
            if (note % 5 > 2) {
                return note + 5 - note % 5;
            } else {
                return note;
            }
        }
    }

    public int[] addToArray(int[] original, int newElement) {
        int[] result = new int[original.length + 1];
        for (int i = 0; i < original.length; i++) {
            result[i] = original[i];
        }
        result[original.length] = newElement;
        return result;
    }


    public int durchschnittnitt(int[] note) {
        for (int i = 0; i < note.length; i++) {
            if (note[i] < 0 || note[i] > 100) {
                System.out.println("Noten soll zwischen 0 und 100 sein.");
                return 0;

            }
        }

        int noten_durchschnitt = 0;
        for (int i = 0; i < note.length; i++) {
            noten_durchschnitt = noten_durchschnitt + round(note[i]);
        }
        noten_durchschnitt = noten_durchschnitt / note.length;
        return noten_durchschnitt;
    }

    public int[] abgerundeteNoten(int[] noten) {

        for (int i = 0; i < noten.length; i++) {
            if (noten[i] < 0 || noten[i] > 100) {
                System.out.println("Noten soll zwischen 0 und 100 sein.");
                return null;
            }
        }

        int[] abgerundete_noten = new int[noten.length];
        for (int i = 0; i < noten.length; i++) {
            abgerundete_noten[i] = round(noten[i]);
        }
        return abgerundete_noten;
    }

    public int maximaleAbgerundeteNote(int[] noten) {
        int maximale_abgerundete_note = 0;
        for (int i = 0; i < noten.length; i++) {
            if (round(noten[i]) != noten[i] && round(noten[i]) > maximale_abgerundete_note)
                maximale_abgerundete_note = round(noten[i]);
        }
        return maximale_abgerundete_note;
    }


}

