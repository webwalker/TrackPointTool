示例：
1、先从Excel中拷贝如下的两列数据，然后保存到test.txt中
   b_btn_ cancle_edit_f_f_b_r_j_click	点击发布日记页取消修改按钮

2、执行命令
D:\>java -jar D:\umeng.jar c:\test.txt d:\1112.txt
success[151]

151为成功格式化的埋点数。


其他方式：
1、Excel插入一新列，格式化为大写，然后赋值到RegexBuddy中，用以下表达式替换即可。

(\w+)\s+(.+)
public static final String $1 = $1;//$2