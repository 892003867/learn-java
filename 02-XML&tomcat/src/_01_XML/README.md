#### 导航  
1. _01_XML_DTD_XSD：[DTD语法](#user-content-_01_xml_dtd_xsd)  
----
#### Utils  
1. J   
*p  
----
#### _01_XML_DTD_XSD  
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
*
[跳转导航](#user-content-导航)  
----