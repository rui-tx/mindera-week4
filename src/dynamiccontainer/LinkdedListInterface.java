package dynamiccontainer;

import dynamiccontainer.exceptions.LinkedListException;

public interface LinkdedListInterface {

    void add(Object object) ;
    void remove(Object object) throws LinkedListException;
    void printNode(Object object) throws LinkedListException;;
    void printList() throws LinkedListException;;
}
