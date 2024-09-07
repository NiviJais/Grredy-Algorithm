import java.util.*;

public class Dijkstra {

    public static void dijkstra(int[][] graph, int src) {
        int V = graph.length; // Number of vertices in the graph
        int[] dist = new int[V]; // Array to store the shortest distances from the source
        boolean[] sptSet = new boolean[V]; // Shortest path tree set (visited nodes)

        // Initialize all distances as INFINITE and sptSet[] as false
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0; // Distance of source vertex from itself is always 0

        // Find shortest path for all vertices
        for (int count = 0; count < V - 1; count++) {
            // Pick the minimum distance vertex from the set of vertices not yet processed.
            int u = minDistance(dist, sptSet, V);

            // Mark the picked vertex as processed
            sptSet[u] = true;

            // Update dist[] for adjacent vertices of the picked vertex.
            for (int v = 0; v < V; v++) {
                // Update dist[v] if it's not in the shortest path tree, there is an edge from u to v,
                // and the total weight of path from src to v through u is smaller than the current value of dist[v]
                if (!sptSet[v] && graph[u][v] != 0 &&
                        dist[u] != Integer.MAX_VALUE &&
                        dist[u] + graph[u][v] < dist[v]) {
                    dist[v] = dist[u] + graph[u][v];
                }
            }
        }

        // Print the constructed distance array
        printSolution(dist, V);
    }

    // Function to find the vertex with the minimum distance value, from the set of vertices not yet included in the shortest path tree
    public static int minDistance(int[] dist, boolean[] sptSet, int V) {
        int min = Integer.MAX_VALUE, minIndex = -1;

        for (int v = 0; v < V; v++) {
            if (!sptSet[v] && dist[v] < min) {
                min = dist[v];
                minIndex = v;
            }
        }

        return minIndex;
    }

    // A utility function to print the constructed distance array
    public static void printSolution(int[] dist, int V) {
        System.out.println("Vertex \t\t Distance from Source");
        for (int i = 0; i < V; i++) {
            System.out.println(i + " \t\t " + dist[i]);
        }
    }

    public static void main(String[] args) {
        int[][] graph = {
                {0, 10, 0, 0, 0, 0},
                {10, 0, 5, 0, 0, 0},
                {0, 5, 0, 15, 20, 0},
                {0, 0, 15, 0, 10, 30},
                {0, 0, 20, 10, 0, 25},
                {0, 0, 0, 30, 25, 0}
        };

        int src = 0; // Source vertex
        dijkstra(graph, src);
    }
}
