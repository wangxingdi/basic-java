package com.daiyuma.jdk.lang.object;

/**
 * 1. hashCode方法在基本类型的包装类和String中都有自己的实现；
 * 2. 不重写hashCode方法方法前，修改对象的某几个属性，不影响hashCode返回值；
 * 3. Byte，Short，Integer，Long四种包装类型，127以内自动装箱返回的值相同；
 */
public class HashCodeAndEquals {

    public static void main(String[] args) {
        Byte b = 10;
        System.out.println(b.hashCode());
        Short s = 20;
        System.out.println(s.hashCode());
        Integer i = 30;
        System.out.println(i.hashCode());
        Long l = 40L;
        System.out.println(l.hashCode());
        Double d = 2.9;
        System.out.println(d.hashCode());
        Float f = 4.7f;
        System.out.println(f.hashCode());
        Boolean bo = true;
        System.out.println(bo.hashCode());
        Character ch = 'b';
        System.out.println(ch.hashCode());
        String str = "aaabbb";
        System.out.println(str.hashCode());
        User user = new User();
        user.setName("张三");
        user.setSex(12);
        System.out.println(user.hashCode());
        user.setName("李四");
        user.setSex(28);
        System.out.println(user.hashCode());

        /* ################################################# */
        String s1 = new String("s");
        String s2 = new String("s");
        String s3 = "s";
        String s4 = "s";
        System.out.println("s1==s2: "+(s1==s2));
        System.out.println("s2==s3: "+(s2==s3));
        System.out.println("s3==s4: "+(s3==s4));
        Integer i1 = new Integer(127);
        Integer i2 = new Integer(127);
        System.out.println("i1==i2: "+(i1==i2));
        Integer i3 = 127;
        Integer i4 = 127;
        System.out.println("i3==i4: "+(i3==i4));
        Integer i5 = 128;
        Integer i6 = 128;
        System.out.println("i5==i6: "+(i5==i6));
        Byte b1 = 127;
        Byte b2 = 127;
        System.out.println("b1==b2: "+(b1==b2));
        Short short1 = 127;
        Short short2 = 127;
        System.out.println("short1==short2: "+(short1==short2));
        Long long1 = 127L;
        Long long2 = 127L;
        System.out.println("long1==long2: "+(long1==long2));
        Float float1 = 127f;
        Float float2 = 127f;
        System.out.println("float1==float2: "+(float1==float2));
        Double double1 = 127.0;
        Double double2 = 127.0;
        System.out.println("double1==double2: "+(double1==double2));
        Boolean boolean1 = true;
        Boolean boolean2 = true;
        System.out.println("boolean1==boolean2: "+(boolean1==boolean2));
        Character character1 = 'c';
        Character character2 = 'c';
        System.out.println("character1==character2: "+(character1==character2));
    }

    static class User{
        private String name;
        private int sex;
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
        public int getSex() {
            return sex;
        }
        public void setSex(int sex) {
            this.sex = sex;
        }
    }



}
