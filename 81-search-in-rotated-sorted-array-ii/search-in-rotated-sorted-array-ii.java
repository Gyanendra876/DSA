class Solution {
    public boolean search(int[] nums, int target) {
        int l=0;
        int h=nums.length-1;
        while(l<=h){
            int mid=l+(h-l)/2;
            if(nums[mid]==target){
                return true;
            }
            else if(nums[l]==nums[mid] && nums[mid]==nums[h]){
                l++;
                h--;
            }
            else if(nums[mid]<=nums[h]){
                if(nums[mid]<target &&nums[h]>=target){
                    l=mid+1;
                }
                else{
                    h=mid-1;
                }
            }
            else{
                if(nums[mid]>target &&nums[l]<=target){
                    h=mid-1;
                }
                else{
                    l=mid+1;
                }
            }
        }
        return false;
        
    }
}