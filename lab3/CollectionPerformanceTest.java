package lab3;

import java.util.*;

public class CollectionPerformanceTest {
    private static final int ELEMENTS_FACTOR = 12_000_00;
    private static final long ACCESS_COUNT_FACTOR = 12_000_000_00L;

    public static void main(String[] args) {
        int elements = ELEMENTS_FACTOR;
        long accessCount = ACCESS_COUNT_FACTOR;

        List<Integer> arrayList = new ArrayList<>();
        ArrayDeque<Integer> arrayDeque = new ArrayDeque<>();

        System.out.println("Filling collections with " + elements + " elements...");
        for (int i = 0; i < elements; i++) {
            arrayList.add(i);
            arrayDeque.addLast(i);
        }

        testAddToBeginning(arrayList, arrayDeque);
        testAddToEnd(arrayList, arrayDeque);
        testAddToMiddle(arrayList, arrayDeque);
        testRemoveFromBeginning(arrayList, arrayDeque);
        testRemoveFromEnd(arrayList, arrayDeque);
        testRemoveFromMiddle(arrayList, arrayDeque);
        testGetByIndex(arrayList, accessCount);
    }

    private static void testAddToBeginning(List<Integer> list, ArrayDeque<Integer> deque) {
        List<Integer> temp1 = new ArrayList<>(list);
        ArrayDeque<Integer> temp2 = new ArrayDeque<>(deque);

        long start = System.nanoTime();
        for (int i = 0; i < 10000; i++) temp1.add(0, i);
        System.out.println("Adding to beginning ArrayList: " + (System.nanoTime() - start) / 1_000_000 + " ms");

        start = System.nanoTime();
        for (int i = 0; i < 10000; i++) temp2.addFirst(i);
        System.out.println("Adding to beginning ArrayDeque: " + (System.nanoTime() - start) / 1_000_000 + " ms");
    }

    private static void testAddToEnd(List<Integer> list, ArrayDeque<Integer> deque) {
        List<Integer> temp1 = new ArrayList<>(list);
        ArrayDeque<Integer> temp2 = new ArrayDeque<>(deque);

        long start = System.nanoTime();
        for (int i = 0; i < 10000; i++) temp1.add(i);
        System.out.println("Adding to end ArrayList: " + (System.nanoTime() - start) / 1_000_000 + " ms");

        start = System.nanoTime();
        for (int i = 0; i < 10000; i++) temp2.addLast(i);
        System.out.println("Adding to end ArrayDeque: " + (System.nanoTime() - start) / 1_000_000 + " ms");
    }

    private static void testAddToMiddle(List<Integer> list, ArrayDeque<Integer> deque) {
        // ArrayList
        List<Integer> temp1 = new ArrayList<>(list);
        long start = System.nanoTime();
        for (int i = 0; i < 10000; i++) temp1.add(temp1.size()/2, i);
        System.out.println("Adding to middle ArrayList: " + (System.nanoTime() - start) / 1_000_000 + " ms");
        
        // ArrayDeque (через конвертацию)
        ArrayDeque<Integer> temp2 = new ArrayDeque<>(deque);
        start = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            List<Integer> listTemp = new ArrayList<>(temp2);
            listTemp.add(listTemp.size()/2, i);
            temp2 = new ArrayDeque<>(listTemp);
        }
        System.out.println("Adding to middle ArrayDeque: " + (System.nanoTime() - start) / 1_000_000 + " ms");
    }

    private static void testRemoveFromBeginning(List<Integer> list, ArrayDeque<Integer> deque) {
        List<Integer> temp1 = new ArrayList<>(list);
        ArrayDeque<Integer> temp2 = new ArrayDeque<>(deque);

        long start = System.nanoTime();
        for (int i = 0; i < 10000; i++) temp1.remove(0);
        System.out.println("Removing from beginning ArrayList: " + (System.nanoTime() - start) / 1_000_000 + " ms");

        start = System.nanoTime();
        for (int i = 0; i < 10000; i++) temp2.removeFirst();
        System.out.println("Removing from beginning ArrayDeque: " + (System.nanoTime() - start) / 1_000_000 + " ms");
    }

    private static void testRemoveFromEnd(List<Integer> list, ArrayDeque<Integer> deque) {
        List<Integer> temp1 = new ArrayList<>(list);
        ArrayDeque<Integer> temp2 = new ArrayDeque<>(deque);

        long start = System.nanoTime();
        for (int i = 0; i < 10000; i++) temp1.remove(temp1.size()-1);
        System.out.println("Removing from end ArrayList: " + (System.nanoTime() - start) / 1_000_000 + " ms");

        start = System.nanoTime();
        for (int i = 0; i < 10000; i++) temp2.removeLast();
        System.out.println("Removing from end ArrayDeque: " + (System.nanoTime() - start) / 1_000_000 + " ms");
    }

    private static void testRemoveFromMiddle(List<Integer> list, ArrayDeque<Integer> deque) {
        List<Integer> temp1 = new ArrayList<>(list);
        ArrayDeque<Integer> temp2 = new ArrayDeque<>(deque);

        long start = System.nanoTime();
        for (int i = 0; i < 10000; i++) temp1.remove(temp1.size()/2);
        System.out.println("Removing from middle ArrayList: " + (System.nanoTime() - start) / 1_000_000 + " ms");

        start = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            if (temp2.size() > 0) {
                int midIndex = temp2.size() / 2;
                Integer[] arr = temp2.toArray(new Integer[0]);
                temp2.remove(arr[midIndex]);
            }
        }
        System.out.println("Removing from middle ArrayDeque: " + (System.nanoTime() - start) / 1_000_000 + " ms");
    }

    private static void testGetByIndex(List<Integer> list, long accessCount) {
        long start = System.nanoTime();
        for (long i = 0; i < accessCount; i++) {
            list.get((int)(i % list.size()));
        }
        System.out.println("Getting by index ArrayList: " + (System.nanoTime() - start) / 1_000_000 + " ms");
    }
}