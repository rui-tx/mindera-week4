package dynamiccontainer;

public class Main {
    public static void main(String[] args) {

        LinkdedListInterface list = new LinkedList();

        for (int i = 0; i < 100; i++) {
            list.add(i);
        }

        for (int i = 0; i < 50; i++) {
            if (i % 2 == 0) {
                list.remove(i);
            }
        }

        for (int i = 0; i < 100; i++) {
            list.printNode(i);
        }

        for (int i = 0; i < 200; i++) {
            list.remove(i);
        }

        list.printList();
    }
}
