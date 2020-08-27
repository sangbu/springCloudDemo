# 功能演示

在此之前先启动我们的Nacos和Redis服务，然后依次启动micro-oauth2-auth、micro-oauth2-gateway及micro-oauth2-api服务；

<img src="https://markdown-sjc.oss-cn-beijing.aliyuncs.com/note/20200826145905.png" height=450>

使用密码模式获取JWT令牌，访问地址：http://localhost:9201/auth/oauth/token

![](https://markdown-sjc.oss-cn-beijing.aliyuncs.com/note/20200826145814.png)

使用获取到的JWT令牌访问需要权限的接口，访问地址：http://localhost:9201/api/hello

![](https://markdown-sjc.oss-cn-beijing.aliyuncs.com/note/20200826150244.png)

使用获取到的JWT令牌访问获取当前登录用户信息的接口，访问地址：http://localhost:9201/api/user/currentUser

![](https://markdown-sjc.oss-cn-beijing.aliyuncs.com/note/20200826150336.png)


