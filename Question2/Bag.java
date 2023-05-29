package com.husseinabdikarim;

import java.util.Iterator;

public class Bag<Item> implements Iterable<Integer> {

//-----------------------------------------------------
// Title: Question 2
// Author: Hussein Abdikarim Hussein
// Section: 1
// Assignment: 1
// Description: This is a generic Bag class that holds
// a collection of Items and imitates a linkedList
// implementation.
//-----------------------------------------------------

    private Node first; // first node in list
    private class Node {
        Item item;
        Node next;
    }
    public void add(Item item) {

        //--------------------------------------------------------
        // Summary: It adds an item to the Bag class.
        // Precondition: The Bag list is not empty and the input
        // item is not null..
        // Postcondition: It adds the value to the Bag.
        //--------------------------------------------------------

        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
    }

    public void remove(Item item) {

        //--------------------------------------------------------
        // Summary: Removes the first occurrence of a specified item
        // from the Bag list.
        // Precondition: The Bag is not empty and the input
        // item is not null..
        // Postcondition: The first occurrence of the input item in the Bag is removed.
        // If the item is found, the Bag is modified in place and the first field is updated
        // to reflect the new head of the list. If the item is not found, the list remains unchanged. .
        //--------------------------------------------------------

        Node currentNode = (Node) first;
        Node previousNode = null;
        while(currentNode != null){
            if(item.equals(currentNode.item)){
                if(previousNode  == null) {
                    first = (Node) currentNode.next;
                }
                else {
                    previousNode.next = currentNode.next;
                }
            }
            else {
                previousNode = currentNode;
            }
            currentNode = currentNode.next;
        }

    }

    public Iterator<Integer> iterator()
    { return (Iterator<Integer>) new ListIterator(); }

    private class ListIterator implements Iterator<Item> {
        private Node current = first;
        private Node previous = null;
        private boolean removeCalled = false;
        public boolean hasNext()
        { return current != null; }

        public Item next() {
            Item item = current.item;
            previous = current;
            current = current.next;
            removeCalled = true;
            return item;
        }
    }
}
