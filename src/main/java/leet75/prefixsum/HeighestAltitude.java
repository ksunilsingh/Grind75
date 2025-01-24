package leet75.prefixsum;

public class HeighestAltitude {
	public int largestAltitude(int[] gain) {
		int maxAltitude = 0;
		int altitude = 0;
		for (int i = 0; i < gain.length; ++i) {
			altitude += gain[i];
			maxAltitude = Math.max(altitude, maxAltitude);
		}
		return maxAltitude;
	}
}
