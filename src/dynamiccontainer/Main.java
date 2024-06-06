package dynamiccontainer;

import dynamiccontainer.exceptions.LinkedListException;

import java.util.Iterator;

public class Main {
    public static void main(String[] args) {

        ArrayList<Integer> arrayList = new ArrayList<>();
        Iterator<Integer> iterator = arrayList.iterator();

        for (int i = 0; i < 3; i++) {
            arrayList.add(i);
        }

        System.out.println(iterator.hasNext());
        System.out.println(iterator.next());
        System.out.println(iterator.hasNext());
        System.out.println(iterator.next());
        System.out.println(iterator.hasNext());
        System.out.println(iterator.next());
        System.out.println(iterator.hasNext());
        System.out.println(iterator.next());

        System.out.println();
        iterator = arrayList.iterator();
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
