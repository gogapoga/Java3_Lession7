package ru.gb;

public class CalcTest3 {
    private static Calculator calculator;
    @BeforeSuite
    public static void init() {
        calculator = new Calculator();
    }
    @Test(value = 1)
    public static boolean testAdd1() {
        return 2 == calculator.add(1,1);
    }
    @AfterSuite
    public static void close1() {
        calculator = null;
    }
    @AfterSuite
    public static void close2() { //проверка исключения
        calculator = null;
    }
}
