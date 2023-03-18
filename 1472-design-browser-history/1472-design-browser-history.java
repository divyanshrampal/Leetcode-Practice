class BrowserHistory {
    
    Stack<String> prev;
    Stack<String> next;
    String curr;
    
    public BrowserHistory(String homepage) {
        prev = new Stack<>();
        next = new Stack<>();
        curr = homepage;
        
    }
    
    public void visit(String url) {
        prev.push(curr);
        curr = url;
        next = new Stack<>();
    }
    
    public String back(int steps) {
        while(steps > 0 && prev.empty() == false){
            next.push(curr);
            curr = prev.peek();
            prev.pop();
            steps--;
        }
        
        return curr;
    }
    
    public String forward(int steps) {
        
        while(steps > 0 && next.empty() == false){
            prev.push(curr);
            curr = next.peek();
            next.pop();
            steps--;
        }
        
        return curr;
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */