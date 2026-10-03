class Solution {
    public List<Integer> partitionLabels(String s) {
        int[] count=new int[26];
        int increm=0;
        int end=0;
        List<Integer> ls=new ArrayList<>();
        for(int i=0; i<s.length(); i++){
            count[s.charAt(i)-'a']=i;

        }
        for(int i=0; i<s.length(); i++){
            end=Math.max(end,count[s.charAt(i)-'a']);
            increm++;
            if(i==end){
                ls.add(increm);
                increm=0;
            }
        }
        return ls;

    }
}