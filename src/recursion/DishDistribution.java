public class DishDistribution {

    private static int solve(int dishes, int i, int[][] cooks) {
        if(i == cooks.length && dishes == 0) return 1;
        if(i == cooks.length || dishes < 0) return 0;
        int count = 0;
        int min = cooks[i][0];
        int max = cooks[i][1];
        if(dishes < min) return 0;

        for(int j = min; j <= max; j++) {
            count += solve(dishes - j, i + 1, cooks);
        }
        return count;
    }

    private static int distribute(int dishes, int cno, int[][] cooks) {
        return DishDistribution.solve(dishes, 0, cooks);
    }
    
    public static void main(String[] args) {
        int dishes = 3;
        int cno = 2;
        int[][] cooks = new int[][]{{0, 3}, {1, 3}};
        System.out.println(DishDistribution.distribute(dishes, cno, cooks));
    }
}
