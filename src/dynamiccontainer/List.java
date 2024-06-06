package dynamiccontainer;

import dynamiccontainer.exceptions.LinkedListException;

public interface List<T> extends Iterable<T>{

    void add(T object) ;
    void remove(T object) throws LinkedListException;
    void printNode(T object) throws LinkedListException;;
    void printList() throws LinkedListException;;
}
