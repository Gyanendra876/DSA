class Solution {
    public int characterReplacement(String s, int k) {
        int l=0;
        int max=0;
        int maxfreq=0;
        int count[]=new int[26];
        for(int r=0; r<s.length(); r++){
            char ch=s.charAt(r);
            count[ch-'A']++;
            maxfreq=Math.max(maxfreq,count[ch-'A']);
            while((r-l+1)-maxfreq>k){
                count[s.charAt(l)-'A']--;
                l++;
               
            }
            max=Math.max(max,r-l+1);
        }
        return max;
    }
    
}






















































