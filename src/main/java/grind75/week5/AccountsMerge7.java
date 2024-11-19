package grind75.week5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

public class AccountsMerge7 {
	public List<List<String>> accountsMerge(List<List<String>> accounts) {

		Map<String, String> emailToName = new HashMap<>();
		Map<String, String> parent = new HashMap<String, String>();
		Map<String, TreeSet<String>> unions = new HashMap<>();

		for (List<String> account : accounts) {
			String name = account.get(0);
			for (int i = 0; i < account.size(); i++) {
				emailToName.put(account.get(i), name);
				parent.put(account.get(i), account.get(i));
			}
		}

		for (List<String> account : accounts) {
			String rootEmail = find(account.get(1), parent);
			for (int i = 2; i < account.size(); i++) {
				parent.put(find(account.get(i), parent), rootEmail);
			}
		}

		for (List<String> account : accounts) {
			String rootEmail = find(account.get(1), parent);
			unions.putIfAbsent(rootEmail, new TreeSet<>());
			for (int i = 1; i < account.size(); i++) {
				unions.get(rootEmail).add(account.get(i));
			}
		}

		List<List<String>> merged = new ArrayList<>();

		for (String rootEmail : unions.keySet()) {
			List<String> emails = new ArrayList<>(unions.get(rootEmail));
			emails.add(0, emailToName.get(rootEmail));
			merged.add(emails);
		}

		return merged;

	}

	private String find(String email, Map<String, String> parent) {
		if (!email.equals(parent.get(email))) {
			parent.put(email, find(parent.get(email), parent));
		}
		return parent.get(email);
	}
}
