package com.husseinabdikarim;

public class BreadthFirstPaths {

//-----------------------------------------------------
// Title: Question 2
// Author: Hussein Abdikarim Hussein
// ID: 99230997266
// Section: 1
// Assignment: 1
// Description: This class implements the
// BreadthFirstSearch and uses the pathTO() method
// to find the shortest path between 2 vertices in a graph.
//-----------------------------------------------------

    private boolean[] marked; // Is a shortest path to this vertex known?
    private int[] edgeTo; // last vertex on known path to this vertex
    private final int s; // source

    public BreadthFirstPaths(Graph G, int s) {

        //--------------------------------------------------------
        // Summary: This is the constructor method for
        // BreadthFirstPaths class.
        // Precondition: It the Graph class as input and also
        // takes an int s.
        // Postcondition: It initializes both the marked and edgeTo
        // arrays, sets s to the value s and calls the bfs().
        //--------------------------------------------------------

        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        this.s = s;
        bfs(G, s);
    }

    private void bfs(Graph G, int s) {

        //--------------------------------------------------------
        // Summary: This is a BreadthFirstSearch implementation
        // used to traverse the undirectedGraph.
        // Precondition: It takes an int and a Graph as input.
        // Postcondition: It traverses the Graph and doesn't return anything.
        //--------------------------------------------------------

        MyQueue<Integer> queue = new MyQueue<Integer>();
        marked[s] = true; // Mark the source
        queue.enqueue(s); // and put it on the queue.
        while (!queue.isEmpty()) {
            int v = queue.dequeue(); // Remove next vertex from the queue.
            for (int w : G.adj(v)) {
                if (!marked[w]) {
                    edgeTo[w] = v; // save last edge on a shortest path,
                    marked[w] = true; // mark it because path is known,
                    queue.enqueue(w); // and add it to the queue.
                }
            }
        }
    }
    public boolean hasPathTo(int v) {

        //--------------------------------------------------------
        // Summary: It checks if the value provided is marked
        // True or False.
        // Precondition: It takes an int as a parameter.
        // Postcondition: It returns a boolean value True or False.
        //--------------------------------------------------------

        return marked[v];
    }

    public Iterable<Integer> pathTo(Graph g, int v) {

        //--------------------------------------------------------
        // Summary: This method is used to find the shortest path
        // between the source and a vertex in the Graph.
        // Precondition: In takes an int as an input.
        // Postcondition: It returns an iterable of the paths between
        // the source and the vertex passed as input inclusive.
        //--------------------------------------------------------

        if (!hasPathTo(v)) return null;
        MyStack<Integer> path = new MyStack<>();
        for (int x = v; x != s; x = edgeTo[x]) {
            path.push(x);
                if(x != v){
                    g.removeEdge(x,edgeTo[x]);
                }
        }
        path.push(s);
        if(path.size() == 2) {
           // int top = path.pop(); // Doing this to peek at the 2nd value
            g.removeEdge(s,MyStack.peekSecond(path)); // path.peek() as 2nd parameter..
//            path.push(top); // putting it back
        }
        return path;
    }
}
