package com.hua.demo;

import lombok.Data;
import lombok.ToString;
import org.junit.Test;

public class EnumTest {

    public StuVo getStuVo() {
        StuVo stu = new StuVo();
        stu.setId(1);
        stu.setDay(1);
        return stu;
    }

    //1
    @Test
    public void test1(){

        Weekday mon = Weekday.MON;
        System.out.println(mon);
        mon.setChinese("星期1");
        System.out.println(mon);

    }


}

@Data
@ToString
class StuVo{
    private Integer id;
    private int day;
}


@Data
class StuDao{
    private Integer id;
    private Weekday day;
}

enum Weekday {
    SUN("星期日",7),
    MON("星期一",1),
    TUE("星期二",2),
    WEN("星期三",3),
    THR("星期四",4),
    FRI("星期五",5),
    SAT("星期六",6);
    private String chinese;
    private int num;

    Weekday(String chinese,int num) {
        this.chinese = chinese;
        this.num = num;
    }
    public String getChinese() {
        return chinese;
    }

    public void setChinese(String chinese) {
        this.chinese = chinese;
    }

    public int getNum() {
        return num;
    }

    @Override
    public String toString() {
        return chinese +"-"+ num;
    }
}