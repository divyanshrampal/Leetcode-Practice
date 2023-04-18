class Solution {
    public String reverseParentheses(String s) {
     
        Stack<Character> st = new Stack<>();
        
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(ch == ')'){
                Queue<Character> que = new LinkedList<>();
                char temp = st.pop();
                while(temp != '('){
                    que.add(temp);
                    temp = st.pop();
                }
                
                while(que.size() > 0){
                    st.push(que.remove());
                }
            }
            else{
                st.push(ch);
            }
        }
        
        char[] ans = new char[st.size()];
        
        for(int i = st.size() - 1; i >= 0; i--){
            ans[i] = st.pop();
        }
        
        return new String(ans); 
    }
}