class Solution {
    int count=0;
    public int countSubstrings(String s) {

        for(int i=0;i<s.length();i++){
            count+=countPal(s,i,i);
            count+=countPal(s,i,i+1);
        }
        return count;
        
    }

    private int countPal(String s,int left,int right){
        int count=0;
        while(left>=0 && right<s.length() && s.charAt(left)==s.charAt(right)){
            count++;
            left--;
            right++;
        }
        return count;
    }
}
