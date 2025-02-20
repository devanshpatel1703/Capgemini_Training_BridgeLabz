import java.util.Arrays;

public class CircularBuffer {
    int[] buffer;
    int size, start, end;

    public CircularBuffer(int capacity) {
        buffer = new int[capacity];
    }

    public void insert(int value) {
        buffer[end] = value;
        end = (end + 1) % buffer.length;
        if (size < buffer.length) size++;
        else start = (start + 1) % buffer.length;
    }

    public void printBuffer() {
        System.out.println(Arrays.toString(buffer));
    }

    public static void main(String[] args) {
        CircularBuffer cb = new CircularBuffer(3);
        cb.insert(1);
        cb.insert(2);
        cb.insert(3);
        cb.insert(4);
        cb.printBuffer();
    }
}