class Solution {
    public int lengthOfLongestSubstring(String s) {
                if (s.length() == 0) return 0;

        int i=0; 
        int j=i+1;
        int max=1;        
        HashSet<Character> hs=new HashSet<>();
        hs.add(s.charAt(i));
        while(i<=j && j<s.length()){
            char c=s.charAt(j);
                while(hs.contains(c)){
                    hs.remove(s.charAt(i));
                    i++;
                }
                hs.add(c);
                max=Math.max(max,hs.size());

            j++;

        }

        
        
        return max;
    }
}