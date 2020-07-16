package cn.jerrychen.sort;

import java.util.Arrays;

/*
    想了解堆排序，首先要了解什么是堆。堆是一个完全二叉树，通常以数组的形式来表示。
    Parent(i) = floor((i-1)/2)，i 的父节点下标
    Left(i) = 2i + 1，i 的左子节点下标
    Right(i) = 2(i + 1)，i 的右子节点下标
    堆分为两种：最大堆和最小堆，两者的差别在于节点的排序方式。最大堆父节点的值比每一个子节点的值都要大，最小堆则相反。
 */
public class HeapSort {
    //将最大（最小）元素与最后的元素交换，完成排序
    void heapSort(int[] arr) {
        for (int i = arr.length; i > 0; i--) {
            buildHeap(arr, i);
            swap(arr, 0, i - 1);
        }
    }

    //将最后一个父节点依次往前面堆化，以此建立堆
    void buildHeap(int[] arr, int size) {
        int parent = ((size - 1) - 1) / 2;

        for (int i = parent; i >= 0; i--) {
            heaping(arr, size, i);
        }
    }

    //将一个节点堆化
    void heaping(int[] arr, int size, int index) {
        if (index > size) return;
        int L = 2 * index + 1, R = 2 * index + 2;
        int max = index;
        //判断左右节点和父节点哪个大，
        if (L < size && arr[L] < arr[max]) {
            max = L;
        }
        if (R < size && arr[R] < arr[max]) {
            max = R;
        }
        if (index != max) {
            swap(arr, index, max);
            heaping(arr, size, index);
        }
    }

    private void swap(int[] arr, int index, int max) {
        int temp = arr[index];
        arr[index] = arr[max];
        arr[max] = temp;
    }

    public static void main(String[] args) {
        int[] a = {12, 34, 12, 11, 10, 33};
        // System.out.println(a[0]);
        HeapSort heapSort = new HeapSort();
        heapSort.heapSort(a);
        System.out.println(Arrays.toString(a));
    }

}
