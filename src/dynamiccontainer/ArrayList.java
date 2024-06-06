package dynamiccontainer;

import dynamiccontainer.exceptions.LinkedListException;
import dynamiccontainer.exceptions.NoNodesCreatedException;
import dynamiccontainer.exceptions.NodeOutOfBoundsException;

import java.util.Iterator;

public class ArrayList<T> implements List<T>{

    private Object[] array;
    private int currentIndex;

    public ArrayList() {
        this.array = new Object[8];
        this.currentIndex = 0;
    }

    @Override
    public void add(T object) {
        this.array[this.currentIndex++] = object;
        this.grow();
    }

    @Override
    public void remove(T object) throws LinkedListException {
        int indexToRemove = this.getIndexOf(object);
        if(indexToRemove == -1) {
            return;
        }

        for (int i = indexToRemove; i < currentIndex - 1 ; i++) {
            this.array[i] = this.array[i + 1];
        }

        this.array[currentIndex - 1] = null;
        currentIndex--;
        this.shrink();
    }

    @Override
    public void printNode(T object) throws LinkedListException {

    }

    @Override
    public void printList() {
        for (int i = 0; i < currentIndex; i++) {
            System.out.println(this.array[i]);
        }
    }

    public int getLength() {
        return this.currentIndex;
    }

    public int getIndexOf(T object) {
        for (int i = 0; i < currentIndex; i++) {
            if(this.array[i].equals(object)) {
                return i;
            }
        }

        return -1;
    }

    public int getLastIndexOf(T object) {
        for (int i = currentIndex - 1; i >= 0; i--) {
            if(this.array[i].equals(object)) {
                return i;
            }
        }

        return -1;
    }

    public T get(int index) {
        if(index < 0 || index > this.currentIndex) {
            throw new IndexOutOfBoundsException();
        }

        return (T) this.array[index];
    }

    private void grow() {
        if (this.array.length / 2 >= this.currentIndex ) {
            return;
        }

        Object[] temp = new Object[this.array.length * 2];
        for (int i = 0; i < this.currentIndex; i++) {
            temp[i] = this.array[i];
        }

        this.array = temp;
        //System.out.println("Array grew to a total length of " + this.array.length);
    }

    private void shrink() {
        // mirror of grow
        if (this.array.length / 2 <= this.currentIndex ) {
            return;
        }

        // brute
        Object[] temp = new Object[this.array.length / 2];
        for (int i = 0; i < this.currentIndex; i++) {
            temp[i] = this.array[i];
        }

        this.array = temp;
        //System.out.println("Array shrunk to a total length of " + this.array.length);
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {

            private int index = 0;

            @Override
            public boolean hasNext() {
                return (currentIndex > this.index);
            }

            @Override
            public T next() {
                return (T) array[index++];
            }
        };
    }
}
