public interface ISinglyLinkedList {

    public void addNode(int data);

    public void display();

    public int countNodes();

    public void printReversedList(SinglyLinkedList.Node current);

    public void deleteFromStart();

    public void deleteFromMiddle();

    public void deleteFromEnd();

    public SinglyLinkedList.Node reverseList(SinglyLinkedList.Node temp);

    public void isPalindrome();

    public int minNode();

    public void searchNode(int data);

    public void addAtStart(int data);

    public void addAtMiddle(int data);

    public void addAtEnd(int data);

    public void removeDuplicate();
}