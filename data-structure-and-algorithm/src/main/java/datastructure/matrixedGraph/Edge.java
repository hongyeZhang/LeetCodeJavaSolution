package datastructure.matrixedGraph;

/**
 * @program: data-structure-and-algorithm
 * @description:
 * @author: ZHQ
 * @create: 2019-08-07
 **/
public class Edge {
    /**
     * 顶点
     */
    public int u;

    /**
     * 顶点
     */
    public int v;

    /**
     * 权值
     */
    public int w;

    public Edge(int u, int v, int w) {
        this.u = u;
        this.v = v;
        this.w = w;
    }
}
