class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        long start=1;
        long end=0;
        int ans=0;
        for(int i=0; i<piles.length; i++){
            end=Math.max(end,piles[i]);
        }
        while(start<=end){
            long mid=(long)start+(end-start)/2;
            long count=0;
            for(int i=0; i<piles.length; i++){
                long temp=(long)piles[i]/mid;
                long temp1=(long)piles[i]%mid;
                if(temp==0){
                    count++;
                }
                else if(temp!=0 && temp1!=0){
                    count+=temp+1;
                }
                else{
                    count+=temp;
                }

            }
            if(count<=h){
                ans=(int)mid;
                end=mid-1;
            }
            else{
                start=mid+1;
            }
        }
        return ans;
    }
}