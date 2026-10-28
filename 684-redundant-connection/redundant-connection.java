class Solution {
    public int par[];
    public int rank[];
    public void init(int n){
            par=new int[n+1];
            rank=new int[n+1];
            for(int i=0; i<n+1; i++){
                par[i]=i;
            }
      
    }
    public int find(int x){
        if(par[x]==x){
            return x;
        }
        return par[x]=find(par[x]);
    }
    public void union(int parA,int parB){
        int a=find(parA);
        int b=find(parB);
        if(rank[a]>rank[b]){
            par[b]=a;
        }
        else if(rank[a]<rank[b]){
            par[a]=b;
        }
        else{
            par[b]=a;
            rank[a]++;
        }

    }
    public int[] findRedundantConnection(int[][] edges) {
        int n=edges.length;
        init(n);
        for(int i=0; i<edges.length; i++){
            int u=edges[i][0];
            int v=edges[i][1];
            if(find(par[u])==find(par[v])){
                return new int[]{u,v};
            }
            else{
                union(u,v);
            }

        }
        

        
        return new int[]{-1,-1};
    }
}