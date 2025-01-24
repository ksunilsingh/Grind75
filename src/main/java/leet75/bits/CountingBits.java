package leet75.bits;

public class CountingBits {

	public int[] countBits(int n) {
		int[] result = new int[n + 1];
		for (int i = 0; i <= n; i++) {
			result[i] = result[i >> 1] + (i & 1);
		}
		return result;
	}

//	public int[] countBits(int n) {
//		int[] result = new int[n + 1];
//		for (int i = 0; i <= n; i++) {
//			result[i] = convertAndCount(i);
//		}
//		return result;
//	}
//
//	private int convertAndCount(int i) {
//		if (i == 0)
//			return 0;
//		int count = 0;
//		while (i > 0) {
//			int remainder = i % 2;
//			if (remainder == 1)
//				++count;
//			i = i / 2;
//		}
//		return count;
//	}
}
