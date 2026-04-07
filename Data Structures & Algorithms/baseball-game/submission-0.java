class Solution {
    public int calPoints(String[] operations) {
        // Our ultra-fast array stack
        int[] stack = new int[operations.length]; 
        int top = 0;
        
        for (int i = 0; i < operations.length; i++) {
            String op = operations[i];
            
            if (op.equals("+")) {
                // Add the previous two scores
                stack[top] = stack[top - 1] + stack[top - 2];
                top++;
            } else if (op.equals("D")) {
                // Double the previous score
                stack[top] = stack[top - 1] * 2;
                top++;
            } else if (op.equals("C")) {
                // Invalidate! Just move the pointer down one step.
                // The next number we push will automatically overwrite it.
                top--;
            } else {
                // If it's not +, D, or C, it MUST be a number.
                stack[top] = Integer.parseInt(op);
                top++;
            }
        }
        
        // Sum up everything currently in the stack
        int result = 0;
        for (int i = 0; i < top; i++) {
            result += stack[i]; 
        }
    
        return result;
    }
}