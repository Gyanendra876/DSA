class Solution {
    class edge{
        int v;
        int w;
        public edge(int v, int w){
            this.v=v;
            this.w=w;
        }

    }

    public int minCostConnectPoints(int[][] points) {
        boolean visited[]=new boolean[points.length];
        int dist[]=new int[points.length];
        ArrayList<edge> graph[]=new ArrayList[points.length];
        for(int i=0; i<points.length; i++){
            graph[i]=new ArrayList<>();
        }
        for(int i=0; i<points.length; i++){
            for(int j=i+1; j<points.length; j++){
                int ans=Math.abs(points[i][0]-points[j][0])+Math.abs(points[i][1]-points[j][1]);
                graph[i].add(new edge(j,ans));
                graph[j].add(new edge(i,ans));

            }
        }
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->Integer.compare(a[1],b[1]));
        int cost=0;
        pq.add(new int[]{0,0});
        while(!pq.isEmpty()){
            int curr[]=pq.remove();
            int u=curr[0];
            int wt=curr[1];
            if(!visited[u]){
            cost+=wt;
            visited[u]=true;
            System.out.println(u);
            for(int i=0; i<graph[u].size(); i++){
                edge e=graph[u].get(i);
                pq.add(new int[]{e.v,e.w});
                
            }
          }
        }
        return cost;
    }
}