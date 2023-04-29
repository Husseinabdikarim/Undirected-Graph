package com.husseinabdikarim;

public class Graph {

//-----------------------------------------------------
// Title: Question 1
// Author: Hussein Abdikarim Hussein
// ID: 99230997266
// Section: 1
// Assignment: 1
// Description: This class represents an undirected graph. It contains a constructor
// that takes the number of vertices and initializes an empty adjacency list
// for each vertex. It has methods to add an edge between two vertices, return
// the number of vertices and edges, and get the adjacency list for a given vertex.
//-----------------------------------------------------

    private final int V; // number of vertices
    private int E; // number of edges
    private Bag<Integer>[] adj; // adjacency lists

    public Graph(int V) {

        //--------------------------------------------------------
        // Summary: Assigns a value to the variable whose
        // name is given.
        // Precondition: varName is a char and varValue is an
        // integer
        // Postcondition: The value of the variable is set.
        //--------------------------------------------------------

        this.V = V+1;
        this.E = 0;
        adj = (Bag<Integer>[]) new Bag[V+1]; // Create array of lists.
        for (int v = 0; v < V + 1; v++) // Initialize all lists
            adj[v] = new Bag<Integer>(); // to empty.
    }

    public int V() {
        //--------------------------------------------------------
        // Summary: Assigns a value to the variable whose
        // name is given.
        // Precondition: varName is a char and varValue is an
        // integer
        // Postcondition: The value of the variable is set.
        //--------------------------------------------------------

        return V;
    }
    public int E() {

        //--------------------------------------------------------
        // Summary: Assigns a value to the variable whose
        // name is given.
        // Precondition: varName is a char and varValue is an
        // integer
        // Postcondition: The value of the variable is set.
        //--------------------------------------------------------

        return E;
    }

    public void addEdge(int v, int w) {

        //--------------------------------------------------------
        // Summary: It is used to add edges between vertices of the Graph.
        // Precondition: Takes in 2 int values as input.
        // Postcondition: Adds edge between these 2 vertices.
        //--------------------------------------------------------

        adj[v].add(w); // Add w to v’s list.
        adj[w].add(v); // Add v to w’s list.
        E++;
    }
    public Iterable<Integer> adj(int v) {

        //--------------------------------------------------------
        // Summary: It is used to find the adjacency of the vertices
        // in the Graph.
        // Precondition: It takes in an int as input.
        // Postcondition: It returns an iterable of the value
        // adjacent to the input of the method.
        //--------------------------------------------------------

        return adj[v];
    }
}
