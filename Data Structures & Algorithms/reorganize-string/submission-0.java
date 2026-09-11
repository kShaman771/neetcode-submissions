class Solution {
    public String reorganizeString(String s) {
        int[] freq=new int[26];
        StringBuilder sb=new StringBuilder();
        for(char c:s.toCharArray()){
            freq[c-'a']++;
        }
        PriorityQueue<Character> pq=new PriorityQueue<>((a,b)-> freq[b-'a']- freq[a-'a']);
        for(char c='a';c<='z';c++){
            if(freq[c-'a']>0){
                pq.offer(c);
            }
        }
        while(pq.size()>1){
            char c1=pq.poll();
            char c2=pq.poll();
            sb.append(c1).append(c2);
            if(--freq[c1-'a']>0){
                pq.offer(c1);
            }
            if(--freq[c2-'a']>0){
                pq.offer(c2);
            }

        }

        if(!pq.isEmpty()){
            char c=pq.poll();
            if(freq[c-'a']>1){
                return "";
            }
            sb.append(c);
        }
        return sb.toString();
        
    }
}