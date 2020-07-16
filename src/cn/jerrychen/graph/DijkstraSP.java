package cn.jerrychen.graph;

import cn.jerrychen.queue.IndexMinPriorityQueue;

import java.util.LinkedList;
import java.util.Queue;


public class DijkstraSP {
    //索引代表顶点，值表示从顶点s到当前顶点的最短路径上的最后一条边
    private DirectedEdge[] edgeTo;
    //索引代表顶点，值从顶点s到当前顶点的最短路径的总权重
    private double[] distTo;
    //存放树中顶点与非树中顶点之间的有效横切边
    private IndexMinPriorityQueue<Double> pq;

    //根据一副加权有向图G和顶点s，创建一个计算顶点为s的最短路径树对象
    public DijkstraSP(EdgeWeightedDigraph G, int s) {
        edgeTo = new DirectedEdge[G.V()];
        distTo = new double[G.V()];
        for (int i = 0; i < distTo.length; i++) {
            distTo[i] = Double.POSITIVE_INFINITY;
        }
        pq = new IndexMinPriorityQueue<>(G.V());
        //从0开始，将所有周围的边加入到队列中，找到权重最小的并松弛
        pq.insert(0, 0.0);
        distTo[0] = 0;
        while (!pq.isEmpty()) {
            relax(G, pq.delMin());
        }
    }

    //松弛图G中的顶点v
    private void relax(EdgeWeightedDigraph G, int v) {
        //找到传入的值所有的边，找到权重最小的
        for (DirectedEdge directedEdge : G.adj(v)) {
            //如果edgeTo上已经有边，就把当前边的权重和之前边的权重相加，判断与已有边哪个权重低，如果低就替换。
            int w = directedEdge.to();
            double weight = directedEdge.weight() + distTo[v];
            //如果这条线路权重小于之前的线路就更新， distTo[w]默认为无限大
            if (weight < distTo[w]) {
                //更新线路
                distTo[w] = weight;
                edgeTo[w] = directedEdge;
                //判断之前是否存入过W的权重
                if (pq.contains(w)) {
                    //更新权重
                    pq.changeItem(w, distTo[w]);
                } else {
                    pq.insert(w, distTo[w]);
                }
            }

        }

    }

    //获取从顶点s到顶点v的最短路径的总权重
    public double distTo(int v) {
        return distTo[v];
    }

    //判断从顶点s到顶点v是否可达
    public boolean hasPathTo(int v) {
        return distTo[v] < Double.POSITIVE_INFINITY;
    }

    //查询从起点s到顶点v的最短路径中所有的边
    public Queue<DirectedEdge> pathTo(int v) {
        Queue<DirectedEdge> queue = new LinkedList<>();
        while (edgeTo[v].from() != 0) {
            queue.add(edgeTo[v]);
            v = edgeTo[v].from();
        }
        queue.add(edgeTo[v]);
        return queue;
    }

}