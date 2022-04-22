package graph;

import java.util.Scanner;

public class IsLands {
	public static int numConnected(int[][] edges, int n) {
		// int[][] arr = adjMatrixofOneZero(edges, n);
		boolean visited[] = new boolean[n];
		int count = 0;
		for (int i = 0; i < n; i++) {
			if (visited[i] == false) {
				System.out.println(" i ki value " + i);
				count++;
				drawTreeForComponents(edges, i, visited, n);
			}
		}
		return count;
	}

	public static void drawTreeForComponents(int[][] adjMatrix, int i, boolean[] visited, int n) {
		visited[i] = true;
		for (int j = 0; j < n; j++) {
			if (visited[j] == false && adjMatrix[i][j] == 1) {
				System.out.println(adjMatrix[i][j] + " j ki value " + j);
				drawTreeForComponents(adjMatrix, j, visited, n);

			}

		}

	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();// no of vertices
		int e = s.nextInt();// no. of edges

		int adjMatrix[][] = new int[n][n];
		for (int i = 0; i < e; i++) {
			int v1 = s.nextInt();
			int v2 = s.nextInt();
			adjMatrix[v1][v2] = 1;
			adjMatrix[v2][v1] = 1;
		}
		int ans = numConnected(adjMatrix, adjMatrix.length);
		System.out.println(ans);

	}
}
