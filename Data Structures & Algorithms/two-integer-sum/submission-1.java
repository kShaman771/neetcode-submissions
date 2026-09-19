class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> set=new HashMap<>();
        int[] res=new int[2];
        for(int i=0;i<nums.length;i++){
            int s=target-nums[i];
            if(set.containsKey(s)){
                res[1]=i;
                res[0]=set.get(s);
                return res;
            }
            set.put(nums[i],i);
        }
        return res;
        
    }
}
