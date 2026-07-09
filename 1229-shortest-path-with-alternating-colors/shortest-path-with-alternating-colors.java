import java.util.*;

class Solution {
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {

        ArrayList<int[]>[] graph = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        // Red = 1, Blue = 2
        for (int[] edge : redEdges) {
            graph[edge[0]].add(new int[]{edge[1], 1});
        }

        for (int[] edge : blueEdges) {
            graph[edge[0]].add(new int[]{edge[1], 2});
        }

        int[][] dist = new int[n][3];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }

        Queue<int[]> q = new LinkedList<>();

        // Start node can be considered reached with either color
        dist[0][1] = 0;
        dist[0][2] = 0;

        q.offer(new int[]{0, 1}); // last color = red
        q.offer(new int[]{0, 2}); // last color = blue

        while (!q.isEmpty()) {

            int[] curr = q.poll();

            int u = curr[0];
            int lastColor = curr[1];

            for (int[] nbr : graph[u]) {

                int v = nbr[0];
                int edgeColor = nbr[1];

                // Need alternating colors
                if (edgeColor == lastColor) {
                    continue;
                }

                if (dist[v][edgeColor] != Integer.MAX_VALUE) {
                    continue;
                }

                dist[v][edgeColor] = dist[u][lastColor] + 1;

                q.offer(new int[]{v, edgeColor});
            }
        }

        int[] ans = new int[n];

        for (int i = 0; i < n; i++) {

            int best = Math.min(dist[i][1], dist[i][2]);

            ans[i] = (best == Integer.MAX_VALUE) ? -1 : best;
        }

        return ans;
    }
}