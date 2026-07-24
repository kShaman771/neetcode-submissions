class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set=new HashSet<>();
        char[] ch=s.toCharArray();
        int left=0;
        int count=0;
        for(int right=0;right<ch.length;right++){
            while(set.contains(ch[right])){
                set.remove(ch[left]);
                left++;
            }
            set.add(ch[right]);
            count=Math.max(count,right-left+1);
        }
        return count;
        
        
    }
}
