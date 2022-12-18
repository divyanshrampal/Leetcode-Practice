class Solution {

    boolean isdigit(String token){
        char ch = token.charAt(token.length()-1);
        return (ch != '+' && ch != '-' && ch != '*' && ch != '/');
    }
    
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        int number = 0;

        for(int i = 0; i<tokens.length; i++){
            
            if(isdigit(tokens[i])){
                number = Integer.parseInt(tokens[i]);
                st.push(number);
                continue;
            }    
            if(tokens[i].charAt(0) == '+'){
                int first = st.pop();
                int second = st.pop();
                st.push(first+second);
            }
            else if(tokens[i].charAt(0) == '-'){
                int first = st.pop();
                int second = st.pop();
                st.push(second-first);
            }
            else if(tokens[i].charAt(0) == '*'){
                int first = st.pop();
                int second = st.pop();
                st.push(second*first);
            }
            else if(tokens[i].charAt(0) == '/'){
                int first = st.pop();
                int second = st.pop();
                st.push(second/first);
            }
        }

        return st.pop();


    }
}