class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<int[]>> graph=new ArrayList<>();
        for(int i=0;i<=n;i++){
            graph.add(new ArrayList<>());
        }
        for(int[] edge: times){
            int u=edge[0];
            int v=edge[1];
            int w=edge[2];
            graph.get(u).add(new int[]{v,w});
        }
        int dist[]=new int[n+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[k]=0;
        PriorityQueue<int[]>pq=new PriorityQueue<>((a,b) -> a[0]-b[0]);

        pq.offer(new int[]{0,k});
        while(!pq.isEmpty()){
            int[] cur=pq.poll();
            int d=cur[0];
            int node=cur[1];

            if(d>dist[node]){
                continue;
            }

            for(int[] nei:graph.get(node)){
                int next=nei[0];
                int weight=nei[1];

                if(weight+dist[node]<dist[next]){
                    dist[next]=dist[node]+weight;

                    pq.offer(new int[]{dist[next],next});
                }
            }
        }

        int answer=0;
        for(int i=1;i<=n;i++){
            if(dist[i]==Integer.MAX_VALUE){
                return -1;
            }
            answer=Math.max(answer,dist[i]);
        }

        return answer;
    }
}
