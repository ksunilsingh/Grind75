package leet75.arrays;

public class CanPlaceFlowers {

	public boolean canPlaceFlowers(int[] flowerbed, int n) {
		if (n == 0)
			return true;
		int prev = 0;
		for (int i = 0; i < flowerbed.length; i++) {
			int current = flowerbed[i];
			int next = (i == flowerbed.length - 1) ? 0 : flowerbed[i + 1];
			if (current == 0 && prev == 0 && next == 0) {
				--n;
				flowerbed[i] = 1;
				if (n == 0)
					return true;
			}
			prev = flowerbed[i];
		}
		return n == 0;
	}

	public static void main(String[] args) {
		CanPlaceFlowers cpf = new CanPlaceFlowers();
		cpf.canPlaceFlowers(new int[] { 0, 0, 1, 0, 1 }, 1);
	}
}
