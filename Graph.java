import java.io.*; 
import java.util.*;
class Graph{
	private int V;
	private LinkedList<Integer> adj[];

	Graph(int v) 
	{
		V = v;
		adj = new LinkedList[v];
		for(int i=0;i<v;i++)
		{
			adj[i] = new LinkedList();
		}
	}


	void connect(int v,int des)
	{
		adj[v].add(des);
		// because i am implementing un directed graph
		adj[des].add(v);
	}

	void disconnect(int v,int des)
	{
		adj[v].remove((Integer) des);
		// because i am implementing un directed graph

		//disconnect both the edge with each other
		adj[des].remove((Integer) v);
	}

	void BFS(int source)
	{
		boolean visitedNode[] = new boolean[V];
		LinkedList<Integer> queue = new LinkedList<Integer>();

		visitedNode[source] = true;
		queue.add(source);
		System.out.print("Bfs travesing : ");
		while(queue.size()!=0)
		{
			source = queue.poll();
			System.out.print(source+" ");
			Iterator<Integer> i = adj[source].listIterator(); 
			while(i.hasNext())
			{
				int n = i.next();
				if(!visitedNode[n])
				{
					visitedNode[n] = true;
					queue.add(n);
				}
			}
		}
		System.out.println("");
	}


	void DFSfunction(int source,boolean visitedNode[])
	{

		visitedNode[source] = true;
		System.out.print(source+" ");
		Iterator<Integer> i = adj[source].listIterator();
		while(i.hasNext())
		{
			int n = i.next();
			if(!visitedNode[n])
			{
				DFSfunction(n,visitedNode);
			}
		}
	}
	void DFS(int source)
	{
		boolean visitedNode[] = new boolean[V];
		System.out.print("Dfs travesing : ");
		DFSfunction(source,visitedNode);
		System.out.println("");
	}

	public static void main(String[] args) {

		Graph g = new Graph(4);
		g.connect(0,1);
		g.connect(0,2);
		g.connect(0,3);
		g.connect(1,3);
		g.connect(2,3);
		g.BFS(0);
		g.DFS(0);

		/*  picorial representation

			0------1
			|\     /
			| \   /
			|  \ / 
			2-- 3
		*/


		g.disconnect(0,3);
		g.disconnect(0,2);
		g.BFS(0);
		g.DFS(0);

		/* picorial representation

			0------1
			       /
			      /
			     / 
			2-- 3
		*/

		
	}
}