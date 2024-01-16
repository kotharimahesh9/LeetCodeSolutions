class RandomizedSet {
    
    private Set<Integer> randomSet;
    public RandomizedSet() {
        randomSet = new HashSet<>();
    }
    
    public boolean insert(int val) {
        if(randomSet.contains(val))
            return false;
        randomSet.add(val);
        return true;
    }
    
    public boolean remove(int val) {
        if(!randomSet.contains(val))
            return false;
        randomSet.remove(val);
        return true;
    }
    
    public int getRandom() {
        int size = randomSet.size();
        Random rand = new Random();
        int max = size-1;
        int min = 0;
        int randomNumber = rand.nextInt(max - min + 1) + min;
        return (int) randomSet.toArray()[randomNumber];
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */