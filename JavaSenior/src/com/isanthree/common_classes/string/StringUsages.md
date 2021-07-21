

# String

## String 的内存空间

![](https://gitee.com/juststepbystep/pic-bed/raw/master/pic/20210716162205.png)

## String 不同的定义的区别

![](https://gitee.com/juststepbystep/pic-bed/raw/master/pic/20210716163339.png)

## 字符串对象的存储方式

![](https://gitee.com/juststepbystep/pic-bed/raw/master/pic/20210716163846.png)

![image-20210716163956518](https://cdn.jsdelivr.net/gh/isanthree/blog-gallery/pic/20210718235754.png)

![image-20210716165705210](https://cdn.jsdelivr.net/gh/isanthree/blog-gallery/pic/20210718235755.png)

结论：

1. 常量与常量的拼接结果在常量 池 。 且常量池中不会存在相同内容的常量
2. 只要其中有一个是变量 结果就在堆中
3. 如果拼接的结果调用 intern() 方法 返回值 就 在常量池中

