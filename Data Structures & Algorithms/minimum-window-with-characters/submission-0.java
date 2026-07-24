class Solution {
    public String minWindow(String s, String t) {
        if (t.length()>s.length()){
            return "";
        }
        HashMap<Character,Integer>map =new HashMap<>();
        HashMap<Character,Integer>map1 =new HashMap<>();
        for(char ch:t.toCharArray()){
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        int left=0;
        int need=map.size();
        int have=0;
        int start=0;
        int minlength=Integer.MAX_VALUE;
        for(int right=0;right<s.length();right++){
            char c=s.charAt(right);
            map1.put(c,map1.getOrDefault(c,0)+1);
            if(map.containsKey(c) && map1.get(c).intValue()==map.get(c).intValue()){
                have++;
            }
            while(have==need){
                if(right-left+1<minlength){
                    minlength=right-left+1;
                    start=left;
                }
                char ch1=s.charAt(left);
                map1.put(ch1,map1.get(ch1)-1);
                if(map.containsKey(ch1) && map1.get(ch1)<map.get(ch1)){
                    have--;
                }
                left++;

            }

        }
        if(minlength==Integer.MAX_VALUE){
            return "";
        }
        else{
            return s.substring(start,start+minlength);
        }


        
    }
}
