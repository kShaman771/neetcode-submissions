class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer,Integer> map=new HashMap<>();
        int i=0;
        for(int n:nums){
            if(map.containsKey(nums[i])){
                int pre=map.get(nums[i]);
                if(i-pre<=k){
                    return true;
                }
            }
            map.put(nums[i],i);
            i++;
        }
        return false;

    }
}