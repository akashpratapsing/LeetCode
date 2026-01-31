class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }

        for (int[] flight: flights){
            adj.get(flight[0]).add(new int[] {flight[1], flight[2]});
        }

        int[] dist = new int[n];
        Arrays.fill(dist, (int) 1e9);
        dist[src] = 0;

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {0, src, 0});

        while (!q.isEmpty()){
            int stops = q.peek()[0];
            int node = q.peek()[1];
            int cost = q.peek()[2];
            q.poll();

            if (stops > k) continue;

            for (int[] it: adj.get(node)){
                int adjNode = it[0];
                int wt = it[1];

                if (cost + wt < dist[adjNode] && stops <= k){
                    dist[adjNode] = cost + wt;
                    q.offer(new int[] {stops + 1, adjNode, cost + wt});
                }

            }
        }

        if (dist[dst] == (int) 1e9) return -1;
        return dist[dst];
    }
}