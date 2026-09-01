class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int num[]=new int[2];
        int i=0;
        int j=numbers.length-1;
        while(i!=j){
            int a=numbers[i];
            int b=numbers[j];
            if((a+b)==target){
                num[0]=i+1;
                num[1]=j+1;
                break;
            }
            else if((a+b)>target){
                j--;
            }
            else{
                i++;
            }
        }
        return num;
    }
}