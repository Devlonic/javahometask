package collections.generic;

import jdk.jshell.spi.ExecutionControl;

public class MyList<T> implements List<T> {
    static class ListNode<T> {
        private T value;
        private ListNode<T> prevNode;
        private ListNode<T> nextNode;

        public ListNode(T value) {
            this.value = value;
            this.nextNode = null;
            this.prevNode = null;
        }
    }

    private ListNode<T> firstNode = null;

    public int getCountElements() {
        return countElements;
    }

    private int countElements = 0;

    @Override
    public void add(T item) {
        var newNode = new ListNode(item);

        if(firstNode == null) {
            this.firstNode = newNode;
        } else {
            ListNode<T> lastNode = this.firstNode;

            while (lastNode.nextNode != null)
                lastNode = lastNode.nextNode;

            lastNode.nextNode = newNode;
            newNode.prevNode = lastNode;
        }

        countElements++;
    }

    @Override
    public T elementAt(int index) throws IndexOutOfBoundsException {
        ListNode<T> node = firstNode;
        for (int i = 0; node != null && i < index; i++) {
            node = node.nextNode;
        }

        if(node == null)
            throw new IndexOutOfBoundsException();

        return node.value;
    }

    @Override
    public void delete(T item) throws Exception {
        ListNode<T> node = this.firstNode;

        while(node.nextNode != null && node.value != item) {
            node = node.nextNode;
        }

        if(node.nextNode == null && node.value == item) { // delete last element
            node.prevNode.nextNode = null;
        } else if(node.nextNode != null && node.prevNode != null) { // delete between element
            node.prevNode.nextNode = node.nextNode;
            node.nextNode.prevNode = node.prevNode;
        } else if(node.prevNode == null) { // delete first element
            this.firstNode = node.nextNode;
        } else
            throw new Exception("Element not found");

        countElements--;
    }

    @Override
    public boolean tryDelete(T item) throws ExecutionControl.NotImplementedException {
        throw new ExecutionControl.NotImplementedException("MyList.Exist not implemented");
    }

    @Override
    public boolean exist(T item) {
        ListNode<T> node = this.firstNode;
        boolean isFound = false;
        while(node != null && node.nextNode != null) {
            if(node.value == item) {
                isFound = true;
                break;
            }
            node = node.nextNode;
        }
        return isFound;
    }
}
