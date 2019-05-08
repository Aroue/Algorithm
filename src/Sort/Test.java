package Sort;

import java.io.File;

import static FileUtil.ReadFileToArray.ReadFile;
import static java.lang.System.currentTimeMillis;

public class Test {

    public static void main(String[] args) {
        File file = new File("data.txt");
        Comparable[] a = ReadFile(file);
        long startTime = currentTimeMillis();
        QuickSort.sort(a);
        HeapSort heapSort = new HeapSort();
        heapSort.sort(a);
        long endTime = currentTimeMillis();
        for (Comparable intNumber: a) {
            System.out.print(intNumber + " ");
        }
        System.out.println();
        System.out.println(endTime - startTime + " ms");
    }
}
