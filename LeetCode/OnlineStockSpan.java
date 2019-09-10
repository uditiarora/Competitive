class StockSpanner {
    Stack<Integer> p, c;
    public StockSpanner() {
        p = new Stack<Integer>();
        c = new Stack<Integer>();
    }
    
    public int next(int price) {
        int ans = 0;
        while(!p.isEmpty() && p.peek()<=price){
            p.pop();
            ans += c.pop();
        }
        p.push(price);
        c.push(ans+1);
        return ans + 1;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */