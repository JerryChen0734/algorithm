package cn.jerrychen.graph;

public class DirectedEdge {
    private final int v;//顶点一
    private final int w;//顶点二
    private final double weight;//当前边的权重

    public DirectedEdge(int v, int w, double weight) {
        this.v = v;
        this.w = w;
        this.weight = weight;
    }

    //获取边的权重值
    public double weight() {
        return weight;
    }

    public int from() {
        return v;
    }

    public int to() {
        return w;
    }
}
