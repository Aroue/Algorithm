package Sort;

import java.io.File;

import static FileUtil.ReadFileToArray.ReadFile;
import static java.lang.System.currentTimeMillis;

public class MergeSort {
    private static Comparable[] data;

    public static void main(String[] args) {
        File file = new File("data.txt");
        data = ReadFile(file);
        MergeSort mergeSort = new MergeSort();
    }

    // 归并排序
    private MergeSort() {
        int i = 0;
        int mid = data.length / 2 - 1;
        int j = mid + 1;
        int[] temp = new int[data.length];


        long start = currentTimeMillis();
        System.arraycopy(data, 0, temp, 0, data.length);

        for (int k = 0;k < data.length;k++) {
            if (i > mid)
                data[k] = temp[j++];
            else if (j >= data.length)
                data[k] = temp[i++];
            else if (temp[i] > temp[j])
                data[k] = temp[j++];
            else
                data[k] = temp[i++];

        }

        long end = currentTimeMillis();
        for (Comparable intNumber: data) {
            System.out.print(intNumber + " ");
        }
        System.out.println();
        System.out.println(end - start + " ms");


    }
}
