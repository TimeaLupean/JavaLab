package main;

public class Problem2 {

    public int maximaleZahl(int[] zahlen) {
        for (int i = 0; i < zahlen.length; i++) {
            if (zahlen[i] < 0) {
                System.out.println("Zahlen sollen positiv sein");
                return 0;
            }
        }

        int n = zahlen.length;
        int maxim = 0;
        for (int i = 0; i < n; i++) {
            if (zahlen[i] > maxim) {
                maxim = zahlen[i];
            }
        }
        return maxim;
    }

    public int minimaleZahl(int[] zahlen) {
        for (int i = 0; i < zahlen.length; i++) {
            if (zahlen[i] < 0) {
                System.out.println("Zahlen sollen positiv sein");
                return 0;
            }
        }

        int n = zahlen.length;
        int minim = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (zahlen[i] < minim) {
                minim = zahlen[i];
            }
        }
        return minim;
    }

    public int maximaleSumme(int[] zahlen) {
        for (int i = 0; i < zahlen.length; i++) {
            if (zahlen[i] < 0) {
                System.out.println("Zahlen sollen positiv sein");
                return 0;
            }
        }

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


    public int minimaleSumme(int[] zahlen) {
        for (int i = 0; i < zahlen.length; i++) {
            if (zahlen[i] < 0) {
                System.out.println("Zahlen sollen positiv sein");
                return 0;
            }
        }

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

