class Solution {
    public int minimumEffortPath(int[][] heights) {
        int n=heights.length;
        int m=heights[0].length;
        int[][] value=new int[n][m];
        int dir[][]={{0,1},{1,0},{-1,0},{0,-1}};
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->Integer.compare(a[2],b[2]));
        pq.add(new int[]{0,0,0});
        for (int[] row : value) {
            Arrays.fill(row,Integer.MAX_VALUE);
        }
        value[0][0]=0;
        while(!pq.isEmpty()){
            int[] curr=pq.remove();
            int x=curr[0];
            int y=curr[1];
            int cost=curr[2];
            if(x==n-1 && y==m-1){
                break;
            }
            for(int[] d:dir){
                int nx=d[0]+x;
                int ny=d[1]+y;
                if(nx<0 || ny<0 || nx>=n || ny>=m){
                    continue;
                }
                int diff=Math.abs(heights[x][y]-heights[nx][ny]);
                int put=Math.max(diff,cost);
                if(value[nx][ny]>put){ 
                    pq.add(new int[]{nx,ny,put});
                    value[nx][ny]=put;
                     
                }

            }

        }
        return value[n-1][m-1];
    }
}