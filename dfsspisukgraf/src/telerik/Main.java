package telerik;

public class Main {

    public static void main(String[] args) {
            Graph graph = new Graph(5);

        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 4);
        graph.addEdge(3, 4);

        graph.dfs(1);
    }
}
