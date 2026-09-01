class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left=0;
        HashMap<Character,Integer> map=new HashMap<>();
        int right=0;
        int max=0;
        while(right<s.length()){
            while(map.containsKey(s.charAt(right))){
                map.remove(s.charAt(left));
                left++;
            }
            max=Math.max(max,right-left+1);
            map.put(s.charAt(right),map.getOrDefault(s.charAt(right),0)+1);
            right++;

        }
        return max;
        
    }
}
