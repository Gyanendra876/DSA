class Solution {
    int[][] heights;
    int m;
    int n;
    boolean[][] pacific;
    boolean[][] atlantic;
    int[][] dir={{1,0},{-1,0},{0,1},{0,-1}};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
       this.heights=heights;
       this.m=heights.length;
       this.n=heights[0].length; 
       pacific=new boolean[m][n];
       atlantic=new boolean[m][n];
       for(int i=0; i<m; i++){
        dfs(i,0,pacific);
        }
       for(int i=0; i<n; i++){
        dfs(0,i,pacific);
        }
        for(int i=0; i<n; i++){
        dfs(m-1,i,atlantic);
        }
       for(int i=0; i<m; i++){
        dfs(i,n-1,atlantic);
        }
        List<List<Integer>> arr=new ArrayList<>();
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(pacific[i][j] && atlantic[i][j]){
                    arr.add(Arrays.asList(i,j));
                }
            }
        }
        return arr;
    }
    public void dfs(int i, int j, boolean[][] visited){
        visited[i][j]=true;
        for(int k=0; k<dir.length; k++){
            int x=i+dir[k][0];
            int y=j+dir[k][1];
            if(x<0 || x>=m || y<0 || y>=n){
                continue;
            }
            if(visited[x][y]){
                continue;
            }
            if(heights[i][j]>heights[x][y]){
                continue;
            }
            dfs(x,y,visited);
        }
    }
}