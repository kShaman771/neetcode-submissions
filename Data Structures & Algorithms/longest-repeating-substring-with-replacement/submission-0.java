class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character,Integer> map=new HashMap<>();
        char[] ch=s.toCharArray();
        int left=0;
        int count=0;
        int maxfreq=0;
        for(int right=0;right<ch.length;right++){
            map.put(ch[right],map.getOrDefault(ch[right],0)+1);
            maxfreq=Math.max(maxfreq,map.get(ch[right]));
            while((right-left+1)-maxfreq>k){
                map.put(ch[left],map.getOrDefault(ch[left],0)-1);
                left++;
            }
            count=Math.max(count,right-left+1);
        }
        return count;
        
    }
}
