# AES

#### 介绍
安卓控件元素类库。Android Elementary Substance.

#### 软件架构
使用安卓应用AIDE编译。
app 是测试类库的项目。
libaes 是可供外部引用的类库。
本类库版本查询接口：
[![](https://jitpack.io/v/zhangsken/AES.svg)](https://jitpack.io/#zhangsken/AES)

#### libaes 类库引用方法
(1)修改项目中的上一层根目录build.gradle文件，添加的Maven库:
    allprojects {
        repositories {
            ...
            maven { url 'https://jitpack.io' }
        }
    }
## 修改项目文件夹build.gradle文件，添加项目依赖项
dependencies {
            implementation 'com.github.zhangsken.AES:libaes:3.1.220805.5'
	}
    
    
(2)类库使用
类库使用方法一：
Button按钮布局文件：
<cc.zhangsken.libaes.Button
        android:layout_width="wrap_content"
        android:layout_height="32dp"
		android:text="确定"/>
		
#### 参与贡献
ZhanGSKen<ZhangShaojian2018@163.com> 主要适配小米9开发版MIUI12.5的安卓系统。

#### 参考文档
android shape(如自定义Button)
https://www.cnblogs.com/liangstudyhome/p/3715259.html

Android:如何更改ProgressBar的高度？
https://qa.1r1g.com/sf/ask/191743051/
