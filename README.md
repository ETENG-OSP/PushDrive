PushDrive
=========

通用推送驱动。本组件是抽象的第三方推送服务调用方法。如果期望整合更多的服务，请实现 com.eteng.mobile.PushDriver。


整合方法
--------
- 将 build 中的文件引入 buildpath
- 将 lib 中的依赖引入 buildpath


使用方法
---------

### Push.create()
创建新的推送实例

### Push.text("内容")
编写推送显示的文字信息

### Push.title("题目")
编写推送题目

### Push.toAll()
向所有用户推送信息

### Push.toAccount("账户名")
向目标用户推送信息

### 例子
```
Push.create().text("你好").title("世界").toAccount("admin");
```
