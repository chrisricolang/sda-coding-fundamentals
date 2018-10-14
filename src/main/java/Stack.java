public class Stack {

    private final int[] array;
    private int sizeOfStack = 0;


    public Stack(int size) {
        array = new int[size];
    }

    public boolean isEmpty() {
        return sizeOfStack == 0;
    }

    public void push(int value) {
        if (isStackWillOverflow()) {
            throw new IllegalStateException("overflow");
        }

        increaseStackSize();
        addValueToArray(value);

    }

    private boolean isStackWillOverflow() {
        return sizeOfStack + 1 > array.length;
    }

    private int increaseStackSize() {
        return sizeOfStack++;
    }

    private void addValueToArray(int value) {
        array[getCurrentArrayIndex()] = value;
    }

    private int getCurrentArrayIndex() {
        return sizeOfStack - 1;
    }

    public int pop() {
        if (isEmpty()) {
            throw new IllegalStateException("underflow");
        }

        int value = getLastElement();
        decreaseStackSize();
        return value;
    }

    private int decreaseStackSize() {
        return sizeOfStack--;
    }

    private int getLastElement() {
        return array[getCurrentArrayIndex()];
    }

    public int size() {
        return sizeOfStack;
    }

    @Override
    public String toString() {
        String display = "";
        for (int i = sizeOfStack - 1; i >= 0; i--){

            display = display + array[i];

            if (i != 0) {
                display = display + " -> ";
            } else if (i == 0){
                display = display + " Stack size is " + sizeOfStack;
            }
        }

        return display;
    }
}