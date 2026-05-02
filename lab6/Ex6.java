package lab6;

public class Ex6 {
    public static void main(String[] args) throws InterruptedException {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        
        int sum = sumParallel(array);
        System.out.println("Sum: " + sum);
    }
    
    public static int sumParallel(int[] array) throws InterruptedException {
        int cores = Runtime.getRuntime().availableProcessors();
        Thread[] threads = new Thread[cores];
        int[] partialSums = new int[cores];
        
        int chunkSize = (int) Math.ceil((double) array.length / cores);
        
        for (int i = 0; i < cores; i++) {
            final int threadIndex = i;
            final int start = i * chunkSize;
            final int end = Math.min(start + chunkSize, array.length);
            
            threads[i] = new Thread(() -> {
                int sum = 0;
                for (int j = start; j < end; j++) {
                    sum += array[j];
                }
                partialSums[threadIndex] = sum;
            });
            threads[i].start();
        }
        
        for (Thread t : threads) {
            t.join();
        }
        
        int totalSum = 0;
        for (int sum : partialSums) {
            totalSum += sum;
        }
        return totalSum;
    }
}
