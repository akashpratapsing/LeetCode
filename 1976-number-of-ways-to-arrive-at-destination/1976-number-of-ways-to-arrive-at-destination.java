class Solution {

    class Pair {
        long dist;
        int node;

        public Pair( int node, long dist){
            this.dist = dist;
            this.node = node;
        }
    }
    public int countPaths(int n, int[][] roads) {

        int mod = (int) 1e9 + 7;
        List<List<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }

        for (int[] road: roads){
            adj.get(road[0]).add(new Pair(road[1], road[2]));
            adj.get(road[1]).add(new Pair(road[0], road[2]));
        }

        long[] dist = new long[n];
        int[] ways = new int[n];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[0] = 0;
        ways[0] = 1;

        PriorityQueue<Pair> q = new PriorityQueue<>((a, b) -> Long.compare(a.dist, b.dist));
        q.offer(new Pair(0, 0));

        while (!q.isEmpty()){
            int node = q.peek().node;
            long dis = q.peek().dist;
            q.poll();

            if (dis > dist[node]) continue;

            for (Pair it: adj.get(node)){
                int adjNode = it.node;
                long wt = it.dist;

                if (dis + wt < dist[adjNode]){
                    dist[adjNode] = dis + wt;
                    ways[adjNode] = ways[node];
                    q.offer(new Pair(adjNode, dist[adjNode]));
                } else if (dis + wt == dist[adjNode]){
                    ways[adjNode] = (ways[adjNode] + ways[node]) % mod;
                }
            }
        }

        return ways[n - 1];
    }
}