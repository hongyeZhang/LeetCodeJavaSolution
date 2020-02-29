package datastructure.linkedGraph;

/**
 * @program: data-structure-and-algorithm
 * @description:
 * @author: ZHQ
 * @create: 2019-08-09
 **/
//边的类型
class Edge{
    char start;  //起点
    char end;    //终点
    int weight;  //边的权值
    public Edge(char start,char end,int weight) {
        this.start=start;
        this.end=end;
        this.weight=weight;
    }
}
