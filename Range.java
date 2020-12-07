import java.util.NoSuchElementException;
public class Range implements IntegerSequence {
    private int start, end, current;

    public Range(int start, int end) {
        if (start > end) throw new IllegalArgumentException();
        this.start = start;
        this.end = end;
        this.current = start;
    }

    public void reset() {
        current = start;
    }

    public int length() {
        return end - start + 1;
    }

    public boolean hasNext() {
        return current <= end;
    }

    public int next() {
        if (!hasNext()) throw new NoSuchElementException();
        current += 1;
        return current - 1;
    }
}
