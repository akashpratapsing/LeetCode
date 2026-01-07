class Solution {

    public boolean bipartite(int start, int[] color, int[][] graph){

        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        color[start] = 0;

        while (!q.isEmpty()){
            int node = q.peek();
            q.poll();

            for (int it : graph[node]){
                if (color[it] == -1){
                    q.offer(it);
                    color[it] = 1 - color[node];
                }else if (color[it] == color[node]){
                    return false;
                }
            }
        }
        return true;
    }
    public boolean isBipartite(int[][] graph) {
        
        int n = graph.length;
        int[] color = new int[n];
        Arrays.fill(color, -1);
        for (int i = 0; i < n; i++){
            if (color[i] == -1){
                if (!bipartite(i, color, graph)) return false;
            }
        }
        return true;
    }
}