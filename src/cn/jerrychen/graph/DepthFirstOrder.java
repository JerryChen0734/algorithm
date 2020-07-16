package cn.jerrychen.graph;

import java.util.Stack;

public class DepthFirstOrder {
    //索引代表顶点，值表示当前顶点是否已经被搜索
    private boolean[] marked;
    //使用栈，存储顶点序列
    private Stack<Integer> reversePost;


    public DepthFirstOrder(Digraph G) {
        //初始化marked数组
        this.marked = new boolean[G.V()];
        //初始化reversePost栈
        this.reversePost = new Stack<Integer>();

        //遍历图中的每一个顶点，让每个顶点作为入口，完成一次深度优先搜索
        for (int v = 0; v < G.V(); v++) {
            if (!marked[v]) {
                dfs(G, v);
            }
        }
    }

    //基于深度优先搜索，把顶点排序
    private void dfs(Digraph G, int v) {
        marked[v] = true;
        for (Integer index : G.adj(v)) {
            if (!marked[index]) {
                dfs(G, index);
            }
        }
        reversePost.push(v);

    }

    //获取顶点线性序列
    public Stack<Integer> reversePost() {
        return reversePost;
    }
}
