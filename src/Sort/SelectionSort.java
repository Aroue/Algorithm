package Sort;

import java.io.File;

import static FileUtil.ReadFileToArray.ReadFile;
import static java.lang.System.currentTimeMillis;


// 选择排序
public class SelectionSort<T extends Comparable<T>> extends Sort<T> {

    // 将data[]按升序排列
    private void sort(Comparable[] data) {
        int N = data.length; // 数组长度

        // 将data[i]和data[i+1..N]中最小的元素交换
        for (int i = 0; i < N; i++)
        {
            int min = i; // 最小元素的索引
            for (int j = i+1; j < N; j++)
                if (less(data[j], data[min])) min = j;
            exch(data, i, min);
        }
    }

    public static void main(String[] args) {
        File file = new File("data.txt");
        Comparable[] data = ReadFile(file);
        long start = currentTimeMillis();
        SelectionSort selectionSortSort = new SelectionSort();
        selectionSortSort.sort(data);
        long end = currentTimeMillis();
        for (Comparable intNumber: data) {
            System.out.print(intNumber + " ");
        }
        System.out.println();
        System.out.println(end - start + " ms");
    }

}
