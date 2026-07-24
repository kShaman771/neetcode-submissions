class Solution {
    public boolean isValidSudoku(char[][] board) {
        for(int i=0;i<9;i++){
            HashSet<Character> set= new HashSet<>();
            for(int j=0;j<9;j++){
                if(board[i][j]=='.'){
                    continue;
                    }
                if(set.contains(board[i][j])){
                    return false;
                }
                set.add(board[i][j]);    
            }

        }
        for(int k=0;k<9;k++){
            HashSet<Character> set= new HashSet<>();
            for(int l=0;l<9;l++){
                if(board[l][k]=='.'){
                     continue;
                }
                if(set.contains(board[l][k])){
                    return false;
                }
                set.add(board[l][k]);
            }
        }
        for (int row=0;row<9;row+=3){
            for(int col=0;col<9;col+=3){
                HashSet<Character> set= new HashSet<>();
                for(int m=row;m<row+3;m++){
                    for(int n=col;n<col+3;n++){
                        if(board[m][n]=='.'){
                            continue;
                        }
                        if(set.contains(board[m][n])){
                            return false;
                        }
                        set.add(board[m][n]);

                }

                    }

                }


            }
            return true;
            

        }





    }

