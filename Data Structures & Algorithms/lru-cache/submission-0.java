class LRUCache {
    
    // --- 1. The Blueprint for our Nodes ---
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

    // --- 2. The Class Variables ---
    int capacity;
    Map<Integer, Node> cache;
    Node head;
    Node tail;

    // --- 3. The Constructor ---
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
        
        // Setup the dummy guards
        this.head = new Node(0, 0);
        this.tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
    }
    
    // --- 4. The Helper Methods ---
    private void insertAfterHead(Node node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }
    
    private void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    // --- 5. Get ---
    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1;
        }
        Node node = cache.get(key);
        
        // Make it the Most Recently Used
        removeNode(node);
        insertAfterHead(node);
        
        return node.value;
    }
    
    // --- 6. Put ---
    public void put(int key, int value) {
        // If it exists, update it and move to front
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            node.value = value;
            removeNode(node);
            insertAfterHead(node);
            return;
        }

        // It's new! Add it to both structures
        Node newNode = new Node(key, value);
        cache.put(key, newNode);
        insertAfterHead(newNode);

        // Check if we need to evict the LRU
        if (cache.size() > capacity) {
            Node lru = tail.prev; // The guy right in front of the tail
            cache.remove(lru.key); // Remove from HashMap
            removeNode(lru);       // Remove from Linked List
        }
    }
}