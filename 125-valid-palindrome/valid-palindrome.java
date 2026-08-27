class Solution {
    public boolean isPalindrome(String s) {
        int i=0;
        String s1=s.toLowerCase();
        String result =s1.replaceAll("[^a-z0-9]","");
        int j=result.length()-1;

        while(i<j){

            if(result.charAt(i)!=result.charAt(j)){
                return false;
            }
            i++; 
            j--;
        }
        return true;
    }
}