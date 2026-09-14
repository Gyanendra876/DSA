/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 
class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int low=0,high=mountainArr.length()-1;
        while(low<high){
            int mid=low+(high-low)/2;
            if(mountainArr.get(mid)>mountainArr.get(mid+1)){
                high=mid;
            }
            else{
                low=mid+1;
            }
        }
        int sechigh=high+1;
        int num=-1;
        num=calculate( target, mountainArr,high,0);
        if(num==-1){
          num=calculate1( target, mountainArr,mountainArr.length()-1,sechigh);
        }
        return num;
    }
    public int calculate(int target, MountainArray mountainArr,int high,int low){
        while(low<=high){
            int mid=low+(high-low)/2;
            if(mountainArr.get(mid)==target){
                return mid;
            }
            else if(mountainArr.get(mid)<target){
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        return -1;
    }
    public int calculate1(int target, MountainArray mountainArr,int high,int low){
        while(low<=high){
            int mid=low+(high-low)/2;
            if(mountainArr.get(mid)==target){
                return mid;
            }
            else if(mountainArr.get(mid)>target){
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        return -1;
    }
}