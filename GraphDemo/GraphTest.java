package app;

import java.util.List;

public class GraphTest {
    public static void main(String[] args) {
        String[] vertices = {
            "Mohave", "Coconino", "Navajo", "Apache", "Greenlee",
            "Cochise", "Santa Cruz", "Pima", "Pinal", "Graham",
            "Gila", "Yavapai", "La Paz", "Yuma", "Maricopa"
        };

        int numVertices = vertices.length;
        Graph graph = new Graph(numVertices);

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
        graph.addEdge(4, 9, 9);
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

        // Printing adjacency matrix
        graph.printAdjacencyMatrix();


     // Testing getDistance and getNeighbors
     // Define the starting and ending vertices for which distance and neighbors will be tested
     int startVertex = 0;
     int endVertex = 1;

     // Calculate the distance between the specified start and end vertices using the graph's getDistance method
     int distance = graph.getDistance(startVertex, endVertex);

     // Print the calculated distance between the start and end vertices
     System.out.println("Distance between " + vertices[startVertex] + " and " + vertices[endVertex] + ": " + distance);

     // Get a list of neighboring vertices for the specified start vertex using the graph's getNeighbors method
     List<Integer> neighbors = graph.getNeighbors(startVertex);

     // Print the list of neighboring vertices for the start vertex
     System.out.println("Neighbors of " + vertices[startVertex] + ": " + neighbors);

    }
}
