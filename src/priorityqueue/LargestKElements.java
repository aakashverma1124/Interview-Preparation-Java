import java.util.*;

class LargestKElements {

	public static int[] largestKElements(int arr[], int k) {
		PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b) -> a - b);
		for(int i = 0; i < arr.length; i++) {
			minHeap.offer(arr[i]);
			if(minHeap.size() == k + 1) {
				minHeap.poll();
			}
		}
		int ans[] = new int[k];
		for(int i = 0; i < k; i++) {
			ans[i] = minHeap.poll();
		}
		return ans;
	}

	public static void main(String[] args) {
		int arr[] = {1, 4, 5, 3, 7, 8, 6, 10};
		int k = 3;
		int ans[] = LargestKElements.largestKElements(arr, k);
		for(int a : ans) {
			System.out.print(a + " ");
		}
	}
}