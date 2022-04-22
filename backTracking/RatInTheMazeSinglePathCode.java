package backTracking;

public class RatInTheMazeSinglePathCode {
	public static boolean hasPath(int[][] maze) {
		int n = maze.length;
		int path[][] = new int[n][n];
		return solvemaze(maze, 0, 0, path);
	}

	public static boolean solvemaze(int[][] maze, int i, int j, int[][] path) {
		// Check if i,j cell is valid or not
		int n = maze.length;
		if (i < 0 || i >= n || j < 0 || j >= n || maze[i][j] == 0 || path[i][j] == 1) {
			return false;
		}
		path[i][j] = 1;
		// Destination cell
		if (i == n - 1 && j == n - 1) {
			for (int row = 0; row < n; row++) {
				for (int col = 0; col < n; col++) {
					System.out.print(path[row][col] + " ");
				}
				System.out.println();
			}
			return true;
		}
		// Explore all direction
		// Direction -1 Top
		if (solvemaze(maze, i - 1, j, path)) {
			return true;

		}
		// Direction -2 right
		else if (solvemaze(maze, i, j + 1, path)) {
			return true;
		}
		// Direction -3 down
		else if (solvemaze(maze, i + 1, j, path)) {
			return true;
		}
		// Direction -4 left
		else if (solvemaze(maze, i, j - 1, path)) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		int[][] maze = { { 1, 1, 0 }, { 1, 1, 1 }, { 0, 1, 1 } };
		boolean pathPossible = hasPath(maze);
		System.out.println(pathPossible);

	}

}
