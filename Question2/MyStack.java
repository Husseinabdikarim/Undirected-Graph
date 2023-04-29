package com.husseinabdikarim;

import java.util.Iterator;

public class MyStack<Item> implements Iterable{

//-----------------------------------------------------
// Title: Question 2
// Author: Hussein Abdikarim Hussein
// ID: 99230997266
// Section: 1
// Assignment: 1
// Description: This is a generic Stack class DataStructure used in
// the BreadthFirstPaths class for storing the shortest path
// values in it and is also used by Main class to print the values.
//-----------------------------------------------------

    private Node first; // top of stack (most recently added node)
    private int N; // number of items

    private class Node { // nested class to define nodes
        Item item;
        Node next;
    }

    public boolean isEmpty() { // check if it is empty
        return first == null;
    } // Or: N == 0.
    public int size() {
        return N;
    }

    public void push(Item item) { // Add item to top of stack.

        //--------------------------------------------------------
        // Summary: This method is used to add an item to the top of
        // the Stack.
        // Precondition: It takes Item as input which is a generic type.
        // Postcondition: Pushes the items to the Stack.
        //--------------------------------------------------------

        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
        N++;
    }
    public Item pop() { // Remove item from top of stack.

        //--------------------------------------------------------
        // Summary: This method is used to delete an item from
        // the Stack.
        // Precondition: It takes no input.
        // Postcondition: Pops the items from the Stack.
        //--------------------------------------------------------

        Item item = first.item;
        first = first.next;
        N--;
        return item;
    }

    public Item peek() {

        //--------------------------------------------------------
        // Summary: This method is used to peek an items from
        // the Stack.
        // Precondition: It takes no input.
        // Postcondition: peeks the first items from the Stack
        // without removing it.
        //--------------------------------------------------------

        return first.item;
    }

    public static <Item> Item peekSecond(MyStack<Integer> stack) {

        //--------------------------------------------------------
        // Summary: This method is used to peek an the 2nd Item from
        // the Stack.
        // Precondition: It takes Stack Item as input.
        // Postcondition: peeks the 2nd items from the Stack
        // without removing it.
        //--------------------------------------------------------

        if (stack.size() < 2) {
            return null;
        } else {
            Item top = (Item) stack.pop();
            Item second = (Item) stack.peek();
            stack.push((Integer) top);
            return second;
        }
    }

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
}

