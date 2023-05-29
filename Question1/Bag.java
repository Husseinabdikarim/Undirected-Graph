package com.husseinabdikarim;

import java.util.Iterator;

public class Bag<Item> implements Iterable<Integer> {


//-----------------------------------------------------
// Title: Question 1
// Author: Hussein Abdikarim Hussein
// Section: 1
// Assignment: 1
// Description: This is a generic Bag class that holds
// a collection of Items that is similar with a linkedList
// implementation.
//-----------------------------------------------------

    private Node first; // first node in the list

    private class Node {
        Item item;
        Node next;
    }
    public void add(Item item) {

        //--------------------------------------------------------
        // Summary: It adds an item to the Bag class.
        // Precondition: It takes an Item as input which is a generic type.
        // Postcondition: It adds the value to the Bag.
        //--------------------------------------------------------

        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
    }

    public Iterator<Integer> iterator() {

        return (Iterator<Integer>) new ListIterator();
    }

    private class ListIterator implements Iterator<Item> {
        private Node current = first;
        public boolean hasNext() {
            return current != null;
        }

        public void remove() { }

        public Item next() {
            Item item = current.item;
            current = current.next;
            return item;
        }
    }
}
