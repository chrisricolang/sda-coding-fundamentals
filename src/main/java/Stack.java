public class Stack {

    private int[] array;
    private int top = -1;

    public Stack(int size) {
        array = new int[size];

    }

    public boolean isEmpty() {
        return top == -1;
    }

    public void push(int value) {
        if (top + 1 == array.length){
            throw new IllegalStateException("overflow");
        }
        top++;
        array[top] = value;
    }

    public int pop() {
        if (isEmpty()) {
            throw new IllegalStateException("underflow");
        }
        int oldTop = top;
        top--;
        return array[oldTop];
    }

    public int size() {
        return top + 1;
    }
}