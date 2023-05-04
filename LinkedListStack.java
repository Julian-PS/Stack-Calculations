public class LinkedListStack implements Stack {

    MyLinkedList<Integer> stack = new MyLinkedList<>(); // Linked list created for the stack

    /**
     * Method to add an element to the stack
     *
     * @param element, int element we want to add to the stack
     */
    @Override
    public void push(int element) {
        stack.add(element);     // call to the add method in our MyLinkedList
    }

    /**
     * Method to remove the last element inserted in the stack
     *
     * @return the value of the element removed
     */
    @Override
    public int pop() {
        int temp = stack.head.getElement();  //create temporary int to return value after being removed
        stack.remove(stack.head.getElement());  // call to remove method in MyLinkedList
        return temp;
    }

    /**
     *  Method to return the size of the stack
     *
     * @return size of the stack (Linked list)
     */
    @Override
    public int size() {
        return stack.size(); // call to size method in MyLinkedList
    }

    /**
     * Method to return the stack elements, using the toString method in MyLinkedList
     *
     * @return string with the elements in the stack
     */
    @Override
    public String toString(){
        return "Your stack items are: [" + stack.toString() + "]";  // call to the toString method in MyLinkedList
    }

    /**
     * Method to add the last two elements of the stack, pop (remove) them and push the resulting value
     *
     * @return resulting int from the sum
     */
    public int addition(){
        // sum the elements by using the methods getNext and getElement from Node class
        int sum = stack.head.getElement() + stack.head.getNext().getElement();
        pop();
        pop();
        push(sum);
        return sum;
    }

    /**
     * Method to multiply the last two elements of the stack, pop (remove) them and push the resulting value
     *
     * @return resulting int from the multiplication
     */
    public int multiply(){
        // multiply the elements by using the methods getNext and getElement from Node class
        int product = stack.head.getElement() * stack.head.getNext().getElement();
        pop();
        pop();
        push(product);
        return product;
    }
}
