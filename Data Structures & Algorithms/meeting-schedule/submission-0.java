/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public boolean canAttendMeetings(List<Interval> intervals) {
        intervals.sort((a,b) -> a.start-b.start);
        for(int i=1;i<intervals.size();i++){
            int prevend=intervals.get(i-1).end;
            int curstart=intervals.get(i).start;
            if(curstart<prevend){
                return false;
            }
        }
        return true;
    }
}
