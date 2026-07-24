class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int row=heights.length;
        int col=heights[0].length;

        boolean[][] pacific=new boolean[row][col];
        boolean[][] atlantic=new boolean[row][col];

        for(int r=0;r<row;r++){
            dfs(r,0,heights,pacific);
            dfs(r,col-1,heights,atlantic);
        }

        for(int c=0;c<col;c++){
            dfs(0,c,heights,pacific);
            dfs(row-1,c,heights,atlantic);
        }
        List<List<Integer>> result=new ArrayList<>();
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(pacific[i][j] && atlantic[i][j]){
                    result.add(Arrays.asList(i,j));
                }
            }
        }
        return result;
    }

    private void dfs(int row,int col,int[][] heights,boolean[][] visited){
        visited[row][col]=true;

        int[][] dir={{1,0},{-1,0},{0,1},{0,-1}};

        for(int[] d:dir){
            int nr=row+d[0];
            int nc=col+d[1];

            if(nr<0 || nr>=heights.length || nc<0 || nc>=heights[0].length){
                continue;
            }
            if(visited[nr][nc]){
                continue;
            }

            if(heights[nr][nc]<heights[row][col]){
                continue;
            }

            dfs(nr,nc,heights,visited);
        }
        
    }
}
