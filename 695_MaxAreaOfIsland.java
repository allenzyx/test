class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        int h = grid.length;
        int w = grid[0].length;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                maxArea = Math.max(maxArea, expand(grid, i, j));
            }
        }
        return maxArea;
    }
    
    private int expand(int[][] grid, int r, int c) {
        int h = grid.length;
        int w = grid[0].length;
        if (r < 0 || r >= h || c < 0 || c >= w || grid[r][c] == 0) {
            return 0;
        }
        grid[r][c] = 0;
        return 1 + expand(grid, r + 1, c) + expand(grid, r - 1, c) + expand(grid, r, c + 1) + expand(grid, r, c - 1);
    }
}
