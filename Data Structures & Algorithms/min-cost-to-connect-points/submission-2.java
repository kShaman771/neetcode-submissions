class Solution {
    int[] parent;
    int[] rank;
    public int minCostConnectPoints(int[][] points) {
        int n =points.length;
        parent=new int[n];
        rank=new int[n];

        for(int i=0;i<n;i++){
            parent[i]=i;
        }

        List<int[]> edge=new ArrayList<>();

        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int cost=Math.abs(points[i][0]-points[j][0])+Math.abs(points[i][1]-points[j][1]);
                edge.add(new int[]{cost,i,j});
            }
        }

        Collections.sort(edge,(a,b)->a[0]-b[0]);

        int answer=0;
        int used=0;
        for(int[] e:edge){
            int cost=e[0];
            int u=e[1];
            int v=e[2];

            if(union(u,v)){
                answer+=cost;
                used++;

                if(used==n-1){
                    break;
                }
            }
        }

        return answer;
        
    }


    private int find(int x){
        if(parent[x]!=x){
            parent[x]=find(parent[x]);
        }
        return parent[x];

    }

    private boolean union(int x,int y){
        int px=find(x);
        int py=find(y);

        if(px==py){
            return false;
        }
        if(rank[px]>rank[py]){
            parent[py]=px;
        }
        else if(rank[px]<rank[py]){
            parent[px]=py;
        }
        else{
            parent[py]=px;
            rank[px]++;
        }
        return true;

    }
}
