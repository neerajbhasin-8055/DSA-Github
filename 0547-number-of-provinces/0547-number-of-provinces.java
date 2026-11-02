class Solution {
    public int findCircleNum(int[][] isConnected) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        int cnt = 0;
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            list.add(new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (isConnected[i][j] == 1) {
                    list.get(i).add(j);
                }
            }
        }
        for (int i = 0; i < list.size(); i++) {
            // visted[i] = true;
            for (int node : list.get(i)) {
                if (visited[node] == false) {
                    dfs(node, list, visited);
                    cnt++;
                }
            }

        }
        return cnt;
    }

    public void dfs(int node, ArrayList<ArrayList<Integer>> list, boolean[] visited) {
        visited[node] = true;
        for (int neighbor : list.get(node)) {
            if (visited[neighbor] == false) {
                dfs(neighbor, list, visited);
            }
        }
    }
}