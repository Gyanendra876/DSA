class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        int first=-1;
        int second=-1;
        int third=-1;
        for(int i=0; i<triplets.length; i++){
            if(triplets[i][0]==target[0] && triplets[i][1]<=target[1] &&triplets[i][2]<=target[2] ){
                first=i;
            }
            if(triplets[i][0]<=target[0] &&triplets[i][1]==target[1] &&triplets[i][2]<=target[2] ){
                second=i;
            }
            if(triplets[i][0]<=target[0] &&triplets[i][1]<=target[1] &&triplets[i][2]==target[2] ){
                third=i;
            }
        }
        if(first!=-1 && second!=-1 && third!=-1){
            return true;
        }
        return false;
    }
}