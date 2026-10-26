class Solution {
    public int dir[][]={{0,1},{1,0},{-1,0},{0,-1}};
    public int orangesRotting(int[][] grid) {
        Queue<int[]> q =new LinkedList<>();
        int n=grid.length;
        int m=grid[0].length;
        int ans=0;
        boolean [][] visited=new boolean[n][m];
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j]==2){
                   q.add(new int[]{i,j,0});
                   visited[i][j]=true;
                }
            }
        }
        while(!q.isEmpty()){
           int[] curr=q.remove();
           int row=curr[0];
           int col=curr[1];
           int count=curr[2];
           for(int d[]:dir){
            int nx=d[0]+row;
            int nz=d[1]+col;
            if(nx>=0 && nx<n && nz>=0 && nz<m && grid[nx][nz]==1 && visited[nx][nz]==false){
                q.add(new int[]{nx,nz,count+1});
                ans=Math.max(count+1,ans);
                visited[nx][nz]=true;
            }
           }
        }
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j]==1 && !visited[i][j]){
                    
                    return -1;
                }
            }
        }
        return ans;
        
       

    }
}