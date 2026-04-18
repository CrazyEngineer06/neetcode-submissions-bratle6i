class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n = s2.length();
        int m = s1.length();

        int[] freq = new int[26];
        for (char c : s1.toCharArray()) {
            freq[c - 'a']++;
        }

        int l = 0;
        for (int r = m - 1; r < n; r++) {
            int[] freq2 = new int[26];

            for (char c : s2.substring(l, r + 1).toCharArray()) {
                freq2[c - 'a']++;
            }

            boolean isValid = true;
            for (int i = 0; i < 26; i++) {
                if (freq[i] != freq2[i]) {
                    isValid = false;
                    break;
                }
            }

            if (isValid) return true;
            l++;
        }
        return false;
    }
}