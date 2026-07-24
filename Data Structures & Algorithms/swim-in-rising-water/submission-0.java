class Solution {

    public int swimInWater(int[][] grid) {

        int n = grid.length;

        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> a[0] - b[0]
        );

        boolean[][] visited = new boolean[n][n];

        // {time, row, col}
        pq.offer(new int[]{grid[0][0], 0, 0});

        int[][] dir = {
            {1, 0},
            {-1, 0},
            {0, 1},
            {0, -1}
        };

        while (!pq.isEmpty()) {

            int[] cur = pq.poll();

            int time = cur[0];
            int row = cur[1];
            int col = cur[2];

            if (visited[row][col]) {
                continue;
            }

            visited[row][col] = true;

            if (row == n - 1 && col == n - 1) {
                return time;
            }

            for (int[] d : dir) {

                int nr = row + d[0];
                int nc = col + d[1];

                if (nr < 0 || nr >= n ||
                    nc < 0 || nc >= n ||
                    visited[nr][nc]) {
                    continue;
                }

                pq.offer(new int[]{
                    Math.max(time, grid[nr][nc]),
                    nr,
                    nc
                });
            }
        }

        return -1;
    }
}