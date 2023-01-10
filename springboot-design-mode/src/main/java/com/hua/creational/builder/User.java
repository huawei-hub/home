package com.hua.creational.builder;

/**
 * 建造者模式
 *   先把所有的属性都设置给 Builder，
 *   然后 build() 方法的时候，将这些属性复制给实际产生的对象
 */

public class User {
    // 下面是“一堆”的属性
    private String name;
    private String password;
    private String nickName;
    private int age;

    //构造方法私有化，不然客户端就会直接调用构造方法了
    private User(String name, String password, String nickName, int age) {
        this.name = name;
        this.password = password;
        this.nickName = nickName;
        this.age = age;
    }

    public static UserBuilder builder() {
        return new UserBuilder();
    }

    public static class UserBuilder {
        // 下面是“一堆”的属性
        private String name;
        private String password;
        private String nickName;
        private int age;

        private UserBuilder() {

        }

        //链式调用设置各个属性值，返回 this，即 UserBuilder
        public UserBuilder name(String name) {
            this.name = name;
            return this;
        }

        public UserBuilder password(String password) {
            this.password = password;
            return this;
        }

        public UserBuilder nickName(String nickName) {
            this.nickName = nickName;
            return this;
        }

        public UserBuilder age(int age) {
            this.age = age;
            return this;
        }

        public User builder() {
            if (name == null || password == null) {
                throw new RuntimeException("用户名和密码必填");
            }
            if (age < 0 || age > 150) {
                throw new RuntimeException("年龄不合法");
            }
            //给nickName添加值
            if (nickName == null) {
                nickName = "游客";
            }
            return new User(name, password, nickName, age);
        }
    }

    @Override
    public String toString() {
        return " -> " + name +
                "\n -> " + password +
                "\n -> " + age +
                "\n -> " + nickName;
    }
}
