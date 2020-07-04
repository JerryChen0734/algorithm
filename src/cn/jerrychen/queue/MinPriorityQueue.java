package cn.jerrychen.queue;

/*
最小优先队列
 */
public class MinPriorityQueue<T extends Comparable<T>> {
    //存储堆中的元素
    private T[] items;
    //记录堆中元素的个数
    private int N;


    public MinPriorityQueue(int capacity) {
        items = (T[]) new Comparable[capacity+1];
        N = 0;
    }

    //获取队列中元素的个数
    public int size() {
        return N;
    }

    //判断队列是否为空
    public boolean isEmpty() {
        return N == 0;
    }

    //判断堆中索引i处的元素是否小于索引j处的元素
    private boolean less(int i, int j) {
        return items[i].compareTo(items[j]) < 0;
    }

    //交换堆中i索引和j索引处的值
    private void exch(int i, int j) {
        T tmp = items[i];
        items[i] = items[j];
        items[j] = tmp;
    }

    //往堆中插入一个元素
    public void insert(T t) {
        items[++N] = t;
        swim(N);
    }

    //删除堆中最大的元素,并返回这个最大元素
    public T delMin() {
        T max = items[1];
        exch(1, N);
        N--;
        sink(1);
        return max;
    }

    //使用上浮算法，使索引k处的元素能在堆中处于一个正确的位置
    private void swim(int k) {
      /*  int parent = (k - 1) / 2;
        int L, R;
        for (int i = parent; i >= 0; i--) {
            L = 2 * i + 1;
            R = 2 * i + 2;
            int max = i;
            //判断左右节点和父节点哪个大，
            if (L < N && less(L, max)) {
                max = L;
            }
            if (R < N && less(R, max)) {
                max = R;
            }
            if (i != max) {
                exch(i, max);
            }
        }*/

        while (k > 1) {
            if (less(k, k / 2)) {
                exch(k / 2, k);
            }

            k = k / 2;
        }
    }

    //使用下沉算法，使索引k处的元素能在堆中处于一个正确的位置
    private void sink(int k) {
        while (2 * k <= N) {
            int min;
            if (2 * k + 1 <= N) {
                if (less(2 * k, 2 * k + 1)) {
                    min = 2 * k;
                } else {
                    min = 2 * k + 1;
                }
            } else {
                min = 2 * k;
            }
            //比较当前结点和较小值
            if (less(k,min)){
                break;
            }
            exch(k, min);
            k = min;
        }

    }

}