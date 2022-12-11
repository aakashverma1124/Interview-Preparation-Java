class Node {
    int key, value, frequency;
    Node next, prev;
    public Node(int key, int value, int frequency) {
        this.key = key;
        this.value = value;
        this.frequency = frequency;
    }
}

class DoublyLinkedList {
    int size;
    Node head, tail;

    public DoublyLinkedList() {
        this.size = 0;
        this.head = new Node(-1, -1, -1);
        this.tail = new Node(-1, -1, -1);
        this.head.next = this.tail;
        this.tail.prev = this.head;
    }

    public void addNode(Node node) {
        node.next = this.head.next;
        this.head.next = node;
        node.prev = this.head;
        node.next.prev = node;
        this.size += 1;
    }

    public void deleteNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        this.size -= 1;
    }
}

class LFUCache {

    int minimumFrequency, capacity;
    Map<Integer, Node> cacheMap;
    Map<Integer, DoublyLinkedList> lfuMap;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.minimumFrequency = 0;
        cacheMap = new HashMap<>();
        lfuMap = new HashMap<>();
    }

    public void updateNode(Node node) {
        int currentFrequency = node.frequency;
        DoublyLinkedList lruCache = lfuMap.get(currentFrequency);
        lruCache.deleteNode(node);
        
        node.frequency += 1;

        if(this.minimumFrequency == currentFrequency && lruCache.size == 0) {
            this.minimumFrequency += 1;
        }
        
        if(!lfuMap.containsKey(node.frequency)) {
            lfuMap.put(node.frequency, new DoublyLinkedList());
        }
        lruCache = lfuMap.get(node.frequency);
        lruCache.addNode(node);
    }
    
    public int get(int key) {
        if(cacheMap.containsKey(key)) {
            Node node = cacheMap.get(key);
            int value = node.value;
            updateNode(node);
            return node.value;
        } else {
            return -1;
        }
    }
    
    public void put(int key, int value) {
        
        if(this.capacity == 0) return;

        if(cacheMap.containsKey(key)) {
            Node node = cacheMap.get(key);
            node.value = value;
            updateNode(node);
        } else {
            if(this.capacity == cacheMap.size()) {
                DoublyLinkedList lruCache = lfuMap.get(this.minimumFrequency);
                Node node = lruCache.tail.prev;
                cacheMap.remove(node.key);
                lruCache.deleteNode(node);
            }
            this.minimumFrequency = 1;
            Node node = new Node(key, value, this.minimumFrequency);
            cacheMap.put(key, node);
            if(!lfuMap.containsKey(this.minimumFrequency)) {
                lfuMap.put(this.minimumFrequency, new DoublyLinkedList());
            }
            DoublyLinkedList lruCache = lfuMap.get(this.minimumFrequency);
            lruCache.addNode(node);
        }
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */