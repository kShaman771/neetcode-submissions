class Solution {
    private int start=0;
    private int maxlength=0;
    public String longestPalindrome(String s) {
        if(s==null || s.length()<2){
            return s;
        }
        for(int i=0;i<s.length();i++){
            expand(s,i,i);
            expand(s,i,i+1);
        }
        return s.substring(start,start+maxlength);
        
    }
    private void expand(String s,int left,int right){
    while(left>=0 && right <s.length() && s.charAt(left)==s.charAt(right)){
        int length=right-left+1;
        if(length>maxlength){
            maxlength=length;
            start=left;
        }

        right++;
        left--;
    }
    }
}
