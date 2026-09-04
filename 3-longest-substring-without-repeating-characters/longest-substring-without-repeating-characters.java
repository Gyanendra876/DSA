class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> hs=new HashSet<>();
        int l=0;
        int maxlen=0;
        for(int right=0; right<s.length(); right++){
            char ch=s.charAt(right);
            while(hs.contains(ch)){
                hs.remove(s.charAt(l));
                l++;

            }
            hs.add(ch);
            maxlen=Math.max(maxlen,right-l+1);
        }
        return maxlen;
    }
}