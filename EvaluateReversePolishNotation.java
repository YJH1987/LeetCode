// Solution 1
public class Solution {
    interface Operator {
        int eval(int x, int y);
    }

    private static final Map<String, Operator> OPERATORS = 
        new HashMap<String, Operator>() {{
            put("+", new Operator() {
                public int eval(int x, int y) { return x + y; }
            });
            put("-", new Operator() {
                public int eval(int x, int y) { return x - y; }
            });
            put("*", new Operator() {
                public int eval(int x, int y) { return x * y; }
            });
            put("/", new Operator() {
                public int eval(int x, int y) { return x / y; }
            });
        }};
        
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            if (OPERATORS.containsKey(token)) {
                int y = stack.pop();
                int x = stack.pop();
                stack.push(OPERATORS.get(token).eval(x, y));
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }
}

// Solution 2
import java.util.ArrayDeque;

public class Solution {
    public int evalRPN(String[] tokens) {
        ArrayDeque<String> stack = new ArrayDeque<String>();
        for(int i = 0; i < tokens.length; i++) {
            String t = tokens[i];
            if(!isOperator(t)) stack.push(t);
            else {
                try {
                    int b = Integer.valueOf(stack.pop());
                    int a = Integer.valueOf(stack.pop());
                    stack.push(calc(a, b, t));
                } catch(Exception e) {
                    throw new IllegalArgumentException();
                }
            }
        }
        if(stack.size() != 1) throw new IllegalArgumentException();
        
        try {
            int r = Integer.valueOf(stack.pop());
            return r;
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }
    
    private String calc(int a, int b, String op) {
        switch(op.charAt(0)) {
            case '+':
                return String.valueOf(a + b);
            case '-':
                return String.valueOf(a - b);
            case '*':
                return String.valueOf(a * b);
            case '/':
                if(b==0) throw new IllegalArgumentException();
                else return String.valueOf(a / b);
        }
        throw new IllegalArgumentException();
    }
    
    private boolean isOperator(String t) {
        return t.equals("+") || t.equals("-") || t.equals("*") || t.equals("/");
    }
}
