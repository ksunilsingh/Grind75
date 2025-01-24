package leet75.bits;

public class SingleNumber {

	public int singleNumber(int[] nums) {
		int result = 0;
		for (int num : nums) {
			result ^= num;
		}
		return result;
	}

	public static void main(String[] args) {
		SingleNumber sn = new SingleNumber();
		sn.singleNumber(new int[] { 4, 1, 2, 1, 2 });
	}
}
