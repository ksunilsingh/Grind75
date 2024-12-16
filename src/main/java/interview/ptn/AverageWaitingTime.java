package interview.ptn;

public class AverageWaitingTime {
	public double averageWaitingTime(int[][] customers) {
		double totalWaitingTime = customers[0][1];
		int[] chefStartTimes = new int[customers.length];
		chefStartTimes[0] = customers[0][0];
		for (int i = 1; i < customers.length; i++) {
			if (customers[i][0] >= (chefStartTimes[i - 1] + customers[i - 1][1])) {
				chefStartTimes[i] = customers[i][0];
			} else {
				chefStartTimes[i] = chefStartTimes[i - 1] + customers[i - 1][1];
			}
			if (customers[i][0] >= chefStartTimes[i]) {
				totalWaitingTime += customers[i][1];
			} else {
				totalWaitingTime += (chefStartTimes[i] - customers[i][0] + customers[i][1]);
			}
		}

		double avgWaitingTime = (totalWaitingTime / customers.length);
		return avgWaitingTime;
	}

	public static void main(String[] args) {
		// [[1,2],[2,5],[4,3]]
		AverageWaitingTime avg = new AverageWaitingTime();
		avg.averageWaitingTime(new int[][] { { 5, 2 }, { 5, 4 }, { 10, 3 }, { 20, 1 } });
	}
}
