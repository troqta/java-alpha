package telerik;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Graph {
    private int nodes;
    private List<List<Integer>> connectedList;
    private boolean visited[];

    public Graph(int nodes) {
        this.nodes = nodes;
        this.visited = new boolean[nodes];
        this.connectedList = new LinkedList<>();

        for (int i = 0; i < nodes; i++) {
            connectedList.add(new LinkedList<>());
        }
    }

    public void addEdge(int source, int destination) {
        connectedList.get(source).add(destination);
    }

    public void dfs(int node) {
        visited[node] = true;

        System.out.println(node + " ");
        Iterator iterator = connectedList.get(node).listIterator();

        while (iterator.hasNext()) {
            int adjacent = (int) iterator.next();
            if (!visited[adjacent]) {
                dfs(adjacent);
            }
        }
    }
}
