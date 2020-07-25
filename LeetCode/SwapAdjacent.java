class Solution {
    public boolean canTransform(String start, String end) {
		if (!start.replace("X", "").equals(end.replace("X", ""))) return false;

		int i = 0, j = 0;
		int len = start.length();

		while (i < len && j < len) {
			while (i < len && start.charAt(i) == 'X') i++;
			while (j < len && end.charAt(j) == 'X') j++;
			if (i < len && start.charAt(i) == 'L' && i < j) return false;
			if (i < len && start.charAt(i) == 'R' && i > j) return false;
			i++;
			j++;
		}

		return true;
	}
}