package ru.gb;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class Tester {
    public static void start(String className) {
        Class cl = null;
        Method methodBefore = null;
        Method methodAfter = null;
        ArrayList<Method> methodsTest = new ArrayList<Method>();
        try { //выборка нужных методов
            cl = Class.forName(className);
            Method[] methods = cl.getDeclaredMethods();
            for (Method o : methods) {
                if(o.getAnnotation(BeforeSuite.class) != null) { //поиск метода BeforeSuite
                    if(methodBefore == null) methodBefore = o;
                    else throw new RuntimeException();
                }
                if(o.getAnnotation(AfterSuite.class) != null) { //поиск метода AfterSuite
                    if(methodAfter == null) methodAfter = o;
                    else throw new RuntimeException();
                }
                if(o.getAnnotation(Test.class) != null) { //поиск методов Test c сортировкой
                    int temp = o.getAnnotation(Test.class).value();
                    int  i = 0;
                    while(i < methodsTest.size()) {
                        if (methodsTest.get(i).getAnnotation(Test.class).value() < temp) i++;
                        else break;
                    }
                    methodsTest.add(i, o);
                }
            }
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        try { // выполнение тестов
            System.out.println("Старт набора тестов " + cl.getName() + ":");
            if (methodBefore != null) {
                methodBefore.invoke(cl);
                System.out.println("Метод " + methodBefore.getName() + " набора тестов " + cl.getName() + " выполнен!");
            }
            for(Method o : methodsTest) {
               boolean res = (boolean)o.invoke(cl);
               if (res == true) System.out.println("Тест " + o.getName() + " набора тестов " + cl.getName() + " с приоритетом " + o.getAnnotation(Test.class).value() + " выполнен положительно!");
               else System.out.println("Тест " + o.getName() + " выполнен отрицательно!");
            }
            if (methodBefore != null) {
                methodBefore.invoke(cl);
                System.out.println("Метод " + methodAfter.getName() + " набора тестов " + cl.getName() + " выполнен!");
            }
            System.out.println("Набор тестов " + cl.getName() + " завершен.");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e){
            e.printStackTrace();
        }
    }
}
