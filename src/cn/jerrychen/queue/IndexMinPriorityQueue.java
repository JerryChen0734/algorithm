package cn.jerrychen.queue;

/*
索引最小优先队列
利用2个辅助数组，解决了优先队列无法随机访问和随机修改的缺陷。
 */
public class IndexMinPriorityQueue<T extends Comparable<T>> {
    //存储堆中的元素
    private T[] items;
    //记录堆中元素的个数
    private int N;

    //保存每个元素在items中的索引，需要保持堆有序
    private int[] pq;
    //为pq的逆序，pq的值作为索引，pq的索引作为值
    private int[] qp;

    public IndexMinPriorityQueue(int capacity) {
        items = (T[]) new Comparable[capacity + 1];
        pq = new int[capacity+1];
        qp = new int[capacity+1];
        N = 0;

        for (int i = 0; i < capacity; i++) {
            qp[i] = -1;
        }
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
        return items[pq[i]].compareTo(items[pq[j]]) < 0;
    }

    //交换堆中i索引和j索引处的值
    private void exch(int i, int j) {
        int tmp = pq[i];
        pq[i] = pq[j];
        pq[j] = tmp;

        qp[pq[i]] = i;
        qp[pq[j]] = j;

    }

    //判断k对应的元素是否存在
    public boolean contains(int k) {
        return qp[k] != -1;
    }

    //最小元素关联的索引
    public int minIndex() {
        return pq[1];
    }

    //删除索引i关联的元素
    public void delete(int i) {
        int del = pq[i];
        //更新qp
        qp[del] = -1;
        //更新items
        items[del] = null;

        exch(i, N);
        pq[N] = -1;
        N--;
        sink(i);
        swim(i);
    }

    //把与索引i关联的元素修改为为t
    public void changeItem(int i, T t) {
        //修改items中i的元素
        items[i] = t;
        //通过qp找到i在堆中的位置
        int heapIndex = qp[i];
        //堆pq中i进行上浮下移调整
        sink(heapIndex);
        swim(heapIndex);
    }

    //往堆中插入一个元素
    public void insert(int i, T t) {
        if (contains(i)) return;
        N++;
        items[i] = t;
        pq[N] = i;
        qp[i] = N;
        //保持pq堆有序
        swim(N);
    }

    //删除堆中最小的元素,并返回这个最小元素
    public int delMin() {
        int min = pq[1];
        //更新qp
        qp[min] = -1;
        //更新items
        items[min] = null;

        exch(1, N);
        pq[N] = -1;
        N--;
        sink(1);
        return min;
    }

    //使用上浮算法，使索引k处的元素能在堆中处于一个正确的位置
    private void swim(int k) {
        while (k > 1) {
            if (less(k, k / 2)) {
                exch(k, k / 2);
            }
            k = k / 2;
        }
    }

    //使用下沉算法，使索引k处的元素能在堆中处于一个正确的位置
    private void sink(int k) {
        int min;
        while (2 * k <= N) {
            if (2 * k + 1 <= N) {
                if (less(2 * k, 2 * k + 1)) {
                    min = 2 * k;
                } else {
                    min = 2 * k + 1;
                }
            } else {
                //如果等于2 * k == N
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
