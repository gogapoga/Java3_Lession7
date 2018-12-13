package ru.gb;

public class CalcTest1 {
    private static Calculator calculator;
    @BeforeSuite
    public static void init() {
        calculator = new Calculator();
    }
    @Test(value = 1)
    public static boolean testAdd1() {
        return 2 == calculator.add(1,1);
    }
    @Test(value = 2)
    public static boolean testAdd2() {
        return 4 == calculator.add(2,2);
    }
    @Test(value = 3)
    public static boolean testAdd3() {
        return 8 == calculator.add(3,5);
    }
    @Test(value = 3)
    public static boolean testAdd4() {
        return 10 == calculator.add(6,4);
    }
    @Test(value = 4)
    public static boolean testSub1() {
        return 0 == calculator.sub(1,1);
    }
    @Test(value = 5)
    public static boolean testSub2() {
        return 5 == calculator.sub(6,1);
    }
    @Test(value = 6)
    public static boolean testMul1() {
        return 9 == calculator.mul(3,3);
    }
    @Test(value = 7)
    public static boolean testMul2() {
        return 8 == calculator.mul(4,2);
    }
    @Test(value = 8)
    public static boolean testDiv1() {
        return 6 == calculator.div(12,2);
    }
    @Test(value = 9)
    public static boolean testDiv2() {
        return 3 == calculator.div(12,4);
    }
    @Test(value = 10)
    public static boolean testDiv3() {
        return 5 == calculator.div(15,3);
    }
    @Test(value = 1)
    public static boolean testDiv4() { //проверка очередности
        try {
            calculator.div(15,0);
            return false;
        } catch (Exception e) {
            if (e.getClass() == ArithmeticException.class) return true; //проверка исключения
            else return false;
        }
    }
    @AfterSuite
    public static void close() {
        calculator = null;
    }
}
