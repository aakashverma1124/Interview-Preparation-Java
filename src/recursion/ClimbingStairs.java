public class ClimbingStairs {

    public static int solve(int currStair, int n) {
        if(currStair == n) return 1;
        if(currStair > n) return 0;

        int leftCount = solve(currStair + 1, n);
        int rightCount = solve(currStair + 2, n);

        return leftCount + rightCount;
    }

    public static int findWays(int n) {
        return ClimbingStairs.solve(0, n);
    }

    public static void main(String[] args) {
        int n = 4;
        System.out.println(ClimbingStairs.findWays(n));
    }
    
}
