package cn.jerrychen.test;

import cn.jerrychen.queue.IndexMinPriorityQueue;

import java.util.HashMap;

public class QueueTest {
    public static void main(String[] args) {


        //创建索引最小优先队列对象
        IndexMinPriorityQueue<String> queue = new IndexMinPriorityQueue<>(10);

        //往队列中添加元素
        queue.insert(1, "A");
        queue.insert(2, "C");
        queue.insert(3, "F");
        //往队列中存储元素
        queue.insert(5,"D");
        queue.insert(6,"G");
        queue.insert(7,"E");
        queue.insert(8,"F");
        //测试修改
        queue.changeItem(3, "B");
        //测试删除
        while (!queue.isEmpty()) {
            System.out.println(queue.delMin());

        }
        HashMap hashMap;

    }
}
