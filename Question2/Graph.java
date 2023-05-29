package com.husseinabdikarim;

public class Graph {

//-----------------------------------------------------
// Title: Question 2
// Author: Hussein Abdikarim Hussein
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
        this.V = V+1;
        this.E = 0;
        adj = (Bag<Integer>[]) new Bag[V+1]; // Create array of lists.
        for (int v = 0; v < V + 1; v++) // Initialize all lists
            adj[v] = new Bag<Integer>(); // to empty.
    }

    public int V() {

    //--------------------------------------------------------
    // Summary: Returns the vertices of the graph.
    // Precondition: It takes no inputs.
    // Postcondition: Returns and the number of vertices of the graph.
    //--------------------------------------------------------

     return V;

    }
    public int E() {
//--------------------------------------------------------
        // Summary: Returns the Edges of the graph.
        // Precondition: It takes no inputs.
        // Postcondition: Returns and the number of edges of the graph.
        //--------------------------------------------------------

        return E;
    }

    public void addEdge(int v, int w) {

        //--------------------------------------------------------
        // Summary: This method adds edges between the vertices of the graph.
        // Precondition: It takes 2 ints v and w as inputs.
        // Postcondition: Adds edges between the vertices of the graph..
        //--------------------------------------------------------

        adj[v].add(w); // Add w to v’s list.
        adj[w].add(v); // Add v to w’s list.
        E++;
    }

    public void removeEdge(int v, int u) {

        //--------------------------------------------------------
        // Summary: This method removes edges between the vertices of the graph.
        // Precondition: It takes 2 ints v and u as inputs.
        // Postcondition: Removes edges between the vertices of the graph..
        //--------------------------------------------------------

        adj[v].remove(u);
        adj[u].remove(v);
    }
    public Iterable<Integer> adj(int v) {

        //--------------------------------------------------------
        // Summary: This method returns the adjacent values of one vertex
        // of the graph.
        // Precondition: It takes an int v as input.
        // Postcondition: Returns an iterable adjacent values of input v.
        //--------------------------------------------------------

        return adj[v];
    }
}
