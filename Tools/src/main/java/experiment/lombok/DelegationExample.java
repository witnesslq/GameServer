package experiment.lombok;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 13-12-6
 * Time: 上午11:33
 * To change this template use File | Settings | File Templates.
 */

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Delegate;

import java.util.ArrayList;
import java.util.Collection;

public class DelegationExample {

    private interface SimpleCollection {
        boolean add(String item);

        boolean remove(Object item);
    }

    @Delegate(types = SimpleCollection.class)
    private final Collection<String> collection = new ArrayList<String>();

    public static void main(String[] args) {
        DelegationExample d = new DelegationExample();
        d.add("x");
        d.remove("x");
        Student student = new Student(90, new Person());
        student.setName("xx");
        System.out.println(student);
//        d.
    }
}


@AllArgsConstructor
@Data
class Student {
    private int grade = 90;
    @Delegate
    private Person p;
}

class ExcludesDelegateExample {
    long counter = 0L;

    private interface Add {
        boolean add(String x);

        boolean addAll(Collection<? extends String> x);
    }

    @Delegate(excludes = Add.class)
    private final Collection<String> collection = new ArrayList<String>();

    public boolean add(String item) {
        counter++;
        return collection.add(item);
    }

    public boolean addAll(Collection<? extends String> col) {
        counter += col.size();
        return collection.addAll(col);
    }

}
