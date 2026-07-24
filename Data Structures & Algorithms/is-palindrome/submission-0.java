class Solution {
    public boolean isPalindrome(String s) {
        char[] ch=s.toCharArray();
        int i=0;
        int j=ch.length-1;
        while(i<j){
            if(!Character.isLetterOrDigit(ch[i])){
                i++;
                continue;
            }
            if(!Character.isLetterOrDigit(ch[j])){
                j--;
                continue;
            }
            ch[i]=Character.toLowerCase(ch[i]);
            ch[j]=Character.toLowerCase(ch[j]);
            if(ch[i]!=ch[j]){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
