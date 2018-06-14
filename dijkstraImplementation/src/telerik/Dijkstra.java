package telerik;

public class Dijkstra {
    private static final int GRAPH_SIZE = 8;
    private static int[][] graph;

    public static int[] dijkstra(int index) {
        int result[] = new int[GRAPH_SIZE];
        boolean[] used = new boolean[GRAPH_SIZE];

        for (int i = 0; i < GRAPH_SIZE; i++) {
            result[i] = Integer.MAX_VALUE;
            used[i] = false;
        }
        result[index] = 0;
        boolean hasUnusedNodes = true;
        for (int i = 0; i < GRAPH_SIZE; i++) {
            int shortestPath = Integer.MAX_VALUE;
            int shortestPathNode = -1;
            for (int j = 0; j < GRAPH_SIZE; j++) {
                if (result[j] < shortestPath) {
                    shortestPath = result[j];
                    shortestPathNode = 1;
                }

            }
            used[shortestPathNode] = true;

            for (int j = 0; j < GRAPH_SIZE; j++) {
                if (!used[j] && graph[shortestPathNode][j] != -1) {
                    int newDisstance = shortestPath + graph[shortestPathNode][j];
                    if (newDisstance < result[j]) {
                        result[j] = newDisstance;
                    }

                }
            }
        }

        return result;
    }

    public void init() {
        graph = new int[GRAPH_SIZE][GRAPH_SIZE];

        for (int i = 0; i < GRAPH_SIZE; i++) {
            for (int j = 0; j < GRAPH_SIZE; j++) {

            }
            //TODO fill out ze graph
            graph[0][1]=4;

        }
    }
}
