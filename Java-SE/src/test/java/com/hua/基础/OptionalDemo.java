package com.hua.基础;

import com.hua.entity.Person;
import com.hua.entity.Student;
import com.hua.enums.Gender;
import org.junit.Test;

import java.util.Optional;

public class OptionalDemo {
    Student student;
    Person person = new Person();

    //测试方法
    @Test
    public void testOf(){
        person.setId(1);
        person.setName("张三");
        person.setSex(Gender.MAN);
        Optional<Person> person = Optional.of(this.person);
        System.out.println(person);

        Person p1 = Optional.ofNullable(this.person).orElse(getPerson());
        Person p2 = Optional.ofNullable(new Person()).orElseGet(() -> getPerson());
        System.out.println("p2 = " + p1.getName());
//        Optional<Student> student = Optional.of(this.student);
//        System.out.println(student);
    }

    private Person getPerson() {
        return new Person();
    }
}
