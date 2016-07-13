/*Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and set.

get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
set(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.*/

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    private class DLNode {
        int key, value;
        DLNode prev, next;

        DLNode(int k, int v) {
            key = k;
            value = v;
        }
    }

    private Map<Integer, DLNode> cache;
    private int capacity, size;
    private DLNode dummyFirst, dummyLast;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<Integer, DLNode>();
        size = 0;
        dummyFirst = new DLNode(-1, -1);
        dummyLast = new DLNode(-1, -1);
        dummyFirst.next = dummyLast;
        dummyLast.prev = dummyFirst;
    }

    public int get(int key) {
        if (cache.containsKey(key)) {
            int v = cache.get(key).value;
            this.set(key, v);
            return v;
        } else return -1;
    }

    public void set(int key, int value) {
        if (size == 0) {
            DLNode node = new DLNode(key, value);
            dummyFirst.next = node;
            node.next = dummyLast;
            dummyLast.prev = node;
            node.prev = dummyFirst;
            cache.put(key, node);
            size++;
        } else if (cache.containsKey(key)) {
            DLNode node = cache.get(key);
            node.prev.next = node.next;
            node.next.prev = node.prev;
            cache.remove(key);
            size--;
            this.set(key, value);
        } else if (size >= capacity) {
            DLNode node = dummyFirst.next;
            dummyFirst.next = node.next;
            node.next.prev = dummyFirst;
            node.next = null;
            node.prev = null;
            cache.remove(node.key);
            size--;
            this.set(key, value);
        } else {
            DLNode node = new DLNode(key, value);
            dummyLast.prev.next = node;
            node.prev = dummyLast.prev;
            node.next = dummyLast;
            dummyLast.prev = node;
            cache.put(key, node);
            size++;
        }
    }
}