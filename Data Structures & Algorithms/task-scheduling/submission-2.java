class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq=new int[26];
        for(char c:tasks){
            freq[c-'A']++;
        }
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        for(int i:freq){
            if(i>0){
            pq.offer(i);}
        }
        Queue<int[]> queue=new LinkedList<>();
        int time=0;
        while(!pq.isEmpty() || !queue.isEmpty()){
            time++;
            while(!queue.isEmpty() && queue.peek()[1]==time){
                pq.offer(queue.poll()[0]);
            }            
            if(!pq.isEmpty()){
                int count=pq.poll();
                count--;
                if(count>0){
                    queue.offer(new int[]{count,n+time+1});
                    }
            }

        }

        return time;

        
    }
}
