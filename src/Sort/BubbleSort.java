package Sort;

import java.io.File;

import static FileUtil.ReadFileToArray.ReadFile;
import static java.lang.System.currentTimeMillis;

// 冒泡排序
public class BubbleSort extends Sort {

    private static Comparable[] data;

    private void sort() {
        int N = data.length;
        boolean isSorted = false;
        for (int i = 0; i < N - 1 && !isSorted ;i++) {
            isSorted = true;
            for (int j = 0;j < N - 1 - i ;j++){
                if (less(data[j + 1], data[j])) {
                    isSorted = false;
                    exch(data,j + 1,j);
                }
            }
        }
    }

    public static void main(String[] args) {
        File file = new File("data.txt");
        data = ReadFile(file);
        long start = currentTimeMillis();
        BubbleSort bubbleSort = new BubbleSort();
        bubbleSort.sort();
        long end = currentTimeMillis();
        for (Comparable intNumber: data) {
            System.out.print(intNumber + " ");
        }
        System.out.println();
        System.out.println(end - start + " ms");
    }


}
