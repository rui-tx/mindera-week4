package dynamiccontainer;

import dynamiccontainer.exceptions.LinkedListException;

public class Main {
    public static void main(String[] args) {




        LinkedList list = new LinkedList();

        for (int i = 5; i >= 0; i--) {
            //int j = i % 2;
            list.add(i);
        }

        //list.printList();
        //list.printListRecursive();
        //list.getFirstIndexOf(1);
        //list.printNode(2);
        //list.printNodeRecursive(2);
        //list.headPop();
        //list.pop();
        //list.remove(4);
        //list.removeRecursive(1);
        //list.removeNodeWithIndexRecursive(3);
        //list.getLastNodeRecursive();

        System.out.println();

        try {
            int test = list.get(5);
            System.out.println("index has value: " + test);
        } catch (LinkedListException e) {
            System.out.println(e.getMessage());
        }

        try {
            list.printListRecursive();
        } catch (LinkedListException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("index is: " + list.getCurrentIndex());
    }
}
