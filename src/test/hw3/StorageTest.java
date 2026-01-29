package test.hw3;

import main.hw3.Person;
import main.hw3.Storage;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StorageTest {

    @Test
    void addAndGetString() {
        Storage<String> storage = new Storage<>();
        storage.add("Hello");
        storage.add("World");

        assertEquals(2, storage.size(), "Storage should contain 2 elements");
        assertEquals("Hello", storage.get(0));
        assertEquals("World", storage.get(1));
    }

    @Test
    void addAndGetString1() {
        Storage<String> storage = new Storage<>();
        storage.add("Hello");
        storage.add("World");
        storage.add("There");

        assertEquals(3, storage.size(), "Storage should contain 3 elements");
        assertEquals("Hello", storage.get(0));
        assertEquals("World", storage.get(1));
        assertEquals("There", storage.get(2));
    }

    @Test
    void addAllWithStringVarargs() {
        Storage<String> storage = new Storage<>();
        storage.addAll("Java", "Kotlin", "Scala");

        assertEquals(3, storage.size(), "Storage should contain 3 elements");
        assertEquals("Java", storage.get(0));
        assertEquals("Kotlin", storage.get(1));
        assertEquals("Scala", storage.get(2));
    }

    @Test
    void addAllWithIntegerVarargs() {
        Storage<Integer> storage = new Storage<>();
        storage.addAll(10, 20, 30, 40);

        assertEquals(4, storage.size(), "Storage should contain 4 elements");
        assertEquals(10, storage.get(0));
        assertEquals(20, storage.get(1));
        assertEquals(30, storage.get(2));
        assertEquals(40, storage.get(3));
    }


    @Test
    void removeByIndexReturnsRemovedElementAndShifts() {
        Storage<String> storage = new Storage<>();
        storage.addAll("A", "B", "C", "D");

        String removed = storage.remove(1);

        assertEquals("B", removed, "Removed element should be 'B'");
        assertEquals(3, storage.size(), "Storage should contain 3 elements after removal");
        assertEquals("A", storage.get(0));
        assertEquals("C", storage.get(1));
        assertEquals("D", storage.get(2));
    }

    @Test
    void removeFirstElementShiftsAll() {
        Storage<Integer> storage = new Storage<>();
        storage.addAll(1, 2, 3);

        int removed = storage.remove(0);

        assertEquals(1, removed);
        assertEquals(2, storage.size());
        assertEquals(2, storage.get(0));
        assertEquals(3, storage.get(1));
    }

    @Test
    void getThrowsOnInvalidIndex() {
        Storage<String> storage = new Storage<>();
        storage.add("Only");

        assertThrows(IndexOutOfBoundsException.class, () -> storage.get(-1));
        assertThrows(IndexOutOfBoundsException.class, () -> storage.get(1));
    }

    @Test
    void removeThrowsOnInvalidIndex() {
        Storage<String> storage = new Storage<>();
        storage.addAll("X", "Y");

        assertThrows(IndexOutOfBoundsException.class, () -> storage.remove(-1));
        assertThrows(IndexOutOfBoundsException.class, () -> storage.remove(2));
    }

    @Test
    void toStringPrintsContents() {
        Storage<String> storage = new Storage<>();
        storage.addAll("Red", "Green", "Blue");

        String s = storage.toString();
        assertTrue(s.startsWith("["));
        assertTrue(s.endsWith("]"));
        assertTrue(s.contains("Red"));
        assertTrue(s.contains("Green"));
        assertTrue(s.contains("Blue"));
    }

    @Test
    void storageWithPersonWorks() {
        Storage<Person> people = new Storage<>();
        Person p1 = new Person("Alice", 30);
        Person p2 = new Person("Bob", 25);

        people.add(p1);
        people.add(p2);

        assertEquals(2, people.size());
        assertEquals(p1, people.get(0));
        assertEquals(p2, people.get(1));
    }

    @Test
    void storageIntegerDoesNotAcceptString_compileTime() {
        Storage<Integer> ints = new Storage<>();
        ints.add(10);
        ints.add(20);

        // ⚠ Проверка типобезопасности только на этапе компиляции:
        // раскомментируй строку ниже — и проект НЕ СКОМПИЛИРУЕТСЯ
        //
        // ints.add("Hello");
        //
        assertEquals(2, ints.size());
        assertEquals(10, ints.get(0));
        assertEquals(20, ints.get(1));
    }

    @Test
    void addAllWorksForPersonVarargs() {
        Storage<Person> people = new Storage<>();
        Person p1 = new Person("John", 40);
        Person p2 = new Person("Jane", 35);

        people.addAll(p1, p2);

        assertEquals(2, people.size());
        assertEquals(p1, people.get(0));
        assertEquals(p2, people.get(1));
    }
}