class StoneGameRaw {

    public static int solve(int stones[], int left, int right, boolean alice) {

        if(left > right) {
            return 0;
        }

        if(alice) {
            int left_ans = stones[left] + solve(stones, left + 1, right, !alice);
            int right_ans = stones[right] + solve(stones, left, right - 1, !alice);
            return Math.max(left_ans, right_ans);
        } else {
            int left_ans = -stones[left] + solve(stones, left + 1, right, !alice);
            int right_ans = -stones[right] + solve(stones, left, right - 1, !alice);
            return Math.min(left_ans, right_ans);
        }

    }

    public static boolean stoneGame(int stones[]) {
        int val = StoneGameRaw.solve(stones, 0, stones.length - 1, true);
        if(val > 0) return true;
        else return false;
    }
    public static void main(String[] args) {
        int stones[] = new int[]{3, 2, 7, 3};
        System.out.println(StoneGameRaw.stoneGame(stones));
    }
}