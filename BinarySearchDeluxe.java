import java.util.Arrays;
import java.util.Comparator;

public class BinarySearchDeluxe {

    // Returns the index of the first key in the sorted array a[]
    // that is equal to the search key, or -1 if no such key.
    public static <Key> int firstIndexOf(Key[] a, Key key, Comparator<Key> comparator) {
        // Corner cases
        if (a == null || key == null || comparator == null) throw new IllegalArgumentException("Argument is null");
        for (int i = 0; i < a.length; i++) {
            if (a[i] == null) throw new IllegalArgumentException("Key array has a null element");
        }

        // initialize lo and hi
        int lo = 0;
        int hi = a.length - 1;
        int mid;

        // binary search
        while (lo <= hi) {
            mid = (hi - lo) / 2 + lo;
            int com = comparator.compare(key, a[mid]);
            if (com < 0) {
                hi = mid - 1;
            } else if (com > 0) {
                lo = mid + 1;
            } else {
                while (mid >= 0 && comparator.compare(key, a[mid]) == 0) {
                    mid--;
                }
                return mid + 1;
            }
        }

        return -1;
    }

    // Returns the index of the last key in the sorted array a[]
    // that is equal to the search key, or -1 if no such key.
    public static <Key> int lastIndexOf(Key[] a, Key key, Comparator<Key> comparator) {
        // Corner cases
        if (a == null || key == null || comparator == null) throw new IllegalArgumentException("Argument is null");
        for (int i = 0; i < a.length; i++) {
            if (a[i] == null) throw new IllegalArgumentException("Key array has a null element");
        }

        // initialize lo and hi
        int lo = 0;
        int hi = a.length - 1;

        // binary search
        while (lo <= hi) {
            int mid = (hi - lo) / 2 + lo;
            int com = comparator.compare(key, a[mid]);
            if (com < 0) {
                hi = mid - 1;
            } else if (com > 0) {
                lo = mid + 1;
            } else {
                while (mid < a.length && comparator.compare(key, a[mid]) == 0) {
                    mid++;
                }
                return mid - 1;
            }
        }
        return -1;
    }

    // Used for Testing
    private static class IntComp implements Comparator<Integer> {
        public int compare(Integer a, Integer b) {
            return a.compareTo(b);
        }
    }

    // Used for Testing
    private static Integer[] toInteger(int[] inputInts) {
        int N = inputInts.length;
        Integer[] outputInts = new Integer[N];
        for (int i = 0; i < N; i++)
            outputInts[i] = new Integer(inputInts[i]);
        return outputInts;

    }

    // unit testing (required)
    public static void main(String[] args) {

        //Test use ints since it's easier to test (Said in the video)

        int[] someInts = {10, 10, 20, 30, 30, 30, 40, 50, 50, 70, 70, 70};
        Integer[] intObjects = toInteger(someInts);

        int[] someInts1 = {0, 10, 20, 30, 40, 50, 60, 70, 80, 90, 100, 110, 120, 130};
        Integer[] intObjects1 = toInteger(someInts1);

        Comparator<Integer> intComp = new IntComp();

        Arrays.sort(intObjects, intComp);

        int first10 = BinarySearchDeluxe.firstIndexOf(intObjects, 10, intComp);
        System.out.println("First 10 is: " + first10 + " Should be 0");
        int last10 = BinarySearchDeluxe.lastIndexOf(intObjects, 10, intComp);
        System.out.println("Last 10 is: " + last10 + " Should be 1");
        int first30 = BinarySearchDeluxe.firstIndexOf(intObjects, 30, intComp);
        System.out.println("First 30 is: " + first30 + " Should be 3");
        int last30 = BinarySearchDeluxe.lastIndexOf(intObjects, 30, intComp);
        System.out.println("Last 30 is: " + last30 + " Should be 5");
        int first70 = BinarySearchDeluxe.firstIndexOf(intObjects, 70, intComp);
        System.out.println("First 70 is: " + first70 + " Should be 9");
        int last70 = BinarySearchDeluxe.lastIndexOf(intObjects, 70, intComp);
        System.out.println("Last 70 is: " + last70 + " Should be 11");

        int last30T = BinarySearchDeluxe.lastIndexOf(intObjects1, 30, intComp);
        System.out.println("Last 30 is: " + last30T + " Should be 3");
    }

}
