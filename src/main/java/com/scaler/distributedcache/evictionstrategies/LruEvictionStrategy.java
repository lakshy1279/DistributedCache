package com.scaler.distributedcache.evictionstrategies;

import com.scaler.distributedcache.CacheOperation;
import com.scaler.distributedcache.helper.Node;

import java.util.HashMap;
import java.util.Map;

public class LruEvictionStrategy implements IEvictionStrategy {
    Node head;
    Node tail;
    Map<String, Node> map;
    LruEvictionStrategy() {
        head = new Node("");
        tail = head;
        map = new HashMap<>();
    }
    void removeNode(String key) {
        Node removedNode = map.remove(key);
        if (removedNode == head.next) {
            head.next = head.next.next;
            head.next.prev = head;
            removedNode.next = null;
            head.prev = null;
        }
        else if (removedNode == tail) {
            tail = tail.prev;
            tail.next = null;
            removedNode.prev = null;
        }
        else
        {
            removedNode.prev.next = removedNode.next;
            removedNode.next.prev = removedNode.prev;
        }
        map.remove(key);
    }
    void addNode(String key) {
        Node newNode = new Node(key);
        map.put(key, newNode);
        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
    }
    @Override
    public void notify(String key, CacheOperation operation) {
        if(operation == CacheOperation.PUT)
        {
            addNode(key);
        }
        else if(operation == CacheOperation.GET)
        {
            removeNode(key);
            addNode(key);
        }
        else
        {
           removeNode(key);
        }
    }

    @Override
    public String evict() {
        Node removedNode = head;
        head = head.next;
        head.prev = null;
        return removedNode.getVal();
    }
}
