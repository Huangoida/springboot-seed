# Springboot-seed
自用Springboot脚手架工程，集成了Springboot+MyBatisPlus+redis+JWT+Shiro的Restful API脚手架

## 内容说明
* 集成了mybatis-plus
* 采用druid做数据库连接池和监控
* 用aop实现了参数校验
* 封装异常处理，统一返回信息
* 基于JWT的接口认证

## TODO
* 完善工具类
* 集成swagger2
* 用AOP实现权限校验
* 日志按天记录
* 生成图片验证码

## 快速开始

1. 本项目使用了lombok，请确保编译器安装了该插件
2. 克隆本项目
3. 执行seed.sql SQL脚本
4. 修改相关配置文件
