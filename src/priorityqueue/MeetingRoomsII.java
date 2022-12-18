import java.util.*;

class MeetingRoomsII {

	public static int minimumRooms(int meetings[][]) {

		Arrays.sort(meetings, (a, b) -> Integer.compare(a[0], b[0]));
		PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b) -> a - b);

		for(int meeting[] : meetings) {
			if(!minHeap.isEmpty() && meeting[0] >= minHeap.peek()) {
				minHeap.poll();
			}
			minHeap.offer(meeting[1]);
		}
		return minHeap.size();

	}
	public static void main(String[] args) {
		int meetings[][] = 
			new int[][] {{1, 4}, {2, 3}, {2, 3}, {3, 5}, {1, 4}, {6, 8}, {4, 7}, {7, 9}};
		int rooms = MeetingRoomsII.minimumRooms(meetings);
		System.out.println(rooms);

	}
}