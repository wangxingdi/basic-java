# 阻塞IO

* 当需要操作文件时，FileInputStream和FileOutputStream是两个最重要的类。
* 当需要操作字符时，Reader和Wirter首先需要被考虑。其中BufferedReader和BufferedWriter提供了readLine方法。
* 如果需要将InputStream和OutputStream转换为Reader和Writer，可以使用InputStreamReader和OutputStreamWriter。
同时，OutputStreamWriter可以指定字符集。
* FileInputStream和FileOutputStream与FileReader和FileWriter相比，都是操作文件。相对而言，字节系返回值是byte[]；
字符系返回的是char[]或者String。