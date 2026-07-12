class Solution {
    private int par[];
    public void init(int n){
        par=new int[n];
        for(int i=0; i<n; i++){
            par[i]=i;
        }
    }
    public int find(int x){
        if(x==par[x]){
            return x;
        }

        return par[x]=find(par[x]);
    }
    public void union(int a,int b){
        int parA=find(a);
        int parB=find(b);
        if(parA!=parB){
            par[parA]=parB;

        }
    }
    
    public boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] queries) {
        init(n);
        Arrays.sort(edgeList,(a,b)->a[2]-b[2]);
        int[][] q=new int[queries.length][4];
        for(int i=0; i<queries.length; i++){
            q[i][0]=queries[i][0];
            q[i][1]=queries[i][1];
            q[i][2]=queries[i][2];
            q[i][3]=i;
        }
        boolean[] ans=new boolean[queries.length];
        Arrays.sort(q,(a,b)->a[2]-b[2]);
        int j=0;
        int i=0;
        while(i<q.length){   
            int limit=q[i][2];
            while(j<edgeList.length && limit>edgeList[j][2] ){
                union(edgeList[j][0],edgeList[j][1]);
                j++;     
            } 
            if(find(q[i][0])==find(q[i][1])){
                ans[q[i][3]]=true;
            } 
            i++;      
                
        }

        return ans;
        
    }
}