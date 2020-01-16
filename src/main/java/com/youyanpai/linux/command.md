- ls [-al] 查看目录中的文件

| -rw-r--r--. | 1 | root | root | 18645 | May 29 16:08 | /root/readme.txt |
| :----: | :----: | :----: |:----: |:----: |:----: |:----: |
| 表示文件的类型与权限<br/>(共10个字符) | 连接数 | 档案拥有者 | 档案所属群组 | 大小   | 最后被修改时间   | 文件名 |

- mkdir [-p] 创建目录

- rm [-f]
 1. rm -f file 删除一个叫file1的文件
 2. rmdir dir1 删除一个叫dir1的目录
 3. rm -rf dir1 删除一个叫dir1的目录以及其内容
 
- mv
 1. mv file1 file2 将file1重命名为file2；如果file2存在，则file2会被覆盖
 2. mv file1 dir1 将file1移动到dir1中
 3. mv dir1 dir2 将dir1移动到dir2；如果dir2存在，则会将dir1移动到dir2里面
 4. mv dir1 file1 出错
 
- cp
 1. cp file1 file2 将file1复制到file2中；如果file2存在，则其内容会被覆盖；如果file2不存在，则会被创建
 2. cp dir1/* . 将dir1目录下的全部文件复制到当前目录下
 3. cp -a dir1 . 将dir1目录复制到当前目录下
 4. cp -a dir1 dir2 将dir1复制并重命名为dir2
 