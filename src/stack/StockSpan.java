import java.util.*;

class StockSpan {

	public static int[] stockSpan(int prices[]) {
		Stack<Integer> stack = new Stack<>();
		int spans[] = new int[prices.length];
		for(int i = 0; i < prices.length; i++) {
			while(!stack.isEmpty() && prices[stack.peek()] <= prices[i]) {
				stack.pop();
			}
			if(stack.isEmpty()) {
				spans[i] = i - (-1);
			} else {
				spans[i] = i - stack.peek();
			}
			stack.push(i);
		}
		return spans;
	}

	public static void main(String[] args) {
		int prices[] = new int[]{1, 2, 4, 5, 6};
		int spans[] = StockSpan.stockSpan(prices);
		for(int span : spans) {
			System.out.print(span + " ");
		}
	}
}