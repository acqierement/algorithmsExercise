public class Graph01 {
    public int numIslands(char[][] grid) {
        int count = 0;
        int m = grid.length;
        if(m == 0) return 0;
        int n = grid[0].length;
        for(int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    doExplore(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    private void doExplore(char[][] grid, int i, int j) {
        int m = grid.length;
        int n = grid[0].length;
        if(i >= m || j >= n || i < 0 || j < 0 || grid[i][j] == '0') return;
        grid[i][j] = '0';
        doExplore(grid, i - 1, j);
        doExplore(grid, i + 1, j);
        doExplore(grid, i, j - 1);
        doExplore(grid, i, j + 1);
    }
}
