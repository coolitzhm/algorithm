package second.secondlesson;

public class Graph {
	int[][] graph;
	int num;

	public Graph(int[][] graph) {
		this.graph = graph;
		num = graph.length;
	}

	public int[] getIndegree() {
		int[] indegree = new int[num];
		for (int i = 0; i < num; i++) {
			for (int j = 0; j < num; j++) {
				if (graph[i][j] == 1)
					indegree[j]++;
			}
		}
		return indegree;
	}
}
