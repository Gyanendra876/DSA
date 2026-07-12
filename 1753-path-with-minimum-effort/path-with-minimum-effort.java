class Solution {

    class Edge implements Comparable<Edge> {
        int u, v, w;

        Edge(int u, int v, int w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }

        @Override
        public int compareTo(Edge other) {
            return this.w - other.w;
        }
    }

    int[] parent;
    int[] rank;

    void init(int n) {
        parent = new int[n];
        rank = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    void union(int a, int b) {
        int pa = find(a);
        int pb = find(b);

        if (pa == pb) return;

        if (rank[pa] < rank[pb]) {
            parent[pa] = pb;
        } else if (rank[pa] > rank[pb]) {
            parent[pb] = pa;
        } else {
            parent[pb] = pa;
            rank[pa]++;
        }
    }

    public int minimumEffortPath(int[][] heights) {

        int rows = heights.length;
        int cols = heights[0].length;

        List<Edge> edges = new ArrayList<>();

        // Build graph
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {

                int id = i * cols + j;

                // Right
                if (j + 1 < cols) {
                    int nid = i * cols + (j + 1);
                    int w = Math.abs(heights[i][j] - heights[i][j + 1]);
                    edges.add(new Edge(id, nid, w));
                }

                // Down
                if (i + 1 < rows) {
                    int nid = (i + 1) * cols + j;
                    int w = Math.abs(heights[i][j] - heights[i + 1][j]);
                    edges.add(new Edge(id, nid, w));
                }
            }
        }

        Collections.sort(edges);

        int totalNodes = rows * cols;
        init(totalNodes);

        int start = 0;
        int end = totalNodes - 1;

        for (Edge e : edges) {
            union(e.u, e.v);

            if (find(start) == find(end)) {
                return e.w;
            }
        }

        return 0;
    }
}