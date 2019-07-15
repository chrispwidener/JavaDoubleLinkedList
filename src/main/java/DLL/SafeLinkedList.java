package DLL;

import com.google.common.annotations.VisibleForTesting;

import java.util.Optional;

public class SafeLinkedList<E> {
    private Optional<Node<E>> first = Optional.empty();
    private Optional<Node<E>> last  = Optional.empty();
    private int length = 0;

    public void linkHead(E item) {
        length++;
        final Optional<Node<E>> oldFirst = first;
        final Optional<Node<E>> newFirst = Optional.of(new Node(Optional.empty(), item, oldFirst));
        first = newFirst;

        if (oldFirst.isEmpty()) {
            last = newFirst;
        } else {
            oldFirst.get().prev = newFirst;
        }
    }

    public void linkTail(E item) {
        length++;
        final Optional<Node<E>> oldLast = last;
        final Optional<Node<E>> newLast = Optional.of(new Node(oldLast, item, Optional.empty()));
        this.last = newLast;

        if (oldLast.isEmpty()) {
            first = newLast;
        } else {
            oldLast.get().next = newLast;
        }
    }

    public Optional<E> unlinkHead() {
        if (length == 0) {
            return Optional.empty();
        } else if (length == 1){
            E result = first.get().item;
            first = Optional.empty();
            last = Optional.empty();
            length--;
            return Optional.of(result);
        } else {
            E result = first.get().item;
            first = first.get().next;
            first.get().prev = Optional.empty();
            length--;
            return Optional.of(result);
        }
    }

    public Optional<E> unlinkTail() {
        if (length == 0) {
            return Optional.empty();
        } else if (length ==1) {
            E result = last.get().item;
            first = Optional.empty();
            last  = Optional.empty();
            length--;
            return Optional.of(result);
        } else {
            E result = last.get().item;
            last = last.get().prev;
            last.get().next = Optional.empty();
            length--;
            return Optional.of(result);
        }
    }

    public int getLength() {
        return length;
    }

    // Need to return defensive copy, maybe just the item
    public Optional<Node<E>> peekFirst() {
        return first;
    }

    public Optional<Node<E>> peekLast() {
        return last;
    }

    @VisibleForTesting // Otherwise private
    static class Node<E> {
        final E item;
        Optional<Node<E>> prev;
        Optional<Node<E>> next;

        Node( Optional<Node<E>> prev,
              E item,
              Optional<Node<E>> next) {
            this.item = item;
            this.prev = prev;
            this.next = next;
        }
    }
}
