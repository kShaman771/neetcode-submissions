class Solution {
    public int jump(int[] nums) {
        int left=0;
        int right=0;
        int jumps=0;
        while(right<nums.length-1){
            int maxreach=0;
            for(int i=left;i<=right;i++){
                maxreach=Math.max(maxreach,i+nums[i]);
            }
            left=right+1;
            right=maxreach;
            jumps++;
        }
        return jumps;
        
    }
}
