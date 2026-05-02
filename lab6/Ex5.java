package lab6;
import java.util.concurrent.atomic.AtomicInteger;

public class Ex5 {
    public static void main(String[] args) throws InterruptedException {
        int[] array = {3, 8, 1, 9, 5, 2, 7, 6, 10, 4};
        
        int max = findMaxParallel(array);
        System.out.println("Max: " + max);
    }
    
    public static int findMaxParallel(int[] array) throws InterruptedException {
        int cores = Runtime.getRuntime().availableProcessors();
        Thread[] threads = new Thread[cores];
        int[] partialMax = new int[cores];
        
        int chunkSize = (int) Math.ceil((double) array.length / cores);
        
        for (int i = 0; i < cores; i++) {
            final int threadIndex = i;
            final int start = i * chunkSize;
            final int end = Math.min(start + chunkSize, array.length);
            
            threads[i] = new Thread(() -> {
                int max = Integer.MIN_VALUE;
                for (int j = start; j < end; j++) {
                    if (array[j] > max) {
                        max = array[j];
                    }
                }
                partialMax[threadIndex] = max;
            });
            threads[i].start();
        }
        
        for (Thread t : threads) {
            t.join();
        }
        
        int globalMax = Integer.MIN_VALUE;
        for (int max : partialMax) {
            if (max > globalMax) {
                globalMax = max;
            }
        }
        return globalMax;
    }
}
