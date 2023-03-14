package debili;

public class SomeWork<T>implements Work<T>{
    private T data;
    private Work<T> work;
    public SomeWork(T x,Work<T> work){
        data = x;
        this.work = work;
    }
    @Override
    public boolean noWork() {
        return false;
    }

    @Override
    public Work<T> addWork(T x) {
        return new SomeWork<>(x,this);
    }

    @Override
    public T viewWork() {
        return data;
    }

    @Override
    public Work<T> removeWork() {
        return work;
    }

    @Override
    public Work<T> reverse() {
        return helper(this,new NoWork<>());

    }
    private static<T> Work<T> helper(Work<T> w,Work<T> acc){
        if(w.noWork()) {
            return acc;
        }
        else {
            acc = new SomeWork<>(((SomeWork<T>) w).data,acc);
            return helper(((SomeWork<T>) w).work,acc);
        }
    }



    public static void main(String[] args) {
        Work<Integer> work = new SomeWork<>(5,new SomeWork<>(1,new SomeWork<>(2,new NoWork<>())));
        work = work.addWork(12);
        work = work.reverse();
        for (Integer i:work) {
            System.out.println(i);
        }
    }
}
