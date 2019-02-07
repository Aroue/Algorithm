package Sort;

// 归并排序
public class Merge extends Sort {

    protected Comparable[] aux;

    // 归并排序
    private void MergeSort(Comparable[] a, int lo, int mid, int hi) {

        // 将a[lo..mid] 和 a[mid+1..hi] 归并
        int i = lo, j = mid + 1;

        for (int k = lo; k <= hi; k++) // 将a[lo..hi]复制到aux[lo..hi]
            aux[k] = a[k];
        for (int k = lo; k <= hi; k++) {// 归并回到a[lo..hi]
            if (i > mid)
                a[k] = aux[j++];
            else if (j > hi)
                a[k] = aux[i++];
            else if
                    (less(aux[j], aux[i])) a[k] = aux[j++];
            else
                a[k] = aux[i++];
        }


    }
}
