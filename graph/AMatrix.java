package graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class AMatrix {
	public static void dFtraversal(int adjMatrix[][], int currentVertex, boolean visited[]) {
		visited[currentVertex] = true;
		System.out.print(currentVertex + " ");
		for (int i = 0; i < adjMatrix.length; i++) {
			if (adjMatrix[currentVertex][i] == 1 && visited[i] == false) {
				dFtraversal(adjMatrix, i, visited);
			}
		}
	}

	public static void dFtraversal(int adjMatrix[][]) {
		boolean visited[] = new boolean[adjMatrix.length];
		dFtraversal(adjMatrix, 0, visited);
	}

	public static void bFTraversal(int adMatrix[][]) {
		Queue<Integer> pendingVertices = new LinkedList<>();
		boolean visited[] = new boolean[adMatrix.length];
		visited[0] = true;
		pendingVertices.add(0);
		while (!pendingVertices.isEmpty()) {
			int currvertex = pendingVertices.poll();
			System.out.print(currvertex + " ");
			for (int i = 0; i < adMatrix.length; i++) {
				if (adMatrix[currvertex][i] == 1 && !visited[i]) {
					// i is visited neighbour of currentVertex
					pendingVertices.add(i);
					visited[i] = true;
				}
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
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(adjMatrix[i][j] + " ");
			}
			System.out.println();
		}
//		dFtraversal(adjMatrix);
//		System.out.println();
//		bFTraversal(adjMatrix);
	}

}
