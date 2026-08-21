class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character,Integer> map=new HashMap<>();
        char[] c=s.toCharArray();
        int left=0;
        int maxfreq=0;
        int count=0;
        for(int right=0;right<c.length;right++){
            map.put(c[right],map.getOrDefault(c[right],0)+1);
            maxfreq=Math.max(maxfreq,map.get(c[right]));
            while((right-left+1)-maxfreq>k){
                map.put(c[left],map.getOrDefault(c[left],0)-1);
                left++;

            }
            count=Math.max(count,right-left+1);
        }
        return count;
        
    }
}
