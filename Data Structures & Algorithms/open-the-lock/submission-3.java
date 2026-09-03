class Solution {
    public int openLock(String[] deadends, String target) {
        Set<String> set=new HashSet<>(Arrays.asList(deadends));
        if(set.contains("0000")){
            return -1;
        }
        Queue<String> q=new LinkedList<>();
        Set<String> visited=new HashSet<>();
        q.offer("0000");
        visited.add("0000");
        int moves=0;
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                String cur=q.poll();
                if(cur.equals(target)){
                    return moves;
                }
                for(int j=0;j<4;j++){
                    String next=rotate(cur,j,1);
                    if(!set.contains(next) && !visited.contains(next)){
                        visited.add(next);
                        q.offer(next);
                    }
                    next=rotate(cur,j,-1);
                    if(!set.contains(next) && !visited.contains(next)){
                        visited.add(next);
                        q.offer(next);
                    }                   
                }
            }
            moves++;
        }
        return -1;
        
    }

    private String rotate(String cur,int index,int dir){
        char[] ar=cur.toCharArray();
        if(dir==1){
            ar[index]=(char) ((ar[index] -'0' +1)%10 +'0');
        }else{
            ar[index]=(char) ((ar[index] -'0' +9)%10 +'0');
        }
        return new String(ar);
    }
}