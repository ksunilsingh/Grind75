package leet75.queue;

import java.util.LinkedList;
import java.util.Queue;

public class PartyVictory {
	public String predictPartyVictory(String senate) {
		Queue<Integer> qRad = new LinkedList<>();
		Queue<Integer> qDir = new LinkedList<>();

		for (int i = 0; i < senate.length(); i++) {
			if (senate.charAt(i) == 'R')
				qRad.add(i);
			else
				qDir.add(i);
		}

		while (!qRad.isEmpty() && !qDir.isEmpty()) {
			int radIndex = qRad.poll();
			int dirIndex = qDir.poll();
			if (radIndex < dirIndex)
				qRad.add(radIndex + senate.length());
			else
				qDir.add(dirIndex + senate.length());
		}

		return qRad.size() > qDir.size() ? "Radiant" : "Dire";
	}
}
