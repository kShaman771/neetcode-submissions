class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set=new HashSet<>(wordList);
        if(!set.contains(endWord)){
            return 0;
        }
        Queue<String> q=new LinkedList<>();
        Set<String>visited=new HashSet<>();
        q.offer(beginWord);
        visited.add(beginWord);

        int step=1;

        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                String word=q.poll();
                if(word.equals(endWord)){
                    return step;
                }
                char[] c=word.toCharArray();
                for(int j=0;j<c.length;j++){
                    char original=c[j];

                    for(char ch='a';ch<='z';ch++){
                        c[j]=ch;
                        String next=new String(c);
                        if(set.contains(next)&&!visited.contains(next)){
                            visited.add(next);
                            q.offer(next);
                        }                    
                        }
                        c[j]=original;
                }
            }
            step++;
        }
        return 0;
    }
}
