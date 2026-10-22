class Solution {
    public int dir[][]={{0,1},{1,0},{0,-1},{-1,0}};
    public int maxAreaOfIsland(int[][] grid) {
        int n=grid.length;
        int max=0;
        int m=grid[0].length;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j]==1){
                    int ans=bfs(grid,i,j,n,m);
                    max=Math.max(ans,max);
                }
            }
        }  
        return max;
    }
    public int bfs(int[][] grid,int row,int col,int n,int m){
        int ans=1;
        Queue<int[]> q=new LinkedList<>();
        q.add(new int[]{row,col});
        grid[row][col]=0;
        while(!q.isEmpty()){
            int []cell=q.remove();
            int r=cell[0];
            int y=cell[1];
            for(int[] d:dir){
                int nx=r+d[0];
                int ny=y+d[1];
                if(nx>=0 && nx<n && ny>=0 && ny<m && grid[nx][ny]==1){
                    q.add(new int[]{nx,ny});
                    grid[nx][ny]=0;
                    ans++;

                }
            }
        }
        return ans;

    }
}