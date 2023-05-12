class CustomStack {
    
    Stack<Integer> st;
    int maxSize;
    
    public CustomStack(int maxSize) {
        this.st = new Stack<>();
        this.maxSize = maxSize;
    }
    
    public void push(int x) {
        if(st.size() < maxSize){
            st.push(x);
        }
    }
    
    public int pop() {
        if(!st.empty()){
            return st.pop();
        }
        else{
            return -1;
        }
    }
    
    public void increment(int k, int val) {
        if(st.size() <= k){
            Stack<Integer> temp = new Stack<>();
            while(st.empty() == false){
                temp.push(st.pop() + val);
            }
            while(temp.empty() == false){
                st.push(temp.pop());
            }
        }
        else{
            Stack<Integer> temp = new Stack<>();
            while(st.empty() == false){
                temp.push(st.pop());
            }
            while(temp.empty() == false){
                if(k > 0){
                    st.push(temp.pop() + val);
                }
                else{
                    st.push(temp.pop());
                }
                k--;
            }
        }
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */