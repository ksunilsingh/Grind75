package grind75.practice1.week3;

import java.util.PriorityQueue;

/*
 * Given an array of points where points[i] = [xi, yi] represents a point on the X-Y plane and an integer k, return the k closest points to the origin (0, 0).

The distance between two points on the X-Y plane is the Euclidean distance (i.e., √(x1 - x2)2 + (y1 - y2)2).

You may return the answer in any order. The answer is guaranteed to be unique (except for the order that it is in).

 

Example 1:


Input: points = [[1,3],[-2,2]], k = 1
Output: [[-2,2]]
Explanation:
The distance between (1, 3) and the origin is sqrt(10).
The distance between (-2, 2) and the origin is sqrt(8).
Since sqrt(8) < sqrt(10), (-2, 2) is closer to the origin.
We only want the closest k = 1 points from the origin, so the answer is just [[-2,2]].
Example 2:

Input: points = [[3,3],[5,-1],[-2,4]], k = 2
Output: [[3,3],[-2,4]]
Explanation: The answer [[-2,4],[3,3]] would also be accepted.
 

Constraints:

1 <= k <= points.length <= 104
-104 <= xi, yi <= 104
 */
public class KClosest {
	public int[][] kClosest(int[][] points, int k) {
		PriorityQueue<Point> closestPoints = new PriorityQueue<>();

		for (int[] point : points) {
			Point newPoint = new Point(point[0], point[1]);

			if (closestPoints.size() < k) {
				closestPoints.add(newPoint);
			} else {
				Point lowPoint = closestPoints.peek();
				if (lowPoint.getDistance() > newPoint.getDistance()) {
					closestPoints.poll();
					closestPoints.add(newPoint);
				}
			}
		}

		int[][] closestPointsArr = new int[closestPoints.size()][2];
		int i = 0;
		while (!closestPoints.isEmpty()) {
			Point p = closestPoints.poll();
			closestPointsArr[i][0] = p.x;
			closestPointsArr[i++][1] = p.y;
		}
		return closestPointsArr;
	}

}

class Point implements Comparable<Point> {

	int x;
	int y;

	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public int compareTo(Point o) {
		return Integer.compare(o.getDistance(), getDistance());
	}

	public int getDistance() {
		return x * x + y * y;
	}

}