class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result=new ArrayList<>();
        dfs(0,nums,new ArrayList<>(),result);
        return result;    
    }
    private void dfs(int index,int[] nums,List<Integer> current,List<List<Integer>> result){
        if(index==nums.length){
            result.add(new ArrayList<>(current));
            return;
        }

    current.add(nums[index]);
    dfs(index+1,nums,current,result);
    current.remove(current.size()-1);

    dfs(index+1,nums,current,result);
    }
}

