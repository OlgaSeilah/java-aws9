package main;

public class VarargUtils {

    /****
     * находит максимальное значение,
     * выбрасывает IllegalArgumentException, если передано 0 аргументов,
     * принимает как отдельные числа, так и массив:
     */
    public static int max(int... values){
        if (values == null || values.length == 0) {
            throw new IllegalArgumentException("illegal argument: values is null or empty");
        }

        int max = values[0];
        for (int i = 1; i < values.length; i++) {
            if(values[i] > max){
                max = values[i];
            }
        }

        return max;
    }
}
