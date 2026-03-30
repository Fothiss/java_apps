package leetcode;

public class Leetcode20 {
    public boolean isValid(String s) {
        java.util.Stack<Character> stack = new java.util.Stack<>();
        java.util.Map<Character, Character> brackets = new java.util.HashMap<>();
        brackets.put('(', ')');
        brackets.put('{', '}');
        brackets.put('[', ']');

        for (char sym : s.toCharArray()) {
            if (brackets.containsKey(sym)) {
                stack.push(sym);
            } else {
                if (stack.isEmpty() || sym != brackets.get(stack.peek())) {
                    return false;
                }
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}
