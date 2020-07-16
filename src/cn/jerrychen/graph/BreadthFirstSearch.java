package cn.jerrychen.graph;

import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearch {
    //索引代表顶点，值表示当前顶点是否已经被搜索
    private boolean[] marked;
    //记录有多少个顶点与s顶点相通
    private int count;
    //辅助队列
    Queue<Integer> queue;

    //构造深度优先搜索对象，使用深度优先搜索找出G图中s顶点的所有相邻顶点
    public BreadthFirstSearch(Graph G, int s) {
        marked = new boolean[G.V()];
        queue = new LinkedList();
        for (int i = 0; i < marked.length; i++) {
            marked[i] = false;
        }
        count = 0;
        bfs(G, s);
    }

    //使用深度优先搜索找出G图中v顶点的所有相通顶点
    private void bfs(Graph G, int v) {
     /*   Queue<Integer> queue = new LinkedList();
        queue.addAll(G.adj(v));
        while (!queue.isEmpty()) {
            Integer remove = queue.remove();
            if (marked[remove] == true) return;
            marked[remove] = true;
            queue.addAll(G.adj(remove));
            count++;
        }*/
        if (marked[v] == true) return;
        marked[v] = true;
        queue.addAll(G.adj(v));
        if (!queue.isEmpty()) {
            bfs(G, queue.remove());
        }
        count++;
    }

    //判断w顶点与s顶点是否相通
    public boolean marked(int w) {
        return marked[w] == true;
    }

    //获取与顶点s相通的所有顶点的总数
    public int count() {
        return count;
    }
}
