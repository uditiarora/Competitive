class Solution {
public int longestStrChain(String[] words) {
        int n = words.length;
        if (n <= 1) {
            return n;
        }
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int result = 1;
        for (int i = 0; i < n; i++) {
            int len2 = words[i].length();
            for (int j = i - 1; j >= 0; j--) {
                int len1 = words[j].length();
                if (len1 < len2 - 1) {
                    break;
                }
                if (len1 == len2 - 1 && isPreceding(words[j], words[i])) {
                    if (dp[i] < dp[j] + 1) {
                        dp[i] = dp[j] + 1;
                    }
                }
            }
            result = Math.max(result, dp[i]);
        }
        return result;
    }

    private boolean isPreceding(String s1, String s2) {
        int i = 0, j = 0;
        boolean skip = false;
        while (i < s1.length() && j < s2.length()) {
            if (s1.charAt(i) == s2.charAt(j)) {
                i++;
                j++;
            } else {
                j++;
                skip = true;
            }
        }
        return i == s1.length() && (j == s2.length() || !skip);
    }
}