package com.zh.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制。它应该支持以下操作： 获取数据 get 和 写入数据 put 。
 * <p>
 * 获取数据 get(key) - 如果关键字 (key) 存在于缓存中，则获取关键字的值（总是正数），否则返回 -1。
 * 写入数据 put(key, value) - 如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组「关键字/值」。当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/lru-cache
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 进阶:
 * <p>
 * 你是否可以在 O(1) 时间复杂度内完成这两种操作？
 */
public class LRUCache {
    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);

//        cache.get(2);
//        cache.put(2, 6);
//        cache.get(1);
//        cache.put(1, 5);
//        cache.put(1, 2);
//        cache.get(1);
//        cache.get(2);

        cache.put(1, 1);
        cache.put(2, 2);
        cache.get(1);       // 返回  1
        cache.put(3, 3);    // 该操作会使得关键字 2 作废
        cache.get(2);       // 返回 -1 (未找到)
        cache.put(4, 4);    // 该操作会使得关键字 1 作废
        cache.get(1);       // 返回 -1 (未找到)
        cache.get(3);       // 返回  3
        cache.get(4);       // 返回  4

    }


    private int capacity;
    private Map<Integer, Node> nodeMap;
    private int size = 0;
    private Node head = new Node(-1, -1);
    private Node tail = new Node(-1, -1);

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.pre = head;
        nodeMap = new HashMap<>(capacity);
    }

    public int get(int key) {
        Node n = nodeMap.get(key);
        if (n == null) return -1;
        if (n.next != tail) {
            moveToTail(n);
        }
        return n.value;
    }

    //尾插法，头部为最不常用节点
    public void put(int key, int value) {
        Node n = nodeMap.get(key);
        if (n != null) {
            //有则替换
            n.value = value;
            moveToTail(n);
        } else {
            if (size == capacity && size != 0) {
                Node last = head.next;
                head.next = last.next;
                last.next.pre = head;
                nodeMap.remove(last.key);
                size--;
            }

            //无则插入
            Node insert = new Node(key, value);
            nodeMap.put(key, insert);

            Node newest = tail.pre;
            tail.pre = insert;
            insert.next = tail;
            newest.next = insert;
            insert.pre = newest;
            size++;
        }
    }

    private void moveToTail(Node n) {
        Node temp = n.pre;
        temp.next = n.next;
        n.next.pre = temp;

        Node newest = tail.pre;
        tail.pre = n;
        newest.next = n;
        n.pre = newest;
        n.next = tail;
    }

    class Node {
        int key;
        int value;
        Node next;
        Node pre;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}
