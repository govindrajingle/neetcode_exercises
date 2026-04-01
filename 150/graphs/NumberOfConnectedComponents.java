import java.util.ArrayList;

public class NumberOfConnectedComponents {
    public static void main(String[] args) {
        int[][] arr = { new int[] { 0, 2 }, new int[] { 3, 4 }, new int[] { 1, 2 } };
        int v = 5;
        ArrayList<ArrayList<Integer>> components = new NumberOfConnectedComponents().getComponents(v, arr);
        printGraph(components);
    }

    public ArrayList<ArrayList<Integer>> getComponents(int V, int[][] edges) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }

        // Build graph correctly
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        boolean[] visited = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                ArrayList<Integer> component = new ArrayList<>();
                dfs(i, graph, visited, component);
                result.add(component);
            }
        }

        return result;
    }

    public void dfs(int vertex, ArrayList<ArrayList<Integer>> graph,
            boolean[] visited, ArrayList<Integer> component) {
        visited[vertex] = true;
        component.add(vertex);

        for (int neighbor : graph.get(vertex)) {
            if (!visited[neighbor]) {
                dfs(neighbor, graph, visited, component);
            }
        }
    }

    private static void printGraph(ArrayList<ArrayList<Integer>> graph) {
        int i = 0;
        for (ArrayList<Integer> list : graph) {
            System.out.print(i + "<->" + list);
            i += 1;
            System.out.println();
        }
    }
}
