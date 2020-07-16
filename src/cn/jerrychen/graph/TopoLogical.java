package cn.jerrychen.graph;

import java.util.Stack;

public class TopoLogical {
    //索引代表顶点，值表示当前顶点是否已经被搜索
    private boolean[] marked;
    //记录图中是否有环
    private boolean hasCycle;
    //索引代表顶点，使用栈的思想，记录当前顶点有没有已经处于正在搜索的有向路径上
    private boolean[] onStack;

    //使用栈，存储顶点序列
    private Stack<Integer> reversePost;


    //构造拓扑排序对象
    public TopoLogical(Digraph G) {
        marked = new boolean[G.V()];
        onStack = new boolean[G.V()];
        //初始化reversePost栈
        this.reversePost = new Stack<Integer>();
        for (int i = 0; i < G.V(); i++) {
            onStack[i] = false;
            marked[i] = false;
        }
        hasCycle = false;
        for (int i = 0; i < G.V(); i++) {
            if (!marked[i]) {
                dfs(G, i);
            }
        }
    }

    //基于深度优先搜索，检测图G中是否有环
    //同时在marked中又在onStack中就是有环
    private void dfs(Digraph G, int v) {
        onStack[v] = true;
        marked[v] = true;
        for (Integer index : G.adj(v)) {
            if (!marked[index]) {
                dfs(G, index);
            }
            if (onStack[index]) {
                hasCycle = true;
                return;
            }
        }
        onStack[v] = false;
        reversePost.push(v);
    }

    //判断图G是否有环
    private boolean isCycle() {
        return hasCycle == true;
    }

    //获取拓扑排序的所有顶点
    public Stack<Integer> order() {
        if (!isCycle()) {
            return reversePost;
        }
        return null;

    }
}
