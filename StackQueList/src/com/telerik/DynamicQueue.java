package com.telerik;

public class DynamicQueue {
    private Node head, tail;

    public DynamicQueue() {
        head = tail = null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void enQueue(int element) {
        Node newElement = new Node(element);
        if (isEmpty()) {
            head = tail = newElement;

        } else {
            tail.next = newElement;
            tail = newElement;
        }
    }

    public int deQueue() throws Exception {
        if (isEmpty()) {
            throw new Exception("queue is empty");
        }
        int value = head.value;
        head = head.next;

        if (head == null) {
            tail = null;
        }
        return value;
    }

    public int peek() throws Exception {
        if (isEmpty()) {
            throw new Exception("queue is empty");
        }
        return head.value;
    }
}
