class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
       int k=0;
       int z=0;
       Arrays.sort(nums);
       List<List<Integer>> ls=new ArrayList<>();
       for(int i=0; i<nums.length; i++){
        long temp;
        if(i>0 && nums[i]==nums[i-1])continue;
        for(int j=i+1; j<nums.length-2; j++){
            temp=(long)nums[i]+nums[j];
            long ans=(long)target-temp;
            if(j>i+1 && nums[j]==nums[j-1])continue;   
            k=j+1;
            z=nums.length-1;
            while(k<z){
                long result=(long)nums[k]+nums[z];
                if(result==ans){
                    ls.add(Arrays.asList(nums[i],nums[j],nums[k],nums[z]));
                    while(k<z && nums[k]==nums[k+1])k++;
                    while(k<z && nums[z]==nums[z-1])z--;
                    k++;
                    z--;
                }
                else if(result>ans){
                    z--;

                }
                else{
                    k++;
                }
            }
            
        }

       } 
       return ls;
    }
}