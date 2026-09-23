class StockSpanner {
    Stack<int[]> lookmanStack;

    public StockSpanner() {
        lookmanStack=new Stack<>();
    }
    
    public int next(int price) {
        int span=1;
        while(!lookmanStack.isEmpty()&& lookmanStack.peek()[0] <= price){
            span=span+lookmanStack.peek()[1];
            lookmanStack.pop();
        }
        lookmanStack.push(new int[]{price,span});
        return span;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */