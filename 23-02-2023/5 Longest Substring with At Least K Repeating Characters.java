class Solution {
    public int longestSubstring(String s, int k) {
        if(s.length()<k){
            return 0;
        }
        int[] freq_arr = new int[26];
		for(int i = 0; i < s.length(); i++){
            freq_arr[s.charAt(i)-'a']++;
        }
		for(int i = 0; i < s.length(); i++) {
			if(freq_arr[s.charAt(i)-'a'] >= k){
                continue;
            }
			int j = i + 1;
			while(j < s.length() && freq_arr[s.charAt(j)-'a'] < k) {
               j++; 
            }
			return Math.max(longestSubstring(s.substring(0, i), k), longestSubstring(s.substring(j), k));
		}
		return s.length();
    }
}
