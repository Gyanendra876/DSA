class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int count=0;
        int i=0;
        int j=people.length-1;
        while(i<=j){
            int a=people[i];
            int b=people[j];
            if(((a+b)<=limit)|| i==j){
                i++;
                j--;
                count++;
                
            }
            else if((a+b)>limit){
                j--;
                count++;
            }

        }
        return count;
    }
}