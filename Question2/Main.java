package com.husseinabdikarim;

import java.util.Scanner;

public class Main {

//-----------------------------------------------------
// Title: Question 2
// Author: Hussein Abdikarim Hussein
// Section: 1
// Assignment: 1
// Description: This class finds a cycle between
// the the given vertices from the user.
//-----------------------------------------------------

    public static void main(String[] args) {

        //--------------------------------------------------------
        // Summary: This main() takes inputs from the user
        // and adds these values the undirectedGraph then finds a cycle
        // between those given verices.
        // Precondition: it takes String arguments as input
        // Postcondition: It outputs the cycle of the given vertices
        // in ascending order.
        //--------------------------------------------------------

        Scanner scanner = new Scanner(System.in);
        // Read the number of vertices and edges
        int numVertices = scanner.nextInt();
        int numEdges = scanner.nextInt();

        Graph g = new Graph(numVertices);

        // Read the edges and add them to the adjacency list
        for (int i = 0; i < numEdges; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            g.addEdge(u,v);
        }

        int source = scanner.nextInt();
        int fDestination = scanner.nextInt();

//        DepthFirstPaths dfs = new DepthFirstPaths(g,source);
        BreadthFirstPaths bfs = new BreadthFirstPaths(g,source);
        MyStack<Integer> stack = new MyStack<>();

        for(int w : bfs.pathTo(g,fDestination)) {
            stack.push(w);
        }

        BreadthFirstPaths bfs2 = new BreadthFirstPaths(g,source);
        for(int w : bfs2.pathTo(g,fDestination)) {

            if(w != source && w != fDestination){
                stack.push(w);
            }
        }

        int[] array = new int[stack.size()];
        for(int i = 0; i < array.length; i++) {
            array[i] = stack.pop();
        }

        insertionSort(array);
    }

    private static int[] insertionSort(int[] array) {

        //--------------------------------------------------------
        // Summary: Sorts an array of integers using the insertion sort algorithm.
        // Precondition: The array must not be null.
        // Postcondition: The elements in the input array are rearranged
        // such that they are in non-decreasing order. The input array is
        // modified in place and the sorted array is returned.
        //--------------------------------------------------------

        /*We start from 1 because we assume by default the first value is sorted*/
        for(int firstUnsortedIndex = 1; firstUnsortedIndex < array.length; firstUnsortedIndex++) {
            int newElement = array[firstUnsortedIndex];

            /*iterate backwards through the sorted portion of the array
            (i.e., the elements to the left of firstUnsortedIndex)
            until you find the correct position for newElement.*/
            int i;
            for(i = firstUnsortedIndex; i > 0 && array[i - 1] > newElement; i--) { //
                array[i] = array[i - 1];
            }

            array[i] = newElement;
        }

        for (int i = 0; i < array.length; i++) { // print the array
            System.out.print(array[i] + " ");
        }

        return array;
    }

}
