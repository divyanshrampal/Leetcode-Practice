

class LRUCache {
    
    public static class Node{
        int key;
        int value; 
        Node prev, next;
        Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }
    
    int capacity;
    Node head, tail;
    HashMap<Integer, Node> map; 
    int size = 0;

    public LRUCache(int capacity) {
        size = 0;
        this.capacity = capacity;
        map = new HashMap<>();
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if(map.containsKey(key) == false){
            return -1;
        }
        
        Node curr = map.get(key);
        
        //remove from there
        curr.prev.next = curr.next;
        curr.next.prev = curr.prev;
        
        //add first
        curr.prev = head;
        curr.next = head.next;
        curr.prev.next = curr;
        curr.next.prev = curr;
        
        return curr.value;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key) == false){
            
            Node curr = new Node(key, value);
            if(size == capacity){
                //remove last
                Node temp = tail.prev;
                temp.prev.next = temp.next;
                temp.next.prev = temp.prev;
                map.remove(temp.key);
                
            }
            else{
                size++;
            }
            curr.prev = head;
            curr.next = head.next;
            curr.prev.next = curr;
            curr.next.prev = curr;
            map.put(key, curr);
        }
        else{
            
            Node curr = map.get(key);
        
            //remove from there
            curr.prev.next = curr.next;
            curr.next.prev = curr.prev;

            //add first
            curr.prev = head;
            curr.next = head.next;
            curr.prev.next = curr;
            curr.next.prev = curr;

            curr.value = value;
            
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */