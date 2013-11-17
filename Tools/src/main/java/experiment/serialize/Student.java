package experiment.serialize;

import org.msgpack.annotation.Message;

/**
 * Created with IntelliJ IDEA.
 * User: liukun
 * Date: 13-11-17
 * Time: 上午12:18
 */



@Message
public class Student{

    public static final int COUNT = 1000000;
    public static final int LIST_COUNT = 1000000;
    String name;
    int age;

    public int getAge(){
        return age;
    }

    public void setAge(int age){
        this.age = age;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }
}
