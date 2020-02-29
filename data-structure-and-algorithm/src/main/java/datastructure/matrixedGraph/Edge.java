package datastructure.matrixedGraph;

/**
 * @program: data-structure-and-algorithm
 * @description:
 * @author: ZHQ
 * @create: 2019-08-07
 **/
public class Edge {
    public int u;  //顶点
    public int v;  //顶点
    public int w; //权值

    public Edge(int u, int v, int w) {
        this.u = u;
        this.v = v;
        this.w = w;
    }
}
