class Solution {
    public List<Integer> partitionLabels(String s) {
        int[] last=new int[26];
        char[] c=s.toCharArray();
        int end=0;
        int start=0;
        List<Integer> result=new ArrayList<>();
        for(int i=0;i<c.length;i++){
            last[c[i]-'a']=i;
        }
        for(int i=0;i<c.length;i++){
            end=Math.max(end,last[c[i]-'a']);
            if(i==end){
                result.add(i-start+1);
                start=i+1;
                continue;
            }

        }
        return result;
        
    }
}
