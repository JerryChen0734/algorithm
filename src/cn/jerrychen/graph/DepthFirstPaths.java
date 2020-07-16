package cn.jerrychen.graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class DepthFirstPaths {
    //索引代表顶点，值表示当前顶点是否已经被搜索
    private boolean[] marked;
    //起点
    private int s;
    //索引代表顶点，值代表从起点s到当前顶点路径上的最后一个顶点
    private int[] edgeTo;

    //构造深度优先搜索对象，使用深度优先搜索找出G图中起点为s的所有路径
    public DepthFirstPaths(Graph G, int s) {
        marked = new boolean[G.V()];
        for (int i = 0; i < marked.length; i++) {
            marked[i] = false;
        }
        edgeTo = new int[G.V()];
        this.s = s;
        dfs(G, s);
    }

    //使用深度优先搜索找出G图中v顶点的所有相邻顶点
    private void dfs(Graph G, int v) {
        marked[v] = true;
        for (Integer w : G.adj(v)) {
            if (!marked[w]) {
                edgeTo[w] = v;
                dfs(G, w);
            }
        }

    }

    //判断w顶点与s顶点是否存在路径
    public boolean hasPathTo(int v) {
        return marked[v];
    }

    //找出从起点s到顶点v的路径(就是该路径经过的顶点)
    public Stack<Integer> pathTo(int v) {
        if (!hasPathTo(v)) return null;
        Stack<Integer> pathStack = new Stack<>();
        //把获取终点到起点的前一个路径
        for (int x = v; x != s; x = edgeTo[x]) {
            pathStack.push(x);
        }
        pathStack.push(s);
        return pathStack;
    }


}