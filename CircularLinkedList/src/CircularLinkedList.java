public class CircularLinkedList implements ICircularLinkedList {
    public class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public Node head = null;
    public Node tail = null;

    @Override
    public void addAtEnd(int data) {
        Node newNode = new Node(data);
        if (this.head == null) {
            this.head = newNode;
            this.tail = newNode;
            newNode.next = this.head;

        } else {
            this.tail.next = newNode;
            this.tail = newNode;
            this.tail.next = this.head;
        }
    }

    @Override
    public void addAtStart(int data) {
        Node newNode = new Node(data);
        if (this.head == null) {
            this.head = newNode;
            this.tail = newNode;
            newNode.next = this.head;
        } else {
            Node temp = this.head;
            newNode.next = temp;
            this.head = newNode;
            this.tail.next = head;
        }
    }

    @Override
    public void addAtMiddle(int data) {
        Node newNode = new Node(data);
        if (this.head == null) {

            this.head = newNode;
            this.tail = newNode;
            newNode.next = this.head;
        } else {
            Node temp;
            Node current;
            int middle = this.countNodes() / 2;
            temp = this.head;
            current = null;
            for (int i = 0; i < middle; i++) {
                current = temp;
                temp = temp.next;
            }
            current.next = newNode;
            newNode.next = temp;
        }
    }

    @Override
    public void display() {
        Node current = this.head;
        if (this.head == null) {
            System.out.println("The list is empty!");
        } else {
            do {
                System.out.print(" " + current.data);
                current = current.next;
            }
            while (current != head);
        }
    }

    @Override
    public int countNodes() {
        Node current = this.head;
        int counter = 0;

        do {
            counter++;
            current = current.next;
        }
        while (current != this.head);
        return counter;
    }

    @Override
    public void reversedPrint(Node current) {
        if (current.next == this.head) {
            System.out.println(current.data + " ");
            return;
        }
        reversedPrint(current.next);
        System.out.println(current.data + " ");
    }

    @Override
    public void deleteFromEnd() {
        if (this.head == null) {
            return;
        } else {
            if (this.head != this.tail) {
                Node current = this.head;
                while (current.next != this.tail) {
                    current = current.next;
                }
                this.tail = current;
                this.tail.next = head;
            } else {
                this.tail = this.head = null;
            }
        }
    }

    @Override
    public void deleteFromStart() {
        if (this.head == null) {
            return;
        } else {
            if (this.head != this.tail) {
                this.head = this.head.next;
                tail.next = head;
            } else {
                this.head = this.tail = null;
            }
        }
    }

    @Override
    public void deleteTheMiddle() {

        Node current;
        Node temp;
        if (this.head == null) {
            return;
        } else {

            int middle = this.countNodes() / 2;
            if (this.head != this.tail) {
                temp = head;
                current = null;
                for (int i = 0; i < middle - 1; i++) {
                    current = temp;
                    temp = temp.next;
                }

                if (current != null) {
                    current.next = temp.next;
                    temp = null;
                } else {
                    this.head = this.tail = temp.next;
                    this.tail.next = this.head;
                    temp = null;
                }

            } else {
                this.head = this.tail = null;
            }
        }
    }

    @Override
    public void removeDuplicate() {
        Node current = this.head;
        Node index = null;
        Node temp = null;
        if (this.head == null) {
            System.out.println("The list is empty!");
        } else {
            do {
                temp = current;
                index = current.next;
                while (index != this.head) {
                    if (current.data == index.data) {
                        temp.next = index.next;
                    } else {
                        temp = index;
                    }
                    index = index.next;
                }
                current = current.next;
            } while (current.next != head);
        }
    }

    @Override
    public void minNode() {
        Node current = this.head;
        int min = this.head.data;
        if (this.head == null) {
            System.out.println("The list is empty");
        } else {
            do {
                if (min > current.data) {
                    min = current.data;
                }
                current = current.next;
            }
            while (current != this.head);
        }
        System.out.println("The minimum value of node is: " + min);
    }

    @Override
    public void search(int element) {
        if (this.head == null) {
            System.out.println("The list is empty!");
        } else {
            Node current = this.head;
            int position = 1;
            boolean flag = false;
            do {
                if (current.data == element) {
                    flag = true;
                    break;
                }
                current = current.next;
                position++;
            }
            while (current != this.head);
            if (flag) {
                System.out.println("The element is present at position " + position);
            } else {
                System.out.println("The element is not present ");

            }
        }
    }

    @Override
    public void sort() {
        Node current = this.head;
        Node index = null;
        int temp;
        if (this.head == null) {
            System.out.println("The list is empty");
        } else {
            do {
                index = current.next;
                while (index != this.head) {
                    if (current.data > index.data) {
                        temp = current.data;
                        current.data = index.data;
                        index.data = temp;
                    }
                    index = index.next;
                }
                current = current.next;
            } while (current.next != head);
        }
    }


    public static void main(String[] args) {
        CircularLinkedList l = new CircularLinkedList();
        l.addAtEnd(1);
        l.addAtEnd(2);
        l.addAtEnd(8);
        l.addAtEnd(4);
        l.addAtEnd(0);
        l.addAtEnd(80);
        l.display();
        System.out.println();
        l.reversedPrint(l.head);
        l.deleteFromStart();
        l.display();
        System.out.println();
        l.minNode();
        l.sort();
        System.out.println();
        l.display();
    }
}
