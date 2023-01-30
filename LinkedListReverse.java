/**
 * linked_list_reverse
 */
public class linked_list_reverse {
    public static void main(String[] args) {
        linkedList lList = new linkedList();
        lList.print();
        lList.reverse();
        lList.printReverse();
    }
}

/**
 * Односвязный список
 */
class Node {
    Node next;
    Integer payLoad;

    public Node(Integer value) {
        payLoad = value;
    }
}

/**
 * linkedList
 */
class linkedList {
    private Node n1 = new Node(12);
    private Node n2 = new Node(16);
    private Node n3 = new Node(20);
    private Node n4 = new Node(21);
    private Node n5 = new Node(22);
    private Node n6 = new Node(23);

    public linkedList() {
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
    }

    public void print() {
        Node node = this.n1;
        System.out.print(node.payLoad + " ");
        do {
            node = node.next;
            System.out.print(node.payLoad + " ");
        } while (node.next != null);
    }

    public void printReverse() {
        Node node = this.n6;
        System.out.print(node.payLoad + " ");
        do {
            node = node.next;
            System.out.print(node.payLoad + " ");
        } while (node.next != null);
    }

    public void reverse() {
        Node node = n1;
        int count = 0;
        do {
            count++;
            node = node.next;
        } while (node.next != null);

        node = n1;
        Node t1 = node;
        Node t2 = node.next;
        node.next = null;
        System.out.println();
        for (int i = 0; i < count; i++) {
            {
                node = t2;
                t2 = node.next;
                node.next = t1;
                t1 = node;
            }

        }
    }
}
