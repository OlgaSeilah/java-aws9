package main;

public class HW2 {
    /**
     * Задание 2 *
     * Определи, какой перегруженный метод будет вызван:
     * public static void test(int a, int... b)
     * public static void test(int... a)
     * public static void test(Integer... a)
     * public static void test(Object... a)
     * И объясни, почему компилятор выбирает именно его.
     */

    /*
    зависит от того, что будет передано в метод
    всегда будет вызван наиболее "подходящий" вариант метода.
    если метод вызван с 2мя параметрами типа int - public static void test(int a, int... b)
    и если аргументов больше 2, и это int, то тоже public static void test(int a, int... b) - так как
    первый int пойдет в  параметр а, а все последующие int - в массив аргументов int... b
    если сбез аргументов - public static void test(int... a)
    если переданы Integer'ы - public static void test(Integer... a)
    если не int / Integer - public static void test(Object... a)
    JVM самостоятельно автоматически вызывает то, что более близко к реализации
    тк Java - язык со строгой типизацией, она всегда "стремится" к максимальной строгости. методы с аргументами varargs
    имеют самый низкий приоритет.
     */
}
