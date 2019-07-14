package DLL;

public class DLL<E> {
    private Node<E> head;
    private Node<E> tail;
    private int length = 0;

    public void linkHead(E item) {
        length++;
        this.head = new Node(null, item, this.head);
    }

    public void linkTail(E item) {
        length++;
        this.tail = new Node (this.tail, item, null);
    }

    public E unlinkHead() {
        length = (length == 0) ? 0 : length--;
        E result = this.head.item;
        this.head = this.head.next;
        return result;
    }

    public E unlinkTail() {
        length = (length == 0) ? 0 : length--;
        E result = this.tail.item;
        this.tail = this.tail.prev;
        return result;
    }

    private static class Node<E> {
        E item;
        Node<E> prev;
        Node<E> next;

        Node(Node<E> prev, E item, Node<E> next) {
            this.item = item;
            this.prev = prev;
            this.next = next;
        }
    }
}
