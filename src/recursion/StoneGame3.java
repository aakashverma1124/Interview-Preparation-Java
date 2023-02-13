class StoneGame3 {

    public static int solve(int stones[], int i) {

        if(i >= stones.length) {
            return 0;
        }
        
        int a, b, c;
        b = Integer.MIN_VALUE;
        c = Integer.MIN_VALUE;
        a = stones[i] - solve(stones, i + 1);
        if(i + 1 < stones.length) {
            b = stones[i] + stones[i + 1] - solve(stones, i + 2);
        }
        if(i + 1 < stones.length && i + 2 < stones.length) {
            c = stones[i] + stones[i + 1] + stones[i + 2] - solve(stones, i + 3);
        }

        return Math.max(a, Math.max(b, c));
    }

    public static String stoneGame(int stones[]) {
        int val = StoneGame3.solve(stones, 0);
        if(val > 0) return "Alice";
        else if(val == 0) return "Tie";
        else return "Bob";
    }
    public static void main(String[] args) {
        int stones[] = new int[]{5, 2, 4, 7};
        System.out.println(StoneGame3.stoneGame(stones));
    }
}