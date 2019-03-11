package Sort;

import static Sort.MergeSort.merge;

public class MergeBu extends Sort {
    private static Comparable[] aux; // 归并所需的辅助数组

    // 自底向上的归并排序
    static void sort(Comparable[] a) { // 进行lgN次两两归并
        int N = a.length;
        aux = new Comparable[N];
        for (int sz = 1; sz < N; sz = sz + sz)// sz子数组大小
            for (int lo = 0; lo < N - sz; lo += sz + sz) // lo:子数组索引
                merge(a, lo, lo + sz - 1, Math.min(lo + sz + sz - 1, N - 1));

    }

}
