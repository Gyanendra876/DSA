class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int gasSum=0;
        int costSum=0;
        int currSum=0;
        int remember=-1;
        for(int i=0; i<gas.length; i++){
            currSum+=(gas[i]-cost[i]);
            if(currSum<0){
                currSum=0;
                remember=i;
            }
        }
        if(remember==gas.length-1){
            return -1;
        }

        for(int i=0; i<=remember; i++){
            gasSum+=gas[i];
            costSum+=cost[i];
        }
        if(currSum+gasSum<costSum){
            return -1;
        }
        return remember+1;
    }
}