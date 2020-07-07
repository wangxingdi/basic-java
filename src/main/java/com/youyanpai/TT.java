package com.youyanpai;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class TT {

	//待测试的全局变量
    private static String strLabel;
    private static ThreadLocal<String> threadLabel = new ThreadLocal<>();

    public static void main(String[] args) {
        strLabel = "main线程";
        threadLabel.set("main线程");
        threadLabel.set("main线程2");

        Thread thread = new Thread() {
            @Override
            public void run() {
                super.run();
                strLabel = "child线程";
                threadLabel.set("child线程");
            }
        };
		
        thread.start();
		
        try {
            // 保证线程执行完毕
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("strLabel = " + strLabel);
        System.out.println("threadLabel = " + threadLabel.get());
    }

}
