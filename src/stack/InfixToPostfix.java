import java.util.*;

class InfixToPostfix {
	public static int precedence(char ch) {
		if(ch == '+' || ch == '-') return 1;
		else if(ch == '*' || ch == '/') return 2;
		else if(ch == '^') return 3;
		else return -1;
	}
	public static String infixToPostfix(String s) {
		Stack<Character> stack = new Stack<>();
		StringBuilder result = new StringBuilder();
		for(int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if(Character.isLetterOrDigit(ch)) {
				result.append(ch);
			} else if(ch == '(') {
				stack.push(ch);
			} else if(ch == ')') {
				while(!stack.isEmpty() && stack.peek() != '(') {
					result.append(stack.pop());
				}
				if(stack.isEmpty()) return "NA";
				stack.pop();
			} else {
				while(!stack.isEmpty() && InfixToPostfix.precedence(ch) <= InfixToPostfix.precedence(stack.peek())) {
					result.append(stack.pop());
				}
				stack.push(ch);
			}
		}
		while(!stack.isEmpty()) {
			if(stack.peek() == '(') return "NA";
			result.append(stack.pop());
		}
		return result.toString();
	}
	public static void main(String[] args) {
		// String s = "a+b*(c^d-e)^(f+g*h)-i";
		String s = "a+b*c)";
		String ans = InfixToPostfix.infixToPostfix(s);
		System.out.println(ans);
	}
}