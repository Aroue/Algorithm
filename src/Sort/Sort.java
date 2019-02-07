package Sort;

// 排序算法抽象类
public abstract class Sort<T extends Comparable<T>> {
    // 返回两个数中较小的数
    boolean less(Comparable v, Comparable w)
    {  return v.compareTo(w) < 0;  }
    // 交换数组中的两个元素
    void exch(Comparable[] a, int i, int j)
    {  Comparable t = a[i]; a[i] = a[j]; a[j] = t;  }
    // 在单行中打印数组
    public  void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++)
            System.out.print(a[i] + " ");
        System.out.println();
    }
    // 测试数组元素是否有序
    public  boolean isSorted(Comparable[] a) {
        for (int i = 1; i < a.length; i++)
            if (less(a[i], a[i-1]))  return false;
        return true;
    }
}
