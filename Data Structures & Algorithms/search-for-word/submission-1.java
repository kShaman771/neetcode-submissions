class Solution {
    public boolean exist(char[][] board, String word) {
        int row=board.length;
        int col=board[0].length;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(dfs(board,i,j,word,0)){
                    return true;
                }
            }
        }
        return false;
        
    }

    private boolean dfs(char[][] board,int row,int col,String word,int index){
        if(index==word.length()){
            return true;
        }
        if(row<0 || row>=board.length || col<0 || col>=board[0].length){
            return false;
        }
        if(board[row][col]!=word.charAt(index)){
            return false;
        }
        char temp=board[row][col];
        board[row][col]='#';
        boolean found=dfs(board,row+1,col,word,index+1) || dfs(board,row-1,col,word,index+1) || dfs(board,row,col+1,word,index+1) || dfs(board,row,col-1,word,index+1);
        board[row][col]=temp;

        return found;
    }
}
