class Solution {

    public List<List<String>> solveNQueens(int n) {

        List<List<String>> result = new ArrayList<>();

        char[][] board = new char[n][n];

        for(int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }

        Set<Integer> cols = new HashSet<>();
        Set<Integer> posDiag = new HashSet<>(); // row + col
        Set<Integer> negDiag = new HashSet<>(); // row - col

        backtrack(0, board, cols, posDiag, negDiag, result);

        return result;
    }

    private void backtrack(int row,
                           char[][] board,
                           Set<Integer> cols,
                           Set<Integer> posDiag,
                           Set<Integer> negDiag,
                           List<List<String>> result) {

        if(row == board.length) {

            List<String> solution = new ArrayList<>();

            for(char[] r : board) {
                solution.add(new String(r));
            }

            result.add(solution);
            return;
        }

        for(int col = 0; col < board.length; col++) {

            if(cols.contains(col) ||
               posDiag.contains(row + col) ||
               negDiag.contains(row - col)) {
                continue;
            }

            // Place Queen
            board[row][col] = 'Q';
            cols.add(col);
            posDiag.add(row + col);
            negDiag.add(row - col);

            backtrack(row + 1,
                      board,
                      cols,
                      posDiag,
                      negDiag,
                      result);

            // Undo
            board[row][col] = '.';
            cols.remove(col);
            posDiag.remove(row + col);
            negDiag.remove(row - col);
        }
    }
}