package Sort;

// 快速排序
public class QuickSort extends Sort {

    public static void sort(Comparable[] a)
    {
        sort(a, 0, a.length - 1);
    }
    private static void sort(Comparable[] a, int lo, int hi)
    {
        if (hi <= lo) return;
        int j = partition(a, lo, hi); // 切分(请见“快速排序的切分”)
        sort(a, lo, j-1);  // 将左半部分a[lo .. j-1]排序
        sort(a, j+1, hi);  // 将右半部分a[j+1 .. hi]排序
    }
    // 快速排序的切分
    private static int partition(Comparable[] a, int lo, int hi) {
        int i = lo, j = hi + 1;
        Comparable v = a[i];
        while (true) { // 扫描左右，检查扫描是否结束并交换元素
            while (less(a[++i], v)) if (i == hi) break;
            while (less(v, a[--j])) if (j == lo) break;
            if (i >= j) break;
            exch(a, i, j);
        }
        exch(a, lo, j);
        return j;

    }
}
