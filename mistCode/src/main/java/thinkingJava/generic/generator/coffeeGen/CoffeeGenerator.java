package thinkingJava.generic.generator.coffeeGen;

import thinkingJava.generic.generator.Generator;
import thinkingJava.generic.generator.coffeeGen.model.Cappuccino;
import thinkingJava.generic.generator.coffeeGen.model.Coffee;
import thinkingJava.generic.generator.coffeeGen.model.Latte;
import thinkingJava.generic.generator.coffeeGen.model.Mocha;

import java.util.Iterator;
import java.util.Random;

/**
 * Created by zhuxuemei on 17/8/13.
 */
public class CoffeeGenerator implements Generator<Coffee> , Iterable<Coffee> {

    private Class[] types = {Latte.class, Mocha.class, Cappuccino.class};

    private static Random random = new Random(47);

    private int size = 0;

    public CoffeeGenerator() {};

    public CoffeeGenerator(int size) { //末端哨兵,用于循环条件截止
        this.size = size;
    }

    @Override
    public Coffee next() {
        try {
            return  (Coffee) (types[random.nextInt(types.length)].newInstance());
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Iterator<Coffee> iterator() {
        return new CoffeeIterator();
    }



    class CoffeeIterator implements Iterator<Coffee> {
        int count = size;

        @Override
        public boolean hasNext() {
            return count > 0;
        }

        @Override
        public Coffee next() {
            count--;
            return CoffeeGenerator.this.next();
        }

        public void remove() {
        }
    }


    public static void main(String[] args) {
        CoffeeGenerator gen = new CoffeeGenerator();
        for (int i=0;i<5;i++) {
            System.out.println(gen.next());
        }
        for (Coffee c : new CoffeeGenerator(5)) {
            System.out.println(c);
        }
    }
}
