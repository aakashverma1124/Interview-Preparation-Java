import java.util.*;

class MaximumAreaHistogram {

	public static int[] nsel(int arr[]) {
		Stack<Integer> stack = new Stack<>();
		int nsel[] = new int[arr.length];
		for(int i = 0; i < arr.length; i++) {
			while(!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
				stack.pop();
			}
			if(stack.isEmpty()) {
				nsel[i] = -1;
			} else {
				nsel[i] = stack.peek();
			}
			stack.push(i);
		}
		return nsel;
	}

	public static int[] nser(int arr[]) {
		Stack<Integer> stack = new Stack<>();
		int nser[] = new int[arr.length];
		for(int i = arr.length - 1; i >= 0; i--) {
			while(!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
				stack.pop();
			}
			if(stack.isEmpty()) {
				nser[i] = arr.length;
			} else {
				nser[i] = stack.peek();
			}
			stack.push(i);
		}
		return nser;
	}

	public static int maximumAreaHistogram(int arr[]) {
		int nser_i[] = MaximumAreaHistogram.nser(arr);
		int nsel_i[] = MaximumAreaHistogram.nsel(arr);
		int maximumArea = Integer.MIN_VALUE;
		for(int i = 0; i < arr.length; i++) {
			maximumArea = Math.max(maximumArea, (nser_i[i] - nsel_i[i] - 1) * arr[i]);
		}
		return maximumArea;
	}

	public static void main(String[] args) {
		int arr[] = new int[]{2, 1, 2};
		int ans = maximumAreaHistogram(arr);
		System.out.println(ans);
	}
}