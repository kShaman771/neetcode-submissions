class Solution {
    List<Integer> answer=new ArrayList<>();
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph=new ArrayList<>();

        for(int i=0;i<numCourses;i++){
            graph.add(new ArrayList<>());
        }

        for(int[] pre:prerequisites){
            graph.get(pre[1]).add(pre[0]);
    
        }

        int[] state=new int[numCourses];
        for(int i=0;i<numCourses;i++){
            if(dfs(i,graph,state)){
                return new int[0];
            }
        }
        Collections.reverse(answer);
        int[] result=new int[numCourses];
        for(int i=0;i<numCourses;i++){
            result[i]=answer.get(i);
        }
        return result;
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
        answer.add(course);
        return false;

            
    }
}
