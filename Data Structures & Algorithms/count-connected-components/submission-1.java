class Solution {
    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }
        for(int[] edge :edges){

            int u=edge[0];
            int v=edge[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        boolean[] visited=new boolean[n];
        int components=0;

        for(int i=0;i<n;i++){
            if(!visited[i]){
                components++;

                dfs(i,graph,visited);
            }

        }
        return components;
    }

    private void dfs(int node,List<List<Integer>> graph,boolean[] visited){
        if(visited[node]){
            return;
        }
        visited[node]=true;
        for(int neighbour:graph.get(node)){
            dfs(neighbour,graph,visited);
        }
    }
}
