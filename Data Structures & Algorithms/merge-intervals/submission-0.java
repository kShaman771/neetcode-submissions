class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a,b) -> a[0]-b[0]);
        List<int[]> result=new ArrayList<>();
        int curstart=intervals[0][0];
        int curend=intervals[0][1];
        for(int i=1;i<intervals.length;i++){
            int nextstart=intervals[i][0];
            int nextend=intervals[i][1];
            if(nextstart<=curend){
                curend=Math.max(curend,nextend);
            }
            else{
                result.add(new int[]{curstart,curend});
                curstart=nextstart;
                curend=nextend;
            }

        }
        result.add(new int[]{curstart,curend});
        return result.toArray(new int[result.size()][]);
        
    }
}
