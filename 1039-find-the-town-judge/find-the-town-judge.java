class Solution {
    public int findJudge(int n, int[][] trust) {
        int []indegree=new int[n+1];  
        for(int i=0; i<trust.length; i++){
            int u=trust[i][0];
            int v=trust[i][1];
            indegree[u]--;
            indegree[v]++;
        }
        for(int i=1; i<indegree.length; i++){
            if(indegree[i]==n-1){
                return i; 
            }
        }
        return -1;
       

    }
}