# springboot处理异常
- 源代码 https://github.com/xuwujing/springBoot-study
- 枚举类型，推荐大写：SUCCESS("200","success") 枚举类型实现BaseErrorInfoInterface接口，实现get方法
  - 配置成员变量 String resultCode,String resultMsg,通过构造函数注入枚举类型
  - 提供get方法，让方法可以获得code或者msg
- 在controller层构造多个异常用GlobalExceptionHandler中的@ControllerAdvice来捕获
  - 在其中的方法细分具体是哪一个异常，通过@ExceptionHandler来声明要捕获哪一个异常
  - 返回值为ResultBody,形式参数为HttpServletRequest与异常类
  - 在ResultBody提供三个成员变量code，message，result，用于构造resultBody类，
  - 重载error与success方法，提供errorInfoInterface（java设定好的异常）与code，msg（自定义异常）注入resultBody的方法
  - 在ResultBody提供toString方法，利用fastjson来进行类与json的转化
- 在controller层 new BizException（"-1","用户名不能为空"）抛出异常
- 在BizException建立多个构造方法，包括枚举的和code，msg的，既可以自定义msg也可以使用枚举类型

