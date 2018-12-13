package ru.gb;

public class Main {

    public static void main(String[] args) {
	    Tester.start("ru.gb.CalcTest1");
	    try {
             Tester.start("ru.gb.CalcTest2");
        } catch (RuntimeException e) {
	        e.printStackTrace();
        }
        try {
             Tester.start("ru.gb.CalcTest3");
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
        Tester.start("ru.gb.CalcTest4");
    }
}
