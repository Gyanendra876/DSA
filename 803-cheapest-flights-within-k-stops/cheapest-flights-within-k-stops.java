class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<int[]>[] graph=new ArrayList[n];
        int[][] dist=new int[n][k+2];
        for(int i=0; i<n; i++){
            graph[i]=new ArrayList<>();
        }
        for(int[] i:flights){
            int u=i[0];
            int v=i[1];
            int z=i[2];
            graph[u].add(new int[]{v,z});

        }
        for(int i=0; i<n; i++){
            Arrays.fill(dist[i],Integer.MAX_VALUE);
        }
        PriorityQueue<int[]>pq=new 
        PriorityQueue<>((a,b)->a[1]-b[1]);
        dist[src][k+1]=0;
        pq.add(new int[]{src,0,k+1});
        while(!pq.isEmpty()){
            int[] curr=pq.remove();
            int u=curr[0];
            int cost=curr[1];
            int kValue=curr[2];
            if(u==dst){
                return cost;
            }
             if (cost > dist[u][kValue]) {
                continue;
            }

            if (kValue == 0) {
                continue;
            }
            System.out.println(u+" "+cost+" "+ kValue);
            for(int i=0; i<graph[u].size(); i++){
                int v=graph[u].get(i)[0];
                int wt=graph[u].get(i)[1];
                int newCost=cost+wt;
                if(newCost<dist[v][kValue-1]){
                    dist[v][kValue-1]=newCost;
                    pq.add(new int[]{v,cost+wt,kValue-1});

                }
                
              
            }
        }
        return -1;
    }
}