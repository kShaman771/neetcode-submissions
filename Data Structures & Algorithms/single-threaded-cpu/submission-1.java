class Solution {
    public int[] getOrder(int[][] tasks) {
        int[] res=new int[tasks.length];
        int[][] arr=new int[tasks.length][3];
        int n=tasks.length;
        int idx=0;
        for(int i=0;i<tasks.length;i++){
            arr[i][0]=tasks[i][0];
            arr[i][1]=tasks[i][1];
            arr[i][2]=i;
        }
        Arrays.sort(arr,(a,b) -> Integer.compare(a[0],b[0]));
        PriorityQueue<int[]> pq=new PriorityQueue<>(
            (a,b)->{
                if(a[1]!=b[1]){
                    return Integer.compare(a[1],b[1]);}
            return Integer.compare(a[2],b[2]);
            });
        
        int i=0;
        int time=0;
        while(i<n || !pq.isEmpty()){
            while(i<n && arr[i][0]<=time ){
                pq.offer(arr[i]);
                i++;
            }
            if(pq.isEmpty()){
                time=arr[i][0];
                continue;
            }
            int[] cur=pq.poll();
            res[idx++]=cur[2];
            time+=cur[1];

        }
        return res;

    
        

        
    }
}