class MinStack {
    ArrayList<int[]> stack;

    public MinStack() {
        stack = new ArrayList<>();
    }
    
    public void push(int val) {
        int min = val;
        if (!stack.isEmpty()) {
            int prevMin = stack.get(stack.size()-1)[1];
            min = Math.min(prevMin, val);
        }
        // put curr val and min into arr and push
        stack.add(new int[]{val, min});
    }
    
    public void pop() {
        // remove last one from list
        stack.remove(stack.size() - 1);
    }
    
    public int top() {
        // get last one
        return stack.get(stack.size() - 1)[0];
    }
    
    public int getMin() {
        // from last element in list [1] elem.
        return stack.get(stack.size() - 1)[1];
    }
}
