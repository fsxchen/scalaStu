[TOC]





# 变量



## 解释器

scala

## 变量声明

变量和不变量的申明，在函数式编程中，变量是不变的，在OOP编程中，变量是可变的。scala作为一种混合性语言，这两种都支持。

```
val array: Array[string] = new Array(5)

var stockPrice: Double = 100.0

```



### 常用的数值类型

`Byte, Char, Short, Int, Long. Float.Double, Boolean`

## Range

Range支持的类型包括`Int`,`Long`,`Fload`,`Double`, `Char`,`BigInt`

```
1 to 10		  // Int的Range，从1到10
1 until 10		//	从1到9
1 to 10 by 3	// 步长为3
```

## 算术符号

在scala中，一切都是对象，算术符号也是`+ - * / %`

```
a + b
```

实际的调用是

```
a.+(b)
```

### TIPS

可以看到，在scala中，实例.方法(参数) 可以写成 实例 方法 参数

```
scala> 1.+(2)
res0: Int = 3

scala> 1.to(10)
res1: scala.collection.immutable.Range.Inclusive = Range 1 to 10

scala> 1 to 10
res2: scala.collection.immutable.Range.Inclusive = Range 1 to 10
```



## 函数的调用和方法

使用import导入方法，`_`匹配所有的包

```
import math._
println(sqrt(2))
```

### tips

**一个没有参数的函数，如果在定义的时候没有括号，那么调用的时候也没有括号！**



### apply方法

在scala中，如果要取一个序列中的某个字，使用`someSeq(i)`,其他语言则使用方括号的形式。

```
scala> "Hello world".apply(1)
res5: Char = e

scala> "Hello world"(2)
res6: Char = l
```

# 结构控制

## 控制结构和函数

### if 的条件是有值的

### 代码块是有值的

```
val s = if (x > 0) 1 else -1
```

这种表达方式和python类似

### tips

**表达式的类型**scala中的每个表达式都是有类型的例如：

```
if (x>0) "positive" else -1
```

对于这个表达式的类型，就是Int 和String的集合Any。语句块也可以不带值

Unit相当于void，可以当作占位符。

```
if (x > 0) 1
// or
if (x > 0) else ()
```



### 注意 REPL的编译问题

```
if (x>0) 1
else if (x == 0) 0 else 1
```

在REPL的编译器中，2句话。为了避免这个问题，可以在REPL中键入

`:paste`，把代码黏贴过去，然后按下`Ctrl+D`



## 终止语句

不需要使用分号

### 块和赋值

在Scala中， `{}`块包含一系列的表达式，其结果是一个表达式，最后一个表达式的值就是块的值。



## 循环

### while

```
while (n>0) {
  r = r*n
  n -= 1
}
```

while循环和其他语言中的循环相同。

### for

```
for (i <- 1 to 10)
      println(i)
```

### 如何退出循环

scala没有直接退出循环的方法，可以

+ 使用Boolean型的控制变量

+ 使用嵌套函数-从函数中break

+ 使用Breaks对象中的break方法

  ```
  import scala.util.control.Breaks._
  breakable {
    for (...) {
      if (...) break;	//退出breakable块
    }
  }
  ```

  ​



### 高级for循环

```
for (i <- 1 to 3; j <- 1 to 3; if i!= j) print(i * j + " ")
```

#### for 推导式子



## 函数

定义函数，需要名称、参数和函数体

```
def abs(x: Double) = if (x > 0) x else -x
```

`return` 并不常见，一般代码块的最后一行会返回

### tips

递归函数一定需要返回值



### 默认参数带名参数

```
def decorate(str: String, left: String="[]", right: String="]")

//调用
decorate(str="hell", right=">>")
```

### 变长参数

```
def sum(args: Int*) = {
  var result = 0
  for (arg <- args ) result += arg
}
```

## 过程

Scala对于不返回值的函数有特殊的表示法。如果函数体包含在华括号中但没有前面的·=·，那么返回类型就是`Unit`，这样的函数被称作过程

```
def box(s: String) {
  var border = "-" * s.length + "--\n"
  println(border + "|" + s "\n" + border)
}
```

等价于

```
def box(s: String): Unit = {
  var border = "-" * s.length + "--\n"
  println(border + "|" + s "\n" + border)
}
```



## 懒值

```
lazy val words = "hello"
```



## 异常



## 偏函数PartialFunction

偏函数只能使用case语句。
偏函数必须使用花括号包围

如果偏函数被调用，而函数的输入与所有的语句都不匹配，就会抛出一个MatchError错误

```
package txt

object Hello {
  def main(args: Array[String]): Unit = {
    println("Hello, Scala")
  }
}
```

## 单例对象object

scala没有静态对象，不过有成员对象



# 数组

## 定长数组

```
val noms = new ArrayInt
```

scala中的Array以Java数组方式实现

## 变长数组

`Java`中有`ArrayList`, `C++`中有`vector`,`scala`中有数据结构`ArrayBuffer`.

# 映射和元组

## 构造映射

```
val scores = Map(
      "Ali" -> 10,
      "Bob" -> 3
    )
println(scores("Ali"))
```

构造一个**不可变**的映射的过程。

然而，`->`实际上是构造了一个元组，上面的代码等价于

```
val scores = Map(("Ali", 10), ("Bob", 3))
```

可以使用如下代码定义一个可变的映射

```
val scores = scala.collection.mutable.Map("Ali" -> 10, "Bob" -> 3)
```

## 在可变映射中改变映射的值

```
scores("Bob") = 10
```



## 迭代映射

```
for ((k, v) <- 映射) 处理k，v
```



# 类

## 简单的类

```
Class Counter {

	private var value = 0

	def increment() {value += 1}
	def current() = value
}

//调用的时候，既可以用`.current()`也可以用`.current`
```



### tips

`改值器`（改变对象状态）使用括号，**取值器**不使用括号。



## `gettr`和`settr`

```
class Person {
  var age = 0
}
```

在scala中，getter和setter分别叫做`age`和`age_=`

## 辅助构造器

辅助构造器的名字是`this`

## 主构造器

```
class Person(val name: Stringt, val age: Int) {
  // 主构造器
}
```

scala的主构造器混合出现在类的定义中

## 类嵌套



# 对象

## 单例对象

scala中没有静态方法或者静态字段，可以用`object`这个语法结构达到同样的目的。

## 伴生对象 

在c++ java等语言中，可以看到既可以提供静态方法，又可以提供实例方法的对象，在scala中使用伴生对象可以达到要求。类有一个与之同名的伴生对象。

### tips

伴生对象必须和类在同一个源文件中。

## apply函数

```
//当调用一个对象如
Object(),实际上就是调用了该对象的apply函数
例如：
Array("Hello", "world")
```



## 应用程序对象



## 枚举

# 包

包的概念和Java／C++中的命名空间是相同。

## 包的作用域



# 继承

## 扩展类

## 重写方法

重写一个非抽象方法必须使用`override`修饰符

使用`super`调用超类的方法。

# 特质trait

相当于java中的interface，不过比interface功能强大，能够在trait中

## case对象



