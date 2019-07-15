package DLL;

import com.google.common.annotations.VisibleForTesting;

import javax.annotation.Nullable;

public class DLL<E> {
    @Nullable private Node<E> head;
    @Nullable private Node<E> tail;
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

    @Nullable
    public E unlinkHead() {
        if (length == 0) {
            return null;
        } else if (length == 1){
            E result = head.item;
            head = null;
            tail = null;
            length--;
            return result;
        } else {
            E result = head.item;
            head = head.next;
            head.prev = null;
            length--;
            return result;
        }
    }

    @Nullable
    public E unlinkTail() {
        if (length == 0) {
            return null;
        } else if (length ==1) {
            E result = tail.item;
            head = null;
            tail = null;
            length--;
            return result;
        } else {
            E result = tail.item;
            tail = tail.prev;
            tail.next = null;
            length--;
            return result;
        }
    }

    public int getLength() {
        return length;
    }

    @VisibleForTesting // Otherwise none
    @Nullable
    Node<E> peakHead() {
        if (head == null) {
            return null;
        } else {
            return head;
        }
    }

    @VisibleForTesting // Otherwise none
    @Nullable
    Node<E> peakTail() {
        if (tail == null) {
            return null;
        } else {
            return tail;
        }
    }

    @VisibleForTesting // Otherwise private
    static class Node<E> {
        final E item;
        Node<E> prev;
        Node<E> next;

        Node(Node<E> prev, E item, Node<E> next) {
            this.item = item;
            this.prev = prev;
            this.next = next;
        }
    }
}
