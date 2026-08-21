class MyHashMap {
    private List<Integer> list;

    public MyHashMap() {
        list=new ArrayList<>();
        
    }
    
    public void put(int key, int value) {
        while(list.size()<=key){
            list.add(-1);
        }
        list.set(key,value);
    }
    
    public int get(int key) {
        if(key>=list.size()){
            return -1;
        }
        return list.get(key);
    }
    
    public void remove(int key) {
        if(key<list.size()){
            list.set(key,-1);
        }
        
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */