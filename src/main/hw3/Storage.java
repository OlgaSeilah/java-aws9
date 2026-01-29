package main.hw3;

import java.util.Arrays;

public class Storage<T> {
    @SuppressWarnings("unchecked")
    private T[] data = (T[]) new Object[10];
    private int size = 0; // count of elements

    public void add(T value) {
        if(value == null){
            return;
        }
        if (size == data.length) {
            data = Arrays.copyOf(data, data.length * 2);
        }
        data[size++] = value;
    }

    public void addAll(T... elements) {
        for (T element : elements) {
            add(element);
        }
    }

    public T get(int index) {
        if (index >= 0 && index < size) {
            return data[index];
        } else {
            throw new IndexOutOfBoundsException("illegal argument: index is out of bounds");
        }
    }

    public T remove(int index) {

        if (index < 0 || index >= size) {

            throw new IndexOutOfBoundsException("illegal argument: index is out of bounds");
        }
        T removed = data[index];
        System.arraycopy(data, index + 1, data, index, data.length - index - 1);
        size--;
        System.out.println(Arrays.toString(data));

        return removed;
    }

    public int size() {

        return size;
    }

    @Override
    public String toString() {
        if (data == null || data.length == 0) {
            return "[]";
        }
        for (int i = 0; i < data.length; i++) {
            if (data[i] == null) {
                continue;
            }
        }


        return Arrays.toString(data);
    }
}
