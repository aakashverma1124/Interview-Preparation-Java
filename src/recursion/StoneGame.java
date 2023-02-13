class StoneGame {

    public static int solve(int stones[], int left, int right) {

        if(left > right) {
            return 0;
        }

        int left_ans = stones[left] - solve(stones, left + 1, right);
        int right_ans = stones[right] - solve(stones, left, right - 1);
        return Math.max(left_ans, right_ans);

    }

    public static boolean stoneGame(int stones[]) {
        int val = StoneGame.solve(stones, 0, stones.length - 1);
        if(val > 0) return true;
        else return false;
    }
    public static void main(String[] args) {
        int stones[] = new int[]{3, 2, 7, 3};
        System.out.println(StoneGame.stoneGame(stones));
    }
}