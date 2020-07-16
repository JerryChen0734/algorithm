package cn.jerrychen.graph;

import java.util.LinkedList;
import java.util.Queue;

public class Digraph {
    //记录顶点数量
    private final int V;
    //记录边数量
    private int E;
    //邻接表
    private Queue<Integer>[] adj;

    //创建一个包含V个顶点但不包含边的图
    public Digraph(int V) {
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

    //向图中添加一条有向边 v-w
    public void addEdge(int v, int w) {
        adj[v].add(w);
        E++;
    }

    //获取和顶点v指向的所有顶点
    public Queue<Integer> adj(int v) {
        return adj[v];
    }

    public Digraph reverse() {
        Digraph digraph = new Digraph(V);
        for (int i = 0; i < V; i++) {
            for (Integer v : adj(i)) {
                digraph.addEdge(v, i);
            }
        }
        return digraph;
    }
}
