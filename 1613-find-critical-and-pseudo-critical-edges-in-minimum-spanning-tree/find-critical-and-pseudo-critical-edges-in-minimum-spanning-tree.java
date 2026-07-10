

class Solution {

    class Edge {
        int u, v, w, idx;

        Edge(int u, int v, int w, int idx) {
            this.u = u;
            this.v = v;
            this.w = w;
            this.idx = idx;
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
        if (parent[x] != x)
            parent[x] = find(parent[x]);
        return parent[x];
    }

    boolean union(int a, int b) {
        int pa = find(a);
        int pb = find(b);

        if (pa == pb)
            return false;

        if (rank[pa] < rank[pb]) {
            parent[pa] = pb;
        } else if (rank[pa] > rank[pb]) {
            parent[pb] = pa;
        } else {
            parent[pb] = pa;
            rank[pa]++;
        }

        return true;
    }

    private int kruskal(List<Edge> edges, int n, int skipEdge, int pickEdge) {

        init(n);

        int cost = 0;
        int usedEdges = 0;

        // Force include an edge
        if (pickEdge != -1) {
            Edge e = edges.get(pickEdge);
            union(e.u, e.v);
            cost += e.w;
            usedEdges++;
        }

        for (int i = 0; i < edges.size(); i++) {

            if (i == skipEdge)
                continue;

            Edge e = edges.get(i);

            if (union(e.u, e.v)) {
                cost += e.w;
                usedEdges++;
            }
        }

        if (usedEdges != n - 1)
            return Integer.MAX_VALUE;

        return cost;
    }

    public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] input) {

        List<Edge> edges = new ArrayList<>();

        for (int i = 0; i < input.length; i++) {
            edges.add(new Edge(input[i][0], input[i][1], input[i][2], i));
        }

        Collections.sort(edges, (a, b) -> a.w - b.w);

        int mstCost = kruskal(edges, n, -1, -1);

        List<Integer> critical = new ArrayList<>();
        List<Integer> pseudo = new ArrayList<>();

        for (int i = 0; i < edges.size(); i++) {

            // Check Critical
            if (kruskal(edges, n, i, -1) > mstCost) {
                critical.add(edges.get(i).idx);
            }

            // Check Pseudo Critical
            else if (kruskal(edges, n, -1, i) == mstCost) {
                pseudo.add(edges.get(i).idx);
            }
        }

        List<List<Integer>> ans = new ArrayList<>();
        ans.add(critical);
        ans.add(pseudo);

        return ans;
    }
}
         