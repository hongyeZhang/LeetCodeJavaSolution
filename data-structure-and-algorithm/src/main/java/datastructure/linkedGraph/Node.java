package datastructure.linkedGraph;

/**
 * @program: data-structure-and-algorithm
 * @description:
 * @author: ZHQ
 * @create: 2019-08-09
 **/
//作为某个点的邻接点的顶点信息
class Node{
    int index;  // 顶点的序号
    int weight;  // 以该顶点为终点的边的权值
    Node nextNode; // 指向下一个顶点
}
