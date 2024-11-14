import java.util.Scanner;

class DLList {
    class Node { int data; Node prev, next; Node(int d) { data = d; } }
    private Node head, tail;

    public void insertAtBeginning(int data) {
        Node newNode = new Node(data);
        if (head == null) head = tail = newNode;
        else { newNode.next = head; head.prev = newNode; head = newNode; }
    }

    public void insertAtEnd(int data) {
        Node newNode = new Node(data);
        if (tail == null) head = tail = newNode;
        else { tail.next = newNode; newNode.prev = tail; tail = newNode; }
    }

    public void insertAtPosition(int data, int pos) {
        if (pos <= 0) { insertAtBeginning(data); return; }
        Node newNode = new Node(data), current = head;
        for (int i = 0; i < pos - 1 && current != null; i++) current = current.next;
        if (current == null) insertAtEnd(data);
        else {
            newNode.next = current.next; newNode.prev = current;
            if (current.next != null) current.next.prev = newNode;
            current.next = newNode;
        }
    }

    public void deleteAtPosition(int pos) {
        if (head == null || pos < 0) return;
        Node current = head;
        for (int i = 0; i < pos && current != null; i++) current = current.next;
        if (current == null) return;
        if (current.prev != null) current.prev.next = current.next; else head = current.next;
        if (current.next != null) current.next.prev = current.prev; else tail = current.prev;
    }

    public void display() { for (Node curr = head; curr != null; curr = curr.next) System.out.print(curr.data + " "); System.out.println(); }

    public static void main(String[] args) {
        DLList list = new DLList();
        Scanner sc = new Scanner(System.in);
        int choice, data, pos;
        do {
            System.out.println("1. Insert at Beginning\n2. Insert at End\n3. Insert at Position\n4. Delete at Position\n5. Check if Empty\n6. Display\n7. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            switch (choice) {
                case 1 -> { System.out.print("Enter data: "); list.insertAtBeginning(sc.nextInt()); }
                case 2 -> { System.out.print("Enter data: "); list.insertAtEnd(sc.nextInt()); }
                case 3 -> { System.out.print("Enter data: "); data = sc.nextInt(); System.out.print("Enter position: "); list.insertAtPosition(data, sc.nextInt()); }
                case 4 -> { System.out.print("Enter position: "); list.deleteAtPosition(sc.nextInt()); }
                case 5 -> System.out.println("List is " + (list.head == null ? "empty" : "not empty"));
                case 6 -> list.display();
                case 7 -> System.out.println("Exiting...");
                default -> System.out.println("Invalid choice.");
            }
        } while (choice != 7);
        sc.close();
    }
}
