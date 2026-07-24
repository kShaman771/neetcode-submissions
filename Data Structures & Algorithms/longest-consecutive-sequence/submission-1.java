class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set=new HashSet<>();
        int longest=0;
        for(int i:nums){
            set.add(i);
        }
        for(int num:set){
            if(!set.contains(num-1)){
                int start=num;
                int count=1;
                while(set.contains(start+1)){
                    count++;
                    start++;
                }
                longest=Math.max(longest,count);
            }
            
        }
        return longest;

    }
}
