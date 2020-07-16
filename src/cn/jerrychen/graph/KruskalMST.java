package cn.jerrychen.graph;

import cn.jerrychen.queue.MinPriorityQueue;
import cn.jerrychen.tree.UF_Tree;

import java.util.LinkedList;
import java.util.Queue;

public class KruskalMST {
    //保存最小生成树的所有边
    private Queue<Edge> mst;
    //索引代表顶点，使用uf.connect(v,w)可以判断顶点v和顶点w是否在同一颗树中，使用uf.union(v,w)可以把顶点v所在的树和顶点w所在的树合并
    private UF_Tree uf;
    //存储图中所有的边，使用最小优先队列，对边按照权重进行排序
    private MinPriorityQueue<Edge> pq;

    //根据一副加权无向图，创建最小生成树计算对象
    public KruskalMST(EdgeWeightedGraph G) {
        mst = new LinkedList<>();
        uf = new UF_Tree(G.V());
        pq = new MinPriorityQueue<>(G.E());
        for (Edge edge : G.edges()) {
            pq.insert(edge);
        }
        while (!pq.isEmpty()) {
            Edge min = pq.delMin();
            int v = min.either();
            int w = min.other(v);
            if (uf.connected(v, w)) {
                continue;
            }
            mst.add(min);
            uf.union(v, w);
        }
    }

    //获取最小生成树的所有边
    public Queue<Edge> edges() {
        return mst;
    }
}
