# bookmarks-professor

#### 介绍
收藏夹专家 - 浏览器导出的多个收藏夹合并工具

#### 项目结构
```
com.stevejrong.bookmarks.professor ------------------------------------------------------ 项目根包 
com.stevejrong.bookmarks.professor.boot ------------------------------------------------- 启动main()方法
com.stevejrong.bookmarks.professor.common ----------------------------------------------- 通用类
com.stevejrong.bookmarks.professor.config ----------------------------------------------- 系统配置
com.stevejrong.bookmarks.professor.module ----------------------------------------------- 业务模块
com.stevejrong.bookmarks.professor.util ------------------------------------------------- 通用工具类
```

#### 说明
1. 由于开发时间仓促，仅实现了功能，但代码结构和实现方式还待优化。
2. 目前实现的功能有：
 - 将多个由主流浏览器导出的收藏夹HTML文件合并为一个HTML文件。


#### 如何使用
###### 先决条件
1. 下载并安装Java IDE。以下任意一种均可：
```
Visual Code（系统需要安装JDK并配置JDK环境变量，IDE中需要安装Java相关插件。将项目打开后，会自动提示安装哪些插件）
IntelliJ IDEA（无需安装和配置JDK变量，IDE中自带OpenJDK）
Eclipse（系统需要安装JDK并配置JDK环境变量）
```

2. 下载并解压Gradle插件。以下为下载地址：
```
https://services.gradle.org/distributions/gradle-4.5.1-all.zip
```
> 下载后无需配置系统环境变量，在IDE中设置Gradle的解压目录即可

###### 执行功能
1. 将多个收藏夹HTML文件合并为一个HTML文件。
☞ 指南：
    - 定位到项目中的以下类：
    ```
    com.stevejrong.bookmarks.professor.boot.BookmarksProfessorApplication
    ```
    - 定位到项目中的以下配置文件：
    ```
    resources/application-bean.xml
    ```
    修改Bean名称为```systemConfig```中```directoryPathOfOriginalBookmarkFile```和```directoryPathOfNewBookmarkFile```属性的值，分别为```收藏夹原始文件的存放目录```和```整合好的收藏夹文件存放目录```
    - 再次定位到项目中的以下类，右键运行即可：
    ```
    com.stevejrong.bookmarks.professor.boot.BookmarksProfessorApplication
    ```

#### 版本信息
1.0

#### 开发计划
- 暂无

#### 更新日志
2021/01/03：
1. 初版代码提交
