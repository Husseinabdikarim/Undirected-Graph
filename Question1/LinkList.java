package com.husseinabdikarim;

public class LinkList<I extends Number> {

//-----------------------------------------------------
// Title: Question 1
// Author: Hussein Abdikarim Hussein
// ID: 99230997266
// Section: 1
// Assignment: 1
// Description: This is a generic SinglyLinkList class DataStructure used in
// the Main class for storing values in order to find the total
// time required between paths.
//-----------------------------------------------------

        private SingleNode head;
        private SingleNode tail;
        private int Size;

        public LinkList() {
            this.head = null;
            this.tail = null;
        }

    public SingleNode getHead() {
        return head;
    }

    public void setHead(SingleNode head) {
        this.head = head;
    }

    public SingleNode getTail() {
        return tail;
    }

    public void setTail(SingleNode tail) {
        this.tail = tail;
    }

    public int getSize() {
        return Size;
    }

    public void setSize(int size) {
        Size = size;
    }

    private class SingleNode<I extends Number> {
            int item;
            SingleNode next;
            SingleNode previous;

            public SingleNode(int item) {
                this.item = item;
            }

            public int getItem() {
                return item;
            }

            public void setItem(int item) {
                this.item = item;
            }

            public SingleNode getNext() {
                return next;
            }

            public void setNext(SingleNode next) {
                this.next = next;
            }

            public SingleNode getPrevious() {
                return previous;
            }

            public void setPrevious(SingleNode previous) {
                this.previous = previous;
            }

            @Override
            public String toString() {
                return ("[ " + item + " ]");
            }
        }
        //  the addLast method of the linkList
        public void add(int t) {
            SingleNode node = new SingleNode(t);
            if (head == null) {
                head = tail = new SingleNode(t);
                Size++;
            } else if (head != null) {
                tail.setNext(node);
                node.setPrevious(tail);
                tail = node;
                Size++;
            }
        }

        //  Printing the LinkList method
        public void print() {
            SingleNode iter = head;
            System.out.print("[");
            for (int i = 0; i < Size; i++) {
                if (iter == tail)
                    System.out.print(iter.getItem());
                else
                    System.out.print(iter.getItem() + " ,");
                iter = iter.getNext();
            }
            System.out.print("]");
        }
}

