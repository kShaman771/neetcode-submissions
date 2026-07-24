class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list=new ArrayList<>();
        for(int i=0;i<nums.length-2;i++){
            if(i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            int target=-(nums[i]);
            int j=i+1;
            int k=nums.length-1;
            while(j<k){
                if(nums[j]+nums[k]==target){
                    List<Integer> mlist = new ArrayList<>();
                    mlist.add(nums[i]);
                    mlist.add(nums[j]);
                    mlist.add(nums[k]);
                    list.add(mlist);
                    j++;
                    k--;
                    while(j < k && nums[j] == nums[j-1]){
                        j++;
                    }

                    while(j < k && nums[k] == nums[k+1]){
                        k--;
                    }
                    continue;
                }
                if(nums[j]+nums[k]<target){
                    j++;
                }
                else{
                    k--;
                }
            }
        }
        return list;

        
    }
}
