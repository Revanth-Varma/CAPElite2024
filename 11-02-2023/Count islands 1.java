import java.io.*;
import java.util.*;

public class Solution {
    
    public static void bfs(int row, int col, int[][] grid, boolean[][] visited){
        int r = grid.length, c = grid[0].length;
        visited[row][col] = true;
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(row, col));
        while(!queue.isEmpty()){
            int x = queue.peek().x;
            int y = queue.peek().y;
            for(int i = -1; i<=1; i++){
                for(int j = -1; j<=1; j++){
                    int temp_x = x + i;
                    int temp_y = y + j;
                    if(temp_x>=0 && temp_x<r && temp_y>=0 && temp_y<c && !visited[temp_x][temp_y] && grid[temp_x][temp_y]==1){
                        visited[temp_x][temp_y] = true;
                        queue.offer(new Pair(temp_x, temp_y));
                    }
                }
            }
            queue.poll();
        }

    }
    public static class Pair{
        int x,y;
        public Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int row = sc.nextInt();
        int col = sc.nextInt();
        int[][] grid = new int[row][col];
        
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                grid[i][j] = sc.nextInt();
            }
        }
        boolean[][] visited = new boolean[row][col];
        int count = 0;
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(!visited[i][j] && grid[i][j] == 1){
                    bfs(i, j, grid, visited);
                    count++;
                }
            }
        }
		System.out.println(count);
    }
}
