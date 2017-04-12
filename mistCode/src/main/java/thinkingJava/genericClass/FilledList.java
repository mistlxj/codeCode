package thinkingJava.genericClass;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lixiaojian on 2017/4/11.
 */
public class FilledList<T> {
    private Class<T> type;

    public FilledList(Class<T> type) {
        this.type = type;
    }

    public List<T> create(int nCnt) {
        List<T> result = new ArrayList<T>();
        try{
            for(int i=0;i<nCnt;i++) {
                result.add(type.newInstance());
            }
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    public static void main(String[] args) {
        FilledList<CountInteger> fl = new FilledList<CountInteger>(CountInteger.class);
        System.out.println(fl.create(15));
    }
}
