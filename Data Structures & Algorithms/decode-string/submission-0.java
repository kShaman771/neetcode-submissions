class Solution {
    public String decodeString(String s) {

        Stack<Integer> numStack = new Stack<>();
        Stack<String> strStack = new Stack<>();

        String current = "";
        int num = 0;

        for (char c : s.toCharArray()) {

            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            }

            else if (c == '[') {
                numStack.push(num);
                strStack.push(current);

                num = 0;
                current = "";
            }

            else if (c == ']') {
                int k = numStack.pop();
                String prev = strStack.pop();

                StringBuilder temp = new StringBuilder(prev);

                for (int i = 0; i < k; i++) {
                    temp.append(current);
                }

                current = temp.toString();
            }

            else {
                current += c;
            }
        }

        return current;
    }
}