package dynamiccontainer;

public class Main {
    public static void main(String[] args) {

        LinkdedListInterface list = new LinkedList();

        for (int i = 0; i < 20; i++) {
            list.add(i);
        }

        for (int i = 0; i < 20; i++) {
            if (i % 2 == 0) {
                list.remove(i);
            }
        }

        for (int i = 0; i < 20; i++) {
            list.printNode(i);
        }

        list.printList();
    }
}
