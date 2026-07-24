class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack= new Stack<>();
        int max=Integer.MIN_VALUE;
        for(int i=0;i<=heights.length;i++){
            int element=(i==heights.length)?0:heights[i];
            while(!stack.isEmpty() && heights[stack.peek()]>element){
                int h=heights[stack.pop()];
                int ps= stack.isEmpty()?-1:stack.peek();
                int w=i-ps-1;
                max=Math.max(max,h*w);
            }
            stack.push(i);

        }
        return (max==Integer.MIN_VALUE)?0:max;

        
    }
}
