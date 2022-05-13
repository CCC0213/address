package dao;

import aQute.bnd.annotation.component.Component;

@Component
public class perpson {
    String name;
    int  age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge(int i) {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


}
