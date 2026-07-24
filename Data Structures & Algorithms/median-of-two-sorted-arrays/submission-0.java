class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length > nums2.length){
            return findMedianSortedArrays(nums2, nums1);
            }
        int m=nums1.length;
        int n=nums2.length;
        int total=m+n;
        int half=(total+1)/2;
        int left=0;
        int right=m;
        while(left<=right){
            int x=left+(right-left)/2;
            int y=half-x;//elems to be selected from larger array
            int Aleft=(x==0)?Integer.MIN_VALUE:nums1[x-1];
            int Aright=(x==m)?Integer.MAX_VALUE:nums1[x];
            int Bleft=(y==0)?Integer.MIN_VALUE:nums2[y-1];
            int Bright=(y==n)?Integer.MAX_VALUE:nums2[y];
            if(Aleft <= Bright && Bleft <= Aright){
                if(total%2==1){
                    return Math.max(Aleft,Bleft);
                }
                else{
                    return (Math.max(Aleft,Bleft)+Math.min(Aright,Bright))/2.0;
                }
            }
            else if(Bleft>Aright){
                left=x+1;
            }
            else{
                right=x-1;
            }
        }
        return 0;
    }
}
