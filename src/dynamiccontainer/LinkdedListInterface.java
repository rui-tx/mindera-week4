package dynamiccontainer;

import dynamiccontainer.exceptions.LinkedListException;

public interface LinkdedListInterface {

    void add(int data) ;
    void remove(int data) throws LinkedListException;
    void printNode(int data) throws LinkedListException;;
    void printList() throws LinkedListException;;
}
