/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sm.ds.lists;

/**
 * Implementation of a singly linked linked list.
 *
 * @author smazumder
 */
public class LList<T> {

    //Inner representantion of a node
    class Node<T> {

        private T item;
        private Node next;

        private Node(T anItem, Node n) {
            this.item = anItem;
            this.next = n;
        }
    }

    //Maintain a count of the number of nodes in the list.
    private int length = 0;

    //Maintain a reference to the head of this list
    private Node head = null;

    public LList(T item) {
        this.add(item);
    }

    public Node head() {
        return head;
    }

    /**
     * Adds an item to the front of this list.
     *
     * @param item
     */
    public void add(final T item) {
        this.head = new Node(item, head);
        length++;
    }

    /**
     * Adds an element to the end of this list
     *
     * @param item
     */
    public void addLast(final T item) {
        if (length == 0) {
            this.head = new Node(item, null);
        } else {
            Node curr = head;
            while (curr.next != null) {
                curr = curr.next;
            }
            Node newNode = new Node(item, null);
            curr.next = newNode;
            length++;
        }

    }

    /**
     * Insert an item after the node matching this key.
     *
     * @param Key
     * @param item
     */
    public void insertAfter(final T key, final T item) {
        if (length == 0) { //none inserted
            return;
        }
        if (head.item.equals(key)) {
            Node newNode = new Node(item, head.next);
            head.next = newNode;
            this.length++;
        } else {
            Node curr = head;
            Node prev = null;
            while (curr != null && !curr.item.equals(key)) {
                prev = curr;
                curr = curr.next;
            }
            if (curr != null) {
                prev = curr;
                Node newNode = new Node(item, curr.next);
                prev.next = newNode;
                length++;
            }
        }
    }

    /**
     * Remove an item from a list.
     *
     * @param item
     * @return
     */
    public Node remove(final T key) {

        Node n = null;
        //If the list is empty
        if (length == 0) { //list is empty
            return null;
        }
        //Ket to be removed is at the head.
        if (head.item.equals(key)) {
            n = head;
            head = head.next;
            length--;
            return n;
        }

        Node curr = head;
        Node prev = null;

        while (curr != null && !curr.item.equals(key)) {
            prev = curr;
            curr = curr.next;
        }

        if (curr == null) {
            return null; //Key not found therefore not removed.
        } else {
            prev.next = curr.next;
            length--;
            n = curr;
        }
        return n;
    }

    /**
     * Returns the length of this list.
     *
     * @return
     */
    public int length() {
        return this.length;
    }

    /**
     * Returns the string representation of a list.
     *
     * @return
     */
    @Override
    public String toString() {
        Node tmp = head;
        StringBuilder sb = new StringBuilder("[ ");
        while (tmp != null) {
            sb.append(tmp.item.toString() + " , ");
            tmp = tmp.next;
        }
        return sb.append("]").toString();
    }

    public static void main(String[] args) {
        LList<Integer> list = new LList<Integer>(new Integer(12));
        System.out.println(list);
        list.add(14);
        list.add(15);
        list.add(16);
        list.add(17);
        System.out.println(list);
        list.insertAfter(12, 18);
        list.insertAfter(16, 99);
        System.out.println(list);
        list.remove(99);
        System.out.println(list);
        list.remove(12);
        System.out.println(list);
        list.addLast(999);
        System.out.println(list);
    }
}
