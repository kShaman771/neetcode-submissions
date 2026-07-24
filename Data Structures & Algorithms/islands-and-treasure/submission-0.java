class Solution {
    public void islandsAndTreasure(int[][] grid) {
        Queue<int[]> q=new LinkedList<>();
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==0){
                q.offer(new int[]{i,j});}
            }
        }

        int[][] dir={{1,0},{-1,0},{0,1},{0,-1}};
        while(!q.isEmpty()){
            int[] cur=q.poll();
            int row=cur[0];
            int col=cur[1];

            for(int[] d:dir){
                int newrow=row+d[0];
                int newcol=col+d[1];

                if(newrow<0 || newrow>=grid.length || newcol<0 || newcol>=grid[0].length){
                    continue;
                }

                if(grid[newrow][newcol]!=Integer.MAX_VALUE){
                    continue;
                }

                grid[newrow][newcol]=grid[row][col] +1;
                q.offer(new int[]{newrow,newcol});
            }
        }

        return;
        
    }
}
