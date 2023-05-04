public class Node <E extends Comparable<E>>  {

    private E element; // value of the node. We make it private to protect the value

    private Node<E> next; // points to the next node.


    public E getElement() {return element;}

    public void setElement(E element) {
        this.element = element;
    }

    public Node<E> getNext() {
        return next;
    }

    public void setNext(Node<E> next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return this.getElement().toString();
    }  // return the value of the element


}
