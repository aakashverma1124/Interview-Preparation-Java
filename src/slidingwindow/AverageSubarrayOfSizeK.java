package slidingwindow;

public class AverageSubarrayOfSizeK {

    public static double[] averageSubarray(int arr[], int k) {
        double ans[] = new double[arr.length - k + 1];
        int windowStart = 0;
        int windowSum = 0;
        for(int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            windowSum += arr[windowEnd];
            if(windowEnd >= k - 1) {
                ans[windowStart] = (double) windowSum/k;
                windowSum -= arr[windowStart];
                windowStart += 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int arr[] = new int[]{1, 2, 3, 4, 5, 6};
        int k = 3;
        double ans[] = AverageSubarrayOfSizeK.averageSubarray(arr, k);
        for(double a : ans) {
            System.out.print(a + " ");
        }
    }
}
