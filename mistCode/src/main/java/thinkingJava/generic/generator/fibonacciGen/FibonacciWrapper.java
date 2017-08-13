package thinkingJava.generic.generator.fibonacciGen;

import java.util.Iterator;

/**
 * Created by zhuxuemei on 17/8/13.
 */
public class FibonacciWrapper extends Fibonacci implements Iterable<Integer>{
    private int n;
    public FibonacciWrapper(int n) {
        this.n = n;
    }


    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            public boolean hasNext() {
                return n > 0;
            }

            public Integer next() {
                n--;
                return FibonacciWrapper.this.next();
            }

            public void remove() {

            }
        };
    }

    public static void main(String[] args) {
        for (int i : new FibonacciWrapper(10)) {
            System.out.print(i + " ");
        }
    }
}
