package test;

public class TestRunner {
    public static void main(String[] args) {

//Problem1
        Problem1Test problem1Test = new Problem1Test();
        problem1Test.nichtAusreichendeNotenTest();
        problem1Test.roundTest();
        problem1Test.durchschnittTest();
        problem1Test.abgerundeteNotenTest();
        problem1Test.maximalebgerundeteNotenTest();
        System.out.println();

//Problem2
        Problem2Test problem2Test = new Problem2Test();
        problem2Test.MaximTest();
        problem2Test.MinimalTest();
        problem2Test.maxSummeTest();
        problem2Test.minSummeTest();
        System.out.println();

//Problem3
        Problem3Test problem3Test = new Problem3Test();
        problem3Test.SummeTest();
        problem3Test.DifferenzTest();
        problem3Test.MultiplikationTest();
        problem3Test.DivisionTest();
        System.out.println();

//Problem4
        Problem4Test problem4Test = new Problem4Test();
        problem4Test.billigsteTastaturTest();
        problem4Test.teuersteGegenstandTest();
        problem4Test.teuersteLaufwerkTest();
        problem4Test.geldbetragTest();


    }

}
