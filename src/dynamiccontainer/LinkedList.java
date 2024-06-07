package dynamiccontainer;

import dynamiccontainer.exceptions.LinkedListException;
import dynamiccontainer.exceptions.NoNodeFoundException;
import dynamiccontainer.exceptions.NoNodesCreatedException;
import dynamiccontainer.exceptions.NodeOutOfBoundsException;

import java.util.Iterator;

public class LinkedList<T> implements List<T> {

    private Node firstNode;
    private Node lastNode;
    private int currentIndex;

    private void incrementIndex() {
        this.currentIndex++;
    }

    private void decreaseIndex() {
        this.currentIndex--;
    }

    public int length() {
        return currentIndex;
    }

    public T get(int index) throws LinkedListException {
        if (this.firstNode == null) {
            throw new NoNodesCreatedException();
        }

        if (index < 0 || index > this.currentIndex) {
            throw new NodeOutOfBoundsException();
        }

        int currentIndex = 0;
        return getAux(index, this.firstNode, currentIndex);
    }

    private T getAux(int index, Node node, int currentIndex) throws LinkedListException {

        return index == currentIndex || node.getNextNode() == null ?
                node.getValue() : getAux(index, node.getNextNode(), currentIndex + 1);

       /*
        if (index == currentIndex || node.getNextNode() == null) {
            return node.getValue();
        }

        return getAux(index, node.getNextNode(), currentIndex + 1);

        */
    }

    public T get2(int index) throws LinkedListException {
        if (this.firstNode == null) {
            throw new NoNodesCreatedException();
        }

        if (index < 0 || index > this.currentIndex) {
            throw new NodeOutOfBoundsException();
        }

        int currentIndex = 0;
        Node currentNode = this.firstNode;
        while (index != currentIndex) {
            if (currentNode.getNextNode() == null) { // last item
                break;
            }

            currentNode = currentNode.getNextNode();
            currentIndex++;
        }

        return currentNode.getValue();
    }

    @Override
    public void add(T object) {
        Node newNode = new Node(object);

        if (this.firstNode == null) {
            this.firstNode = newNode;
        } else {
            this.lastNode.setNextNode(newNode);
        }

        this.incrementIndex();
        this.lastNode = newNode;
    }

    @Override
    public void remove(T object) throws LinkedListException {
        if (this.firstNode == null) {
            throw new NoNodesCreatedException();
        }

        Node currentNode = this.firstNode;
        while (true) {
            if (currentNode.getNextNode() == null) {
                throw new NoNodeFoundException();
            }

            if (currentNode.getNextNode().getValue().equals(object)) {
                if (currentNode.getNextNode().getNextNode() != null) {
                    currentNode.setNextNode(currentNode.getNextNode().getNextNode());
                } else {
                    currentNode.setNextNode(null); // redundant?
                }
                this.decreaseIndex();
                break;
            }

            currentNode = currentNode.getNextNode();
        }
    }

    public void removeRecursive(T object) throws LinkedListException {
        if (this.firstNode == null) {
            throw new NoNodesCreatedException();
        }
        // need to check first
        // if
        // then others
        this.removeRecursiveAux(object, this.firstNode);
    }

    private void removeRecursiveAux(T object, Node node) throws LinkedListException {
        if (node.getNextNode() == null) {
            throw new NoNodeFoundException();
        }

        if (node.getNextNode().getValue().equals(object)) {
            if (node.getNextNode().getNextNode() != null) {
                node.setNextNode(node.getNextNode().getNextNode());
            } else {
                node.setNextNode(null);
            }
            return;
        }

        this.removeRecursiveAux(object, node.getNextNode());
    }

    public void headPop() throws LinkedListException {
        if (this.firstNode == null) {
            throw new NoNodesCreatedException();
        }

        this.firstNode = this.firstNode.getNextNode();
        this.decreaseIndex();

    }

    public void pop() throws LinkedListException {
        if (this.firstNode == null) {
            throw new NoNodesCreatedException();
        }

        if (this.firstNode.getNextNode() == null) {
            System.out.println("Cant delete 1st node for now.");
            return;
        }

        this.popAux(this.firstNode);

    }

    private void popAux(Node node) {
        if (node.getNextNode() == this.lastNode) {
            node.setNextNode(null);
            this.lastNode = node;
            this.decreaseIndex();
            return;
        }

        this.popAux(node.getNextNode());
    }

    public void removeNodeWithIndexRecursive(int index) throws LinkedListException {
        if (this.firstNode == null) {
            throw new NoNodesCreatedException();
        }

        int currentIndex = 0;
        this.removeNodeWithIndexAux(index, this.firstNode, currentIndex);
    }

    private void removeNodeWithIndexAux(int index, Node node, int currentIndex) throws LinkedListException {
        if (node.getNextNode() == null) {
            throw new NoNodeFoundException();
        }

        if (index - 1 == currentIndex) {
            if (node.getNextNode() != null) {
                Node temp = node.getNextNode().getNextNode();
                node.setNextNode(temp);
                return;
            }

            throw new NodeOutOfBoundsException();
        }

        this.removeNodeWithIndexAux(index, node.getNextNode(), currentIndex + 1);
    }

    @Override
    public void printNode(T object) throws LinkedListException {
        if (this.firstNode == null) {
            throw new NoNodesCreatedException();
        }

        Node currentNode = this.firstNode;
        while (currentNode != null) {
            if (currentNode.getValue().equals(object)) {
                System.out.println("Found: " + currentNode.getValue());
                return;
            }

            currentNode = currentNode.getNextNode();
        }

        throw new NoNodeFoundException();
    }

    public void printNodeRecursive(T object) throws LinkedListException {
        if (this.firstNode == null) {
            throw new NoNodesCreatedException();
        }

        this.printNodeRecursiveAux(object, this.firstNode);
    }

    private void printNodeRecursiveAux(T object, Node node) throws LinkedListException {
        if (node.getValue().equals(object)) {
            System.out.println("Found value: " + node.getValue());
            return;
        }

        if (node.getNextNode() == null) {
            throw new NoNodeFoundException();
        }

        this.printNodeRecursiveAux(object, node.getNextNode());
    }

    @Override
    public void printList() throws LinkedListException {
        if (this.firstNode == null) {
            throw new NoNodesCreatedException();
        }

        Node currentNode = this.firstNode;
        while (currentNode != null) {
            System.out.println(currentNode.getValue());
            currentNode = currentNode.getNextNode();
        }
    }

    public void printListRecursive() throws LinkedListException {
        if (this.firstNode == null) {
            throw new NoNodesCreatedException();
        }

        this.printListRecursiveAux(this.firstNode);
    }

    private void printListRecursiveAux(Node node) {
        System.out.println(node.getValue());
        if (node.getNextNode() == null) {
            return;
        }

        this.printListRecursiveAux(node.getNextNode());
    }

    public void getFirstIndexOf(T object) throws LinkedListException {
        if (this.firstNode == null) {
            throw new NoNodesCreatedException();
        }
        int index = 0;
        this.getFirstIndexOfAux(object, this.firstNode, index);
    }

    private void getFirstIndexOfAux(T object, Node node, int index) throws LinkedListException {
        if (node.getValue().equals(object)) {
            System.out.println("Found object at index: " + index);
            return;
        }

        if (node.getNextNode() == null) {
            throw new NoNodeFoundException();
        }

        this.getFirstIndexOfAux(object, node.getNextNode(), index + 1);
    }

    public void getLastNodeRecursive() {
        if (this.firstNode.getNextNode() == null) {
            System.out.println("this is last element: " + this.firstNode.getValue());
            return;
        }

        this.getLastNodeRecursiveAux(this.firstNode);
    }

    private void getLastNodeRecursiveAux(Node node) {
        if (node.getNextNode() == null) {
            System.out.println("this is last element: " + node.getValue());
            return;
        }

        this.getLastNodeRecursiveAux(node.getNextNode());
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {

            private Node headNode = null;

            @Override
            public boolean hasNext() {
                if (headNode == null && firstNode != null) {
                    return true;
                }

                return headNode.getNextNode() != null;
                //return headNode.getNextNode() != null;
            }

            @Override
            public T next() {
                if (headNode == null && firstNode != null) {
                    headNode = firstNode;
                } else {
                    if (headNode == null || headNode.getNextNode() == null) {
                        return null;
                    }
                    headNode = headNode.getNextNode();
                }
                return headNode.getValue();
            }
        };
    }


    /*
    public void sort() throws LinkedListException{
        if(this.firstNode == null) {
            throw new NoNodesCreatedException();
        }

        sortAux(firstNode, true);
    }

    private void sortAux(Node node, boolean noSwaps) {
        if (node.getNextNode() == null) {
            if(noSwaps) {
                return;
            }

            noSwaps = true;
            node = this.firstNode;
            sortAux(this.firstNode.getNextNode(), noSwaps);
        }

        if(node.getValue() > node.getNextNode().getValue()) {
            noSwaps = false;
            int temp = node.getValue();
            node.setValue(node.getNextNode().getValue());
            node.getNextNode().setValue(temp);

            sortAux(node.getNextNode(), noSwaps);
        }

        if (!noSwaps && node.getNextNode().getNextNode() == null) {
            noSwaps = true;
            node = this.firstNode;
            sortAux(node.getNextNode(), noSwaps);
        }

        sortAux(node.getNextNode(), noSwaps);
    }

     */

    private class Node {

        private T object;
        private Node nextNode;

        public Node(T object) {
            this.object = object;
            this.nextNode = null;
        }

        public T getValue() {
            return object;
        }

        public void setValue(T object) {
            this.object = object;
        }

        public Node getNextNode() {
            return nextNode;
        }

        public void setNextNode(Node nextNode) {
            this.nextNode = nextNode;
        }

    }
}