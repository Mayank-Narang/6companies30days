class LRUCache {

   class Node {
        int key;
        int val;
        Node prev;
        Node next;

        Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    Node head = new Node(-1,-1);
    Node end = new Node(-1,-1);


    int count;
    HashMap<Integer,Node> map;

    public LRUCache(int capacity) {
        head.next = end;
        end.prev = head;
        count = capacity;
        map = new HashMap<>();
    }
    
    private void addNode(Node newnode){

        Node temp = head.next;

        newnode.next = temp;
        newnode.prev = head;

        head.next = newnode;
        temp.prev = newnode;

    }

    private void deleteNode(Node delnode){

        Node prevv = delnode.prev;
        Node nextt = delnode.next;

        prevv.next = nextt;
        nextt.prev = prevv;

    }

    public int get(int key) {

        if (map.containsKey(key)){

            Node resNode = map.get(key);

            map.remove(key);
            deleteNode(resNode);
            addNode(resNode);

            map.put(key,head.next);

            return resNode.val;

        }

        return -1;

    }
    
    public void put(int key, int value) {

        if (map.containsKey(key)){

            Node curr = map.get(key);
            map.remove(key);
            deleteNode(curr);

        }
        
        if (map.size() == count){

            map.remove(end.prev.key);
            deleteNode(end.prev);

        }

        addNode(new Node(key,value));
        map.put(key,head.next);

    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
