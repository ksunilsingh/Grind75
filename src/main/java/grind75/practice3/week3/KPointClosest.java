package grind75.practice3.week3;

import java.util.PriorityQueue;

public class KPointClosest {
	public int[][] kClosest(int[][] points, int k) {
		PriorityQueue<Point> pointsPQ = new PriorityQueue<>();
		int m = points.length;
		for (int i = 0; i < m; i++) {
			Point point = new Point(points[i][0], points[i][1]);

			if (pointsPQ.size() >= k) {
				Point peeked = pointsPQ.peek();
				if (point.compareTo(peeked) > 0) {
					pointsPQ.poll();
					pointsPQ.add(point);
				}
			} else {
				pointsPQ.add(point);
			}
		}
		int[][] closest = new int[pointsPQ.size()][2];
		int index = 0;
		while (!pointsPQ.isEmpty()) {
			Point p = pointsPQ.poll();
			closest[index][0] = p.x;
			closest[index++][1] = p.y;
		}
		return closest;
	}
}

class Point implements Comparable<Point> {
	int x;
	int y;

	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getDistance() {
		return x * x + y * y;
	}

	@Override
	public int compareTo(Point o) {
		return Integer.compare(getDistance(), o.getDistance());
	}
}
