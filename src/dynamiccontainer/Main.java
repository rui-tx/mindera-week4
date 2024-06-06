package dynamiccontainer;

import dynamiccontainer.exceptions.LinkedListException;

public class Main {
    public static void main(String[] args) {

        LinkedList list = new LinkedList();
        ArrayList<Integer> arrayList = new ArrayList<>();

        for (int i = 4; i >= 0; i--) {
            arrayList.add(i);
            //System.out.println("array size = " + arrayList.getLength());
        }

        //arrayList.remove(4);
        System.out.println("first index of 1: " + arrayList.getIndexOf(1));
        arrayList.add(1);
        arrayList.add(1);
        System.out.println("last index of 1: " + arrayList.getLastIndexOf(1));
        //arrayList.remove(2);

        arrayList.printList();
    }
}
