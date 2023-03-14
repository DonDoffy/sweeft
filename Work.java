package debili;

import javax.swing.text.html.HTMLDocument;
import java.util.Iterator;

public interface Work<T> extends Iterable<T> {
    boolean noWork();

    Work<T> addWork(T x);

    T viewWork();

    Work<T> removeWork();

    Work<T> reverse();

    class WorkIterator<T> implements Iterator<T> {
        private Work<T> work;

        public WorkIterator(Work<T> work){
            this.work = work;
        }

        @Override
        public boolean hasNext() {
            return !work.noWork();
        }

        @Override
        public T next() {
            T temp = work.viewWork();
            work = work.removeWork();
            return temp;
        }
// todo
    }

    default Iterator<T> iterator() {
        return new WorkIterator<>(this);
    }
}

