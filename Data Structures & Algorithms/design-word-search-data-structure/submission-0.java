class WordDictionary {
    class TrieNode{
        TrieNode[] children;
        boolean isEnd;

        TrieNode(){
            children=new TrieNode[26];
            isEnd=false;
        }
    }

    private TrieNode root;

    public WordDictionary() {
        root=new TrieNode();
    }

    public void addWord(String word) {
        TrieNode cur=root;
        for(char c:word.toCharArray()){
            int index=c-'a';
            if(cur.children[index]==null){
                cur.children[index]=new TrieNode();
            }
            cur=cur.children[index];
        }
        cur.isEnd=true;

    }

    public boolean search(String word) {
        return dfs(word,0,root);
    }

    private boolean dfs(String word, int i, TrieNode cur){
        if(i==word.length()){
            return cur.isEnd;
        }
        char c=word.charAt(i);
        if(c!='.'){
            int index=c-'a';
            if(cur.children[index]==null){
                return false;
            }
            return dfs(word,i+1,cur.children[index]);
        }

        for(int j=0;j<26;j++){
            if(cur.children[j]!=null){
                if(dfs(word,i+1,cur.children[j])){
                    return true;
                }
            }
        }
        return false;


    }
}
