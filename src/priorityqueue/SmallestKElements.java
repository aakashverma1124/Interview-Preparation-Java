import java.util.*;

class SmallestKElements {

	public static int[] smallestKElements(int arr[], int k) {
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
		for(int i = 0; i < arr.length; i++) {
			maxHeap.offer(arr[i]);
			if(maxHeap.size() == k + 1) {
				maxHeap.poll();
			}
		}
		int ans[] = new int[k];
		for(int i = 0; i < k; i++) {
			ans[i] = maxHeap.poll();
		}
		return ans;
	}

	public static void main(String[] args) {
		int arr[] = {1, 4, 5, 3, 7, 8, 6, 10};
		int k = 3;
		int ans[] = SmallestKElements.smallestKElements(arr, k);
		for(int a : ans) {
			System.out.print(a + " ");
		}
	}
}