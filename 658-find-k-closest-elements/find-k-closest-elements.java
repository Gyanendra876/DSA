class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int size=arr.length;
        int arr1[]=new int[size];
        List<Integer> ls=new ArrayList<>();
        for(int i=0; i<size; i++){
            arr1[i]=Math.abs(arr[i]-x);
        }
        int l=size-k;
        int r=size-1;
        while(l>0 && arr1[l-1]<=arr1[r]){
                l--;
                r--;
        }
        for(int i=0; i<k; i++){
            ls.add(arr[l]);
            l++;
        }
        return ls;

        
    }
}