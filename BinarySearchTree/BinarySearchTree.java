package app;

import java.io.File; 
import java.io.FileNotFoundException; 
import java.io.IOException;
import java.util.Scanner; 

// Define a class "Node" to represent nodes in the Binary Search Tree
class Node {
    String data; // Store the data of the node
    Node left, right; // Store references to the left and right child nodes

    Node(String data) { // Constructor to create a new node with the given data
        this.data = data;
        left = right = null; // Initialize left and right child references to null
    }
}

// Define the main class "BinarySearchTree" to implement the Binary Search Tree
public class BinarySearchTree {
    private Node root; // Declare a private variable "root" to store the root node of the BST

    public BinarySearchTree() { // Constructor to initialize the BST with an empty root
        root = null;
    }

    // Function to insert a new node with the given data into the BST
    public void insert(String data) {
        root = insertRec(root, data); // Call the private recursive insert function with the root and data
    }

    // Recursive helper function to insert a new node into the BST
    private Node insertRec(Node root, String data) {
        if (root == null) { // If the current node is null, create a new node with the data
            root = new Node(data);
            return root; // Return the new node
        }

        // If the data is less than the current node's data, recursively insert into the left subtree
        if (data.compareTo(root.data) < 0) {
            root.left = insertRec(root.left, data);
        } else if (data.compareTo(root.data) > 0) {
            // If the data is greater than the current node's data, recursively insert into the right subtree
            root.right = insertRec(root.right, data);
        }

        return root; // Return the current node after insertion
    }

    // Function to perform an in-order traversal of the BST and display the data in the console
    public void inOrderTraversal(Node root) {
        if (root != null) { // If the current node is not null
            inOrderTraversal(root.left); // Recursively traverse the left subtree
            System.out.print(root.data + " "); // Display the current node's data in the console
            inOrderTraversal(root.right); // Recursively traverse the right subtree
        }
    }

    // Function to search for a word in the BST and return the number of elements inspected during the search
    public int search(String word) {
        return searchRec(root, word, 0); // Call the private recursive search function with the root and word
    }

    // Recursive helper function to search for a word in the BST and count the elements inspected
    private int searchRec(Node root, String word, int count) {
        if (root == null) { // If the current node is null, the word is not found
            return -count; // Return the negative count to indicate word not found
        }

        count++; // Increment the count of elements inspected
        if (word.equals(root.data)) { // If the word matches the current node's data
            System.out.println("Found " + word + " with " + count + " elements inspected."); // Print the search result
            return count; // Return the count of elements inspected
        } else if (word.compareTo(root.data) < 0) {
            // If the word is less than the current node's data, recursively search the left subtree
            return searchRec(root.left, word, count);
        } else {
            // If the word is greater than the current node's data, recursively search the right subtree
            return searchRec(root.right, word, count);
        }
    }

    // Function to remove a word from the BST
    public Node remove(Node root, String word) {
        if (root == null) { // If the tree is empty or the word is not found
            return root;
        }

        // Recursively search for the word in the left subtree
        if (word.compareTo(root.data) < 0) {
            root.left = remove(root.left, word);
        } 
        // Recursively search for the word in the right subtree
        else if (word.compareTo(root.data) > 0) {
            root.right = remove(root.right, word);
        } 
        // If the word is found
        else {
            // Case 1: Node with only one child or no child
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            // Case 2: Node with two children
            root.data = minValue(root.right);

            // Delete the in-order successor
            root.right = remove(root.right, root.data);
        }
        return root;
    }

    // Helper function to find the minimum value in a BST
    private String minValue(Node root) {
        String minValue = root.data;
        while (root.left != null) {
            minValue = root.left.data;
            root = root.left;
        }
        return minValue;
    }

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree(); // Create a new instance of BinarySearchTree

        try {
            File inputFile = new File("input.txt"); // Create a new File instance for "input.txt"
            Scanner fin = new Scanner(inputFile); // Create a new Scanner to read from "input.txt"

            while (fin.hasNext()) { // Read words from "input.txt" and insert them into the BST
                String word = fin.next(); // Read the next word from the file
                tree.insert(word); // Insert the word into the Binary Search Tree
            }
            fin.close(); // Close the Scanner after reading is complete
        } catch (FileNotFoundException e) { // Handle FileNotFoundException if "input.txt" is not found
            e.printStackTrace(); // Print the error stack trace
        }
        
        tree.inOrderTraversal(tree.root);
        System.out.println();

        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        while (choice != 3) {
            System.out.println("Enter 1 for search, 2 for removal, or 3 to quit:");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter word to search (or 'exit' to go back to the main menu):");
                    String searchWord = scanner.next();
                    while (!searchWord.equals("exit")) {
                        int count = tree.search(searchWord);
                        if (count < 0) {
                            System.out.println("Word not found. Inspected " + Math.abs(count) + " elements.");
                        }
                        System.out.println("Enter word to search (or 'exit' to go back to the main menu):");
                        searchWord = scanner.next();
                    }
                    break;
                case 2:
                    System.out.println("Enter word to remove (or 'exit' to go back to the main menu):");
                    String removeWord = scanner.next();
                    while (!removeWord.equals("exit")) {
                        tree.root = tree.remove(tree.root, removeWord);
                        System.out.println("Tree after removing '" + removeWord + "':");
                        tree.inOrderTraversal(tree.root);
                        System.out.println();
                        System.out.println("Enter word to remove (or 'exit' to go back to the main menu):");
                        removeWord = scanner.next();
                    }
                    break;
                case 3:
                    System.out.println("Exiting program...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }
}




