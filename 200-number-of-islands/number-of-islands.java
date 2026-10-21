class Solution {
    public int count=0;
    public int numIslands(char[][] grid) {
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[i].length; j++){
                if(grid[i][j]=='1'){
                    count++;
                    dfs(grid,i,j);
                }
            }
        }
        return count;
    }
    public void dfs(char[][]grid,int i,int j){
        int n=grid.length;
        int m=grid[0].length;
        if(i<0 || j>=m || i>=n || j<0 || grid[i][j]=='0'){
            return;
        }

        grid[i][j]='0';
        dfs(grid,i-1,j);
        dfs(grid,i,j-1);
        dfs(grid,i+1,j);
        dfs(grid,i,j+1);
    }
}