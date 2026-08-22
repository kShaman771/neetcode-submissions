class MyCircularQueue {
    class Node{
        Node next;
        int val;
        Node(int val){
            this.val=val;
        }
    }
    Node front;
    Node rear;
    int capacity;
    int size;
    public MyCircularQueue(int k) {
        capacity=k;
        size=0;
    }
    
    public boolean enQueue(int value) {
        Node newnode=new Node(value);
        if(isFull()){
            return false;
        }
        if(isEmpty()){
            front=rear=newnode;
            rear.next=newnode;
        }
        else{
            newnode.next=front;
            rear.next=newnode;
            rear=newnode;
        }
        size++;
        return true;
        
    }   
    public boolean deQueue() {
        if(isEmpty()){
            return false;
        }
        if(size==1){
            front=rear=null;
        }
        else{
            front=front.next;
            rear.next=front;
        }
        size--;
        return true;
        
    }
    
    public int Front() {
        if(isEmpty()){
            return -1;
        }
        return front.val;
        
    }
    
    public int Rear() {
        if(isEmpty()){
            return -1;
        }
        return rear.val;
        
    }
    
    public boolean isEmpty() {
        return size==0;
        
    }
    
    public boolean isFull() {
        return size==capacity;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */