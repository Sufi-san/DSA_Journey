package _2_Implementation.Graphs;

class Pair<T> {
    public final T A;
    public final T B;

    Pair(T A, T B) {
        this.A = A;
        this.B = B;
    }

    @Override
    public String toString() {
        return "["+A+", "+B+"]";
    }
}
