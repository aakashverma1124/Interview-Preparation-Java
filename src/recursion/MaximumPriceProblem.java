public class MaximumPriceProblem {

    public static int solve(int[] winePrice, int left, int right) {
        if(left > right) return 0;
        int year = winePrice.length - (right - left);
        int leftCost = winePrice[left] * year + solve(winePrice, left + 1, right);
        int rightCost = winePrice[right] * year + solve(winePrice, left, right - 1);
        return Math.max(leftCost, rightCost);
    }

    public static int maxPrice(int[] winePrice) {
        return MaximumPriceProblem.solve(winePrice, 0, winePrice.length - 1);
    }
    public static void main(String[] args) {
        int[] winePrice = new int[]{2, 3, 5, 1, 4};
        System.out.println(MaximumPriceProblem.maxPrice(winePrice));
    }    
}
