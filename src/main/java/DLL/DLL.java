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
        length = (length == 0) ? 0 : length--;
        E result = this.head.item;
        this.head = this.head.next;
        return result;
    }

    @Nullable
    public E unlinkTail() {
        length = (length == 0) ? 0 : length--;
        E result = this.tail.item;
        this.tail = this.tail.prev;
        return result;
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
