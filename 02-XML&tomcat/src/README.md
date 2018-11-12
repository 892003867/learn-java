#### 导航  
1. _01_XML_DTD_XSD：[XML](#user-content-_01_xml)  
2. _02_tomcat：[HTTP协议](#user-content-_02_tomcat)  
3. _03_tomcat：[tomcat](#user-content-_03_tomcat)  
----
#### Utils  
1.    
*  
----
#### _01_XML  
1. DTD约束  
>定义规则
```
     *：          出现多次  
     ?：          0次或者1次  
     +：          最少出现1次或者多次  
     |：          选择两者之一  
     ()：         用来给元素分组  
     ,：          表示按照顺序出现  
     (#PCDATA)：  该内容模型说明元素中可以同时出现文本和元素  
```   
2. XML文件的定义  
>XML约束规则
```
     xmlns：                               空间命名，url可以自定义，也可以使用约束url  
     xmlns:xsi：                           使用xs做为前缀  
     xsi:schemaLocation：                  导入本地约束文件，XSD约束  
     <!DOCTYPE web-app SYSTEM "test.dtd">：导入本地约束文件，DTD约束  
     <![cdata[ 转成字符形式 ]]>：            不会被浏览器解析  
```  
3. XSD约束  
>XSD定义规则
```  
    xmlns:xs="http://www.baidu.com"  
    targetNamespace="http://www.baidu.com"  
    xmlns="http://www.baidu.com"  
    elementFormDefault="qualified"  
    element：        定义元素的开始  
    complexType：    代表下面出现的是复杂的类型  
    sequence：       表示下方子元素是有序的  
```  
4. XSD与DTD区别  
*DTD约束文件没有命名空间，导致无法区分，XSD有了命名空间，这样将不会文件命名元素冲突  
5. 名称空间介绍  
*名称空间的作用防止相同两个元素同名冲突问题  
9. XML解析方式  
*常用解析方式DOM解析，树状方式解析，将文档加载内存中，形成Document对象  
*通过`domj4`对XML文件进行解析[跳转导航](#user-content-导航)  
----  
#### _02_tomcat  
1. http协议request请求头  
```  
Accpet：text/html,application/xhtml+xml (可以接受的数据类型)  
Referer：(数据来源的域名地址)  
Accpet-language：(接收的语言)  
User-Agent：(可以查看客户端系统相关信息)  
Content-Type：application/x-www-form-urlencoded (文本的类型)  
Accpet-Encoding：gzip，deflate (接收的压缩格式)  
Host：(主机端口)  
Content-length：(文件的长度)  
Connection：keep-alive (保持连接)  
Cache-Control：no-cache (是否缓存)  
If-Modified-Since：(客户端记录的上一次修改时间)  
```  
2. http协议response响应头  
```  
HTTP：1.1 200 ok (响应头，协议版本，状态码)  
Server：Apache-Coyoye/1.1 (服务器版本)  
Accpet-Ranges：bytes (可接收的数据范围为字节)  
ETag：W/"305-1470186605044" ()  
Last-Modified：web,03 aug 2016 (最后的修改时间)  
Content-Type：text/html (响应体的页面显示的正文为text/html)  
Content-Length：305 (响应体的内容长度)  
Date：web 03 aug 2016 (最终响应时间)  
```  
*Last-modified：response响应头记录了访问资源最后的修改时间，而客户端的request请求头记录了上一次的修改时间。于是服务器端的修改时间与客户端记录的修改时间进行对比，如果服务器端的数据发生了修改，那么对比出来的时间不相等，就会重新发送新的数据，触发200状态码。如果服务器端数据没有修改，修改时间相等，那么浏览器默认直接从本地缓存读取数据，触发304  
3. tomcat的目录结构  
```  
bin：可执行的脚本  
conf：配置信息(server.xml配置文件很重要)  
lib：jar包，类库  
logs：日志  
temp：临时文件目录  
webapps：项目的运行环境空间(ROOT默认的目录，可以放index.html等)  
work：工作目录  
```  
*启动的执行脚本，在bin目录下，start.bat，而start.bin是linux系统启动文件  
4. web应用的目录结构  
```  
WEB-INF：受保护的目录，无法静态资源访问此目录内部文件  
    >classes：此目录存放源文件，java类  
    >lib：此目录存放jar包  
    >web.xml：web的配置文件  
```  
5. servlet快速入门  
* 实现`Servlet`接口，实现接口方法[跳转导航](#user-content-导航)  
#### _03_tomcat  
>##### 01_生命周期  
1. (Servlet创建时候)init -> (每次请求)service -> 关闭服务器(destroy)  
[跳转导航](#user-content-导航)  