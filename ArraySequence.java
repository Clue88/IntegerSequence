import java.util.NoSuchElementException;
public class ArraySequence implements IntegerSequence {
    int currentIndex;
    int[] data;

    public ArraySequence(int[] other) {
        currentIndex = 0;
        data = new int[other.length];
        for (int i = 0; i < other.length; i++) {
            data[i] = other[i];
        }
    }

    public ArraySequence(IntegerSequence otherseq) {
        currentIndex = 0;
        data = new int[otherseq.length()];

        otherseq.reset();
        int i = 0;
        while (otherseq.hasNext()) {
            data[i] = otherseq.next();
            i++;
        }
    }

    public void reset() {
        currentIndex = 0;
    }

    public int length() {
        return data.length;
    }

    public boolean hasNext() {
        return currentIndex != length() - 1;
    }

    public int next() {
        if (!hasNext()) throw new NoSuchElementException();
        currentIndex++;
        return data[currentIndex - 1];
    }
}
