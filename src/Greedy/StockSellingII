package Greedy;

public class StockSellingII {
	public static void main(String[] args) {

	}

	public static int maxProfit(int[] prices) {
		int buyPrice = 0;
		int profit = 0;
		boolean doIHaveShare = false;
		for (int i = 0; i < prices.length; i++) {
			if (i == prices.length - 1) {
				if (doIHaveShare) {
					if (prices[i] > buyPrice) {
						doIHaveShare = false;
						return profit = profit + prices[i] - buyPrice;
					} else {
						return profit;
					}
				}
			} else if (prices[i] < prices[i + 1]) {
				if (!doIHaveShare) {
					buyPrice = prices[i];
					doIHaveShare = true;
				}

			} else if (prices[i] > prices[i + 1]) {
				if (doIHaveShare) {
					doIHaveShare = false;

					profit = profit + prices[i] - buyPrice;
					buyPrice = 0;
				}
				continue;
			}
		}
		return profit;
	}
}
