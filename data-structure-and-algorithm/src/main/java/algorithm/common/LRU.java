package algorithm.common;

import java.util.HashMap;

/**
 * @program: data-structure-and-algorithm
 * @description:
 * 参考网址： https://www.cnblogs.com/xuwc/p/9028216.html
 * @author: ZHQ
 * @create: 2019-07-16 22:20
 **/

/**
 *    最近最久未使用淘汰策略
 *    基于 双向链表 + 哈希表组成，其中双向链表由哈希链表节点构成
 *    封装为 LRU(K, V)
 *    对外提供 get(K)访问数据、put(K, V)更新数据
 *
 *  底层结构：双向链表 + HashMap ，双向链表由特定的哈希节点组成。
 * （1）访问节点时，将其从原来位置删除，插入到双向链表头部；
 * （2）更新节点时，先删除原有缓存数据（即原有节点），然后更新map映射，再将更新值作为节点插入链表头；更新后，判断容量是否超过最大内存使用量
 * （3）超过则执行淘汰；淘汰即删除双向链表最后一个节点，同时删除map中的映射
 * （4）LRU实现中有频繁的查找节点并删除，为节省时间（链表查找目标节点需要遍历），使用HashMap保存键-节点映射关系，O(1)的查找+O(1)的删除
 * （5）LRU实现中，要频繁的在头部插入，以及在尾部删除；因此，需要定义head、tail两个节点，方便操作
 *
 *
 * 缓存淘汰算法：
 * 常见类型包括 LFU、LRU、ARC、FIFO、MRU。
 *
 * （1）最不经常使用算法（LFU）：
 * 这个缓存算法使用一个计数器来记录条目被访问的频率。通过使用LFU缓存算法，最低访问数的条目首先被移除。这个方法并不经常使用，
 * 因为它无法对一个拥有最初高访问率之后长时间没有被访问的条目缓存负责。
 *
 * （2）最近最少使用算法（LRU）：
 * 这个缓存算法将最近使用的条目存放到靠近缓存顶部的位置。当一个新条目被访问时，LRU将它放置到缓存的顶部。当缓存达到极限时，
 * 较早之前访问的条目将从缓存底部开始被移除。这里会使用到昂贵的算法，而且它需要记录“年龄位”来精确显示条目是何时被访问的。
 * 此外，当一个LRU缓存算法删除某个条目后，“年龄位”将随其他条目发生改变。
 *
 * （3）先进先出算法（FIFO）：
 * FIFO是英文First In First Out 的缩写，是一种先进先出的数据缓存器，他与普通存储器的区别是没有外部读写地址线，这样使用起来非常简单，
 * 但缺点就是只能顺序写入数据，顺序的读出数据，其数据地址由内部读写指针自动加1完成，不能像普通存储器那样可以由地址线决定读取或写入某个指定的地址。
 *
 *（4）最近最常使用算法（MRU）：
     * 这个缓存算法最先移除最近最常使用的条目。一个MRU算法擅长处理一个条目越久，越容易被访问的情况。
 *
 */
public class LRU<K, V>{

    private Node head;
    private Node tail;
    //记录K-Node映射，便于快速查找目标数据对应节点
    private HashMap<K, Node> map;
    private int maxSize;

    //哈希链表节点类 Node
    private class Node{
        Node pre;
        Node next;
        K k;
        V v;

        //Node对外提供构造方法
        public Node(K k, V v) {
            this.k = k;
            this.v = v;
        }
    }

    //初始化时必须传入最大可用内存容量
    public LRU(int maxSize){
        this.maxSize = maxSize;
        //HashMap初始容量设置为 maxSize * 4/3，即达到最大可用内存时，HashMap也不会自动扩容浪费空间
        this.map = new HashMap<>(maxSize * 4 / 3);

        head.next = tail;
        tail.pre = head;
    }

    //获取指定数据
    private V get(K key) {
        //判断是否存在对应数据
        if(!map.containsKey(key)) {
            return null;
        }

        //最新访问的数据移动到链表头
        Node node = map.get(key);
        remove(node);
        addFirst(node);
        return node.v;
    }

    //更新旧数据或添加数据
    private void put(K key, V value) {
        //若存在旧数据则删除
        if(map.containsKey(key)) {
            Node node = map.get(key);
            remove(node);
        }

        //新数据对应节点插入链表头
        Node node = new Node(key, value);
        map.put(key, node);
        addFirst(node);

        //判断是否需要淘汰数据
        if(map.size() > maxSize) {
            removeLast();
            //数据节点淘汰后，同时删除map中的映射
            map.remove(node.k);
        }
    }

    //将指定节点插入链表头
    private void addFirst(Node node) {
        Node next = head.next;

        head.next = node;
        node.pre = head;

        node.next = next;
        next.pre = node;
    }

    //从链表中删除指定节点
    private void remove(Node node) {
        Node pre = node.pre;
        Node next = node.next;

        pre.next = next;
        next.pre = pre;

        node.next = null;
        node.pre = null;
    }

    //淘汰数据
    private Node removeLast() {
        //找到最近最久未使用的数据所对应节点
        Node node = tail.pre;

        //淘汰该节点
        remove(node);

        return node;
    }

}
