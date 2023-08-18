package app;

import java.util.ArrayList; 
import java.util.List; 

class Graph { 
    private int numVertices; // Declares a private integer variable to store the number of vertices
    private int[][] edges; // Declares a private 2D integer array to represent the edges between vertices

    public Graph(int numVertices) { // Constructor that takes the number of vertices as a parameter
        this.numVertices = numVertices; // Assigns the provided number of vertices to the class variable
        this.edges = new int[numVertices][numVertices]; // Initializes the 'edges' array with dimensions [numVertices][numVertices]
        for (int i = 0; i < numVertices; i++) { // Nested loop to iterate through rows and columns of the 'edges' array
            for (int j = 0; j < numVertices; j++) {
                edges[i][j] = Integer.MAX_VALUE; // Sets the initial distance between vertices as maximum integer value
            }
        }
    }

    public void addEdge(int start, int end, int distance) { // Method to add an edge between vertices with a specified distance
        edges[start][end] = distance; // Sets the distance between start and end vertices
        edges[end][start] = distance; // Sets the distance between end and start vertices (assuming an undirected graph)
    }

    public int getDistance(int start, int end) { // Method to get the distance between two vertices
        return edges[start][end]; // Returns the distance stored in the 'edges' array
    }

    public List<Integer> getNeighbors(int vertex) { // Method to get a list of neighboring vertices for a given vertex
        List<Integer> neighbors = new ArrayList<>(); // Creates an ArrayList to store neighboring vertices
        for (int i = 0; i < numVertices; i++) { // Loop to iterate through vertices
            if (edges[vertex][i] != Integer.MAX_VALUE) { // Checks if there's a valid edge between the given vertex and i
                neighbors.add(i); // Adds the neighboring vertex 'i' to the list
            }
        }
        return neighbors; // Returns the list of neighboring vertices
    }

    public void printAdjacencyMatrix() { 
        System.out.print("        "); // Prints initial spacing
        for (int i = 0; i < numVertices; i++) { // Loop to print column headers (vertex numbers)
            System.out.printf("%-7d", i); // Prints the vertex number with formatting
        }
        System.out.println(); // Moves to the next line

        for (int i = 0; i < numVertices; i++) { // Loop to iterate through rows
            System.out.printf("%-7d", i); // Prints the row header (vertex number)
            for (int j = 0; j < numVertices; j++) { // Loop to iterate through columns
                System.out.print(edges[i][j] == Integer.MAX_VALUE ? "∞\t   " : edges[i][j] + "\t   ");
                // Prints either '∞' if distance is maximum or the actual distance with formatting
            }
            System.out.println(); // Moves to the next line after printing a row
        }
    }
}
