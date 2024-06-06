package dynamiccontainer;

import dynamiccontainer.exceptions.LinkedListException;

public class Main {
    public static void main(String[] args) {

        LinkedList list = new LinkedList();
        ArrayList arrayList = new ArrayList();

        for (int i = 15; i >= 0; i--) {
            arrayList.add(i);
            //System.out.println("array size = " + arrayList.getLength());
        }

        try {
            arrayList.remove(4);
            arrayList.remove(5);
            arrayList.remove(7);
            arrayList.remove(8);
            arrayList.remove(9);
            arrayList.remove(0);
            arrayList.remove(1);
            //arrayList.remove(2);
        } catch (LinkedListException e) {
            System.out.println(e.getMessage());
        }

        arrayList.printList();
    }
}
