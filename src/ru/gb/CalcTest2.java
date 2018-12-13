package ru.gb;

public class CalcTest2 {
    private static Calculator calculator;
    @BeforeSuite
    public static void init1() {
        calculator = new Calculator();
    }
    @BeforeSuite
    public static void init2() {  //проверка исключения
        calculator = new Calculator();
    }
    @Test(value = 1)
    public static boolean testAdd1() {
        return 2 == calculator.add(1,1);
    }
    @AfterSuite
    public static void close() {
        calculator = null;
    }
}
