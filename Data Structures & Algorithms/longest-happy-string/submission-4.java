class Solution {
    public String longestDiverseString(int a, int b, int c) {
        class Pair{
            int count;
            char ch;
            Pair(int count,char ch){
                this.count=count;
                this.ch=ch;
            }
        }
        StringBuilder sb=new StringBuilder();
        PriorityQueue<Pair> pq=new PriorityQueue<>((r,s) -> s.count-r.count);
        if(a>0) pq.offer(new Pair(a,'a'));
        if(b>0) pq.offer(new Pair(b,'b'));
        if(c>0) pq.offer(new Pair(c,'c'));
        while(!pq.isEmpty()){
            Pair first=pq.poll();
            if(sb.length()>=2 && sb.charAt(sb.length()-1)==first.ch && sb.charAt(sb.length()-2)==first.ch){
                if(pq.isEmpty()){
                    break;
                }
                Pair second=pq.poll();
                sb.append(second.ch);
                second.count=second.count-1;
                pq.offer(first);
                if(second.count>0){
                    pq.offer(second);
                }
            }else{
                sb.append(first.ch);
                first.count=first.count-1;
                if(first.count>0){
                    pq.offer(first);
                }
            }
        }
        return sb.toString();

        
    }
}