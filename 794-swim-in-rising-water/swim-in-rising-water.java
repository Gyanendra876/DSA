class Solution {
    public int swimInWater(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int dir[][]={{0,1},{1,0},{0,-1},{-1,0}};
        PriorityQueue<int[]> pq =new PriorityQueue<>((a,b)->Integer.compare(a[2],b[2]));
        pq.add(new int[]{0,0,grid[0][0]});
        boolean[][] visited=new boolean[grid.length][grid[0].length];
        int t=grid[0][0];
        while(!pq.isEmpty()){
            int curr[]=pq.remove();
            int x=curr[0];
            int y=curr[1];
            int time=curr[2];
            t=Math.max(t,time);
            if(x==n-1 && y==n-1){
                return t;
            }
            visited[x][y]=true;
            for(int d[]:dir){
                int nx=x+d[0];
                int ny=y+d[1];
                if(nx<0 || nx>=n || ny<0 || ny>=m || visited[nx][ny]){
                    continue;
                }
                pq.add(new int[]{nx,ny,grid[nx][ny]});
            } 
        }
        return t;
    }
}