package test;

public class TestRunner {
    public static void main(String[] args) {

//Problem1
        Problem1Test problem1Test = new Problem1Test();
        problem1Test.nichtAusreichendeNotenTest();
        problem1Test.roundTest();
        problem1Test.durchschnittTest();
        problem1Test.abgerundeteNotenTest();
        problem1Test.maximaleAbgerundeteNotenTest();
        System.out.println();

//Problem2
        Problem2Test problem2Test = new Problem2Test();
        problem2Test.maximaleZahlTest();
        problem2Test.minimaleZahlTest();
        problem2Test.maximaleSummeTest();
        problem2Test.minimaleSummeTest();
        System.out.println();

//Problem3
        Problem3Test problem3Test = new Problem3Test();
        problem3Test.summeTest();
        problem3Test.differenzTest();
        problem3Test.multiplikationTest();
        problem3Test.divisionTest();
        System.out.println();

//Problem4
        Problem4Test problem4Test = new Problem4Test();
        problem4Test.billigsteTastaturTest();
        problem4Test.teuersteGegenstandTest();
        problem4Test.teuersteLaufwerkTest();
        problem4Test.geldbetragTest();


    }

}
