package dynamiccontainer;

import dynamiccontainer.exceptions.LinkedListException;

public class Main {
    public static void main(String[] args) {

        LinkedList list = new LinkedList();
        LinkedList listTest = new LinkedList();
        for (int i = 0; i < 6; i++) {
            int j = i % 2;
            int[] arrayTest = new int[6];
            arrayTest[i] = i;
            listTest.add("string test " + i);
            //listTest.add(arrayTest);
            //listTest.add(j);
        }

        for (int i = 5; i >= 0; i--) {
            int j = i % 2;
            int[] arrayTest = new int[6];
            arrayTest[i] = i;
            list.add("string test " + i); // string
            list.add(arrayTest); // array
            list.add(j); // int
            list.add(listTest); // another linked list
            try {
                list.add(listTest.get(0)); // add 1st value from node from another list
            } catch (LinkedListException e) {
                System.out.println(e.getMessage());
            }
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
            //Object test = list.get(1);
            list.add(1);
            list.add(1);
            Object test = listTest.get(3);

            System.out.println("index has value: " + test);
        } catch (LinkedListException e) {
            System.out.println(e.getMessage());
        }


        try {
            listTest.printListRecursive();
        } catch (LinkedListException e) {
            System.out.println(e.getMessage());
        }


        System.out.println("list last index is: " + listTest.length());

        try {
            listTest.headPop();
            listTest.pop();
        } catch (LinkedListException e) {
            System.out.println(e.getMessage());
        }

        try {
            listTest.printListRecursive();
        } catch (LinkedListException e) {
            System.out.println(e.getMessage());
        }


        System.out.println("list last index is: " + listTest.length());
    }
}
