class Solution {
    public int[] twoSum(int[] numbers, int target) {
        HashSet<Integer> set= new HashSet<>();
        int[] result=new int[2];
        int j=0;
        int i=numbers.length-1;
        while(j<i){
            int sum=numbers[j]+numbers[i];
            if(sum==target){
                result[0]=j+1;
                result[1]=i+1;
                return result;
                
            }
            if(sum<target){
                j++;
            }
            else{
                i--;
                
            }
        }
        return result;
        
    }
}
