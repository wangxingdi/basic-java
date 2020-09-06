package com.daiyuma.tmp.day_20200831;

import java.util.ArrayList;
import java.util.LinkedList;

public class ListTest {

    static ArrayList<Integer> arr = new ArrayList<Integer>();
    static LinkedList<Integer> link = new LinkedList<Integer>();

    public static void main(String[] args) {
        testSpeed(10000000);
    }

    private static void testSpeed(int num){
            System.out.println("==================num=" +num+ "==================");
            insertArrayList_1(num);
            insertLinkedList_1(num);

            insertArrayList_2(num/3,num/2, 8878);
            insertLinkedList_2(num/3, num/2,8878);

            setArrayList(num/3, num/2,9987);
            setLinkedList(num/3, num/2,9987);

            removeArrayList(num/3,num/2);
            removeLinkedList(num/3, num/2);

            getArrayList(num/3);
            getLinkedList(num/3);
    }

    /**
     * 直接插入数据,查看消耗时间
     * @param nums
     */
    private static void insertArrayList_1(int nums){
        long begin = System.currentTimeMillis();
        for(int i=0;i<nums;i++){
            arr.add(i);
        }
        long end = System.currentTimeMillis();
        System.out.println("insertArrayList_1插入完成，共耗费时间："+(end-begin));
    }

    /**
     * 直接插入数据,查看消耗时间
     * @param nums
     */
    private static void insertLinkedList_1(int nums){
        long begin = System.currentTimeMillis();
        for(int i=0;i<nums;i++){
            link.add(i);
        }
        long end = System.currentTimeMillis();
        System.out.println("insertLinkedList_1插入完成，共耗费时间："+(end-begin));
    }

    private static void insertArrayList_2(int start, int stop, int num){
        long begin = System.currentTimeMillis();
        for(int i=start;i<stop;i*=2){
            arr.add(i, num);
        }
        long end = System.currentTimeMillis();
        System.out.println("insertArrayList_2插入完成，共耗费时间："+(end-begin));
    }

    private static void insertLinkedList_2(int start, int stop, int num){
        long begin = System.currentTimeMillis();
        for(int i=start;i<stop;i*=2){
            link.add(i, num);
        }
        long end = System.currentTimeMillis();
        System.out.println("insertLinkedList_2插入完成，共耗费时间："+(end-begin));
    }

    private static void setArrayList(int start, int stop, int num){
        long begin = System.currentTimeMillis();
        for(int i=start;i<stop;i*=2){
            arr.set(i, num);
        }
        long end = System.currentTimeMillis();
        System.out.println("setArrayList替换完成，共耗费时间："+(end-begin));
    }

    private static void setLinkedList(int start, int stop, int num){
        long begin = System.currentTimeMillis();
        for(int i=start;i<stop;i*=2){
            link.set(i, num);
        }
        long end = System.currentTimeMillis();
        System.out.println("setLinkedList替换完成，共耗费时间："+(end-begin));
    }

    private static void removeArrayList(int start, int stop){
        long begin = System.currentTimeMillis();
        for(int i=start;i<stop;i*=2){
            arr.remove(i);
        }
        long end = System.currentTimeMillis();
        System.out.println("removeArrayList删除完成，共耗费时间："+(end-begin));
    }

    private static void removeLinkedList(int start, int stop){
        long begin = System.currentTimeMillis();
        for(int i=start;i<stop;i*=2){
            link.remove(i);
        }
        long end = System.currentTimeMillis();
        System.out.println("removeLinkedList删除完成，共耗费时间："+(end-begin));
    }

    private static void getArrayList(int index){
        long begin = System.currentTimeMillis();
        arr.get(index);
        long end = System.currentTimeMillis();
        System.out.println("getArrayList遍历完成，共耗费时间："+(end-begin));
    }

    private static void getLinkedList(int index){
        long begin = System.currentTimeMillis();
        link.get(index);
        long end = System.currentTimeMillis();
        System.out.println("getLinkedList遍历完成，共耗费时间："+(end-begin));
    }
}
