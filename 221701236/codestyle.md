## 代码风格

- 缩进<br/>
  &emsp;&emsp;1.缩进采用4个空格，禁止使用tab字符。<br/>
- 变量命名<br/>
  &emsp;&emsp;1.代码中的命名均不能以下划线或美元符号开始，也不能以下划线或美元符号结束。<br/>
  &emsp;&emsp;2.代码中的命名严禁使用拼音与英文混合的方式，更不允许直接使用中文的方式。<br/>
  &emsp;&emsp;3.参数名、成员变量、局部变量都统一使用lowerCamelCase风格，必须遵从驼峰形式。<br/>
  &emsp;&emsp;4.中括号是数组类型的一部分，数组定义如下：String[] args;<br/>
- 每行最多字符数<br/>
  &emsp;&emsp;1.单行字符数限制不超过 120个，超出需要换行，换行时遵循如下原则：第二行相对第一行缩进 4个空格，从第三行开始，不再继续缩进。运算符与下文一起换行。方法调用的点符号与下文一起换行。在多个参数超长，逗号后进行换行。在括号前不要换行。
  <br/>
- 函数最大行数<br/>
  &emsp;&emsp;无限制<br/>
- 函数、类命名<br/>
  &emsp;&emsp;1.类名使用UpperCamelCase风格，必须遵从驼峰形式，但以下情形例外：（领域模型的相关命名）DO / BO / DTO / VO等。<br/>
  &emsp;&emsp;2.抽象类命名使用Abstract或Base开头；异常类命名使用Exception结尾；测试类命名以它要测试的类的名称开始，以Test结尾。<br/>
  &emsp;&emsp;3.方法名使用lowerCamelCase风格，必须遵从驼峰形式。<br/>
- 常量<br/>
  &emsp;&emsp;1.常量命名全部大写，单词间用下划线隔开，力求语义表达完整清楚，不要嫌名字长。<br/>
- 空行规则<br/>
  &emsp;&emsp;1.方法体内的执行语句组、变量的定义语句组、不同的业务逻辑之间或者不同的语义之间插入一个空行。相同业务逻辑和语义之间不需要插入空行。<br/>
- 注释规则<br/>
  &emsp;&emsp;1.方法内部单行注释，在被注释语句上方另起一行，使用//注释。方法内部多行注释使用/ */注释，注意与代码对齐。<br/>
- 操作符前后空格<br/>
  &emsp;&emsp;1.if/for/while/switch/do等保留字与左右括号之间都必须加空格。<br/>
  &emsp;&emsp;2.任何运算符左右必须加一个空格。<br/>
  &emsp;&emsp;3.方法参数在定义和传入时，多个参数逗号后边必须加空格。<br/>
- 其他规则<br/>
  &emsp;&emsp;1.包名统一使用小写，点分隔符之间有且仅有一个自然语义的英语单词。包名统一使用单数形式，但是类名如果有复数含义，类名可以使用复数形式。<br/>
  &emsp;&emsp;2.杜绝完全不规范的缩写，避免望文不知义。<br/>
  &emsp;&emsp;3.大括号的使用约定。如果是大括号内为空，则简洁地写成{}即可，不需要换行；如果是非空代码块则：左大括号前换行。左大括号后换行。右大括号前换行。右大括号后换行。<br/> 
