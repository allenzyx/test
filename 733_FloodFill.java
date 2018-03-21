class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        fill(image, sr, sc, newColor, image[sr][sc]);
        return image;
    }
    
    private void fill(int[][] image, int r, int c, int newColor, int oldColor) {
        int h = image.length;
        int w = image[0].length;
        if (r < 0 || r >= h || c < 0 || c >= w || image[r][c] == newColor || image[r][c] != oldColor) {
            return;
        }
        image[r][c] = newColor;
        fill(image, r+1, c, newColor, oldColor);
        fill(image, r-1, c, newColor, oldColor);
        fill(image, r, c+1, newColor, oldColor);
        fill(image, r, c-1, newColor, oldColor);
    }
}
