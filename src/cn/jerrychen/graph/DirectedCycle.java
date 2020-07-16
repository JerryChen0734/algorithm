package cn.jerrychen.graph;

public class DirectedCycle {
    //索引代表顶点，值表示当前顶点是否已经被搜索
    private boolean[] marked;
    //记录图中是否有环
    private boolean hasCycle;
    //索引代表顶点，使用栈的思想，记录当前顶点有没有已经处于正在搜索的有向路径上
    private boolean[] onStack;

    //创建一个检测环对象，检测图G中是否有环
    public DirectedCycle(Digraph G) {
        marked = new boolean[G.V()];
        onStack = new boolean[G.V()];
        for (int i = 0; i < G.V(); i++) {
            onStack[i] = false;
            marked[i] = false;
        }
        hasCycle = false;
        for (int i = 0; i < G.V(); i++) {
            dfs(G, i);
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
    }

    //判断当前有向图G中是否有环
    public boolean hasCycle() {
        return hasCycle;
    }

}


