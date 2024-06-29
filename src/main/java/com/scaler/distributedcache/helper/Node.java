package com.scaler.distributedcache.helper;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Node {
    String val;
    public Node prev;
    public Node next;
    public Node(String val) {
        this.val = val;
        this.prev = null;
        this.next = null;
    }
}
