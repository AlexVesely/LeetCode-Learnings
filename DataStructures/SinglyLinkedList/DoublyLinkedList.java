package DataStructures.SinglyLinkedList;

public class DoublyLinkedList {
    DoublyNode head;

    public void insertAtBeginning(int data) {
        DoublyNode newNode = new DoublyNode(data);
        if (head != null) {
            head.setPrev(newNode);
        }
        newNode.setNext(head);
        head = newNode;
    }

    public void insertAtEnd(int data) {
        DoublyNode newNode = new DoublyNode(data);
        if (head == null) {
            head = newNode;
            return;
        }
        DoublyNode current = head;
        while (current.getNext() != null) {
            current = current.getNext();
        }
        current.setNext(newNode);
        newNode.setPrev(current);
    }

    public void deleteByValue(int value) {
        if (head == null) {
            return;
        }

        if (head.getData() == value) {
            head = head.getNext();
            if (head != null) {
                head.setPrev(null);
            }
            return;
        }

        DoublyNode current = head;
        while (current != null && current.getData() != value) {
            current = current.getNext();
        }

        if (current != null) {
            if (current.getNext() != null) {
                current.getNext().setPrev(current.getPrev());
            }
            if (current.getPrev() != null) {
                current.getPrev().setNext(current.getNext());
            }
        }
    }

    public void printList() {
        DoublyNode current = head;
        while (current != null) {
            System.out.print(current.getData() + " <-> ");
            current = current.getNext();
        }
        System.out.println("null");
    }

    // Reverse the doubly linked list
    public void reverse() {
        DoublyNode current = head;
        DoublyNode temp = null;

        // Traverse through the list and swap next and prev for each node
        while (current != null) {
            temp = current.getPrev();
            current.setPrev(current.getNext());
            current.setNext(temp);

            current = current.getPrev(); // Next node is current.prev after the swap
        }

        // Update head to the last node (temp will be the new head after the loop)
        if (temp != null) {
            head = temp.getPrev();
        }
    }

    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();
        list.insertAtBeginning(3);
        list.insertAtBeginning(2);
        list.insertAtEnd(5);
        list.insertAtEnd(7);
        list.insertAtEnd(1);

        System.out.println("Original List:");
        list.printList();

        list.deleteByValue(5);
        System.out.println("After Deleting 5:");
        list.printList();

        list.reverse();
        System.out.println("After Reversing:");
        list.printList();
    }

}

