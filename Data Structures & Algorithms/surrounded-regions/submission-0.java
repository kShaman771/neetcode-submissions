class Solution {
    public void solve(char[][] board) {
        int row=board.length;
        int col=board[0].length;

        for(int r=0;r<row;r++){
            dfs(r,0,board);
            dfs(r,col-1,board);
        }

        for(int c=0;c<col;c++){
            dfs(0,c,board);
            dfs(row-1,c,board);
        }
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(board[i][j]=='O'){
                    board[i][j]='X';
                    ;
                }
                if(board[i][j]=='#'){
                    board[i][j]='O';
                }
            }
        }       
    }

    private void dfs(int r,int c, char[][] board){
        if(r<0||r>=board.length || c<0 || c>=board[0].length || board[r][c]!='O'){
            return;
        }
        board[r][c]='#';
        dfs(r+1, c, board);
        dfs(r-1, c, board);
        dfs(r, c+1, board);
        dfs(r, c-1, board);
    }
}
