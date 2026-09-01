class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res=new ArrayList<>();
        for(int i=0;i<nums.length-2;i++){
            if(i>0 && nums[i]==nums[i-1]){
                continue;
            }
            int target=-nums[i];
            int j=i+1;
            int k=nums.length-1;
            while(j<k){
                if(nums[j]+nums[k]==target){
                    List<Integer> ar=new ArrayList<>();
                    ar.add(nums[i]);
                    ar.add(nums[j]);
                    ar.add(nums[k]);
                    res.add(ar);
                    j++;
                    k--;

                    while(j<k && nums[j]==nums[j-1]){
                        j++;
                    }
                    while(j<k && nums[k]==nums[k+1]){
                        k--;
                    }

                }else if(nums[j]+nums[k]<target){
                    j++;
                }else{
                    k--;
                }
            }
        }
        return res;
    }
}
