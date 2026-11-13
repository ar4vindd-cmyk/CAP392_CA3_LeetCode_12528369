class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int maxLength = 0;

        int[] lastSeen = new int[65536];
        java.util.Arrays.fill(lastSeen, -1);

        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);

            if (lastSeen[ch] >= left) {
                left = lastSeen[ch] + 1;
            }

            lastSeen[ch] = right;

            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}