package cn.jerrychen.sort;

import java.util.Arrays;

public class ShellSort {


    /*
    遍历数组，对比交换增长量h
    增长量计算公式为:h=h<length/2?h=2h+1
    结束条件为h<1
    h的减少规则是h=h/2
     */
    public static void sort(Comparable[] a) {
        int h = 1;
        int n = a.length;
        while (h < n / 2) {
            h = 2 * h + 1; //1 3 7 15
        }
        //h=1时排序完成
        while (h >= 1) {
            //找到待插入的数(h到n中间的下标)
            for (int i = h; i < n; i++) {
                //循环将待插入的数往前跟增量后的进行对比替换，直到增量的值比待插入的值小为止,j=h时循环结束
                for (int j = i; j >= h; j -= h) {
                    if (greater(a[j - h], a[j])) {
                        exch(a, j - h, j);
                    }
                }
            }
            h = h / 2;
        }
    }

    //判断是否V大于W
    private static boolean greater(Comparable v, Comparable w) {
        return v.compareTo(w) > 0;
    }

    //交换a数组中i和j的值
    private static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static void main(String[] args) {
        Integer[] a = {9, 1, 3, 4, 7, 5, 4, 7, 3, 2, 8, 7, 2, 5, 8, 4, 2, 6, 8};
        ShellSort.sort(a);
        System.out.println(Arrays.toString(a));
    }

}
