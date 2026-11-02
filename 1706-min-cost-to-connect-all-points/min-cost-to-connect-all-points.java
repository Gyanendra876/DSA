class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n=points.length;
        if(n<=1){
            return 0;
        }
        int total=0;
        int[] mindist= new int[n];
        boolean[] inmst=new boolean[n];
        Arrays.fill(mindist,Integer.MAX_VALUE );
        mindist[0]=0;
        for(int i=0; i<n; i++){
            int u=-1;
            for(int j=0; j<n; j++){
                if(!inmst[j] &&(u==-1 || mindist[j]<mindist[u])){
                    u=j;
                }
            }
            inmst[u]=true;
            total+=mindist[u]== Integer.MAX_VALUE ? 0:mindist[u];
            for(int v=0; v<n; v++){
                if(!inmst[v]){
                int w=Math.abs(points[u][0]-points[v][0])+Math.abs(points[u][1]-points[v][1]);
                if(w<mindist[v]){
                    mindist[v]=w;
                }
                }
            } 
        }
        return total;
    }
}