package thinkingJava.genericClass;

/**
 * Created by lixiaojian on 2017/4/11.
 */
 class CountInteger {
    private static long counter;

    private final long id = counter++;

    public String toString() {
        return Long.toString(id);
    }

}
