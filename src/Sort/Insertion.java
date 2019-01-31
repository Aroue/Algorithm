package Sort;


import java.io.File;

import static FileUtil.ReadFileToArray.ReadFile;
import static java.lang.System.currentTimeMillis;

public class Insertion extends Sort {

    // 将data[]按升序排列
    private void sort(Comparable[] data) {
        int N = data.length;
        for (int i = 1; i < N; i++)
        {
            for (int j = i; j > 0 && less(data[j], data[j-1]); j--)
                exch(data, j, j-1);
        }
    }

    public static void main(String[] args) {
        File file = new File("data.txt");
        Comparable[] data = ReadFile(file);
        long start = currentTimeMillis();
        Insertion insertion = new Insertion();
        insertion.sort(data);
        long end = currentTimeMillis();
        for (Comparable intNumber: data) {
            System.out.print(intNumber + " ");
        }
        System.out.println();
        System.out.println(end - start + " ms");
    }

}
