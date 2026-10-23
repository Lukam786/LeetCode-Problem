import java.util.HashMap;

class LRUCache {

    class Node {
        int key;
        int value;
        Node prev;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private Node head;
    private Node tail;

    private HashMap<Integer, Node> map;
    private int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();

        head = new Node(-1, -1);
        tail = new Node(-1, -1);

        head.next = tail;
        tail.prev = head;
    }

    private void addNode(Node newNode) {
        Node oldNext = head.next;

        head.next = newNode;
        oldNext.prev = newNode;

        newNode.next = oldNext;
        newNode.prev = head;
    }

    private void deleteNode(Node node) {
        Node oldPrev = node.prev;
        Node oldNext = node.next;

        oldPrev.next = oldNext;
        oldNext.prev = oldPrev;
    }

    public int get(int key) {

        if (!map.containsKey(key)) {
            return -1;
        }

        Node node = map.get(key);
        int ans = node.value;

        map.remove(key);
        deleteNode(node);

        addNode(node);
        map.put(key, node);

        return ans;
    }

    public void put(int key, int value) {

        if (map.containsKey(key)) {
            Node oldNode = map.get(key);

            deleteNode(oldNode);
            map.remove(key);
        }

        if (map.size() == capacity) {

            Node lruNode = tail.prev;

            map.remove(lruNode.key);
            deleteNode(lruNode);
        }

        Node newNode = new Node(key, value);

        addNode(newNode);
        map.put(key, newNode);
    }
}