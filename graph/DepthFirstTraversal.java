
package graph;

import java.util.Scanner;

public class DepthFirstTraversal {
	// time complexity of this traversal is O(V2)
	public static void depthfirstTraversal(int[][] adjMatrix) {
		// Intially all the value of the array will be false.
		boolean[] visited = new boolean[adjMatrix.length];
		// We will call the helper function
		for (int i = 0; i < adjMatrix.length; i++) {
			if(visited[i]==false)
			{
				System.out.println("i   "+ i);
				depthfirstTraversalHelper(adjMatrix, i, visited);
				System.out.println("Hii");
			}
			
		}

	}

	public static void depthfirstTraversalHelper(int[][] adjMatrix, int currentVertex, boolean[] visited) {
		visited[currentVertex] = true;
		System.out.println(currentVertex + " ");
		for (int i = 0; i < adjMatrix.length; i++) 
		{
			System.out.println("currentVertex "+currentVertex);
			System.out.println("Mai Undar hu");
			if (adjMatrix[currentVertex][i] == 1 && visited[i] == false) {
				// i is the neighbour of currentVertex
				System.out.println("Hello "+i);
				depthfirstTraversalHelper(adjMatrix, i, visited);
				System.out.println("shubhangi");
			}
		}
	}

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		int totalNumOfVertex = s.nextInt();
		int edges = s.nextInt();
		int[][] adjMatrix = new int[totalNumOfVertex][totalNumOfVertex];
		for (int i = 0; i < edges; i++) {
			int vertices1 = s.nextInt();
			int vertices2 = s.nextInt();
			adjMatrix[vertices1][vertices2] = 1;
			adjMatrix[vertices2][vertices1] = 1;

		}
		for (int i = 0; i < adjMatrix.length; i++) {
			for (int j = 0; j < adjMatrix[i].length; j++) {
				System.out.print(adjMatrix[i][j] + " ");
			}
			System.out.println();
		}
		/*
		 * 8 7 0 1 0 3 0 5 1 2 1 4 3 6 5 7
		 */
		System.out.println(" ");
		depthfirstTraversal(adjMatrix);

	}

}
