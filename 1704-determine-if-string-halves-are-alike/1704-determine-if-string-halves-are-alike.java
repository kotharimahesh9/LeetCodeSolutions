class Solution {
    public boolean halvesAreAlike(String s) {
        int n = s.length();
        int first = 0;
        int last = n-1;
        Set<Character> vowelSet = new HashSet<>();
        vowelSet.add('a');
        vowelSet.add('e');
        vowelSet.add('i');
        vowelSet.add('o');
        vowelSet.add('u');
        vowelSet.add('A');
        vowelSet.add('E');
        vowelSet.add('I');
        vowelSet.add('O');
        vowelSet.add('U');
        int c1 = 0;
        int c2 = 0;
        while(first < n/2){
            char ch1 = s.charAt(first);
            char ch2 = s.charAt(last);
            
            if(vowelSet.contains(ch1))
                c1++;
            if(vowelSet.contains(ch2))
                c2++;
            first++;
            last--;
        }
        
        return c1 == c2;
        
    }
}