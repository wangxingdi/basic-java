package com.daiyuma.tmp.year2020.month09.day07;

public class ClassA implements Cloneable {

    private int age;
    private String sex;
    private ClassB b;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public ClassB getB() {
        return b;
    }

    public void setB(ClassB b) {
        this.b = b;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return "ClassA{" +
                "age=" + age +
                ", sex='" + sex + '\'' +
                ", b=" + b +
                '}';
    }
}
