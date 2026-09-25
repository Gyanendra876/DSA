class Solution {
    public int jump(int[] nums) {
        int arr[]=new int[nums.length];
        Arrays.fill(arr,Integer.MAX_VALUE);
        arr[0]=0;
        int steps=0;
        int max=nums[0];
        int maxRechable=Integer.MIN_VALUE;
        for(int i=0; i<nums.length; i++){            
            if(maxRechable<i){
                maxRechable=max;
                steps++;
            }
            max=Math.max(max,i+nums[i]);
            if(arr[i]>steps){
                arr[i]=steps;
            }

        }
       return arr[nums.length-1]; 
    }
}