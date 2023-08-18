package app;

import java.util.*;

public class DijkstraAlgorithm {

    // Inner class to represent the graph
    static class Graph {
        int vertices;
        Map<Integer, Map<Integer, Integer>> adjacencyMap;

        // Constructor to initialize the graph with a given number of vertices
        public Graph(int vertices) {
            this.vertices = vertices;
            this.adjacencyMap = new HashMap<>();
            for (int i = 0; i < vertices; i++) {
                adjacencyMap.put(i, new HashMap<>());
            }
        }

        // Method to add an edge to the graph between source and destination with a given weight
        public void addEdge(int source, int destination, int weight) {
            adjacencyMap.get(source).put(destination, weight);
        }

        // Method to get the neighbors of a vertex along with their weights
        public Map<Integer, Integer> getNeighbors(int vertex) {
            return adjacencyMap.get(vertex);
        }
    }

    // Dijkstra's algorithm implementation
    public static int[] dijkstra(Graph graph, int source) {
        int[] distance = new int[graph.vertices];
        Arrays.fill(distance, Integer.MAX_VALUE); // Initializing distances with a large value
        distance[source] = 0; // Distance to the source vertex is 0

        // Priority queue to keep track of vertices with their current distances
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.offer(new int[]{source, 0}); // Adding source vertex with distance 0 to the priority queue

        // Dijkstra's main loop
        while (!pq.isEmpty()) {
            int[] curr = pq.poll(); // Get vertex with the smallest distance from the priority queue
            int vertex = curr[0];
            int dist = curr[1];

            // If the distance to the current vertex is greater than what's stored, skip it
            if (dist > distance[vertex]) {
                continue;
            }

            // Explore neighbors of the current vertex and update distances if a shorter path is found
            for (Map.Entry<Integer, Integer> neighbor : graph.getNeighbors(vertex).entrySet()) {
                int nextVertex = neighbor.getKey();
                int weight = neighbor.getValue();

                // If a shorter path to the neighbor vertex is found, update the distance and enqueue it
                if (dist + weight < distance[nextVertex]) {
                    distance[nextVertex] = dist + weight;
                    pq.offer(new int[]{nextVertex, distance[nextVertex]});
                }
            }
        }

        return distance; // Return the array of shortest distances from the source vertex
    }



    public static void main(String[] args) {
        int vertices = 15;
        Graph graph = new Graph(vertices);

        // Adding edges and distances
        graph.addEdge(0, 1, 14);
        graph.addEdge(0, 11, 14);
        graph.addEdge(0, 12, 9);
        graph.addEdge(1, 0, 14);
        graph.addEdge(1, 2, 9);
        graph.addEdge(1, 10, 17);
        graph.addEdge(1, 11, 9);
        graph.addEdge(2, 1, 9);
        graph.addEdge(2, 3, 5);
        graph.addEdge(2, 9, 20);
        graph.addEdge(2, 10, 13);
        graph.addEdge(3, 2, 5);
        graph.addEdge(3, 4, 17);
        graph.addEdge(3, 9, 19);
        graph.addEdge(4, 3, 17);
        graph.addEdge(4, 5, 16);
        graph.addEdge(4, 9, 4);
        graph.addEdge(5, 4, 16);
        graph.addEdge(5, 6, 8);
        graph.addEdge(5, 7, 9);
        graph.addEdge(5, 9, 12);
        graph.addEdge(6, 5, 8);
        graph.addEdge(6, 7, 6);   
        graph.addEdge(7, 5, 9);
        graph.addEdge(7, 6, 6);
        graph.addEdge(7, 8, 7);
        graph.addEdge(7, 9, 12);
        graph.addEdge(7, 13, 23);
        graph.addEdge(7, 14, 10);
        graph.addEdge(8, 7, 7);
        graph.addEdge(8, 9, 13);
        graph.addEdge(8, 10, 5);
        graph.addEdge(8, 14, 6);
        graph.addEdge(9, 2, 20);
        graph.addEdge(9, 3, 19);
        graph.addEdge(9, 4, 4);
        graph.addEdge(9, 5, 12);
        graph.addEdge(9, 7, 12);
        graph.addEdge(9, 8, 13);
        graph.addEdge(9, 10, 7);
        graph.addEdge(10, 1, 17);
        graph.addEdge(10, 2, 13);
        graph.addEdge(10, 8, 5);
        graph.addEdge(10, 9, 7);
        graph.addEdge(10, 11, 18);
        graph.addEdge(10, 14, 8);
        graph.addEdge(11, 0, 14);
        graph.addEdge(11, 1, 9);
        graph.addEdge(11, 10, 18);
        graph.addEdge(11, 12, 15);
        graph.addEdge(11, 14, 9);
        graph.addEdge(12, 0, 9);
        graph.addEdge(12, 11, 15);
        graph.addEdge(12, 13, 11);
        graph.addEdge(12, 14, 15);
        graph.addEdge(13, 7, 23);
        graph.addEdge(13, 12, 11);
        graph.addEdge(13, 14, 18);
        graph.addEdge(14, 7, 10);
        graph.addEdge(14, 8, 6);
        graph.addEdge(14, 10, 8);
        graph.addEdge(14, 11, 9);
        graph.addEdge(14, 12, 15);
        graph.addEdge(14, 13, 18);


        int[] shortestDistances = dijkstra(graph, 4); // Greenlee is vertex 4
        int shortestPathToLaPaz = shortestDistances[12]; // La Paz is vertex 12

        System.out.println("Shortest distance from Greenlee to La Paz: " + shortestPathToLaPaz);
    }
}

