package datastructure.matrixedGraph;

/**
 * @program: data-structure-and-algorithm
 * @description:
 * @author: ZHQ
 * @create: 2019-08-07
 **/
class Vertex {
    public char value;   // 顶点值
    public boolean visited; // 顶点是否被访问过

    public Vertex(char v) {
        value = v;
        visited = false;
    }
}
