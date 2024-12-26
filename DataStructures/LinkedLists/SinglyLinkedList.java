package DataStructures.LinkedLists;

public class SinglyLinkedList {
    Node head;

    public void insertAtBeginning(int data) {
        Node newNode = new Node(data);
        newNode.setNext(head);
        head = newNode;
    }

    public void insertAtEnd(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node current = head;
        while (current.getNext() != null) {
            current = current.getNext();
        }
        current.setNext(newNode);
    }

    public void deleteByValue(int value) {
        if (head == null) {
            return;
        }

        // If the head is the node to be deleted
        if (head.getData() == value) {
            head = head.getNext();
            return;
        }

        Node current = head;
        while (current.getNext() != null && current.getNext().getData() != value) {
            current = current.getNext();
        }

        if (current.getNext() != null) {
            current.setNext(current.getNext().getNext());
        }
    }

    public void reverse() {
        Node prev = null;
        Node current = head;
        Node next = null;
        while (current != null) {
            next = current.getNext();  // Store next node
            current.setNext(prev);  // Reverse current node's pointer
            prev = current;       // Move prev and current one step forward
            current = next;
        }
        head = prev;
    }

    public void printList() {
        Node current = head;
        while (current != null) {
            System.out.print(current.getData() + " -> ");
            current = current.getNext();
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        list.insertAtBeginning(3);
        list.insertAtBeginning(2);
        list.insertAtEnd(5);
        list.insertAtEnd(7);

        System.out.println("Original List:");
        list.printList();

        list.reverse();
        System.out.println("Reversed List:");
        list.printList();

        list.deleteByValue(5);
        System.out.println("After Deleting 5:");
        list.printList();
    }
}

