class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph=new ArrayList<>();

        for(int i=0;i<numCourses;i++){
            graph.add(new ArrayList<>());
        }

        for(int[] pre:prerequisites){
            graph.get(pre[0]).add(pre[1]);
    
        }

        int[] state=new int[numCourses];

        for(int i=0;i<numCourses;i++){
            if(dfs(i,graph,state)){
                return false;
            }
        }
        return true;
    }

    private boolean dfs(int course,List<List<Integer>> graph,int[] state){
        if(state[course]==1){
            return true;
        }
        if(state[course]==2){
            return false;
        }
        state[course]=1;

        for(int next:graph.get(course)){
            if(dfs(next,graph,state)){
                return true;
            }
        }
        state[course]=2;
        return false;

    }
}
