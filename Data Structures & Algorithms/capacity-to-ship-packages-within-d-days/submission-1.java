class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int left=0;
        int right=0;
        for(int n:weights){
            left=Math.max(left,n);
            right+=n;
        }
        while(left<right){
            int mid=left+(right-left)/2;
            int curw=0;
            int cap=mid;
            int daysreq=1;
            for(int w:weights){
                if(curw+w>mid){
                    daysreq++;
                    curw=w;
                    continue;
                }
                curw+=w;
            }

            if(daysreq<=days){
                right=mid;
            }else{
                left=mid+1;
            }
        }
        return left;


        
    }
}