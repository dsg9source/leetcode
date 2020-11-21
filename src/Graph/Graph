package Graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Graph {
	boolean isDirectedGraph;
	int vertexCount;
	int adjacencyMatrix[][];
	List<Vertex> vertices;

	Graph(int vertextCount,boolean isDirectedGraph) {
		this.vertexCount = vertextCount;
		adjacencyMatrix = new int[vertextCount][vertextCount];
		this.isDirectedGraph=isDirectedGraph;
		vertices = new ArrayList<Vertex>();
		for(int i=0;i<vertextCount;i++) {
			Vertex v=new Vertex();
			vertices.add(v);
			
		}
	}
	
	public static void main(String[] args) {
		Graph g=new Graph(8,false);
		g.addEdge(0, 1, 1);
		g.addEdge(1, 2, 1);
		g.addEdge(1, 7, 1);
		g.addEdge(2, 3, 1);
		g.addEdge(2, 4, 1);
		g.addEdge(3, 5, 1);
		g.addEdge(4, 6, 1);
		System.out.println("DFS Start**********************");
		g.dfs(g);
		System.out.println("DFS End************************");
		System.out.println("Topological Sort Start ********************");
		Graph topoGraph=new Graph(6,true);
		topoGraph.addEdge(2, 0, 1);
		topoGraph.addEdge(1, 0, 1);
		topoGraph.addEdge(5, 2, 1);
		topoGraph.addEdge(4, 1, 1);
		topoGraph.addEdge(2, 3, 1);
		topoGraph.addEdge(3, 1, 1);
		topoGraph.topologicalSort(topoGraph);
		System.out.println("Topological Sort End **********************");
		
		
	}
	public void addEdge(int i,int j,int value) {
		adjacencyMatrix[i][j]=value;
		if(!isDirectedGraph) {
			adjacencyMatrix[j][i]=value;
		}
		
	}
	public void removeEdge(int i,int j) {
		adjacencyMatrix[i][j]=0;
		adjacencyMatrix[j][i]=0;
	}
	public int[] adjacentVerticesCostArray(int v){
		//this method returns a row from adjacentMatrix which contains 0 if no connection withthe given vertex else the path value
		return adjacencyMatrix[v];
		
	}
	static int dfsTimer=0;
	public void dfs(Graph g) {
		
		int vertexCounter=0;
		for(Vertex v:this.vertices) {
			if(v.color=='W') {
				DFS_VISIT(vertexCounter);
				vertexCounter++;
			}
		}
		
	}
	private void DFS_VISIT(int vertexCounter) {
		this.vertices.get(vertexCounter).color='G';
		this.vertices.get(vertexCounter).stTime=dfsTimer;
		dfsTimer++;
		graphTraversalCollector(vertexCounter);
		//call for adjacent verticess
		int[] adjacentCostArr=adjacentVerticesCostArray(vertexCounter);
		for(int i=0;i<adjacentCostArr.length;i++) {
			if(adjacentCostArr[i]!=0) {
				//visit only not visited vertices
				if(this.vertices.get(i).color=='W') {
					DFS_VISIT(i);
				}
			}
		}
		this.vertices.get(vertexCounter).finishTime=dfsTimer;
		dfsTimer++;
		this.vertices.get(vertexCounter).color='B';
		
	}
	public void graphTraversalCollector(int i) {
		System.out.println(i+" || Start Time: "+vertices.get(i).stTime+" || Finish Time: "+vertices.get(i).finishTime+" || Current Color: "+vertices.get(i).color);
	}
	
	public void topologicalSort(Graph g) {
		Stack<Integer> stack=new Stack<Integer>();
		int[] visited=new int[g.vertexCount];
		int i=0;
		for(Vertex v:vertices) {
			if(visited[i]==0) {
				topologicalVisit(i,visited,stack);
			}
			i++;
		}
		while(!stack.isEmpty()) {
			System.out.println(stack.pop());
		}
	}

	private void topologicalVisit(int vertexIndex, int[] visited, Stack<Integer> stack) {
		visited[vertexIndex]=1;
		//fetch adjacent vertex list
		int[] adjacentCostArr=adjacentVerticesCostArray(vertexIndex);
		for(int i=0;i<adjacentCostArr.length;i++) {
			if(adjacentCostArr[i]!=0 && visited[i]==0) {
				topologicalVisit(i, visited, stack);
			}
		}
		stack.push(vertexIndex);
		
	}
	

}

class Vertex {
	char color;
	int stTime;
	int finishTime;
	int predicessor;

	Vertex() {
		color = 'W';
		stTime = 0;
		finishTime = 0;
		predicessor = -1;

	}
}
