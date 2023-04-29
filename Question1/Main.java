package com.husseinabdikarim;

import java.util.Scanner;

public class Main {

//-----------------------------------------------------
// Title: Question 1
// Author: Hussein Abdikarim Hussein
// ID: 99230997266
// Section: 1
// Assignment: 1
// Description: This class finds the shortest path
// between 2 vertices and calculates the total time
// required to travel that path.
//-----------------------------------------------------


    public static void main(String[] args) {

        //--------------------------------------------------------
        // Summary: This main() takes inputs from the user
        // and adds these values the undirectedGraph then calculated
        // the total_time required to travel those paths.
        // Precondition: it takes String arguments as input
        // Postcondition: It outputs the shortest paths between the 2 vertices
        // inclusive and also gets the total_time of the paths.
        //--------------------------------------------------------

        Scanner scanner = new Scanner(System.in);
        // Read the number of vertices and edges
        int numVertices = scanner.nextInt();
        int numEdges = scanner.nextInt();
        int T = scanner.nextInt();
        int C = scanner.nextInt();

        Graph g = new Graph(numVertices);

        // Read the edges and add them to the adjacency list
        for (int i = 0; i < numEdges; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            g.addEdge(u,v);
        }

        int source = scanner.nextInt();
        int fDestination = scanner.nextInt();
        System.out.println(T);

        int total_time = 0;
        int S_D = C; // source to 1 of the destinations, it takes 5mins.
        int calculateCount = (C - T);
        int count = (T - calculateCount);

        BreadthFirstPaths bfs = new BreadthFirstPaths(g,source);
        MyStack<Integer> stack = new MyStack<>();
        for(int w : bfs.pathTo(fDestination)) {
            stack.push(w);
            System.out.print(w + " ");
        }

        total_time = getTotal_time(fDestination, total_time, S_D, count, bfs);

        System.out.println("\n" + total_time);

    }

    private static int getTotal_time(int fDestination, int total_time, int S_D, int count, BreadthFirstPaths bfs) {

        //--------------------------------------------------------
        // Summary: This method calculates the total_time required
        // to travel between all the paths.
        // Precondition: fDestination, total_time, S_D and count
        // take input as an int and bfs takes input as BreadthFirstPaths.
        // Postcondition: It returns the total_time which is an int.
        //--------------------------------------------------------

        LinkList<Integer> path = new LinkList<>();

        for(int i : bfs.pathTo(fDestination)){
            path.add(i);
        }

        int lastIndex = path.getSize() - 1;
        for (int i = 0; i < path.getSize(); i++) {
            if (i != 0 && i != lastIndex) {
                total_time += S_D + count;
            }else if(i == lastIndex)
                total_time += S_D;
        }
        return total_time;
    }
}
