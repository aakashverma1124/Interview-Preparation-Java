import java.util.*;

class Node {
    int x, y, t;
    public Node(int x, int y, int t) {
        this.x = x;
        this.y = y;
        this.t = t;
    }
}

class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<Node> queue = new LinkedList<>();
        
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 2) {
                    queue.offer(new Node(i, j, 0));
                }
            }
        }

        int ans = 0;

        while(!queue.isEmpty()) {
            Node node = queue.poll();
            int curr_x = node.x;
            int curr_y = node.y;
            int curr_time = node.t;

            if((curr_x - 1) >= 0 && grid[curr_x - 1][curr_y] == 1){
                grid[curr_x - 1][curr_y] = 2;
                queue.offer(new Node(curr_x - 1, curr_y, curr_time + 1));
                ans = curr_time + 1;
            }
            if((curr_x + 1) < grid.length && grid[curr_x + 1][curr_y] == 1) {
                grid[curr_x + 1][curr_y] = 2;
                queue.offer(new Node(curr_x + 1, curr_y, curr_time + 1));
                ans = curr_time + 1;
            }
            if((curr_y - 1) >= 0 && grid[curr_x][curr_y - 1] == 1){
                grid[curr_x][curr_y - 1] = 2;
                queue.offer(new Node(curr_x, curr_y - 1, curr_time + 1));
                ans = curr_time + 1;
            }
            if((curr_y + 1) < grid[0].length && grid[curr_x][curr_y + 1] == 1) {
                grid[curr_x][curr_y + 1] = 2;
                queue.offer(new Node(curr_x, curr_y + 1, curr_time + 1));
                ans = curr_time + 1;
            }
        }

        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 1) {
                    return -1;
                }
            }
        }

        return ans;
    }
}