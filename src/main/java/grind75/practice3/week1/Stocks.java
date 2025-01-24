package grind75.practice3.week1;

public class Stocks {
	public int maxProfit(int[] prices) {
		int maxProfit = 0;
		int minPrice = prices[0];
		for (int i = 1; i < prices.length; i++) {
			int profit = prices[i] - minPrice;
			maxProfit = Math.max(maxProfit, profit);
			minPrice = Math.min(prices[i], minPrice);
		}
		return maxProfit;
	}
}
