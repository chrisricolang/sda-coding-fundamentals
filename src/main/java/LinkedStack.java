public class LinkedStack {

    private final int maxSize;
    private int stackSize = 0;
    private StackNode head;
    public LinkedStack(int maxSize) {
        this.maxSize = maxSize;
    }

    public void push(int value) {
        if (stackSize == maxSize) {
            throw new IllegalStateException("overflow");
        }
        StackNode oldHead = this.head;
        StackNode newHead = new StackNode(value, oldHead);
        this.head = newHead;
        stackSize++;
    }

    public int pop(){
        if (isEmpty()) {
            throw new IllegalStateException("underflow");
        }
        StackNode oldHead = this.head;
        this.head = oldHead.getTail();
        stackSize--;

        return oldHead.getValue();
    }

    public int size(){
        return stackSize;
    }

    public boolean isEmpty(){
        return stackSize == 0;
    }

    public String toString(){
        String display = "";

        if (head != null) {
            StackNode currentNode = head;
            display = display + currentNode.getValue();
            while (currentNode.previousHead != null) {
                currentNode = currentNode.previousHead;
                display = display
                        + " -> "
                        + currentNode.getValue();
            }
        }

        return display;
    }

    private class StackNode {
        private final int value;
        private final StackNode previousHead;

        public StackNode(int value, StackNode previousHead){
            this.value = value;
            this.previousHead = previousHead;
        }

        public int getValue() {
            return value;
        }

        public StackNode getTail() {
            return previousHead;
        }
    }

}
