class Solution {
    class TrieNode{
        TrieNode[] children;
        String word;

        TrieNode(){
            children=new TrieNode[26];
            word=null;
        }
    }
    private TrieNode root;
    private List<String> result = new ArrayList<>();

    public List<String> findWords(char[][] board, String[] words) {
        root=new TrieNode();
        for(String word:words){
            insert(word);
        }

        int row=board.length;
        int column=board[0].length;
        for(int i=0;i<row;i++){
            for(int j=0;j<column;j++){
                dfs(board,i,j,root);
            }
        }
        return result;     
    }

    private void insert(String word){
        TrieNode cur=root;
        for(char c:word.toCharArray()){
            int index=c-'a';
            if(cur.children[index]==null){
                cur.children[index]=new TrieNode();
            }
            cur=cur.children[index];
        }
        cur.word=word;
    }


    private void dfs(char[][] board,int row,int col,TrieNode node){
        if(row<0 || row>=board.length || col<0 || col>=board[0].length){
            return;
        }
        char c=board[row][col];
        if(c=='#'){
            return;
        }
        if(node.children[c-'a']==null){
            return;
        }
        node=node.children[c-'a'];

        if(node.word!=null){
            result.add(node.word);
            node.word=null;
        }

        board[row][col]='#';

        dfs(board,row-1,col,node);
        dfs(board,row+1,col,node);
        dfs(board,row,col-1,node);
        dfs(board,row,col+1,node);

        board[row][col]=c;
    }
}
