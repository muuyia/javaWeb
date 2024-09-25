项目     | Value
-------- | -----
电脑  | $1600
手机  | $12
导管  | $1


| Column 1 | Column 2  |	Column 3 |
|:--------| :---------:|--------:|
| centered 文本居左 | right-aligned 文本居中 |right-aligned 文本居右|


| 模块               |         类名         |                	功能                 |      描述      |
|:-----------------|:------------------:|:----------------------------------:|:------------:|
| centered 文本居左    | right-aligned 文本居中 |         right-aligned 文本居右         |              |
| cainiao_Servlet  |     Helloworld     |         直接在页面输出HelloWorld          | 第一个Servlet程序 |
| demo01-web01     |                    |             web工程基础框架              |              |
| demo02-servlet01 |    UserServlet     |         通过web.xml配置Servlet         |              |
| demo02-servlet01 |      Servlet1      | 通过@WebServlet("/s1") 注解方式配置Servlet |              |
| schedule-system  |                    |                                    |     
|demo06-cookie-session | Servlet1 |             session样例              |    P105  http://localhost:8080/demo06/servlet1?username=zhangsan    |
| demo07 |  |                域对象                 |  |

# 尚硅谷JavaWeb视频教程
[视频链接](https://www.bilibili.com/video/BV1UN411x7xe?p=67&vd_source=14551025f000a7403c153e5a0e5f8140)

## Tomcat
手工启动：D:\software\apache-tomcat-10.1.17-windows-x64\apache-tomcat-10.1.17\bin\startup.bat

官方样例地址：  
http://localhost:8080/  
http://localhost:8080/examples  

自建样例地址：  
http://localhost:8080/testMhw/   默认访问index.html  
http://localhost:8080/testMhw/form_demo.html  
注：不支持中文

### 标准结构
![](/Picture/img.png)

![图片alt](/Picture/P67-index.png "图片title")

### URL
![](/Picture/P59-URL.png)

### 部署方式
![](/Picture/img_1.png)

P65  http://localhost:8080/demo01/servlet1

问题：tomcat 启动后无法访问8080
解决：
![](/Picture/img_2.png)

demo02-servlet01  com.atguigu.servlet P67
demo03-servletConfig-servletConfig   com.atguigu.servlet   P79

### 请求转发和重定向
![](/Picture/img_3.png)
demo04-forward-redirect  com.atguigu.servlet  P83

### MVC模式
![](/Picture/img_5.png)

### lombok自动生成实体类代码
![](/Picture/img_4.png)
com.atguigu.schedule.test.TestLombok
