import java.util.ArrayList;
import java.util.List;

public class NumberOfConnectedComponents {
    public static void main(String[] args) {
        int[][] arr = { new int[] { 0, 2 }, new int[] { 3, 4 }, new int[] { 1, 2 } };
        int v = 5;
        List<List<Integer>> components = getComponents(arr, v);
    }

    public static List<List<Integer>> getComponents(int[][] edges, int v) {
        // Create graph ds to store bidirectional edges
        List<List<Integer>> graph = new ArrayList<>();
        // Intitally this will be empty
        for (int i = 0; i < v; i++) {
            graph.add(new ArrayList<>());
        }
        // Add bidirectional edges
        for (int i = 0; i < edges.length; i++) {
            // one direction
            graph.get(edges[i][0]).add(edges[i][1]);
            // reverse direction
            graph.get(edges[i][1]).add(edges[i][0]);
        }
        // printGraph(graph);

        List<List<Integer>> result = new ArrayList<>();
        boolean[] visited = new boolean[v];
        for (int i = 0; i < v; i++) {
            int vertex = i;
            if (!visited[i]) {
                List<Integer> component = new ArrayList<>();
                dfs(vertex, graph, visited, component);
                result.add(component);
            }
        }
        printGraph(result);
        return result;
    }

    private static void dfs(int vertex, List<List<Integer>> graph, boolean[] visited,
            List<Integer> component) {
        visited[vertex] = true;
        component.add(vertex);
        for (int neighbor : graph.get(vertex)) {
            if (!visited[neighbor]) {
                dfs(neighbor, graph, visited, component);
            }
        }
    }

    private static void printGraph(List<List<Integer>> graph) {
        int i = 0;
        for (List<Integer> list : graph) {
            System.out.print(i + "<->" + list);
            i += 1;
            System.out.println();
        }
    }
}
