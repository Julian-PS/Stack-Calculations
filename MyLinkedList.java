public class MyLinkedList <E extends Comparable<E>> {

    Node<E> head = null;
    Node<E> tail = null;
    private int size = 0;  //starting size of a new list is 0 (empty), head and tail are null


    /**
     * Add element to head of list
     *
     * @param element generic, to be added to list
     */
    public void add(E element) {
        Node<E> newNode = new Node<E>();  // node to be added
        newNode.setElement(element);     // set the value of the new node
        newNode.setNext(head);           //put the new node at the beginning of the list
        head = newNode;                  // update head

        // If statement to update tail's value only once (first node added)
        if (this.size == 0) {
            tail = head;
        }
        size++;                           //increase size of the list
    }

    /**
     * Method to add a new element after the first encounter of a given value. If no match, adds it as tail
     *
     * @param element   generic, value to be added to the list
     * @param afterElem generic, the new element will be placed after this value if found
     */
    public void addAfter(E element, E afterElem) {
        Node<E> newNode = new Node<E>();
        newNode.setElement(element);
        Node<E> buffer = head;           // buffer node to maintain list integrity

        // loop to iterate through the list in search of the value given
        while (buffer != null) {

            // if statement to add new element at the end and replace tail (assuming the given value was not found)
            if (buffer == tail) {
                buffer.setNext(newNode);
                tail = newNode;
                size++;                   // update size
                return;
            }

            //if statement to compare value given with values in the list. If found, new element will be added after it
            if (buffer.getElement().equals(afterElem)) {
                newNode.setNext(buffer.getNext());  // take the present location's next and set it as the new node's next
                buffer.setNext(newNode);            // take the new node and set it as the present location's next
                size++;                             // update size
                return;                             //exit method so no other value in list is changed
            }
            buffer = buffer.getNext();
        }
    }

    /**
     * Method to remove an element from the linkedList
     *
     * @param value generic, value to be removed if found
     */
    public void remove(E value) {
        Node<E> buffer = head;

        // for case when we only have one node
        if (this.size == 1) {
            if (buffer.getElement().equals(value)) {
                head = buffer.getNext();     // set head as null since next is null
                size--;                      //update size
                return;
            }
        }
        // Loop to traverse the list, no need to check tail since the next node is null
        while (buffer != tail) {

            // if statement to remove and update head, in case the value is found there
            if (buffer == head && buffer.getElement().equals(value)) {
                head = buffer.getNext();
                size--;
                return;
            }

            // if statement to check the next element value
            if (buffer.getNext().getElement().equals(value)) {
                if (buffer.getNext() == tail) { // in case the value is found in tail, we need to update the tail before removing
                    tail = buffer;
                }
                buffer.setNext(buffer.getNext().getNext()); // to remove the next node if value is found
                size--;
                return;
            }
            buffer = buffer.getNext();
        }
        System.out.println("Value to be removed was not found in list"); // to inform user in case value not in list
    }

    /**
     * method to show the size of the list
     * @return size of list
     */
    public int size() {
        return size;
    }

    /**
     * method to check if the list contains a given value
     *
     * @param value generic, the element we want to check
     * @return boolean, true if the element is contained in the list and false otherwise
     */
    public boolean contains(E value) {

        Node<E> buffer = head; // Buffer node created to maintain list integrity

        // loop to compare the value of the node with the given value
        while (buffer != null) {
            if (buffer.getElement().equals(value)) {
                return true;
            }
            buffer = buffer.getNext();
        }
        return false;
    }

    /**
     * @return String with linked list elements, separated by an arrow
     */
    @Override
    public String toString() {

        Node<E> buffer = head; // buffer node created to maintain list integrity
        StringBuilder list = new StringBuilder(); // To create the list we are going to return

        //if statement for when list is empty, we return null to let user know it is empty
        if (buffer == null)
            return null;
        while (buffer != null) {
            if (buffer == tail) {
                list.append(buffer.getElement());               // add last element without an arrow
            } else {
                list.append(buffer.getElement() + " - ");       // add element to the String followed by an arrow
            }
            buffer = buffer.getNext();
        }
        return list.toString();           // to return the list as String
    }

    /**
     * Method to compare if two linked lists have the same values
     *
     * @param otherList, linked list to compare
     * @return boolean indicating true if same values or false otherwise
     */
    public boolean compare(MyLinkedList<E> otherList) {
        //buffer nodes to maintain list integrity in both lists
        Node<E> buffer1 = this.head;
        Node<E> buffer2 = otherList.head;

        if (this.size != otherList.size) { //if sizes are not equal we can immediately return false
            return false;
        }
        //loop to iterate through values and check if they are equal, if it finds non-equal values it returns false
        for (int i = 0; i < this.size; i++) {
            if (!buffer1.getElement().equals(buffer2.getElement())) {
                return false;
            }
            buffer1 = buffer1.getNext();
            buffer2 = buffer2.getNext();
        }
        return true; // return true if same size and all values equal
    }

    /**
     * Method to add an element and sort it.
     * I did not have a lot of knowledge on how to compare two generics, so I watched a video on Youtube to get an idea
     * on how I could do it. From that video I was able to understand the concept and then apply it here.
     * video link: https://www.youtube.com/watch?v=wLksl_hoIps&t=818s
     *
     * @param element generic, element to be added after finding its proper place
     */
    public void addInOrder(E element) {
        Node<E> newNode = new Node<E>();
        newNode.setElement(element);

        // if statement for the case where list is empty, add it to top
        if (this.size == 0) {
            head = newNode;
            tail = newNode;
            size++;
            return;
        }

        // if statement for when the element is smaller than the head
        if (head.getElement().compareTo(element) >= 0){
            newNode.setNext(head);
            head = newNode;
            size++;
            return;
        }

        // If statement for when the element is larger than the tail
        if (tail.getElement().compareTo(element) <= 0) {
            tail.setNext(newNode);
            tail = newNode;
            size++;
            return;
        }

        Node<E> buffer = head;

        // loop to traverse the list checking for the proper place for the element
        // no need to check the tail since we already covered that case
        while (buffer != null && buffer != tail) {

            // If statement to check if the next element in the list is larger than the one when want to add
            // If true, the element will be added between the present location and the next one
            if (buffer.getNext().getElement().compareTo(element) > 0) {
                newNode.setNext(buffer.getNext());
                buffer.setNext(newNode);
                size++;
                return;
            }
            buffer = buffer.getNext();
        }
    }
}


