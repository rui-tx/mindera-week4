package dynamiccontainer;

import dynamiccontainer.exceptions.LinkedListException;

import java.util.Iterator;

public class Main {
    public static void main(String[] args) {

        ArrayList<Integer> arrayList = new ArrayList<>();
        LinkedList<Integer> linkedList = new LinkedList<>();
        //Iterator<Integer> iterator = arrayList.iterator();
        for (int i = 0; i < 3; i++) {
            arrayList.add(i);
            linkedList.add(i);
        }

        Iterator<Integer> iterator = linkedList.iterator();
        System.out.println(iterator.hasNext());
        System.out.println(iterator.next());
        System.out.println(iterator.hasNext());
        System.out.println(iterator.next());
        System.out.println(iterator.hasNext());
        System.out.println(iterator.next());
        System.out.println(iterator.hasNext());
        System.out.println(iterator.next());

        System.out.println();
        iterator = linkedList.iterator();
        System.out.println(iterator.hasNext());
        System.out.println(iterator.next());
        System.out.println(iterator.hasNext());
        System.out.println(iterator.next());
        System.out.println(iterator.hasNext());
        System.out.println(iterator.next());
        System.out.println(iterator.hasNext());
        System.out.println(iterator.next());

        //arrayList.printList();
    }
}
