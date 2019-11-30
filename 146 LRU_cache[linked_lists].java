/*
146. LRU Cache
---
Design and implement a data structure for Least Recently Used (LRU) cache.
It should support the following operations: get and put.

get(key) - Get the value (will always be positive) of the key if the key exists in the cache,
    otherwise return -1.
put(key, value) - Set or insert the value if the key is not already present.
When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.
---
Example:

LRUCache cache = new LRUCache( 2 //capacity );

cache.put(1, 1);
cache.put(2, 2);
cache.get(1);       // returns 1
cache.put(3, 3);    // evicts key 2
cache.get(2);       // returns -1 (not found)
cache.put(4, 4);    // evicts key 1
cache.get(1);       // returns -1 (not found)
cache.get(3);       // returns 3
cache.get(4);       // returns 4
 */

class Node {
    int key;
    int value;
    Node prev;
    Node next;
    
    public Node(int key, int value) {
      this.key = key;
      this.value = value;
    }
}

public class LRUCache {
    private HashMap<Integer, Node> hm = new HashMap<>();
    private int capac;
    private Node head;
    private Node tail;
    
    // constructor to set up cache capacity, empty hashmap and doubly linked list head and tail
    public LRUCache(int capacity) {
      this.capac = capacity;

      head = new Node(0, 0);
      tail = new Node(0, 0);
      head.next = tail;
      tail.prev = head;
      head.prev = null;
      tail.next = null;
    }
    
    // delete a node anywhere in doubly linked list
    private void deleteNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    
    // add a node to head of doubly linked list
    private void addToHead(Node node) {
        node.prev = head;
        node.next = head.next;

        head.next.prev = node;
        head.next = node;
    }
    
    // delete node and move to head of doubly linked list
    private void moveToHead(Node node) {
        deleteNode(node);
        addToHead(node);
    }
    
    // Get the value of the key if the key exists in the cache, otherwise return -1.
    public int get(int key) {
        Node n = hm.get(key);
        
        // key doesnt exist
        if(n == null)
            return -1;
        
        // move node from anywhere in list to head of list
        moveToHead(n);
        
        return n.value;
    }
    
    // Insert the value if the key is not already present.
    // When the cache reached its capacity, it should invalidate the least recently used item before inserting
    public void put(int key, int value) {
        Node n = hm.get(key);
        
        // key is already in the cache, update value and move it to head
        if (n != null) {
            n.value = value;
            moveToHead(n);
        }
        // key is not in cache
        else {
            // create new node and add key to hashmap
            Node newNode = new Node(key, value);
            hm.put(key, newNode);
            
            // cache reached its capacity, it should invalidate the least recently used item
            if (hm.size() > capac) {
                hm.remove(tail.prev.key);
                deleteNode(tail.prev);
            }
            
            addToHead(newNode);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

