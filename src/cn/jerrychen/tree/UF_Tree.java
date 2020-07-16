package cn.jerrychen.tree;

/*
并查集树
 */
public class UF_Tree {
    //记录结点元素和该元素所在分组的标识
    private int[] eleAndGroup;
    //记录并查集中数据的分组个数
    private int count;
    //用来存储每一个根结点对应的树中保存的结点的个数
    private int[] sz;

    //初始化并查集
    public UF_Tree(int N) {

        eleAndGroup = new int[N];
        for (int i = 0; i < eleAndGroup.length; i++) {
            eleAndGroup[i] = i;
        }
        count = N;
        sz = new int[N];
        for (int i = 0; i < sz.length; i++) {
            sz[i] = 1;
        }
    }

    //获取当前并查集中的数据有多少个分组
    public int count() {
        return count;
    }

    //判断并查集中元素p和元素q是否在同一分组中
    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    //元素p所在分组的标识符
    public int find(int p) {
        while (true) {
            if (eleAndGroup[p] == p) {
                return p;
            }
            p = eleAndGroup[p];
        }
    }

    //把p元素所在分组和q元素所在分组合并
    public void union(int p, int q) {
        //查询出p和q的根节点
        int rootP = find(p), rootQ = find(q);

        //判断哪边的更小，将其合并
        if (sz[rootP] < sz[rootQ]) {
            eleAndGroup[rootP] = rootQ;
            sz[rootP] += sz[rootQ];
        } else {
            eleAndGroup[rootQ] = rootP;
            sz[rootP] += sz[rootQ];
        }
        count--;
    }


}
