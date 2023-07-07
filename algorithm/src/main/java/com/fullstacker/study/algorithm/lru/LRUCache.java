package com.fullstacker.study.algorithm.lru;


import java.util.HashMap;
import java.util.Map;

/**
 * 链表是一个 k, v 链表。
 * <p>
 * lru 算法，最近经常使用的，放到 k,v 链表的头部
 * <p>
 * map 的key 就是 node 的key
 */
public class LRUCache {
    
    //双向链表节点
    class Node {
        
        int key;
        
        int val;
        
        Node pre;
        
        Node next;
    }
    
    //模拟缓存容量
    private int capacity;
    
    //保存链表的头节点  和 尾节点
    private Node first;
    
    private Node last;
    
    //从 key 到 node 的映射 map
    private Map<Integer, Node> map;
    
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>(capacity);
    }
    
    public int get(int key) {
        Node node = map.get(key);
        if (node == null) {
            return -1;
        }
        moveToHead(node);
        return node.val;
    }
    
    /*
    做两件事情:
        1. 将原来 的 node 删除
        2. 将 node 更新为 first 节点
     */
    private void moveToHead(Node node) {
        //如果是 头结点， 那么什么也不做
        // == 比较的是 内存地址
        if (node == first) {
            return;
            //如果是 尾节点,直接删除, (最后一段代码)并将给节点移动到 头结点的位置
            //头节点放的是 最近使用的节点
        } else if (node == last) {
            last.pre.next = null;
            last = last.pre;
            //节点在中间位置,删除该总监节点
        } else {
            node.pre.next = node.next;
            node.next.pre = node.pre;
        }
        //把该节点做为头结点
        node.pre = first.pre;
        node.next = first;
        first.pre = node;
        first = node;
    }
    
    public void put(int key, int value) {
        Node node = map.get(key);
        //该节点不存在,写入到 head 节点
        if (node == null) {
            Node newNode = new Node();
            newNode.key = key;
            newNode.val = value;
            
            //如果 容量满了， 删除(淘汰)尾节点
            if (map.size() == capacity) {
                removeLast(newNode);
            }
            
            //将值写入到 head节点，代表最近使用的节点数据
            addToHead(newNode);
            
            map.put(key, newNode);
            
        } else {    //该节点存在,删除原来在map中的位置,并将Node 移动到Head 节点
            node.val = value;
            moveToHead(node);
        }
    }
    
    //核心方法， 建立链表，指针移动
    private void addToHead(Node node) {
        if (map.isEmpty()) {
            first = node;
            last = node;
        } else {
            //把新节点作为head,last 就是原来head的指向
            node.next = first;
            first.pre = node;
            first = node;
        }
    }
    
    private void removeLast(Node node) {
        map.remove(last.key);
        Node preLastNode = last.pre;
        
        //修改 last的位置
        if (preLastNode != null) {
            preLastNode.next = null;
            last = preLastNode;
        }
    }
    
    
    public void printInfo() {
        
        Node node = null;
        //按照顺序输出链表
        for (int key : map.keySet()) {
            node = map.get(key);
            //找到头结点
            if (node == first) {
                break;
            }
        }
        
        StringBuffer stringBuffer = new StringBuffer("");
        
        //从头结点开始向下找
        Node mid = node;
        while (mid != null) {
            stringBuffer.append(mid.key + ":" + mid.val + "->");
            mid = mid.next;
        }
        
        String res = stringBuffer.toString();
        
        if (res != "") {
            res = res.substring(0, res.lastIndexOf("->"));
        }
        
        System.out.println(res);
    }
    
    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(4);
        lruCache.put(1, 1);  //[1]
        lruCache.put(2, 2);  //[2,1] 向左侧插入新数据
        lruCache.put(3, 3);  //[3,2,1]
        lruCache.put(4, 4);  //[4,3,2,1] 已经插入4个值,缓存满了
        
        lruCache.printInfo();   //由于map的内部机制输出存在显示问题
        
        lruCache.get(1);    //[1,4,3,2]
        
        lruCache.printInfo();
        
        //淘汰 队尾的数据 2 , 将新增数据 5 加到队头
        lruCache.put(5, 5);  //[5,1,4,3]
        
        lruCache.printInfo();
        
    }
}
