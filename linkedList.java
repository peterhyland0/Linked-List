static class LinkedListDemo {

    static class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
            next = null;
        }
    }

    static Node insertAtpos(Node head, int data, int pos) {
        Node new_node = new Node(data);
        if (pos == 1) {
            new_node.next = head;
            return new_node;
        }
        Node current_pos = head;
        int count = 1;
        while (count < pos-1 && current_pos != null) {
            current_pos = current_pos.next;
            count++;
        }
        if (current_pos == null) {
            System.out.println("Invalid pos!");
            return head;
        }
        new_node.next = current_pos.next;
        current_pos.next = new_node;
        return head;
    }

    static Node deleteAtpos(Node head, int pos) {
        if (pos == 1) {
            return head.next;
        }
        Node current_pos = head;
        int count = 1;
        while (count < pos-1 && current_pos != null) {
            current_pos = current_pos.next;
            count++;
        }
        if (current_pos == null || current_pos.next == null) {
            System.out.println("Invalid pos!");
            return head;
        }
        current_pos.next = current_pos.next.next;
        return head;
    }

    static Node deleteLastNode(Node head) {
        if (head == null || head.next == null) {
            return null;
        }
        Node current_pos = head;
        while (current_pos.next.next != null) {
            current_pos = current_pos.next;
        }
        current_pos.next = null;
        return head;
    }

    static void printList(Node head) {
        Node current_pos = head;
        while (current_pos != null) {
            System.out.print(current_pos.data + " ");
            current_pos = current_pos.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node head = new Node(11);
        head.next = new Node(22);
        head.next.next = new Node(6);
        head.next.next.next = new Node(89);
        head.next.next.next.next = new Node(99);

        // Inserting 50 in the third pos
        head = insertAtpos(head, 50, 3);
        printList(head);

        // Deleting the second element
        head = deleteAtpos(head, 2);
        printList(head);

        // Deleting the first element
        head = deleteAtpos(head, 1);
        printList(head);

        // Deleting the last element
        head = deleteLastNode(head);
        printList(head);
    }
}