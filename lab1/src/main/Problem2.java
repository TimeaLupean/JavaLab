package main;

public class Problem2 {

    public int Maxim(int[] zahlen) {
        int n = zahlen.length;
        int maxim = 0;
        for (int i = 0; i < n; i++) {
            if (zahlen[i] > maxim) {
                maxim = zahlen[i];
            }
        }
        return maxim;
    }

    public int Minim(int[] zahlen) {
        int n = zahlen.length;
        int minim = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (zahlen[i] < minim) {
                minim = zahlen[i];
            }
        }
        return minim;
    }

    public int maxSumme(int[] zahlen) {
        int n = zahlen.length;
        int minim = Integer.MAX_VALUE;
        int maxSumme = 0;
        for (int i = 0; i < n; i++) {
            maxSumme = maxSumme + zahlen[i];
        }
        for (int i = 0; i < n; i++) {
            if (zahlen[i] < minim)
                minim = zahlen[i];
        }
        maxSumme = maxSumme - minim;
        return maxSumme;
    }


    public int minSumme(int[] zahlen) {
        int n = zahlen.length;
        int maxim = 0;
        int minSumme = 0;
        for (int i = 0; i < n; i++) {
            minSumme = minSumme + zahlen[i];
        }
        for (int i = 0; i < n; i++) {
            if (zahlen[i] > maxim)
                maxim = zahlen[i];
        }
        minSumme = minSumme - maxim;
        return minSumme;
    }

}

