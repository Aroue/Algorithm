package Sort;

import java.io.File;

import static FileUtil.ReadFileToArray.ReadFile;
import static java.lang.System.currentTimeMillis;


// 希尔排序
public class ShellSort extends Sort{

    // 将data[]按升序排列
    public void sort(Comparable[] data) {
        int N = data.length;
        int h = 1;
        while (h < N/3)
            h = 3 * h + 1; // 1, 4, 13, 40, 121, 364, 1093, ...
        while (h >= 1)
        {
            // 将数组变为h有序
            for (int i = h; i < N; i++)
            {
                // 将data[i]插入到data[i-h], data[i-2*h], data[i-3*h]... 之中
                for (int j = i; j >= h && less(data[j], data[j-h]); j -= h)
                    exch(data, j, j-h);
            }

            h = h/3;
        }
    }

    public static void main(String[] args) {
        File file = new File("data.txt");
        Comparable[] data = ReadFile(file);
        long start = currentTimeMillis();
        ShellSort shellSort = new ShellSort();
        shellSort.sort(data);
        long end = currentTimeMillis();
        for (Comparable intNumber: data) {
            System.out.print(intNumber + " ");
        }
        System.out.println();
        System.out.println(end - start + " ms");
    }
}
