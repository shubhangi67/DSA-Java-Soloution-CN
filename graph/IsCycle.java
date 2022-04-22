package graph;

import java.util.Scanner;

public class IsCycle {
	public static boolean isCyclic(int adMatrix[][],boolean[] visited,int currentVertex)
	{
		if(visited[currentVertex] == true)
		{
			return true;
		}
		visited[currentVertex]= true;
		boolean flag;
		for(int i=0;i<adMatrix[currentVertex].length;i++)
		
			{
				flag= isCyclic(adMatrix, visited, adMatrix[currentVertex][i]);
				if(flag == true)
				{
					return true;
				}
			}
		return false;
	}
	public static boolean isCyclic(int adMatrix[][])
	{
		boolean visited[] = new boolean[adMatrix.length];
		boolean flag;
		for(int i=0;i<adMatrix.length;i++)
		{
			visited[i] = true;
			for(int j=0;j<adMatrix[i].length;j++)
			{
				flag= isCyclic(adMatrix, visited, j);
				if(flag == true)
				{
					return true;
				}
			}
			visited[i] = false;
		}
		return false;
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
		System.out.println(isCyclic(adjMatrix));

	}
}
