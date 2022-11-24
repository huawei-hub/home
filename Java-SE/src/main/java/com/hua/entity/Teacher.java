package com.hua.entity;

import com.hua.enums.Gender;
import com.hua.enums.Subject;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Teacher extends Person {
    private Subject subject;

    public Teacher(int id, String name, Gender sex, Subject subject) {
        super(id, name, sex);
        this.subject = subject;
    }

    @Override
    public String toString() {
        return super.getId()+"\t"+super.getName()+"\t"+super.getSex().getGender()+"\t"+subject.getDiscipline();
    }
}
