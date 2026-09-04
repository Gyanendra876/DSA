class Solution {
    public int maxProfit(int[] prices) {
        int i=0;
        int j=i+1;
        int max=0;
        while(j<prices.length){
            int a=prices[i];
            int b=prices[j];
            int sum=b-a;
            if(a>b){
                i=j;
            }
            j++;  
            max=Math.max(max,sum);

        }
        return max;
    }
}