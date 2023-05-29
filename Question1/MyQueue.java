package com.husseinabdikarim;

import java.util.Iterator;

public class MyQueue<Item> implements Iterable<Item> {

//-----------------------------------------------------
// Title: Question 1
// Author: Hussein Abdikarim Hussein
// Section: 1
// Assignment: 1
// Description: This is a generic Queue class DataStructure used in
// the BreadthFirstPaths class for the traversal of the Graph.
//-----------------------------------------------------

    private Node first; // link to least recently added node
    private Node last; // link to most recently added node
    private int N; // number of items on the queue

    @Override
    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item> {
        private Node current = first;

        public boolean hasNext() {
            return current != null;
        }

        public void remove() {
        }

        public Item next() {
            Item item = current.item;
            current = current.next;
            return item;
        }
    }

    private class Node { // nested class to define nodes
        Item item;
        Node next;
    }

    public boolean isEmpty() {
        return first == null;
    } // Or: N == 0.

    public int size() {
        return N;
    }

    public void enqueue(Item item) { // Add item to the end of the list.

        //--------------------------------------------------------
        // Summary: This method is used to add an item to the end of
        // the Queue.
        // Precondition: It takes Item as input which is a generic type.
        // Postcondition: Enqueues the items to the Queue.
        //--------------------------------------------------------

        Node oldlast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if (isEmpty()) first = last;
        else oldlast.next = last;
        N++;
    }

    public Item dequeue() { // Remove item from the beginning of the list.

        //--------------------------------------------------------
        // Summary: This method is used to delete an item from
        // the Queue.
        // Precondition: It takes Item as input which is a generic type.
        // Postcondition: Dequeues the items from the Queue.
        //--------------------------------------------------------

        Item item = first.item;
        first = first.next;
        if (isEmpty()) last = null;
        N--;
        return item;
    }
}
