class Solution {

    class Pair {
        int i, j;

        Pair(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    boolean willChange;

    public void solve(char[][] board) {
        int m = board.length, n = board[0].length;
        boolean visited[][] = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O' && !visited[i][j]) {
                    willChange = true;
                    List<Pair> component = new ArrayList<>();
                    dfs(board, i, j, visited, component);
                    if (willChange)
                        change(board, component);
                }
            }
        }
    }

    public void dfs(char[][] board, int i, int j, boolean[][] visited, List<Pair> component) {
        if (i == 0 || j == 0 || i == board.length - 1 || j == board[0].length - 1) {
            if (board[i][j] == 'O')
                willChange = false;
            return;
        }

        if (board[i][j] == 'X' || visited[i][j])
            return;

        component.add(new Pair(i, j));
        visited[i][j] = true;

        if (i > 0)
            dfs(board, i - 1, j, visited, component);

        if (j > 0)
            dfs(board, i, j - 1, visited, component);

        if (i < board.length - 1)
            dfs(board, i + 1, j, visited, component);

        if (j < board[0].length - 1)
            dfs(board, i, j + 1, visited, component);
    }

    public void change(char[][] board, List<Pair> component) {

        for (Pair pair : component) {
            board[pair.i][pair.j] = 'X';
        }
    }
}