package dynamiccontainer;

import dynamiccontainer.exceptions.LinkedListException;

public class Main {
    public static void main(String[] args) {

        LinkedList list = new LinkedList();

        for (int i = 9; i >= 0; i--) {
            int j = i % 2;
            list.add(i + j);
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
            list.printListRecursive();
        } catch (LinkedListException e) {
            System.out.println(e.getMessage());
        }

        list.add(50);
        list.add(23);
        list.add(99);
        list.add(-2);
        list.add(0);
        list.add(155);
        list.add(3);
        list.add(-1000);

        try {
            list.remove(-99);
        } catch (LinkedListException e) {
            System.out.println(e.getMessage());
        }

        try {
            list.sort();
        } catch (LinkedListException e) {
            System.out.println(e.getMessage());

        }
        System.out.println();

        try {
            list.printListRecursive();
        } catch (LinkedListException e) {
            System.out.println(e.getMessage());
        }
    }
}
