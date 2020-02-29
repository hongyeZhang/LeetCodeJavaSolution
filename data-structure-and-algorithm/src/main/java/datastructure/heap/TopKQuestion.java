package datastructure.heap;

/**
 * @program: data-structure-and-algorithm
 * @description:
 * 海量数据的前n大/前n小/Top k问题
 * 海量数据求top k的问题要用到容器和堆
 * 大根堆/小根堆
 * 大根堆(求最小的前n个数)
 * 小根堆(求最大的前n个数)
 * 最大堆特点：父节点值均大于子节点；(堆顶元素最大)
 * 最小堆特点：父节点值均小于子节点；(堆顶元素最小)
 * 总结：找top最大的用小根堆；找top最小的用大根堆
 *
 * 最大堆找top k小代码的基本思路
 * 求前n个最小的数 先建立最大堆 把海量数据向最大堆添加n个数，然后堆的内部会自动排序 我们不用管它的内部是怎么操作的 接
 * 下来我们往最大堆进行插入操作 因为最大堆的特点就是堆顶元素最大 若插入元素大于堆顶元素 则它大于堆中任何一个元素
 * 所以摒弃该元素 遍历下一个元素 若插入元素小于堆顶元素则进行插入 插入后堆内自动排序 堆顶元素又成为该堆的最大元素
 * 原堆顶元素出堆 持续遍历完 得到的就是所有元素中最小的前n个数
 *
 * 最小堆找top k大代码的基本思路
 * 求前n个最大的数 先建立最小堆 把海量数据向最小堆添加n个数，堆的内部会自动排序 不用管它的内部是什么操作
 * 然后我们往最小堆进行插入操作 因为最小堆的特点就是堆顶元素最小 若插入元素小于堆顶元素 则它小于堆中任何一个元素
 * 所以摒弃该元素 遍历下一个元素 若插入元素大于堆顶元素则进行插入 插入后堆内自动排序 堆顶元素又成为该堆的最小元素
 * 原堆顶元素出堆 持续遍历完 得到的就是所有元素中最大的前n个数
 *
 *
 * 应用场景：
 * 针对top K类问题，通常比较好的方案是分治+Trie树/hash+小顶堆（就是上面提到的最小堆），即先将数据集按照Hash方法分解成多个小数据集，
 * 然后使用Trie树活着Hash统计每个小数据集中的query词频，之后用小顶堆求出每个数据集中出现频率最高的前K个数，最后在所有top K中求出最终的top K。
 *
 *
 * @author: ZHQ
 * @create: 2019-07-20 23:41
 **/
public class TopKQuestion {
}
