class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<Character,Integer> freq1= new HashMap<>();
        HashMap<Character,Integer> freq2= new HashMap<>();
        for (char c:s.toCharArray()){
            freq1.put(c,freq1.getOrDefault(c,0)+1);
        }
        for (char c:t.toCharArray()){
            freq2.put(c,freq2.getOrDefault(c,0)+1);
        }
        if(freq1.equals(freq2)){
            return true;
        }
        else return false;
    }
}
