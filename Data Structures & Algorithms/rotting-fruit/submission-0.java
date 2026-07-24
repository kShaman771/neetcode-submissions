class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> q=new LinkedList<>();
        int fresh=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==2){
                    q.offer(new int[]{i,j});
                }
                if(grid[i][j]==1){
                    fresh++;
                }   
        }
        }
        if(fresh==0){
            return 0;
        }
        int minutes=0;
        int dir[][]={{1,0},{-1,0},{0,1},{0,-1}};
        while(!q.isEmpty() && fresh>0){
            int size=q.size();
            for(int i=0;i<size;i++){
                int[] curr=q.poll();
                int row=curr[0];
                int col=curr[1];
                for(int[] d:dir){
                    int newrow=row+d[0];
                    int newcol=col+d[1];
                    if(newrow<0 || newrow>=grid.length || newcol<0 || newcol>=grid[0].length){
                        continue;
                    }
                    if(grid[newrow][newcol]!=1){
                        continue;
                    }
                    grid[newrow][newcol]=2;
                    fresh--;

                    q.offer(new int[]{newrow,newcol});
                }

        }
        minutes++;
        

        
    }
    return fresh==0?minutes:-1;

    }
}
