package debili;

public class NoWork<T> implements Work<T> {


    @Override
    public boolean noWork() {
        return true;
    }

    @Override
    public Work<T> addWork(T x) {
        return null;
    }

    @Override
    public T viewWork() {
        throw new RuntimeException("No Work!");
    }

    @Override
    public Work<T> removeWork() {
        throw new RuntimeException("No Work!");
    }

    @Override
    public Work<T> reverse() {
        return this;
    }
}
