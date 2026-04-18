class Solution {
    public boolean checkInclusion(String s1, String s2) {
        //This is the O(n) solution in which we have made 2 freq array for both s1 and s2 
        // so in freq2 we put element till size of s1 and then we run a loop and excluding
        // the first ele of s2 and inclusing the loop element 
        int n = s2.length();
        int m = s1.length();
        if (m > n) return false;

        int[] freq1 = new int[26];
        int[] freq2 = new int[26];

        for (char c : s1.toCharArray()) freq1[c - 'a']++;
        for (int i = 0; i < m; i++) freq2[s2.charAt(i) - 'a']++;

        if (Arrays.equals(freq1, freq2)) return true;

        for (int r = m; r < n; r++) {
            freq2[s2.charAt(r) - 'a']++;        // add incoming right char
            freq2[s2.charAt(r - m) - 'a']--;    // remove outgoing left char
            if (Arrays.equals(freq1, freq2)) return true;
        }

        return false;
    }
}