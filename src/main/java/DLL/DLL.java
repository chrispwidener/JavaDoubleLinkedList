package DLL;

public class DLL<E> {
    private Node<E> head;
    private Node<E> tail;
    private int length = 0;

    public void linkHead(E item) {
        length++;
        final Node<E> oldHead = head;
        final Node<E> newHead = new Node(null, item, this.head);
        head = newHead;

        if (length == 1) {
            tail = newHead;
        } else {
            oldHead.prev = newHead;
        }
    }

    public void linkTail(E item) {
        length++;
        final Node<E> oldTail = tail;
        final Node<E> newTail = new Node(oldTail, item, null);
        this.tail = newTail;

        if (length == 1) {
            head = newTail;
        } else {
            oldTail.next = newTail;
        }
    }

    public E unlinkHead() {
        if (length == 0) {
            return null;
        } else {
            length--;
            E result = this.head.item;

        }
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
