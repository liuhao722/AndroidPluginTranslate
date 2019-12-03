# AndroidPluginTranslate
An simple translate plugin with AndroidStudio IDE

## AndroidStudio插件-中英文翻译

#### 环境配置

Android Studio是基于IntelliJ专门为Android定制的IDE，是没有办法编写IDE的插件的，所以我们首先要下载一个开发Java用的IntelliJ IDEA。

准备翻译API：[文档地址](http://api.fanyi.baidu.com/api/trans/product/apidoc#joinFile)

#### 新建项目

`File—>new Project` 左边选择`IntelliJ Platform Plugin`，右上方Project SDK第一次进入应该是没有配置的， 自己进行配置即可；

<img src="/Users/qiucheng/Library/Application Support/typora-user-images/image-20191130141905819.png" style="zoom:30%">

下一步：设置项目存放目录及项目

<img src="/Users/qiucheng/Library/Application Support/typora-user-images/image-20191130143030977.png" style="zoom:30%">



配置好这些，我们就可以编写插件了！

------

新建Action

<img src="/Users/qiucheng/Library/Application Support/typora-user-images/image-20191130144243356.png" style="zoom:30%">

<img src="/Users/qiucheng/Library/Application Support/typora-user-images/image-20191130144508705.png" style="zoom:34%">

根据自己将插件放置的位置进行选择对应的add to group，比如目前该项目放到code

<img src="/Users/qiucheng/Library/Application Support/typora-user-images/image-20191202145239010.png" style="zoom:50%">



#### 项目目录结构：

<img src="/Users/qiucheng/Library/Application Support/typora-user-images/image-20191202143832387.png" style="zoom:90%">



#### plugin.xml生成的结构：



<img src="/Users/qiucheng/Library/Application Support/typora-user-images/image-20191202144725035.png" style="zoom:45%">



```java
id即为插件的id
name为插件的名称
version为插件的版本号
vendor中的内容为你的邮箱以及公司名称、官网等
这些信息在用户下载插件时都会展示给用户的
```



#### 项目Demo地址：

[Git地址](https://github.com/liuhao722/AndroidPluginTranslate.git)



#### 发布插件（参照官方文档）

[http://www.jetbrains.org/intellij/sdk/docs/basics/getting_started/publishing_plugin.html](