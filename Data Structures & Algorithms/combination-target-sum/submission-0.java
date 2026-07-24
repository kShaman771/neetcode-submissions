class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> result=new ArrayList<>();
        dfs(0,nums,target,0,new ArrayList<>(),result);
        return result;
    }
    private void dfs(int index,int[] nums,int target,int cursum,List<Integer> current,List<List<Integer>> result){
        if(cursum==target){
            result.add(new ArrayList<>(current));
            return;
        }
        if(index==nums.length || cursum>target){
            return;
        }
        current.add(nums[index]);
        dfs(index,nums,target,cursum+nums[index],current,result);
        current.remove(current.size()-1);
        dfs(index+1,nums,target,cursum,current,result);
    }
}
