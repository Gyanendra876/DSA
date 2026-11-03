class Solution {
    class edge{
        int src;
        int dest;
        int price;
        public edge(int src,int dest,int price){
            this.src=src;
            this.dest=dest;
            this.price=price;
        }
    }
    public void createGraph(ArrayList<edge> graph[],int n,int[][] flights){
        for(int i=0; i<n; i++){
            graph[i]=new ArrayList<>();
        }
        for(int i=0; i<flights.length; i++){
            int src=flights[i][0];
            int dest=flights[i][1];
            int weight=flights[i][2];
            graph[src].add(new edge(src,dest,weight));
        }
    }
    class Info{
        int n;
        int cost;
        int k;
        public Info(int n,int cost,int k){
            this.n=n;
            this.cost=cost;
            this.k=k;
        }


    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<edge> graph[]=new ArrayList[n];
        createGraph(graph,n,flights);
        int dest[]=new int[n];
        for(int i=0; i<n; i++){
            if(src!=i){
                dest[i]=Integer.MAX_VALUE;
            }
        }
        Queue<Info> q= new LinkedList<>();
        q.add(new Info(src,0,0));
        while(!q.isEmpty()){
            Info curr=q.remove();
            if(curr.k>k){
                continue;
            }
            for(int i=0; i<graph[curr.n].size(); i++){
                edge e=graph[curr.n].get(i);
                int v=e.dest;
                int wt=e.price;
                if(curr.cost+wt<dest[v] && curr.k<=k){
                    dest[v]=curr.cost+wt;
                    q.add(new Info(v,dest[v],curr.k+1));
                }
            }
        }
        if(dest[dst]==Integer.MAX_VALUE){
            return -1;
        }
        return dest[dst];
        
        
    }
}