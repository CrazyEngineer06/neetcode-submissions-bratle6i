class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();

        int n = strs.length;
        HashMap<String,List<String>> mp = new HashMap<>();

        for(int i=0;i<n;i++){
            String curr = strs[i];

            char[] chars = curr.toCharArray();
            Arrays.sort(chars);
            String sortedKey = new String(chars);

            int[] freq = new int[26];

            for(int j=0;j<chars.length;j++){
                freq[chars[j] - 'a']++;
            }

            StringBuilder sb = new StringBuilder();
            for(int f : freq){
                sb.append('#').append(f);
            }
            String key = sb.toString();

            mp.computeIfAbsent(key,k -> new ArrayList<>()).add(strs[i]);
        }

        return new ArrayList<>(mp.values());
    }
}
