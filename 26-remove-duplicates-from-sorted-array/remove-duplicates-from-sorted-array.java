class Solution {
    public int removeDuplicates(int[] nums) {
        int i=0; 
        int j=i+1;
        int k=0;
        while(j<nums.length){
            if(nums[i]==nums[j]){
                j++;
                continue;
            }
            else{
                nums[i+1]=nums[j];
                i++;
                k=i;
                j++;
            }
        }
        return k+1;
    }
}