package cn.jerrychen.graph;

import java.util.LinkedList;
import java.util.Queue;

public class EdgeWeightedGraph {
    //记录顶点数量
    private int V;
    //记录边数量
    private int E;
    //邻接表
    private Queue<Edge>[] adj;

    //创建一个包含V个顶点但不包含边的图
    public EdgeWeightedGraph(int V) {
        this.V = V;
        this.E = 0;
        this.adj = new Queue[V];
        for (int i = 0; i < adj.length; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    //获取顶点数目
    public int V() {
        return V;
    }

    //获取边的数目
    public int E() {
        return E;
    }

    //向图中添加一条边 v-w
    public void addEdge(Edge e) {
        int v = e.either();
        int w = e.other(v);
        adj[v].add(e);
        adj[w].add(e);
        E++;
    }

    //获取和顶点v相邻的所有顶点
    public Queue<Edge> adj(int v) {
        return adj[v];
    }

    //获取加权无向图的所有边
    public Queue<Edge> edges() {
        Queue<Edge> queue = new LinkedList();
        for (int i = 0; i < V; i++) {
            for (Edge e : adj[i]) {
                if (e.other(i) < i) {
                    queue.add(e);
                }
            }
        }
        return queue;
    }

}
