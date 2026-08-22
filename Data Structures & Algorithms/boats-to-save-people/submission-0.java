class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int count=0;
        int left=0;
        int right=people.length-1;
        while(left<=right){
            int w1=people[left]+people[right];
            if(w1<=limit){
                count++;
                left++;
                right--;
            }
            else{
                count++;
                right--;
            }
        }
        return count;
        
    }
}