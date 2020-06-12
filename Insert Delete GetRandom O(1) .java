class RandomizedSet {
    HashMap<Integer,Integer> hashMap;
    List<Integer> list;
    Random random = new Random();

    /** Initialize your data structure here. */
    public RandomizedSet() {
        hashMap = new HashMap();
        list = new ArrayList(); 
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(hashMap.containsKey(val)){
            return false;
        }
        
        hashMap.put(val,list.size());
        list.add(list.size(),val);
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(!(hashMap.containsKey(val))){
            return false;
        }
        
        int lastElement = list.get(list.size() - 1);
        int indexOfcurrentElement = hashMap.get(val);
        
        list.set(indexOfcurrentElement,lastElement);
        hashMap.put(lastElement,indexOfcurrentElement);
        
        list.remove(list.size() - 1);
        hashMap.remove(val);
        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        return list.get(random.nextInt(list.size()));
    }
}

/*
    1,0             [1]
    2,1             [1,2]
    5,2             [1,2,5]
    
    remove(2)
    lastElement = 5
    indexOfcurrentElement = 1
    put at index 1 value of lastElement which is 5      [1,5,5]
    now remove the last element successfully            [1,5]
    remove the value from hashMap now.
*/


/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */