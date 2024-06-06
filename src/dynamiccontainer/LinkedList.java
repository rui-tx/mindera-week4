package dynamiccontainer;

import dynamiccontainer.exceptions.LinkedListException;
import dynamiccontainer.exceptions.NoNodeFoundException;
import dynamiccontainer.exceptions.NoNodesCreatedException;
import dynamiccontainer.exceptions.NodeOutOfBoundsException;

public class LinkedList implements LinkdedListInterface {

    private Node firstNode;
    private Node lastNode;
    private int currentIndex;

    private void incrementIndex() {
        this.currentIndex++;
    }

    private void decreaseIndex() {
        this.currentIndex--;
    }

    public int getCurrentIndex() {
        return currentIndex;
    }

    public int get(int index) throws LinkedListException {
        if(this.firstNode == null) {
            throw new NoNodesCreatedException();
        }

        if (index > this.currentIndex) {
            throw new NodeOutOfBoundsException();
        }

        int currentIndex = 0;
        return getAux(index, this.firstNode, currentIndex);
    }

    private int getAux(int index, Node node, int currentIndex) throws LinkedListException{
        if (index == currentIndex) {
            return node.value;
        }

        if (node.getNextNode() == null) {
            throw new NoNodeFoundException();
        }

        return getAux(index, node.getNextNode(), currentIndex + 1);
    }

    @Override
    public void add(int data) {
        Node newNode = new Node(data);
        this.incrementIndex();

        if (this.firstNode == null) {
            this.firstNode = newNode;
        } else {
            this.lastNode.setNextNode(newNode);
        }

        this.lastNode = newNode;
    }

    @Override
    public void remove(int data) throws LinkedListException {
        if(this.firstNode == null) {
            throw new NoNodesCreatedException();
        }

        Node currentNode = this.firstNode;
        while(true) {
            if(currentNode.getNextNode() == null) {
                throw new NoNodeFoundException();
            }

            if(currentNode.getNextNode().getValue() == data) {
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

    public void removeRecursive(int data) throws LinkedListException {
        if(this.firstNode == null) {
            throw new NoNodesCreatedException();
        }
        // need to check first
        // if
        // then others
        this.removeRecursiveAux(data, this.firstNode);
    }

    private void removeRecursiveAux(int data, Node node) throws LinkedListException {
        if (node.getNextNode() == null) {
            throw new NoNodeFoundException();
        }

        if (node.getNextNode().getValue() == data) {
            if (node.getNextNode().getNextNode() != null) {
                node.setNextNode(node.getNextNode().getNextNode());
            } else {
                node.setNextNode(null);
            }
            return;
        }

        this.removeRecursiveAux(data, node.getNextNode());
    }

    public void headPop() throws LinkedListException {
        if(this.firstNode == null) {
            throw new NoNodesCreatedException();
        }

        this.firstNode = this.firstNode.getNextNode();
    }

    public void pop() throws LinkedListException{
        if(this.firstNode == null) {
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
            return;
        }

        this.popAux(node.getNextNode());
    }

    public void removeNodeWithIndexRecursive(int index) throws LinkedListException{
        if(this.firstNode == null) {
            throw new NoNodesCreatedException();
        }

        int currentIndex = 0;
        this.removeNodeWithIndexAux(index, this.firstNode, currentIndex);
    }

    private void removeNodeWithIndexAux(int index, Node node, int currentIndex) throws LinkedListException{
        if (node.getNextNode() == null) {
            throw new NoNodeFoundException();
        }

        if (index - 1 == currentIndex) {
            if(node.getNextNode() != null) {
                Node temp = node.getNextNode().getNextNode();
                node.setNextNode(temp);
                return;
            }

            throw new NodeOutOfBoundsException();
        }

        this.removeNodeWithIndexAux(index, node.getNextNode(), currentIndex + 1);
    }

    @Override
    public void printNode(int data) throws LinkedListException {
        if(this.firstNode == null) {
            throw new NoNodesCreatedException();
        }

        Node currentNode = this.firstNode;
        while (currentNode != null) {
            if (currentNode.getValue() == data) {
                System.out.println("Found: " + currentNode.getValue());
                return;
            }

            currentNode = currentNode.getNextNode();
        }

        throw new NoNodeFoundException();
    }

    public void printNodeRecursive(int data) throws LinkedListException{
        if(this.firstNode == null) {
            throw new NoNodesCreatedException();
        }

        this.printNodeRecursiveAux(data, this.firstNode);
    }

    private void printNodeRecursiveAux(int data, Node node) throws LinkedListException {
        if (node.getValue() == data) {
            System.out.println("Found value: " + node.getValue());
            return;
        }

        if (node.getNextNode() == null) {
            throw new NoNodeFoundException();
        }

        this.printNodeRecursiveAux(data, node.getNextNode());
    }

    @Override
    public void printList() throws LinkedListException{
        if(this.firstNode == null) {
            throw new NoNodesCreatedException();
        }

        Node currentNode = this.firstNode;
        while (currentNode != null) {
            System.out.println(currentNode.getValue());
            currentNode = currentNode.getNextNode();
        }
    }

    public void printListRecursive() throws LinkedListException{
        if(this.firstNode == null) {
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

    public void getFirstIndexOf(int data) throws LinkedListException{
        if(this.firstNode == null) {
            throw new NoNodesCreatedException();
        }
        int index = 0;
        this.getFirstIndexOfAux(data, this.firstNode, index);
    }

    private void getFirstIndexOfAux(int data, Node node, int index) throws LinkedListException{
        if (node.getValue() == data) {
            System.out.println("Found value at index: " + index);
            return;
        }

        if (node.getNextNode() == null) {
            throw new NoNodeFoundException();
        }

        this.getFirstIndexOfAux(data, node.getNextNode(), index+1);
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

    private static class Node{

        private int value;
        private Node nextNode;

        public Node(int value) {
            this.value = value;
            this.nextNode = null;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public Node getNextNode() {
            return nextNode;
        }

        public void setNextNode(Node nextNode) {
            this.nextNode = nextNode;
        }

    }
}