public class SinglyLinkedList implements ISinglyLinkedList {
    class Node {
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
    public void addNode(int data) {

        Node newNode = new Node(data);
        if (this.head == null) {
            this.head = newNode;
            this.tail = newNode;
        } else {
            this.tail.next = newNode;
            this.tail = newNode;
        }
    }

    @Override
    public void display() {

        Node current = this.head;
        if (this.head == null) {
            System.out.println("The list is empty!");
            return;
        }
        while (current != null) {
            System.out.println(current.data + " ");
            current = current.next;
        }
    }

    @Override
    public int countNodes() {
        int counter = 0;
        Node current = this.head;
        while (current != null) {
            counter++;
            current = current.next;
        }
        return counter;
    }

    @Override
    public void printReversedList(Node current) {
        if (this.head == null) {
            System.out.println("The list is empty!");
            return;
        } else {
            if (current.next == null) {
                System.out.println(current.data + " ");
                return;
            }
            printReversedList(current.next);
            System.out.println(current.data + " ");
        }
    }

    @Override
    public void deleteFromStart() {
        if (this.head == null) {
            System.out.println("The list is empty!");
            return;
        }
        if (this.head != this.tail) {
            this.head = this.head.next;
        } else {
            this.head = this.tail = null;
        }
    }

    @Override
    public void deleteFromMiddle() {
        Node temp;
        Node current;
        if (this.head == null) {
            System.out.println("The list is empty!");
            return;
        } else {
            int middle = this.countNodes() / 2;
            if (this.head != this.tail) {
                temp = this.head;
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
                    temp = null;
                }
            } else {
                this.head = this.tail = null;
            }
        }
    }

    @Override
    public void deleteFromEnd() {
        if (this.head == null) {
            System.out.println("The list is empty!");
            return;
        }
        if (this.head == this.tail) {

            this.head = this.tail = null;
        } else {
            Node current = this.head;
            while (current.next != tail) {
                current = current.next;
            }
            this.tail = current;
            this.tail.next = null;

        }
    }

    @Override
    public int minNode() {
        if (this.tail == this.head) {
            return this.tail.data;
        } else {
            Node current = this.head;
            int minElement = this.head.data;
            while (current != null) {
                if (minElement > current.data) {
                    minElement = current.data;
                }
                current = current.next;
            }
            return minElement;
        }
    }

    public void searchNode(int data) {
        Node current = this.head;
        boolean flag = false;
        int position = 1;
        if (this.head == null) {
            System.out.println("The list is empty!");
            return;
        }
        while (current != null) {
            if (current.data == data) {
                flag = true;
                break;
            }
            position++;
            current = current.next;
        }
        if (flag) {
            System.out.println("Element is present in the list at the position : " + position);
        } else {
            System.out.println("Element is not present in the list!");
        }
    }

    @Override
    public void addAtStart(int data) {
        Node newNode = new Node(data);
        if (this.head == null) {
            this.head = newNode;
            this.tail = newNode;
        } else {
            Node temp = this.head;
            this.head = newNode;
            this.head.next = temp;
        }
    }

    @Override
    public void addAtMiddle(int data) {
        Node newNode = new Node(data);
        if (this.head == null) {
            this.head = newNode;
            this.tail = newNode;
        } else {
            Node temp;
            Node current;
            int middle = this.countNodes() / 2;
            temp = head;
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
    public void addAtEnd(int data) {
        Node newNode = new Node(data);
        if (this.head == null) {
            this.head = newNode;
            this.tail = newNode;
        } else {
            this.tail.next = newNode;
            this.tail = newNode;
        }
    }

    @Override
    public void removeDuplicate() {
        Node current = this.head;
        Node temp = null;
        Node index = null;
        if (this.head == null) {
            return;
        } else {
            while (current != null) {

                temp = current;
                index = current.next;

                while (index != null) {
                    if (current.data == index.data) {
                        temp.next = index.next;
                    } else {
                        temp = index;
                    }
                    index = index.next;
                }
                current = current.next;
            }
        }
    }

    @Override
    public Node reverseList(Node temp) {
        Node current = temp;
        Node previousNode = null;
        Node nextNode = null;

        while (current != null) {
            nextNode = current.next;
            current.next = previousNode;
            previousNode = current;
            current = nextNode;
        }
        return previousNode;
    }

    public void isPalindrome() {
        Node current = this.head;
        boolean flag = true;
        int middle = this.countNodes() / 2;

        for (int i = 1; i < middle; i++) {
            current = current.next;
        }

        Node revHead = reverseList(current.next);

        while (this.head != null && revHead != null) {
            if (this.head.data != revHead.data) {
                flag = false;
                break;
            }
            this.head = this.head.next;
            revHead = revHead.next;
        }

        if (flag)
            System.out.println("It is palindrome!");
        else
            System.out.println("It is not a palindrome");
    }

    public static void main(String[] args) {

        SinglyLinkedList list = new SinglyLinkedList();
        list.addNode(1);
        list.addNode(2);
        list.addNode(3);
        list.addNode(4);
        System.out.println("Count of nodes present in the list: " + list.countNodes());
        list.deleteFromMiddle();
        System.out.println("Count of nodes present in the list: " + list.countNodes());
    }
}
