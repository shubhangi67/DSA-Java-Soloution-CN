package graph;



import java.util.Stack;

class Vertex {
 public char label;
 public boolean wasVisited;
 
 public Vertex(char lab) {
   label = lab;
   wasVisited = false;
 }
}

class Graph {

 private final int MAX_VERTS = 20;
 private Vertex vertexList[];
 private int adjMat[][];
 private int nVerts;
 private Stack<Integer> s;
 
 public Graph() {
   vertexList = new Vertex[MAX_VERTS];
   adjMat = new int[MAX_VERTS][MAX_VERTS];
   nVerts = 0;
   s = new Stack<Integer>();
 }
 
 public void addVertex(char lab) {
   vertexList[nVerts++] = new Vertex(lab);
 }
 
 public void addEdge(int start, int end) {
   adjMat[start][end] = 1;
   adjMat[end][start] = 1;
 }
 
 public void displayVertex(int v) {
   System.out.print(vertexList[v].label);
 }
 
 public int getAdjUnvisitedVertex (int v) {
   for(int j = 0; j < nVerts; j++) {
     if(adjMat[v][j] == 1 && vertexList[j].wasVisited == false) {
       return j;
     }
   }
   return -1;
 }
 
 public void mst() {
   vertexList[0].wasVisited = true;
   s.push(0);
   
   while(!s.isEmpty()) {    
     int current = s.peek();
     int v = getAdjUnvisitedVertex(current);
     
     if(v == -1) {
       s.pop();
     } else {
       vertexList[v].wasVisited = true;
       displayVertex(current);
       displayVertex(v);
       System.out.print(" ");
       s.push(v);
     }
   }
 }
}

public class MSTApp {

 public static void main(String[] args) {
 
   Graph a = new Graph();
   a.addVertex('A');
   a.addVertex('B');
   a.addVertex('C');
   a.addVertex('D');
   a.addVertex('E');
   
   a.addEdge(0, 1); 
   a.addEdge(0, 2); 
   a.addEdge(0, 3); 
   a.addEdge(0, 4); 
   a.addEdge(1, 2); 
   a.addEdge(1, 3); 
   a.addEdge(1, 4); 
   a.addEdge(2, 3); 
   a.addEdge(2, 4); 
   a.addEdge(3, 4); 
   
   System.out.println("MST: ");
   a.mst();
 }

}

