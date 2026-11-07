class Solution {
    class edge{
        int v;
        int w;
        public edge(int v, int w){
            this.v=v;
            this.w=w;
        }
      
    }
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<edge>> graph=new ArrayList<>();
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b) -> Integer.compare(a[1],b[1]));
        int dist[]=new int[n+1];
        for(int i=0; i<=n; i++){
            graph.add(new ArrayList<>());
        }
        for(int[] e:times){
            int u=e[0];
            int v=e[1];
            int w=e[2];
            graph.get(u).add(new edge(v,w));
        }
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[k]=0;
        pq.add(new int[]{k,0});
        while(!pq.isEmpty()){
            int curr[]=pq.remove();
            int u=curr[0];
            int w=curr[1];
            if(w > dist[u]) continue;
            for(int i=0; i<graph.get(u).size(); i++){
                edge e=graph.get(u).get(i);
                if(dist[u]+e.w<dist[e.v]){
                    dist[e.v]=dist[u]+e.w;
                    pq.add(new int[]{e.v,dist[e.v]});
                }
            }
        }
        int max=Integer.MIN_VALUE;

        for(int i=1; i<n+1; i++){
            if(dist[i]==Integer.MAX_VALUE){
                return -1;
            }
            max=Math.max(max,dist[i]);
        }
        return max;
        
    }
}