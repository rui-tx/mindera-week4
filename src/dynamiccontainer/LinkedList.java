package dynamiccontainer;

public class LinkedList implements LinkdedListInterface {

    Node firstNode;
    Node lastNode;

    @Override
    public void add(int data) {
        Node newNode = new Node(data);

        if (this.firstNode == null) {
            this.firstNode = newNode;
        } else {
            this.lastNode.setNextNode(newNode);
        }

        this.lastNode = newNode;
    }

    @Override
    public void remove(int data) {
        if(this.firstNode == null) {
            System.out.println("No nodes created.");
            return;
        }

        Node currentNode = this.firstNode;
        while(true) {
            if(currentNode == null || currentNode.getNextNode() == null) {
                break;
            }

            if(currentNode.getNextNode().getValue() == data) {
                if (currentNode.getNextNode().getNextNode() != null) {
                    currentNode.setNextNode(currentNode.getNextNode().getNextNode());
                } else {
                    currentNode.setNextNode(null); // redundant?
                }
                break;
            }

            currentNode = currentNode.getNextNode();
        }
    }

    @Override
    public void printNode(int data) {
        if(this.firstNode == null) {
            System.out.println("No nodes created.");
            return;
        }

        Node currentNode = this.firstNode;
        while (currentNode != null) {
            if (currentNode.getValue() == data) {
                System.out.println("Found: " + currentNode.getValue());
                return;
            }

            currentNode = currentNode.getNextNode();
        }
        System.out.println("No nodes found with value: " + data);
    }

    @Override
    public void printList() {
        if(this.firstNode == null) {
            System.out.println("No nodes created.");
            return;
        }

        Node currentNode = this.firstNode;
        while (currentNode != null) {
            System.out.println(currentNode.getValue());
            currentNode = currentNode.getNextNode();
        }
    }
}