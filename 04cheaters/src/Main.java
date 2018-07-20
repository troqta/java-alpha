//TODO : FIX
//TODO : FIX
//TODO : FIX
//TODO : FIX
//TODO : FIX
//TODO : FIX
//TODO : FIX
//TODO : FIX


import java.io.ByteArrayInputStream;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    static void fakeInput() {
        String input = "7\n" +
                "Coki Doncho Math\n" +
                "Doncho Coki Graphs\n" +
                "Doncho Yana Math\n" +
                "Stamat Coki Graphs\n" +
                "Doncho Stamat Math\n" +
                "Doncho Coki Dynamic Programming\n" +
                "Stamat Yana Math\n" +
                "6\n" +
                "Coki Math\n" +
                "Doncho Math\n" +
                "Stamat Math\n" +
                "Stamat Graphs\n" +
                "Doncho Dynamic Programming\n" +
                "Coki Dynamic Programming";

        System.setIn(new ByteArrayInputStream(input.getBytes()));
    }

    public static void main(String[] args) {
        fakeInput();
        Scanner in = new Scanner(System.in);

        HashMap<String, Graph> dependencies = new HashMap<>();

        int n = in.nextInt();
        in.nextLine();

        for (int i = 0; i < n; i++) {
            String[] line = in.nextLine().split(" ");
            String vertex1 = line[0];
            String vertex2 = line[1];
            StringBuilder graphName = new StringBuilder();
            if (line.length == 3) {
                graphName = new StringBuilder(line[2]);
            } else {
                for (int j = 2; j < line.length; j++)
                    graphName.append(line[j]).append(" ");
            }
            String name = graphName.toString();


            if (!dependencies.containsKey(name)) {
                Graph graph = new Graph(name);
                dependencies.put(name, graph);
            }
            if (!dependencies.get(name).vertices.containsKey(vertex1)) {
                ArrayList<String> list = new ArrayList<>();
                list.add(vertex2);
                dependencies.get(name).vertices.put(vertex1, list);
            } else {
                dependencies.get(name).vertices.get(vertex1).add(vertex2);

            }
        }

        int M = in.nextInt();
        in.nextLine();

        for (int i = 0; i < M; i++) {
            String[] line = in.nextLine().split(" ");
            String vertex = line[0];
            StringBuilder graphName = new StringBuilder();
            if (line.length == 2) {
                graphName = new StringBuilder(line[1]);
            } else {
                for (int j = 2; j < line.length; j++)
                    graphName.append(line[j]).append(" ");
            }
            String name = graphName.toString();

            if (dependencies.containsKey(name)) {
                if (!dependencies.get(name).vertices.isEmpty()) {
                    solve(vertex, dependencies.get(name).vertices);
                }
            }
        }
        //testing
        System.out.println("-*--*-*-*-TESTS CUZ IM BAAD-*-*-*-**-");
        dependencies.forEach((x, y) -> System.out.println(x + " " + printDependencies(y) + "|"));

    }

    //testing
    public static String printDependencies(Graph graph) {
        StringBuilder sb = new StringBuilder();
        graph.vertices.forEach((x, y) -> sb.append(x).append("->").append(stringList(y)).append("|"));
        return sb.toString();
    }

    public static String stringList(List<String> list) {
        StringBuilder sb = new StringBuilder();
        list.forEach(x -> sb.append(x).append(" "));
        return sb.toString();
    }

    private static void solve(String vertex, HashMap<String, List<String>> graph) {

        Set<String> result = bfs(vertex, graph);
        List<String> output = new ArrayList<>(result);
        Collections.reverse(output);


        System.out.println(output.stream()
                .collect(Collectors.joining(", ")));


    }

    private static Set<String> bfs(String vertex, Map<String, List<String>> graph) {
        Queue<String> queue = new LinkedList<>();
        Set<String> used = new TreeSet<>();
        queue.offer(vertex);
        used.add(vertex);

        if (!graph.containsKey(vertex)) {
            return used;
        }

        while (!queue.isEmpty()) {
            String current = queue.poll();
            for (String next : graph.get(current)) {
                if (used.contains(next)) {
                    continue;
                }

                used.add(next);

                if (!graph.containsKey(next)) {
                    continue;
                }

                queue.offer(next);
            }
        }

        return used;
    }


    static class Graph {
        String name;
        HashMap<String, List<String>> vertices;

        public Graph(String name) {
            this.name = name;
            this.vertices = new HashMap<>();
        }

        @Override
        public String toString() {
            return name;
        }
    }
}
