package com.daiyuma.tmp.year2020.month10.day25;

public class BocoTest {

    public static void main(String[] args) {
//        String s = "http://localhost:8080/idc/p/s/action?listid=78678&id=23";
		String s = "http://localhost:8080/idc/p/s/action?id=23&listid=78678";

        if(s.contains("listid=")){
            //先将listId=之后内容截取出来
            String s1 = s.substring(s.indexOf("listid=")+7);
            //然后判断其内容是否包含&
            if(s1.contains("&")){
                s1 = s1.substring(0, s1.indexOf("&"));
            }
            System.out.println(s1);
        }else{
            System.out.println("缺少listid");
        }
    }
}
