package datastructure.matrixedGraph;

/**
 * @program: data-structure-and-algorithm
 * @description:
 * @author: ZHQ
 * @create: 2019-08-07
 **/
class Vertex {
    /**
     *  顶点值
     */
    public char value;

    /**
     * 顶点是否被访问过
     */
    public boolean visited;

    public Vertex(char v) {
        value = v;
        visited = false;
    }
}
