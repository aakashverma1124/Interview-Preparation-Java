import java.util.*;

class Point {
	int x, y, d;
	public Point(int x, int y, int d) {
		this.x = x;
		this.y = y;
		this.d = d;
	}
}

class KClosestPointsToOrigin {

	public static int[][] kClosestPoints(int points[][], int k) {
		PriorityQueue<Point> maxHeap = new PriorityQueue<>((a, b) -> b.d - a.d);
		for(int i = 0; i < points.length; i++) {
		    int x = points[i][0];
		    int y = points[i][1];
			int distance = x * x + y * y;
			maxHeap.offer(new Point(x, y, distance));
			if(maxHeap.size() == k + 1) {
				maxHeap.poll();
			}
		}
		int ans[][] = new int[k][2];
		for(int i = 0; i < k; i++) {
			Point point = maxHeap.poll();
			ans[i][0] = point.x;
			ans[i][1] = point.y;
		}
		return ans;
	}

	public static void main(String[] args) {
		int points[][] = new int[][] {{-4, 3}, {-1, 1}, {5, 5}, {3, 1}, {-4, -3}, {2, -2}};
		int k = 3;
		int ans[][] = KClosestPointsToOrigin.kClosestPoints(points, k);
		for(int point[] : ans) {
			System.out.print(point[0] + " " + point[1]);
			System.out.println();
		}
	}
}