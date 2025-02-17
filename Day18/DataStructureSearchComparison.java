//6.


import java.util.*;

class DataStructureSearchComparison {
    static boolean searchInArray(int[] arr, int target) {
        for (int num : arr) {
            if (num == target) return true;
        }
        return false;
    }

    static boolean searchInHashSet(HashSet<Integer> set, int target) {
        return set.contains(target);
    }

    static boolean searchInTreeSet(TreeSet<Integer> set, int target) {
        return set.contains(target);
    }

    static long measureTime(Runnable function) {
        long startTime = System.nanoTime();
        function.run();
        return (System.nanoTime() - startTime) / 1000000;
    }

    public static void main(String[] args) {
        int[] datasetSizes = {1000, 100000, 1000000};
        Random rand = new Random();
        for (int size : datasetSizes) {
            int[] arr = rand.ints(size, 0, size * 10).toArray();
            HashSet<Integer> hashSet = new HashSet<>();
            TreeSet<Integer> treeSet = new TreeSet<>();
            for (int num : arr) {
                hashSet.add(num);
                treeSet.add(num);
            }
            int target = arr[rand.nextInt(size)];
            long arrayTime = measureTime(() -> searchInArray(arr, target));
            long hashSetTime = measureTime(() -> searchInHashSet(hashSet, target));
            long treeSetTime = measureTime(() -> searchInTreeSet(treeSet, target));
            System.out.println("Dataset Size: " + size);
            System.out.println("Array Search Time: " + arrayTime + " ms");
            System.out.println("HashSet Search Time: " + hashSetTime + " ms");
            System.out.println("TreeSet Search Time: " + treeSetTime + " ms");
            System.out.println("-".repeat(40));
        }
    }
}
