class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int idx=0;
        List<Integer> res=new ArrayList<>();
        while(idx<arr.length && arr[idx]<x){
            idx++;}
        int left=idx-1;
        int right=idx;
        while(res.size()<k){
            if (left<0){
                res.add(arr[right]);
                right++;
            }
            else if(right>arr.length-1){
                res.add(arr[left]);
                left--;
            }
            else{
            int l=Math.abs(arr[left]-x);
            int r=Math.abs(arr[right]-x);
            if(l<=r){
                res.add(arr[left]);
                left--;
            }
            else{
                res.add(arr[right]);
                right++;
            }
            }
        }
        Collections.sort(res);
        return res;
        
    }
}