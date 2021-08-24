package com.fullstacker.study.algorithm;

import java.util.TreeMap;

/**
 * @program: bianlifeng
 * @description:
 * @author: xgs
 * @create: 2021-08-23 11:41
 */
public class RangMap {


    static class Node implements Comparable {
        private Integer min;

        private Integer max;

        public Node(){}

        public Node(int min,int max){
            this.min = min;
            this.max = max;
        }

        public Node(int min){
            this.min = min;
        }
        public Integer getMin() {
            return min;
        }

        public void setMin(Integer min) {
            this.min = min;
        }

        public Integer getMax() {
            return max;
        }

        public void setMax(Integer max) {
            this.max = max;
        }




        @Override
        public int compareTo(Object o) {
            Node node1 = this;
            Node node2 = (Node) o;

            if(node1.getMin() != null && node2.getMin() != null && node1.getMax() != null  && node2.getMax() != null){
                if (node1.getMax() < node2.getMin()){
                    return 1;
                }
                return -1;
            }else {
                if(node1.getMin() <= node2.getMax() && node1.getMin() >= node2.getMin()){
                    return 0;
                }else if(node1.getMin() < node2.getMin()){
                    return 1;
                }else {
                    return  -1;
                }
            }
        }
    }

    static class NodeValue{
        int[] value;

        public int[] getValue() {
            return value;
        }

        public void setValue(int[] value) {
            this.value = value;
        }
    }

    static  class MyTreeMap<K,V> extends TreeMap{
        @Override
        public Object put(Object key, Object value) {
            if(null == key ){
                throw new RuntimeException("key 不能为null");
            }
            Node nodeKey = (Node) key;
            if(nodeKey.getMax() == null || nodeKey.getMin() == null){
                throw new RuntimeException("max和min不能为null");
            }
            return super.put(key, value);
        }


        //        @Override
//        public V get(Object key){
//            Node node = (Node) key;
//            int searchKey = node.getMin();
//            Entry<K,V> p = root;
//            while (p != null) {
//                int cmp = k.compareTo(p.key);
//                if (cmp < 0)
//                    p = p.left;
//                else if (cmp > 0)
//                    p = p.right;
//                else
//                    return p;
//            }
//        }
    }

    public static void main(String[] args) {



        TreeMap<Node, NodeValue> treeMap = new MyTreeMap<>();
        Node node = new Node(1, 5);
        NodeValue nodeValue = new NodeValue();
        nodeValue.setValue(new int[]{1,2,3});
        treeMap.put(node,nodeValue);

        Node node1 = new Node(6, 100);
        NodeValue nodeValue1 = new NodeValue();
        nodeValue1.setValue(new int[]{2,3,4});

        treeMap.put(node1,nodeValue1);
        Node nodeResult = new Node(999);
        NodeValue nodeValue2 = treeMap.get(nodeResult);

        System.out.println(nodeValue2);
    }

}
