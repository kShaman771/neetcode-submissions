class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals,(a,b) -> a[0]-b[0]);
        int removed=0;
        int prevend=intervals[0][1];
        for(int i=1;i<intervals.length;i++){
            int curstart=intervals[i][0];
            int curend=intervals[i][1];
            if(curstart<prevend){
                removed++;
                prevend=Math.min(prevend,curend);
            }
            else{
                prevend=curend;
            }
        }
        return removed;
        
    }
}
