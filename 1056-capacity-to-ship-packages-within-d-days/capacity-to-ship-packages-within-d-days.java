class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int l=0;
        int s=0;
        for(int i=0; i<weights.length; i++){
            l=Math.max(l,weights[i]);
            s+=weights[i];
        }
        int h=s;
        int ans=0;
        while(l<=h){
            int mid=l+(h-l)/2;
            int i=0;
            int cal=1;
            int sum=0;
            while(i<weights.length){
                if(sum+weights[i]<=mid ){
                    sum+=weights[i];
                    i++;
                }
                else{
                    sum=0;
                    cal++; 
                }
            

            }
            if(cal<=days){
                ans=mid;
                h=mid-1;
            }
            else{
                l=mid+1;
            }
        }
        return ans;

    }
}