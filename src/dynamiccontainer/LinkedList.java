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

    public void removeRecursive(int data) {
        if(this.firstNode == null) {
            System.out.println("No nodes created.");
            return;
        }
        // need to check first
        // if
        // then others
        this.removeRecursiveAux(data, this.firstNode);
    }

    private void removeRecursiveAux(int data, Node node) {
        if (node.getNextNode() == null) {
            System.out.println("No values found.");
            return;
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

    public void headPop() {
        if(this.firstNode == null) {
            System.out.println("No nodes created.");
            return;
        }

        this.firstNode = this.firstNode.getNextNode();
    }

    public void pop() {
        if(this.firstNode == null) {
            System.out.println("No nodes created.");
            return;
        }
        if (this.firstNode.getNextNode() == null) {
            System.out.println("Cant delete 1st node for now.");
            return;
        }

        this.popAux(this.firstNode);
    }

    private void popAux(Node node) {
        if (node.getNextNode().getNextNode() == null) {
            node.setNextNode(null);
            return;
        }

        this.popAux(node.getNextNode());
    }

    public void removeNodeWithIndexRecursive(int index) {
        if(this.firstNode == null) {
            System.out.println("No nodes created.");
            return;
        }

        int currentIndex = 0;
        this.removeNodeWithIndexAux(index, this.firstNode, currentIndex);
    }

    private void removeNodeWithIndexAux(int index, Node node, int currentIndex) {
        if (node.getNextNode() == null) {
            System.out.println("No values found.");
            return;
        }

        if (index - 1 == currentIndex) {
            if(node.getNextNode() != null) {
                Node temp = node.getNextNode().getNextNode();
                node.setNextNode(temp);

                return;
            }
            System.out.println("Out of bounds");
            return;
        }

        this.removeNodeWithIndexAux(index, node.getNextNode(), currentIndex + 1);
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

    public void printNodeRecursive(int data) {
        if(this.firstNode == null) {
            System.out.println("No nodes created.");
            return;
        }

        this.printNodeRecursiveAux(data, this.firstNode);
    }

    private void printNodeRecursiveAux(int data, Node node) {
        if (node.getValue() == data) {
            System.out.println("Found value: " + node.getValue());
            return;
        }

        if (node.getNextNode() == null) {
            System.out.println("No values found.");
            return;
        }

        this.printNodeRecursiveAux(data, node.getNextNode());
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

    public void printListRecursive() {
        if(this.firstNode == null) {
            System.out.println("No nodes created.");
            return;
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

    public void getFirstIndexOf(int data) {
        if(this.firstNode == null) {
            System.out.println("No nodes created.");
            return;
        }
        int index = 0;
        this.getFirstIndexOfAux(data, this.firstNode, index);
    }

    private void getFirstIndexOfAux(int data, Node node, int index) {
        if (node.getValue() == data) {
            System.out.println("Found value at index: " + index);
            return;
        }

        if (node.getNextNode() == null) {
            System.out.println("No node found.");
            return;
        }

        this.getFirstIndexOfAux(data, node.getNextNode(), index+1);
    }

    public void getLastNodeRecursive() {
        if(this.firstNode == null) {
            System.out.println("No nodes created.");
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
}