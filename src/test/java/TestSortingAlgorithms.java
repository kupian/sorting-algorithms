import com.algorithms.*;
import org.junit.jupiter.api.Test;
import com.util.CreateArrayFromFile;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The TestSortingAlgorithms class provides methods to test the functionality
 * of various sorting algorithms, including the use of external files to generate
 * data for testing. It ensures that the sorted arrays adhere to the correct ordering.
 */
public class TestSortingAlgorithms {

    private final int[] testArray;

    public TestSortingAlgorithms() {
        testArray = CreateArrayFromFile.CreateIntArrayFromFile("int1000.txt");
    }

    private static boolean TestIntArrayAscends(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[i-1]) {
                return false;
            }
        }
        return true;
    }

    private static boolean TestIntArrayDescends(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[i - 1]) {
                return false;
            }
        }
        return true;
    }

    private static boolean TestAlgorithm(SortingAlgorithm alg, int[] A) {
        return TestIntArrayAscends(alg.sort(A));
    }

    @Test
    public void TestInsertionSort() {
        SortingAlgorithm alg = new InsertionSort();
        assertTrue(TestAlgorithm(alg, testArray));
    }

    @Test
    public void TestMergeSort() {
        SortingAlgorithm alg = new MergeSort();
        assertTrue(TestAlgorithm(alg, testArray));
    }

    @Test
    public void TestHybridMergeSort() {
        SortingAlgorithm alg = new HybridMergeSort();
        assertTrue(TestAlgorithm(alg, testArray));
    }

    @Test
    public void TestIterativeMergeSort() {
        SortingAlgorithm alg = new IterativeMergeSort();
        assertTrue(TestAlgorithm(alg, testArray));
    }

    @Test
    public void TestSelectionSort() {
        SortingAlgorithm alg = new SelectionSort();
        assertTrue(TestAlgorithm(alg, testArray));
    }

    @Test
    public void TestQuickSort() {
        SortingAlgorithm alg = new Quicksort();
        assertTrue(TestAlgorithm(alg, testArray));
    }

    @Test
    public void TestMedianQuickSort() {
        SortingAlgorithm alg = new MedianOfThreeQuicksort();
        assertTrue(TestAlgorithm(alg, testArray));
    }

    @Test
    public void TestDutchFlagQuicksort() {
        SortingAlgorithm alg = new DutchFlagQuicksort();
        assertTrue(TestAlgorithm(alg, testArray));
    }

    @Test
    public void TestHybridQuicksort() {
        SortingAlgorithm alg = new HybridQuicksort();
        assertTrue(TestAlgorithm(alg, testArray));
    }

    @Test
    public void TestShellSort() {
        SortingAlgorithm alg = new Shellsort();
        assertTrue(TestAlgorithm(alg, testArray));
    }

}
