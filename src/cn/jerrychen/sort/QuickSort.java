package cn.jerrychen.sort;

import java.util.Arrays;

public class QuickSort {
    /*
       比较v元素是否小于w元素
    */
    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    /*
    数组元素i和j交换位置
     */
    private static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    /*
    选出一个分界值，小的放在左边，大的放右边。再对分好界限的进行分界
     */
    public static void sort(Comparable[] a) {
        int lo = 0, hi = a.length - 1;
        sort(a, lo, hi);
    }

    /*
    递归数组a，选出基准数，直到只剩一个值
     */
    private static void sort(Comparable[] a, int lo, int hi) {
        //做安全性校验；
        if (hi <= lo) return;
        int mid = partition(a, lo, hi);
        sort(a, lo, mid);
        sort(a, mid + 1, hi);
    }

    /*
      对数组a中，从索引 lo到索引 hi之间的元素使用基准数进行分组，并返回分组界限对应的索引
     */
    private static int partition(Comparable[] a, int lo, int hi) {
        Comparable num = a[lo];//选左边和右边都一样，反正都是要遍历到只剩一个
        int p1 = lo, p2 = hi + 1;
        while (true) {
            while (less(a[++p1], num)) if (p1 == hi) break;
            while (less(num, a[--p2])) if (p2 == lo) break;
            if (p1 >= p2) {
                break;
            } else {
                exch(a, p1, p2);
            }
        }
        exch(a, lo, p2);
        return p2;
    }

    public static void main(String[] args) {
        Integer[] a = {5, 4, 3, 2, 1};
        // System.out.println(a[0]);
        QuickSort.sort(a);
        System.out.println(Arrays.toString(a));
    }
}
