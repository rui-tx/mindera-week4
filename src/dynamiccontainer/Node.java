package dynamiccontainer;

public class Node{

    private int value;
    private Node nextNode;

    public Node(int value) {
        this.value = value;
        this.nextNode = null;
    }

    public Node(int value, Node nextNode) {
        this.value = value;
        this.nextNode = nextNode;
    }

    public int getValue() {
        return value;
    }

    public Node getNextNode() {
        return nextNode;
    }

    public void setNextNode(Node nextNode) {
        this.nextNode = nextNode;
    }

}
