

class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        // outdegree[r][c] = number of neighbors STRICTLY GREATER than matrix[r][c]
        int[][] outdegree = new int[rows][cols];

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                for (int[] dir : directions) {
                    int nr = r + dir[0];
                    int nc = c + dir[1];
                    if (nr >= 0 && nr < rows && nc >= 0 && nc < cols
                            && matrix[nr][nc] > matrix[r][c]) {
                        outdegree[r][c]++;
                    }
                }
            }
        }

        // Cells with outdegree 0 are "peaks" — start BFS from these,
        // peeling the graph inward layer by layer (like topological sort).
        Queue<int[]> queue = new LinkedList<>();
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (outdegree[r][c] == 0) {
                    queue.offer(new int[]{r, c});
                }
            }
        }

        int longest = 0;

        while (!queue.isEmpty()) {
            longest++;
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int[] cell = queue.poll();
                int r = cell[0];
                int c = cell[1];

                for (int[] dir : directions) {
                    int nr = r + dir[0];
                    int nc = c + dir[1];
                    // find neighbors SMALLER than current cell (pointing "inward")
                    if (nr >= 0 && nr < rows && nc >= 0 && nc < cols
                            && matrix[nr][nc] < matrix[r][c]) {
                        outdegree[nr][nc]--;
                        if (outdegree[nr][nc] == 0) {
                            queue.offer(new int[]{nr, nc});
                        }
                    }
                }
            }
        }

        return longest;
    }
}