package dynamiccontainer;

public class Main {
    public static void main(String[] args) {

        LinkedList list = new LinkedList();

        for (int i = 0; i < 10; i++) {
            list.add(i);
        }

        list.printList();
        list.printListRecursive();
        list.getFirstIndexOf(1);
        list.printNode(2);
        list.printNodeRecursive(2);
        list.headPop();
        list.pop();
        list.remove(4);
        list.removeRecursive(1);
        list.removeNodeWithIndexRecursive(3);
        list.getLastNodeRecursive();

        System.out.println();

        list.printListRecursive();
    }
}
