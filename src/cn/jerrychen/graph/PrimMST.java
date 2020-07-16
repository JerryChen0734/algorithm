package cn.jerrychen.graph;

import cn.jerrychen.queue.IndexMinPriorityQueue;

import java.util.LinkedList;
import java.util.Queue;

public class PrimMST {
    //索引代表顶点，值表示当前顶点和最小生成树之间的最短边
    private Edge[] edgeTo;
    //索引代表顶点，值表示当前顶点和最小生成树之间的最短边的权重
    private double[] distTo;
    //索引代表顶点，如果当前顶点已经在树中，则值为true，否则为false
    private boolean[] marked;
    //存放树中顶点与非树中顶点之间的有效横切边
    private IndexMinPriorityQueue<Double> pq;

    //根据一副加权无向图，创建最小生成树计算对象
    public PrimMST(EdgeWeightedGraph G) {
        edgeTo = new Edge[G.V()];
        distTo = new double[G.V()];
        marked = new boolean[G.V()];
        for (int i = 0; i < G.V(); i++) {
            distTo[i] = Double.POSITIVE_INFINITY;
        }
        pq = new IndexMinPriorityQueue<>(G.V());
        distTo[0] = 0;
        pq.insert(0, 0.0);
        while (!pq.isEmpty()) {
            visit(G, pq.delMin());
        }

    }

    //将顶点v添加到最小生成树中，并且更新数据
    private void visit(EdgeWeightedGraph G, int v) {
        marked[v] = true;
        //获取所有相邻的边
        for (Edge edge : G.adj(v)) {
            int w = edge.other(v);
            if (marked[w]) continue;
            if (edge.weight() < distTo[w]) {
                distTo[w] = edge.weight();
                edgeTo[w] = edge;
                if (pq.contains(w)) {
                    pq.changeItem(w, edge.weight());
                } else {
                    pq.insert(w, edge.weight());
                }
            }
        }
    }

    //获取最小生成树的所有边
    public Queue<Edge> edges() {
        Queue queue = new LinkedList();
        for (Edge edge : edgeTo) {
            if (edge != null)
                queue.add(edge);
        }
        return queue;
    }
}
