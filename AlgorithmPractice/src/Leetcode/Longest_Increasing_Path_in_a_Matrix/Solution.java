package Leetcode.Longest_Increasing_Path_in_a_Matrix;

// Longest Increasing Path in a Matrix

class Solution {
    
    private int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
    public int longestIncreasingPath(int[][] matrix) {
        if(matrix==null || matrix.length ==0)
            return 0;
        int n = matrix.length, m=matrix[0].length, longestPath = 0;
        int[][] cache = new int[n][m];
        for(int i=0;i<n;i++)
            for(int j=0;j<m;j++){
                int longest = longestIncreasingPath(matrix, cache, n,m,i,j);
                longestPath = Math.max(longestPath,longest);
            }
        
        return longestPath;
    }
    public int longestIncreasingPath(int[][] matrix,int[][] cache,int n, int m, int i, int j){
        if(cache[i][j]>0)
            return cache[i][j];
        int max=0;
        for(int[] d : dir){
            int x = d[0]+i,y=d[1]+j;
            if(x>-1 && y>-1 && y<m && x<n && matrix[x][y]>matrix[i][j]){
                int longest = longestIncreasingPath(matrix, cache, n,m,x,y);
                max = Math.max(max,longest);
            }
        }
        cache[i][j]=max+1;
        return cache[i][j];
    }
}