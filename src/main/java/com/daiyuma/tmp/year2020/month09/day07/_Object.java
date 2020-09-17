package com.daiyuma.tmp.year2020.month09.day07;

/**
 * 1. public boolean equals方法默认使用==来判断
 * 2. protected native Object clone是浅复制
 * 3. public final native getClass返回的是运行时类型，也就是实际类型
 * 4. public native int hashCode默认返回的是当前对象的内存地址对应的一个整数
 */
public class _Object implements Cloneable{
    public static void main(String[] args) throws Exception {
        System.out.println("===equals和等号===");
        _Object o1 = new _Object();
        _Object o2 = new _Object();
        System.out.println("o1==o2: "+ (o1==o2));
        //Object的equals方法，当且仅当o1和o2指向同一个对象时，才返回true；否则返回false
        System.out.println("o1.equals(o2): "+ (o1.equals(o2)));
        //clone方法会产生一个新的对象，并将地址返回给o3
        Object o3 = o1.clone();
        _Object o4 = o1;
        System.out.println("o1==o3: "+ (o1==o3));
        System.out.println("o1==o4: "+ (o1==o4));
        System.out.println("o1.equals(o3): "+ o1.equals(o3));

        System.out.println("===getClass===");
        System.out.println("o1.getClass(): "+ o1.getClass());
        System.out.println("o3.getClass(): "+ o3.getClass());

        /**
         * 测试clone是浅复制还是深复制
         * 浅复制：复制的对象中如果存在对象属性，只会复制这个对象的引用，此时对克隆兄弟任何一个进行对象属性操作，都会影响另一个；
         * 深复制：复制的对象中如果存在对象属性，会将这个对象属性拷贝一份；
         * 1. ClassB是ClassA的一个属性，先对ClassA和ClassB数据初始化；
         * 2. 使用clone克隆一个ClassA；
         * 3. 然后更改ClassB中的属性值；
         * 4. 输出克隆后的ClassA，结果发现它的ClassB也被修改了，说明clone是一个浅复制；
         */
        System.out.println("===clone===");
        ClassA a = new ClassA();
        ClassB b = new ClassB();
        b.setName("b_name");
        a.setAge(1);
        a.setSex("man");
        a.setB(b);
        ClassA aa = (ClassA) a.clone();
        b.setName("b_name_1");
        System.out.println("aa: "+aa);
        aa.getB().setName("b_name_2");
        System.out.println("a: "+a);

        System.out.println("===hashCode===");
        ClassA aaa = a;
        System.out.println("aaa.hashCode(): "+aaa.hashCode());
        System.out.println("a.hashCode(): "+a.hashCode());
        System.out.println("aa.hashCode(): "+ aa.hashCode());
    }
}
