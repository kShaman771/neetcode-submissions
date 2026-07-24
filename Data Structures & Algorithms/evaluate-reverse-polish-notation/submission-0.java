class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> s1=new Stack<>();
        int result=0;
        for(String s:tokens){
            if(s.equals("+")){
                int op1=s1.pop();
                int op2=s1.pop();
                result=op2+op1;
                s1.push(result);
            }
            else if(s.equals("-")){
                int op1=s1.pop();
                int op2=s1.pop();
                result=op2-op1;
                s1.push(result);
            }
            else if(s.equals("*")){
                int op1=s1.pop();
                int op2=s1.pop();
                result=op2*op1;
                s1.push(result);
            }
            else if(s.equals("/")){
                int op1=s1.pop();
                int op2=s1.pop();
                result=op2/op1;
                s1.push(result);
            }
            else{
                s1.push(Integer.parseInt(s));
            }
        }
        return s1.pop();

    
        
    }
}
