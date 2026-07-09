class Solution {
    public int minCostConnectPoints(int[][] points) {
        int ans=0;
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[2]-b[2]);
        pq.add(new int[]{points[0][0],points[0][1],0,0});
        boolean[] visited=new boolean[points.length];
        while(!pq.isEmpty()){
            int[] curr=pq.remove();
            int x1=curr[0];
            int y1=curr[1];
            int cost=curr[2];
            int z=curr[3];
            if(!visited[z]){
                visited[z]=true;
                ans+=cost;
                for(int i=0; i<points.length; i++){
                    if(!visited[i]){
                        int x2=points[i][0];
                        int y2=points[i][1];
                        int calculate=Math.abs(Math.abs(x1-x2)+Math.abs(y1-y2));
                        pq.add(new int[]{x2,y2,calculate,i});
                    }
                }

            }
        }
        return ans;
    }
}