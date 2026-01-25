class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int N = numCourses;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < N; i++){
            adj.add(new ArrayList<>());
        }
        
        for (int[] p : prerequisites){
            adj.get(p[1]).add(p[0]);
        }
        
        int[] indegree = new int[N];
        
        for (int i = 0 ; i < N; i++){
            for (int it : adj.get(i)){
                indegree[it]++;
            }
        }
        
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < N; i++){
            if (indegree[i] == 0) q.offer(i);
        }
        
        int[] topo = new int[N];
        int count = 0;
        int ind = 0;
        while (!q.isEmpty()){
            int node = q.poll();
            topo[ind++] = node;
            count++;
            for (int it : adj.get(node)){
                indegree[it]--;
                if (indegree[it] == 0) q.offer(it);
            }
        }
        
        return count == N ? topo : new int[]{};
    }
}