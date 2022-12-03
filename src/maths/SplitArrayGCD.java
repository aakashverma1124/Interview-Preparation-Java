import java.util.*;
/*
	19, 28, 14, 20, 1, 3, 9, 5, 3
*/
class SplitArrayGCD {

	public static int gcd(int a, int b) {
		if(b != 0) {
			return gcd(b, a % b);
		} else {
			return a;
		}
	}

	public static int splitArray(int arr[]) {
		int ans[] = new int[arr.length + 1];
		for(int i = arr.length - 1; i >= 0; i--) {
			ans[i] = ans[i + 1] + 1;
			for(int j = i + 1; j < arr.length; j++) {
				if(SplitArrayGCD.gcd(arr[i], arr[j]) > 1) {
					ans[i] = Math.min(ans[i], ans[j + 1] + 1);
				}
			}
		}
		return ans[0];
	}

	public static void main(String[] args) {
		int arr[] = new int[]{2, 3, 4, 5, 7, 11, 9};
		int ans = SplitArrayGCD.splitArray(arr);
		System.out.println(ans);
	}
}