package DataStructures;

import java.util.LinkedList;

public class LinkedListLearning {

    //TO DO
    //Detecting a cycle in a linked list (use Floyd’s cycle detection).
    //Merging two sorted linked lists.
    //Reversing a linked list.
    //Finding the middle node (use slow and fast pointers).
    //Removing duplicates from a linked list.
    //Partitioning a linked list around a value.

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();

        list.addFirst(3);
        list.addFirst(2);
        list.addLast(5);
        list.addLast(7);

        System.out.println("Original List: " + list);

        list.removeFirst();
        System.out.println("After Removing First: " + list);

        list.removeLast();
        System.out.println("After Removing Last: " + list);

        list.add(1, 10); // Add at a specific position
        System.out.println("After Adding 10 at Index 1: " + list);
    }
}
