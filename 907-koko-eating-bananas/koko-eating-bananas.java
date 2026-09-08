class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low=1;
        int high=Integer.MIN_VALUE;
        int ans=0;
        for(int a:piles ){
            high=Math.max(high,a);
        }
        while(low<=high){
            int mid=low+(high-low)/2;
            int totalhours=calcul(piles,mid);
            if(totalhours<=h){
                ans=mid;
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return ans;
    }
    public int calcul(int[] piles,int an){
        int count=0;
        for(int i=0; i<piles.length; i++){
            count+=Math.ceil((double) piles[i]/an);
        }
        return count;
    }
}