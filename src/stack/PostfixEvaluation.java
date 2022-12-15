import java.util.*;

class PostfixEvaluation {

	public static int evaluate(int left, int right, char ch) {
		if(ch == '+') return left + right;
		else if(ch == '-') return left - right;
		else if(ch == '*') return left * right;
		else if(ch == '/') return left / right;
		else if(ch == '^') return left ^ right;
		else return left % right;
	}

	public static int evaluatePostfix(String s) {

		Stack<Integer> stack = new Stack<>();

		for(int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if(Character.isDigit(ch)) {
				stack.push(Integer.parseInt(String.valueOf(ch)));
			} else {
				int right = stack.pop();
				int left = stack.pop();
				stack.push(PostfixEvaluation.evaluate(left, right, ch));
			}
		}
		return stack.pop();
	}

	public static void main(String[] args) {
		String s = "236*+8-";
		int ans = PostfixEvaluation.evaluatePostfix(s);
		System.out.println(ans);
 	}
}