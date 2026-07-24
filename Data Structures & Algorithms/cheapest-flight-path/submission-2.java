class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<int[]>> graph=new ArrayList<>();
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }
        for(int[] flight :flights){
            graph.get(flight[0]).add(new int[]{flight[1],flight[2]});
        }
        PriorityQueue<int[]> pq =
            new PriorityQueue<>(
                (a,b) -> a[0] - b[0]
            );

        pq.offer(new int[]{0,src,0});

        int[] stops=new int[n];
        Arrays.fill(stops,Integer.MAX_VALUE);

        while(!pq.isEmpty()){
            int[] cur=pq.poll();

            int cost=cur[0];
            int node=cur[1];
            int step=cur[2];

            if(node==dst){
                return cost;
            }

            if(step>k || step>stops[node]){
                continue;
            }
            stops[node]=step;
            for(int[] nei:graph.get(node)){
                int next=nei[0];
                int price=nei[1];

                pq.offer(new int[]{cost+price,next,step+1});
            }
        }
        return -1;

    }
}
