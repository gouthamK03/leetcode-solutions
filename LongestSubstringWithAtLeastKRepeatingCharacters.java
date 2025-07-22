class Solution {
    public int longestSubstring(String s, int k) {
        int n = s.length();
        int maxlen = Integer.MIN_VALUE;
        if(n<k){
            return 0;
        }
        char arr[] = new char[26];
        for(char ch : s.toCharArray()){
            arr[ch-'a']++;
        }
        int ind = -1;
        for(int i=0;i<n;i++){
            char ch = s.charAt(i);
            if(arr[ch-'a']<k){
                ind = i;
                break;
            }
        }
        if(ind == -1){
            return n;
        }
        if(ind != 0){
        String s1 = s.substring(0,ind);
        maxlen = Math.max(maxlen,longestSubstring(s1,k));
        }
        String s2 = "";
        if((ind+1<n))
          s2 = s.substring(ind+1,n);
          maxlen = Math.max(maxlen,longestSubstring(s2,k));
        return maxlen;
    }
}
