package backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class RatInaMazeAllPathsCN {
	public static void printSolution(int[][] path, int n) {
		for (int i = 0; i < n; i++) {
			
			for (int j = 0; j < n; j++) {
				
				System.out.print(path[i][j] + " ");
			}
		}

	}
	
	public static void solveMaze(int[][] maze, int i, int j, int[][] path, int n) {
		if (i == n - 1 && j == n - 1) {
			path[i][j] = 1;
			printSolution(path, n);
			System.out.println();
			return;
		}
		if(i < 0 || i > n - 1 || j < 0 || j > n - 1)
		{
			return;
		}
		if (i < 0 || i > n - 1 || j < 0 || j > n - 1 || maze[i][j] == 0 || path[i][j] == 1) {
			return;
		}

		// ( left, right, up and down).
		path[i][j] = 1;
		solveMaze(maze, i - 1, j, path, n);
		solveMaze(maze, i + 1, j, path, n);
		solveMaze(maze, i, j - 1, path, n);
		solveMaze(maze, i, j + 1, path, n);
		
		path[i][j] = 0;
		return;
	}
	public static void ratInAMaze(int[][] maze, int n) {
		int path[][] = new int[20][20];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				path[i][j] = 0;
			}
		}
		solveMaze(maze, 0, 0, path, n);

	}

	

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine().trim());
		int[][] maze = new int[20][20];
		for (int i = 0; i < n; i++) {
			StringTokenizer tk = new StringTokenizer(br.readLine().trim());
			for (int j = 0; j < n; j++) {
				maze[i][j] = Integer.parseInt(tk.nextToken());
			}
		}
		ratInAMaze(maze, n);
	}

}
