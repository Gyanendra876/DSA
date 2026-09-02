class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ls= new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0; i<nums.length; i++){
            if(i>0 && nums[i]==nums[i-1])continue;
            int target=-nums[i];
            int j=i+1; 
            int k=nums.length-1;
            if(i==j){
                j++;
                continue;
            }
            if(i==k){
                k--;
                continue;
            }
            while(j<k){
                int sum=nums[j]+nums[k];
                if(sum==target){
                    ArrayList<Integer> as=new ArrayList<>();
                    as.add(nums[i]);
                    as.add(nums[j]);
                    as.add(nums[k]);
                    ls.add(as);
                    while(j<k && nums[j]==nums[j+1]) j++;
                    while(j<k && nums[k]==nums[k-1]) k--;
                    j++;
                    k--;
                }
                else if(sum<target){
                    j++;
                }
                else{
                    k--;
                }
            }
        }
        return ls;
    }
}