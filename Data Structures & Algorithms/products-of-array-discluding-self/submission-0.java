class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] output= new int[nums.length];
        int[] prefix= new int[nums.length];
        int[] suffix= new int[nums.length];
        int prod1=1;
        int prod2=1;
        prefix[0]=1;
        for(int i=1;i<nums.length;i++){
            prefix[i]=prefix[i-1]*nums[i-1];
        }
        suffix[nums.length-1]=1;
        for(int j=nums.length-2;j>=0;j--){
            suffix[j]=suffix[j+1]*nums[j+1];
        }
        for(int k=0;k<nums.length;k++){
            output[k]=prefix[k]*suffix[k];
        }
        return output;

        
    }
}  
